package com.example.beerstop.repository;

import com.example.beerstop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Product,Long> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT p.id, p.name, SUM(ic.quantidade) AS totalSold\n" +
            "FROM product p\n" +
            "JOIN item_comanda ic ON p.id = ic.produto_id\n" +
            "GROUP BY p.id, p.name\n" +
            "ORDER BY totalSold DESC")
    List<Object[]> ProdutoMaisVendido();

    @Query(nativeQuery = true, value = "\n" +
            "SELECT DISTINCT c2.id, c2.name , SUM(ic.quantidade) AS totalSold\n" +
            "FROM comanda c\n" +
            "JOIN comanda_itens ci on c.id = ci.comanda_id\n" +
            "JOIN item_comanda ic on ic.id = ci.itens_id\n" +
            "JOIN customer c2 on c2.id = c.customer_id\n" +
            "GROUP BY c2.id, c2.name\n" +
            "ORDER BY totalSold DESC")
    List<Object[]> ClienteConsumista();
}
