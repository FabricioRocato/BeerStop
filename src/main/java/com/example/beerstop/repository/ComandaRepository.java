package com.example.beerstop.repository;

import com.example.beerstop.entity.Comanda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    Page<Comanda> findByCustomerIdOrderByIdDesc(Pageable pageable, Long id);

    Page<Comanda> findAllByOrderByIdDesc(Pageable pageable);

}
