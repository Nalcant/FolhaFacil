package org.example.folhafacil.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Entity(name= "beneficios")
@Getter
@Setter
@NoArgsConstructor
public class Beneficio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255, nullable = false)
    @Size(min = 2, max = 255)
    private String descricao;
    @Column(name = "valor_aplicado")
    @DecimalMin("0.0")
    private double valorAplicado;

}
