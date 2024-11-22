package org.example.folhafacil.models;

import jakarta.persistence.*;
@Entity
public class EncargoSalario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "encargo_id", nullable = false)
    private Encargo encargo; // Um encargo por registro

    @ManyToOne
    @JoinColumn(name = "salario_id", nullable = false)
    private Salario salario; // Um salário por registro

    private double valorEncargo; // Atributo adicional

    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Encargo getEncargo() {
        return encargo;
    }

    public void setEncargo(Encargo encargo) {
        this.encargo = encargo;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public double getValorEncargo() {
        return valorEncargo;
    }

    public void setValorEncargo(double valorEncargo) {
        this.valorEncargo = valorEncargo;
    }
}
