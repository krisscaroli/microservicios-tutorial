package com.example.carroservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Carro {
    @Id
    @GeneratedValue
    private int id;

    private String marca;
    private String modelo;
    private int usuarioId;

}
