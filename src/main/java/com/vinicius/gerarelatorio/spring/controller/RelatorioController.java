package com.vinicius.gerarelatorio.spring.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinicius.gerarelatorio.spring.model.Cidade;
import com.vinicius.gerarelatorio.spring.model.RelatorioGrafico;
import com.vinicius.gerarelatorio.spring.services.CidadeService;
import com.vinicius.gerarelatorio.spring.services.EstadoService;
import com.vinicius.gerarelatorio.spring.utils.GeradorPDFUtil;

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
	
	/**
	 * Metodo para contar as cidades a partir do estado.
	 * @param id - Integer - identificador.
	 * @param model - Object - Template.
	 * @return relatorio/graficos.
	 */
	@RequestMapping(value = "/graficos", method = RequestMethod.GET)
	public String geraRelatorioGrafico(Model model ) {
		
		List<RelatorioGrafico> relatorioGraficoList = estadoService.contarCidadesByEstados(); 
		
		// Transformar uma lista em Array
		model.addAttribute("labels", relatorioGraficoList.stream().map(RelatorioGrafico::getNome).collect(Collectors.toList())); 	
		
		model.addAttribute("data", relatorioGraficoList.stream().map(RelatorioGrafico::getTotal).collect(Collectors.toList()));
		return "relatorios/graficos";
	}
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public ResponseEntity<InputStreamSource> geradorRelatorioPdf( @RequestParam(required = false, value = "estado") Integer id, Model model ) {
		
		model.addAttribute("estados", estadoService.findAll());
		
		if (id == null) {
			
			return null;
		}
		
		List<Cidade> list = cidadeService.gerarRelatorioCidade(id);
		
		ByteArrayInputStream pdf = GeradorPDFUtil.geradorPdf(list);
		
		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=relatorio.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));
	}
}
