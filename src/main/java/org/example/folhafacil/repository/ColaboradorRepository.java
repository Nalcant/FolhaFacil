package org.example.folhafacil.repository;
import org.example.folhafacil.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

}
