package org.example.folhafacil.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity(name="pontos")
public class Ponto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "hora_ponto", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaPonto;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}
 /* -- Qtde pontos jornada tem q ser par
00:00-23:59
        08:00 - 12:00 - 13:00 - 17:00
        04:00        +        04:00
        08:00

        23:59-00:00
        22:00 - 02:00 - 03:00 - 07:00
        04:00        +        04:00
        08:00
SELECT * FROM pontos WHERE funcionario = ? AND data IN (2024-11-24 00:00:00 AND 2024-11-24 23:59:59)
 é proibido ter intervalo entre jornada menor que 12 horas   //barrar o ponto!
 */
