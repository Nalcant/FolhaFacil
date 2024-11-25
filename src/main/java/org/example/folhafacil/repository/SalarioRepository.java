package org.example.folhafacil.repository;

import org.example.folhafacil.models.Salario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends CrudRepository<Salario, Long>, ListPagingAndSortingRepository<Salario, Long> {

}
