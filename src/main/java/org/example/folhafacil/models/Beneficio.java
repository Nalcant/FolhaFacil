package org.example.folhafacil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Beneficio {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String descricao;
private double valor_aplicado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_aplicado() {
        return valor_aplicado;
    }

    public void setValor_aplicado(double valor_aplicado) {
        this.valor_aplicado = valor_aplicado;
    }
}
