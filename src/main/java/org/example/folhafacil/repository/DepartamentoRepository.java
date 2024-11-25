package org.example.folhafacil.repository;

import org.example.folhafacil.models.Cargo;
import org.example.folhafacil.models.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long>, ListPagingAndSortingRepository<Departamento, Long> {
}
