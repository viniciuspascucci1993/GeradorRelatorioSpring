package com.vinicius.gerarelatorio.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.gerarelatorio.spring.model.Cidade;
import com.vinicius.gerarelatorio.spring.services.CidadeService;

/**
 * Classe EstadoController que representa os nossos serviços REST. Será o nosso controller.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping("/estados/{estadoId}/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	/**
	 * Metodo para criação de uma cidade na base de dados.
	 * @param cidade - Object - cidade.
	 * @return cidadeService.insert(cidade);
	 */
	@RequestMapping( method = RequestMethod.POST)
	@ResponseStatus( code = HttpStatus.CREATED)
	public Cidade insert( @PathVariable("estadoId") Integer estadoId,  @RequestBody Cidade cidade ) {
		
		return cidadeService.insert(estadoId, cidade);
	}
}
