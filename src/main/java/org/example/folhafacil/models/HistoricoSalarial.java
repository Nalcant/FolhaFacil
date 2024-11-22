package org.example.folhafacil.models;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class HistoricoSalarial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "historicoSalarial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salario> salarios;
    private Date data;
    private float salario;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void registrarHistoricoSalarial(){

    }
}




