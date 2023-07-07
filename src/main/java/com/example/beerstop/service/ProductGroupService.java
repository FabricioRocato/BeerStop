package com.example.beerstop.service;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.entity.ProductGroup;
import com.example.beerstop.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGroupService {

    private ProductGroupRepository repository;
    public void save(ProductGroup productGroup) {
        repository.save(productGroup);
    }

    public void deleteById(Long productGroupId) {
        repository.deleteById(productGroupId);
    }

    public List<ProductGroup> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }
}
