package com.vinicius.gerarelatorio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.gerarelatorio.spring.model.Estado;

/**
 * Interface EstadoRepository responsável por anotar nossas operações de CRUD ( acessar banco de dados, consultas, etc ).
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
