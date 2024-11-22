package org.example.folhafacil.repository;

import org.example.folhafacil.models.HistoricoSalarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoSalarialRepository extends JpaRepository<HistoricoSalarial, Long> {

}
