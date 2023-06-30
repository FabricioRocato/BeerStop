package com.example.beerstop.api;

import com.example.beerstop.entity.*;
import com.example.beerstop.service.MovementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("movement")
public class MovementStockAPI {

    @Autowired
    public MovementStockService service;

    @GetMapping("/{comandaId}")
    public Comanda closeComanda(@PathVariable Long comandaId) {
        return service.closeComanda(comandaId);
    }
    @GetMapping("/finish/{comandaId}")
    public Comanda finishMovement(@PathVariable Long comandaId) {
        return service.finishMovement(comandaId);
    }

    @PostMapping
    public Movement movementStock(@RequestBody Movement movement){
        return service.save(movement);
    }

}
