package com.example.beerstop.repository;

import com.example.beerstop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select c from Product c where c.name ilike :searchTerm ")
    List<Product> findByName(String searchTerm);

    @Query(value = "select c from Product c where c.name ilike :searchTerm")
    Page<Product> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);

}
