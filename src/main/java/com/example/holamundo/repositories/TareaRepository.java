package com.example.holamundo.repositories;

import com.example.holamundo.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Juego, Integer> {
}
