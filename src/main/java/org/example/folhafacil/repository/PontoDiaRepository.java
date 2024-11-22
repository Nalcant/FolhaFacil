package org.example.folhafacil.repository;


import org.example.folhafacil.models.PontoDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoDiaRepository extends JpaRepository<PontoDia, Long>{

}

