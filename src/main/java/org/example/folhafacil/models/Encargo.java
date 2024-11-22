package org.example.folhafacil.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Encargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    private double porcentagem;
    @OneToMany(mappedBy = "encargo")
    private List<EncargoSalario> encargoSalario;
    @OneToMany(mappedBy = "encargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoleriteEncargo> encargoHolerites; // Relacionamento bidirecional



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

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public List<EncargoSalario> getEncargoSalario() {
        return encargoSalario;
    }

    public void setEncargoSalario(List<EncargoSalario> encargoSalario) {
        this.encargoSalario = encargoSalario;
    }

    public List<HoleriteEncargo> getEncargoHolerites() {
        return encargoHolerites;
    }

    public void setEncargoHolerites(List<HoleriteEncargo> encargoHolerites) {
        this.encargoHolerites = encargoHolerites;
    }
}
