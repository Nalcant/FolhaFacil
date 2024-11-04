package org.example.folhafacil.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FolhaPagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private long id;
  private Colaborador colaborador;
  private double salario;
  private double encargos;
  private double descontos;

  public double getBeneficios() {
    return beneficios;
  }

  public void setBeneficios(double beneficios) {
    this.beneficios = beneficios;
  }

  private double beneficios;


  private double calcSalarioFinal() {


    return -1;
  }

  private double calcEncargos(){

    return -1;
  }

  private double calcBeneficios(){

    return -1;
  }

}
