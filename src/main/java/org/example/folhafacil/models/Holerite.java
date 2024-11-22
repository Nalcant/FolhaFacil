package org.example.folhafacil.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
public class Holerite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salario_id", nullable = false)
    private Salario salario;

    private Date mesReferencia;
    private Double totalHoras;
    private Double salarioLiquido;
    @OneToMany(mappedBy = "holerite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoleriteEncargo> holeriteEncargo; // Detalhamento dos encargos


// relação implicita
//    @ManyToMany
//    @JoinTable(
//            name = "holerite_encargo", // Nome da tabela intermediária
//            joinColumns = @JoinColumn(name = "holerite_id"), // FK para Holerite
//            inverseJoinColumns = @JoinColumn(name = "encargo_id") // FK para Encargo
//    )
//    private Set<Encargo> encargos; // Encargos associados ao Holerite

    @ManyToMany
    @JoinTable(
            name = "holerite_beneficio", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "holerite_id"), // FK para Holerite
            inverseJoinColumns = @JoinColumn(name = "beneficio_id") // FK para Beneficio
    )
    private Set<Beneficio> beneficios; // Benefícios associados ao Holerite

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public Date getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Date mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Double getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Double totalHoras) {
        this.totalHoras = totalHoras;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public List<HoleriteEncargo> getHoleriteEncargo() {
        return holeriteEncargo;
    }

    public void setHoleriteEncargo(List<HoleriteEncargo> holeriteEncargo) {
        this.holeriteEncargo = holeriteEncargo;
    }

    public Set<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(Set<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
}
