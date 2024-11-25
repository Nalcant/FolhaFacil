package org.example.folhafacil.repository;

import org.example.folhafacil.models.Beneficio;
import org.example.folhafacil.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>, ListPagingAndSortingRepository<Usuario, Long> {

}