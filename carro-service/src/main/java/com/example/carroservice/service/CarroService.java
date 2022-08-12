package com.example.carroservice.service;

import com.example.carroservice.entity.Carro;
import com.example.carroservice.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    public List<Carro> getAll(){
        return carroRepository.findAll();
    }

    public Carro getCarroById(int id ){
        return carroRepository.findById(id).orElse(null);
    }

    public Carro save(Carro carro){
        Carro nuevoCarro =  carroRepository.save(carro);
        return nuevoCarro;

    }

    public List<Carro> byUsuarioId(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }
}
