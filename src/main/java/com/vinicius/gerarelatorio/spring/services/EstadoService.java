package com.vinicius.gerarelatorio.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.gerarelatorio.spring.model.Estado;
import com.vinicius.gerarelatorio.spring.model.RelatorioGrafico;
import com.vinicius.gerarelatorio.spring.repositories.EstadoRepository;

/**
 * Service responsável por nossas operações de CRUD.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	/**
	 * Metodo para listar todos os estados.
	 * @return estadoRepository.findAll();
	 */
	public List<Estado> findAll() {
		
		return estadoRepository.findAll();
	}
	
	/**
	 * Metodo para criação de estado na base de dados.
	 * @param estado - Object - estado.
	 * @return estadoRepository.save(estado);
	 */
	public Estado insert( Estado estado ) {
		
		return this.estadoRepository.save(estado);
	}
	
	/**
	 * Metodo para contar as cidades a partir do estado.
	 * @return estadoRepository.contarCidadesByEstados();
	 */
	public List<RelatorioGrafico> contarCidadesByEstados() {
		
		return estadoRepository.contarCidadesByEstados();
	}
}
