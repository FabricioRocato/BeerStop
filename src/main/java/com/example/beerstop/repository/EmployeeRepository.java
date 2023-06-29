package com.example.beerstop.repository;

import com.example.beerstop.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select c from Employee c where c.name ilike :searchTerm ")
    List<Employee> findByName(String searchTerm);

    @Query(value = "select c from Employee c where c.name ilike :searchTerm")
    Page<Employee> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);

}
