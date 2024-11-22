package org.example.folhafacil.models;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_colaborador;
    private String nome;
    private String email;
    private String telefone;
    @Column(unique = true)
    private BigInteger cpf;
    @Column(unique = true)
    private String rg;
    private String departamento;
    private String cargo;
    private Date dataAdmis;
    private Date dataDemiss;
    @OneToOne(mappedBy = "colaborador") // Lado inverso, o colaborador não detém a chave estrangeira
    private Usuario usuario;
    @OneToOne(mappedBy = "colaborador" )
    private PontoDia pontoDia;

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    public long getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


}


