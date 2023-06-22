package com.example.beerstop.repository;

import com.example.beerstop.entity.Comanda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    Page<Comanda> findAllByOrderByIdDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * from comanda where id = :comandaId ")
    Comanda closeComanda(@Param("comandaId") Long comandaId);
    @Query(nativeQuery = true, value = "\n" +
            "SELECT p.quantity_in_stock, ic.quantidade FROM comanda\n" +
            "JOIN comanda_itens ci ON comanda.id = ci.comanda_id\n" +
            "JOIN item_comanda ic ON ic.id = ci.itens_id\n" +
            "JOIN product p ON p.id = ic.produto_id\n" +
            "WHERE comanda_id = :comandaId")
    Comanda finishMovement(@Param("comandaId") Long comandaId);
    @Query(nativeQuery = true, value ="SELECT p.quantity_in_stock - ic.quantidade AS remaining_quantity FROM comanda\n" +
            "JOIN comanda_itens ci on comanda.id = ci.comanda_id\n" +
            "JOIN item_comanda ic on ic.id = ci.itens_id\n" +
            "JOIN product p on p.id = ic.produto_id\n" +
            "WHERE comanda_id = :comandaId and ic.id = :itenComandaId")
    int moveStock(@Param("comandaId") Long comandaId, @Param("itenComandaId") long itenComandaId);
    @Query(nativeQuery = true, value = "SELECT id from item_comanda where id = :itenId")
    Long getId(@Param("itenId") Long itenId);

}
