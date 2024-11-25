package org.example.folhafacil.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ToString
@Entity(name = "colaboradores")
@Getter
@Setter
@NoArgsConstructor
public class Colaborador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255, nullable = false)
    @Size(min = 3, max = 255)
    @NotNull
    private String nome;
    @Column(length = 255, nullable = false)
    @Size(min = 3, max = 255)
    private String email;
    @Column(length = 11, nullable = false)
    @Size(min = 11, max = 11)
    private String telefone;
    @Column(length = 11,unique = true, nullable = false)
    @Size(min = 11, max = 11)
    private String cpf;
    @Column(length = 20, nullable = false)
    @Size(min = 5, max = 20)
    private String rg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_admissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_demissao")
    @Temporal(TemporalType.DATE)
    private Date dataDemissao;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ToString.Exclude
    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ToString.Exclude
    @OneToMany(mappedBy = "colaborador")
    private List<Ponto> pontos;
}


