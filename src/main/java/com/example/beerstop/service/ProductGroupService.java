package com.example.beerstop.service;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.entity.ProductGroup;
import com.example.beerstop.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductGroupService {

    @Autowired
    private ProductGroupRepository repository;
    public void save(ProductGroup productGroup) {
        repository.save(productGroup);
    }

    public void deleteById(Long productGroupId) {
        repository.deleteById(productGroupId);
    }


    public Page<ProductGroup> findByName(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByName("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }
}
