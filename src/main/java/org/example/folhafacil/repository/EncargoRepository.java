package org.example.folhafacil.repository;

import org.example.folhafacil.models.Encargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargoRepository extends JpaRepository<Encargo, Long> {

}
