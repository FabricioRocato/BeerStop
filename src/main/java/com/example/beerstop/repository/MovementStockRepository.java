package com.example.beerstop.repository;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface MovementStockRepository extends JpaRepository<Comanda, Long> {

}
