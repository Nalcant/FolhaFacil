package org.example.folhafacil.repository;

import org.example.folhafacil.models.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface BeneficioRepository extends CrudRepository<Beneficio, Long>, ListPagingAndSortingRepository<Beneficio, Long> {
}
