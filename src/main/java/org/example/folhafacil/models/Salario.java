package org.example.folhafacil.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_salario;
    @OneToOne
    @JoinColumn(name = "colaborador")
    private Colaborador colaborador;
    private Double salarioBase;
    @ManyToOne
    @JoinColumn(name = "id_historicoSalarial", nullable = false)
    private HistoricoSalarial historicoSalarial;
    private Date dataInicio;
    private Date dataFim;
    @OneToMany(mappedBy = "salario", cascade = CascadeType.ALL)
    private List<EncargoSalario> encargoSalarios; // Conexão com Encargo através de EncargoSalario

    @ManyToMany
    @JoinTable(
            name = "salario_encargo", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "fk_salario"), // FK para salario
            inverseJoinColumns = @JoinColumn(name = "fk_encargo") // FK para encargo
    )
    private Set<Encargo> encargos;
    @ManyToMany
    @JoinTable(
            name = "salario_beneficio",
            joinColumns = @JoinColumn(name = "fk_salario"),
            inverseJoinColumns = @JoinColumn(name = "fk_encargo")
    )
    private Set<Beneficio> beneficios;


    public Long getId_salario() {
        return id_salario;
    }

    public void setId_salario(Long id_salario) {
        this.id_salario = id_salario;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public HistoricoSalarial getHistoricoSalarial() {
        return historicoSalarial;
    }

    public void setHistoricoSalarial(HistoricoSalarial historicoSalarial) {
        this.historicoSalarial = historicoSalarial;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
