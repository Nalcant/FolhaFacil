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
@Entity(name = "holerites")
public class Holerite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mes_referencia", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date mesReferencia;
    @Column(name = "total_horas", nullable = false)
    @DecimalMin("0.0")
    private Double totalHoras;
    @DecimalMin("0.0")
    @Column(name = "salario_liquido", nullable = false)
    private Double salarioLiquido;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "salario_id", nullable = false)
    private Salario salario;

}
