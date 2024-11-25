package org.example.folhafacil.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity(name = "usuarios")
public class Usuario implements Serializable {
    @Getter
    enum GrupoAcesso {
        ADMIN("Administrador"),
        FUNCIONARIO("Funcionário");

        private final String descricao;

        GrupoAcesso(String descricao) {
            this.descricao = descricao;
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( length = 50, nullable = false, unique = true)
    @Size(min = 3, max = 50)
    private String login;
    
    @ToString.Exclude
    @Column( length = 50, nullable = false)
    @Size(min = 3, max = 50)
    private String senha;
    @Enumerated(EnumType.STRING)
    @NotNull
    private GrupoAcesso grupoAcesso;

    @ToString.Exclude
    @OneToOne(mappedBy = "usuario")
    private Colaborador colaborador;
}