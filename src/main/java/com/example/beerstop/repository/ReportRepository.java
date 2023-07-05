package com.example.beerstop.repository;

import com.example.beerstop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReportRepository extends JpaRepository<Product,Long> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT ON (p.id) p.id, p.name, SUM(ic.quantidade) AS totalSold\n" +
            "FROM product p\n" +
            "JOIN item_comanda ic ON p.id = ic.produto_id\n" +
            "GROUP BY p.id, p.name\n" +
            "ORDER BY p.id, totalSold DESC")
    List<Object[]> ProdutoMaisVendido();

}
