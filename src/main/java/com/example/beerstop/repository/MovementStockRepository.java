package com.example.beerstop.repository;

import com.example.beerstop.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementStockRepository extends JpaRepository<Comanda, Long> {

}