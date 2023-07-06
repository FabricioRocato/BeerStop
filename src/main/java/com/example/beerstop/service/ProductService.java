package com.example.beerstop.service;

import com.example.beerstop.entity.Movement;
import com.example.beerstop.entity.Product;
import com.example.beerstop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public void save(Product product) {
        repository.save(product);

    }
    public List<Product> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Product> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%", PageRequest.of(pageNumber, pageSize));
    }

    public Optional<Product> findProduct(Long productId) {
        return repository.findById(productId);
    }

    public void deleteById(Long productId) {
        repository.deleteById(productId);
    }

    public List<Product> ProdutoEstoque(){
        return repository.ProdutoEstoque();
    }

}