package org.example.folhafacil.repository;

import org.example.folhafacil.models.Beneficio;
import org.example.folhafacil.models.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface CargoRepository extends CrudRepository<Cargo, Long>, ListPagingAndSortingRepository<Cargo, Long> {
}
