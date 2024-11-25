package org.example.folhafacil.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@ToString
@Entity(name = "encargos")
@Getter
@Setter
@NoArgsConstructor
public class Encargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255, unique = true, nullable = false)
    @Size(min = 2, max = 255)
    private String descricao;
    @Column(nullable = false)
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private double porcentagem;
}
