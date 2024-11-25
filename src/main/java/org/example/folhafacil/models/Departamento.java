package org.example.folhafacil.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Entity(name= "departamentos")
@Getter
@Setter
@NoArgsConstructor
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255, unique=true, nullable=false)
    @Size(min=2, max=255)
    private String descricao;

    @ToString.Exclude
    @OneToMany(mappedBy = "departamento")
    private List<Colaborador> colaborador;
}
