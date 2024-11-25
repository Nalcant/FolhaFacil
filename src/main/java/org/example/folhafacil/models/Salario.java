package org.example.folhafacil.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity(name = "salarios")
public class Salario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="salario_base", nullable=false)
    @DecimalMin("0.0")
    private Double salarioBase;
    @Column(name="data_inicio", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name="data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @ToString.Exclude
    @OneToOne(optional=false)
    @NotNull
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "salario_encargo", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "salario_id"), // FK para salario
            inverseJoinColumns = @JoinColumn(name = "encargo_id") // FK para encargo
    )
    private List<Encargo> encargos;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "salario_beneficio",
            joinColumns = @JoinColumn(name = "salario_id"),
            inverseJoinColumns = @JoinColumn(name = "beneficio_id")
    )
    private List<Beneficio> beneficios;
}
