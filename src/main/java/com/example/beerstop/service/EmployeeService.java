package com.example.beerstop.service;

import com.example.beerstop.entity.Employee;
import com.example.beerstop.repository.EmployeeRepository;
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
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public void save(Employee employee) {
        repository.save(employee);

    }
    public List<Employee> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Employee> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%", PageRequest.of(pageNumber, pageSize));
    }

    public List<Employee> findBySupervisorIsTrue(){
        return repository.findBySupervisorIsTrue();
    }

    public Optional<Employee> findEmployee(Long employeeId) {
        return repository.findById(employeeId);
    }

    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }

}