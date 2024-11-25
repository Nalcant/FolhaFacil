package org.example.folhafacil.repository;

import org.example.folhafacil.models.Holerite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface HoleriteRepository extends CrudRepository<Holerite, Long>, ListPagingAndSortingRepository<Holerite, Long> {
}
