package com.example.beerstop.api;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Api
@RestController
@RequestMapping("customer")
public class CustomerApi {

    @Autowired
    private CustomerService service;

    @PostMapping
    public String save(@RequestBody Customer customer) {
        service.save(customer);
        return "Customer saved with success";
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> findCustomer(@PathVariable Long customerId) {
        return service.findCustomer(customerId);
    }

    @GetMapping
    public ResponseEntity findByName(@RequestParam String searchTerm) {
        return ResponseEntity.ok(service.findByName(searchTerm));
    }

    @GetMapping("/v2")
    public Page<Customer> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @PutMapping
    public String update(@RequestBody Customer customer) {
        service.save(customer);
        return "Customer updated with success";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        service.deleteById(customerId);
        return "Customer " + customerId + " Was deleted";
    }
}
