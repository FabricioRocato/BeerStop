package com.example.beerstop.repository;

import com.example.beerstop.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Long> {
    @Query("SELECT m FROM Movement m where m.movementType = 'ENTRADA' ")
    List<Movement> EntradaEstoque();

    @Query("SELECT m FROM Movement m where m.movementType = 'SAIDA' ")
    List<Movement> SaidaEstoque();
}
