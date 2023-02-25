package com.example.beerstop.service;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.repository.CustomerRepository;
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
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer client) {
        repository.save(client);

    }

    public Optional<Customer> findCustomer(Long customerId) {
        return repository.findById(customerId);
    }

    public void deleteById(Long companyId) {
        repository.deleteById(companyId);
    }

    public List<Customer> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Customer> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }
}
