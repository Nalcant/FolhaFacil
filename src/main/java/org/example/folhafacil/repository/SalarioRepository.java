package org.example.folhafacil.repository;

import org.example.folhafacil.models.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {

}
