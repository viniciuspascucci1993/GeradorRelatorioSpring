package com.vinicius.gerarelatorio.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinicius.gerarelatorio.spring.model.Estado;
import com.vinicius.gerarelatorio.spring.model.RelatorioGrafico;

/**
 * Interface EstadoRepository responsável por anotar nossas operações de CRUD ( acessar banco de dados, consultas, etc ).
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	// Consulta JPQL (somando o total de cidades que o estado possui).
	@Query(value = "SELECT new com.vinicius.gerarelatorio.spring.model.RelatorioGrafico(estado.id, estado.nome, (select count(*) FROM Cidade cidade WHERE cidade.estado_id = estado.id ) ) FROM Estado estado")
	public List<RelatorioGrafico> contarCidadesByEstados();

}
