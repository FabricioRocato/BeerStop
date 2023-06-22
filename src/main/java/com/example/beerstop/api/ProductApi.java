package com.example.beerstop.api;

import com.example.beerstop.entity.Product;
import com.example.beerstop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductApi {

    @Autowired
    private ProductService service;

    @PostMapping
    public String save(@RequestBody Product product) {
        service.save(product);
        return "Product saved with success";
    }

    @GetMapping
    public ResponseEntity findByName(@RequestParam String searchTerm) {
        return ResponseEntity.ok(service.findByName(searchTerm));
    }

    @GetMapping("/v2")
    public Page<Product> findByNamev2(@RequestParam String searchTerm,
                                   @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/{productId}")
    public Optional<Product> findProduct(@PathVariable Long productId) {
        return service.findProduct(productId);
    }

    @PutMapping
    public String update(@RequestBody Product product) {
        service.save(product);
        return "Product updated with success";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        service.deleteById(productId);
        return "Product " + productId + " Was deleted";
    }
}
