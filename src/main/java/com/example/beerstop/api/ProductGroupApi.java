package com.example.beerstop.api;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.entity.ProductGroup;
import com.example.beerstop.service.ProductGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("product-group")
public class ProductGroupApi {

    @Autowired
    private ProductGroupService service;

    @PostMapping
    public String save(@RequestBody ProductGroup productGroup) {
        service.save(productGroup);
        return "Product saved with success";
    }

    @GetMapping
    public Page<ProductGroup> findByName(@RequestParam String searchTerm,
                                         @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByName(pageNumber, pageSize, searchTerm);
    }

    @PutMapping
    public String update(@RequestBody ProductGroup productGroup) {
        service.save(productGroup);
        return "productGroup updated with success";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long productGroupId) {
        service.deleteById(productGroupId);
        return "Customer " + productGroupId + " Was deleted";
    }




}
