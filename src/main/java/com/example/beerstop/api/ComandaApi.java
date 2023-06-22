package com.example.beerstop.api;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("comanda")
public class ComandaApi {
    @Autowired
    private ComandaService service;

    @PostMapping
    public String save(@RequestBody Comanda comanda) {
        service.save(comanda);
        return "Comanda saved with success";
    }

    @GetMapping("/{comandaId}")
    public Optional<Comanda> findtimeSheet(@PathVariable Long comandaId) {
        return service.findComanda(comandaId);
    }

    @GetMapping
    public Page<Comanda> findAllByOrderByIdDesc(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return service.findAllByOrderByIdDesc(pageNumber, pageSize);
    }

    @PutMapping
    public String update(@RequestBody Comanda comanda) {
        service.save(comanda);
        return "Comanda updated with success";
    }

    @DeleteMapping("/{comandaId}")
    public String deletecomanda(@PathVariable Long comandaId) {
        service.deleteById(comandaId);
        return "Comanda " + comandaId + " Was deleted";
    }
}
