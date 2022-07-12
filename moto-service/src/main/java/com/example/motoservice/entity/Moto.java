package com.example.motoservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Moto {
    @Id
    @GeneratedValue
    private int id;

    private String marca;
    private String modelo;
    private int usuarioId;

}
