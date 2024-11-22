package org.example.folhafacil.models;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_usuario;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    private Boolean adm;

    @OneToOne // Lado proprietário do relacionamento
    @JoinColumn(name = "colaborador") // Chave estrangeira para Colaborador
    private Colaborador colaborador;

    // Getters and Setters
    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public Long getId() {
        return id_usuario;
    }

    public void setId(Long id) {
        this.id_usuario = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}