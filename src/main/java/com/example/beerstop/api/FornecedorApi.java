package com.example.beerstop.api;

import com.example.beerstop.entity.Employee;
import com.example.beerstop.entity.Fornecedor;
import com.example.beerstop.service.EmployeeService;
import com.example.beerstop.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("fornecedor")
public class FornecedorApi {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public String save(@RequestBody Fornecedor fornecedor) {
        service.save(fornecedor);
        return "Fornecedor saved with success";
    }


    @GetMapping
    public ResponseEntity findByName(@RequestParam String searchTerm) {
        return ResponseEntity.ok(service.findByName(searchTerm));
    }

    @GetMapping("/v2")
    public Page<Fornecedor> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/{fornecedorId}")
    public Optional<Fornecedor> findEmployee(@PathVariable Long fornecedorId) {
        return service.findFornecedor(fornecedorId);
    }

    @PutMapping
    public String update(@RequestBody Fornecedor fornecedor) {
        service.save(fornecedor);
        return "Fornecedor updated with success";
    }

    @DeleteMapping("/{fornecedorId}")
    public String deleteEmployee(@PathVariable Long fornecedorId) {
        service.deleteById(fornecedorId);
        return "FornecedorId " + fornecedorId + " Was deleted";
    }

}
