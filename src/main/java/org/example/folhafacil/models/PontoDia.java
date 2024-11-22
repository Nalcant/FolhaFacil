package org.example.folhafacil.models;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.time.LocalTime;

@Entity
public class PontoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_pontoDia;
    @OneToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervaloComeco;
    private LocalTime intervaloFim;
    private Double horasTrabalhadas;

    public long getId_pontoDia() {
        return id_pontoDia;
    }

    public void setId_pontoDia(int id_pontoDia) {
        this.id_pontoDia = id_pontoDia;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalTime getIntervaloComeco() {
        return intervaloComeco;
    }

    public void setIntervaloComeco(LocalTime intervaloComeco) {
        this.intervaloComeco = intervaloComeco;
    }

    public LocalTime getIntervaloFim() {
        return intervaloFim;
    }

    public void setIntervaloFim(LocalTime intervaloFim) {
        this.intervaloFim = intervaloFim;
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

}
