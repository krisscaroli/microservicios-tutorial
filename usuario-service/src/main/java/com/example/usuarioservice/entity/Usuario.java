package com.example.usuarioservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String email;
}
