package org.example.folhafacil.repository;


import org.example.folhafacil.models.Ponto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long>, ListPagingAndSortingRepository<Ponto, Long> {

}

