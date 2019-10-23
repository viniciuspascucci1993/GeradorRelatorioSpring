package com.vinicius.gerarelatorio.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinicius.gerarelatorio.spring.services.CidadeService;
import com.vinicius.gerarelatorio.spring.services.EstadoService;

/**
 * Classe controller responsável pela geração de relatorios em formato HTML.
 * @author Vinicius-PC - vINICIUS tORRES pASCUCCI.
 */
@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
	
	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CidadeService cidadeService;
	
	/**
	 * Metodo para gerar relatorio HTML
	 * @param model - Object - model.
	 * @return index.html.
	 */
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String geraRelatorioHtml( @RequestParam(required = false, value = "estado") Integer id, Model model ) {
		
		model.addAttribute("estados", estadoService.findAll());
		
		if (id == null) {
			
			return "index.html";
		}
		
		model.addAttribute("list", cidadeService.gerarRelatorioCidade(id));	
		
		return "index.html";
	}
}
