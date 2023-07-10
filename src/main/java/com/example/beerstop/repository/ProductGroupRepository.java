package com.example.beerstop.repository;

import com.example.beerstop.entity.Customer;
import com.example.beerstop.entity.ProductGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

    @Query("select c from ProductGroup c where c.groupName ilike :searchTerm ")
    Page<ProductGroup> findByName(@Param("searchTerm") String searchTerm, Pageable pageable);

}
