package com.example.beerstop.api;

import com.example.beerstop.entity.Employee;
import com.example.beerstop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String save(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee saved with success";
    }

    @GetMapping("/supervisor")
    public List<Employee> findBySupervisorIsTrue(){
        return service.findBySupervisorIsTrue();
    }

    @GetMapping
    public ResponseEntity findByName(@RequestParam String searchTerm) {
        return ResponseEntity.ok(service.findByName(searchTerm));
    }

    @GetMapping("/v2")
    public Page<Employee> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findEmployee(@PathVariable Long employeeId) {
        return service.findEmployee(employeeId);
    }

    @PutMapping
    public String update(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee updated with success";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return "Employee " + employeeId + " Was deleted";
    }
}

