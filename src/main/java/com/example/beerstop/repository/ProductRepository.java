package com.example.beerstop.repository;

import com.example.beerstop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = "update Product p set p.quantityInStock = :quantity where p.id = :id")
    void updateStock(@Param("quantity") int quantity, @Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM product where id = :id")
    Product findProductId(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select quantity_in_stock from product where id = :id ")
    int getProductQuantity(@Param("id") Long id);

}
