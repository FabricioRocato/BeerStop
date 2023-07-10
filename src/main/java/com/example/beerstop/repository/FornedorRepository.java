package com.example.beerstop.repository;

import com.example.beerstop.entity.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornedorRepository  extends JpaRepository<Fornecedor, Long> {



    @Query("select c from Fornecedor c where c.name ilike :searchTerm ")
    List<Fornecedor> findByName(String searchTerm);

    @Query(value = "select c from Fornecedor c where c.name ilike :searchTerm")
    Page<Fornecedor> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);


}