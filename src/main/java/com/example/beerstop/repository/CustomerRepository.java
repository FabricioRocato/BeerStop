package com.example.beerstop.repository;

import com.example.beerstop.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.name ilike :searchTerm ")
    List<Customer> findByName(String searchTerm);

    @Query(value = "select c from Customer c where c.name ilike :searchTerm")
    Page<Customer> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);
}



