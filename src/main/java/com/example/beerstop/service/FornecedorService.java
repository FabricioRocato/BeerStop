package com.example.beerstop.service;

import com.example.beerstop.entity.Employee;
import com.example.beerstop.entity.Fornecedor;
import com.example.beerstop.repository.EmployeeRepository;
import com.example.beerstop.repository.FornedorRepository;
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
public class FornecedorService {


    @Autowired
    private FornedorRepository repository;
    public void save(Fornecedor fornecedor) {
        repository.save(fornecedor);

    }
    public List<Fornecedor> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Fornecedor> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%", PageRequest.of(pageNumber, pageSize));
    }

    public Optional<Fornecedor> findFornecedor(Long fornecedorId) {
        return repository.findById(fornecedorId);
    }

    public void deleteById(Long fornecedorId) {
        repository.deleteById(fornecedorId);
    }

}