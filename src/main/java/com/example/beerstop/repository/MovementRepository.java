package com.example.beerstop.repository;

import com.example.beerstop.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Long> {

}
