package org.example.folhafacil.models;

import jakarta.persistence.*;
@Entity
public class HoleriteEncargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_holerite", nullable = false)
    private Holerite holerite; // Relaciona-se ao holerite

    @ManyToOne
    @JoinColumn(name = "id_encargo", nullable = false)
    private Encargo encargo; // O nome deve coincidir com o "mappedBy"

    private Double valor;

    // Getters e Setters


}
