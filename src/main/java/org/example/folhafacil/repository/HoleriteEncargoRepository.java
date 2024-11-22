package org.example.folhafacil.repository;

import org.example.folhafacil.models.HoleriteEncargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoleriteEncargoRepository extends JpaRepository<HoleriteEncargo, Long> {

}
