package com.vinicius.gerarelatorio.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.gerarelatorio.spring.model.Estado;
import com.vinicius.gerarelatorio.spring.services.EstadoService;

/**
 * Classe EstadoController que representa os nossos serviços REST. Será o nosso controller.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping( method = RequestMethod.GET)
	@ResponseStatus( code = HttpStatus.OK)
	public List<Estado> findAll() {
		
		return estadoService.findAll();
	}
	
	@RequestMapping( method = RequestMethod.POST)
	@ResponseStatus( code = HttpStatus.CREATED)
	public Estado insert( @RequestBody Estado estado ) {
		
		return estadoService.insert(estado);
	}
}
