package com.example.beerstop.repository;

import com.example.beerstop.entity.ItemComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemComandaRepository extends JpaRepository<ItemComanda,Long> {
}
