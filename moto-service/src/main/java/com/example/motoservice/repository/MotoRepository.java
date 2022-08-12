package com.example.motoservice.repository;

import com.example.motoservice.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Integer> {
    List<Moto> findByUsuarioId(int usuarioId);
}
