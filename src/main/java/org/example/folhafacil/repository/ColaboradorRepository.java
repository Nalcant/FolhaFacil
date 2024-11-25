package org.example.folhafacil.repository;
import org.example.folhafacil.models.Beneficio;
import org.example.folhafacil.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long>, ListPagingAndSortingRepository<Colaborador, Long> {

}
