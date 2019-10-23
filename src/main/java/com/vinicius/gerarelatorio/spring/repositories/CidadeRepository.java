package com.vinicius.gerarelatorio.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vinicius.gerarelatorio.spring.model.Cidade;

/**
 * Interface CidadeRepository responsável por anotar nossas operações de CRUD ( acessar banco de dados, consultas, etc ).
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	@Query( value = "SELECT c.* FROM cidade AS c, estado as e WHERE e.id = estado_id AND estado_id = :estado_id", nativeQuery = true)
	public List<Cidade> findAllCidadesByEstado( @Param("estado_id") Integer id);

}
