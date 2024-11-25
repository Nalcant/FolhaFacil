package org.example.folhafacil.repository;

import org.example.folhafacil.models.Encargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargoRepository extends CrudRepository<Encargo, Long>, ListPagingAndSortingRepository<Encargo, Long> {

}
