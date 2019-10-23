package com.vinicius.gerarelatorio.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.gerarelatorio.spring.model.Cidade;
import com.vinicius.gerarelatorio.spring.model.Estado;
import com.vinicius.gerarelatorio.spring.repositories.CidadeRepository;
import com.vinicius.gerarelatorio.spring.repositories.EstadoRepository;

/**
 * Service responsável por nossas operações de CRUD.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	/**
	 * Service responsável por implementar nossa inserção.
	 * @param cidade - Object - cidade.
	 * @return cidadeRepository.save(cidade);
	 */
	public Cidade insert(Integer estadoId, Cidade cidade ) {
		
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		
		cidade.setEstados(estado.get());
		
		return this.cidadeRepository.save(cidade);
	}
}
