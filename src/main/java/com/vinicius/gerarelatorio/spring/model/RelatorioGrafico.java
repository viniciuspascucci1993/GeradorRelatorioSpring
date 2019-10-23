package com.vinicius.gerarelatorio.spring.model;

import java.io.Serializable;

/**
 * Classe POJO responsável por conter os atributos de um relatório de gráfico.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class RelatorioGrafico implements Serializable{

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Representa o identificado do relatório de grafico.
	 */
	private Integer id;
	
	/**
	 * Representa o nome do grafico.
	 */
	private String nome;
	
	/**
	 * Representa um total de cidades que o estado possui.
	 */
	private Long total;
	
	/**
	 * Construtor vazio.
	 */
	public RelatorioGrafico() { }

	/**
	 * Construtor com argumentos.
	 * @param id - Integer - identificador do grafico.
	 * @param nome - String - nome do grafico.
	 * @param total - Integer - total de cidades que o estado possui
	 */
	public RelatorioGrafico(Integer id, String nome, Long total) {
		super();
		this.id = id;
		this.nome = nome;
		this.total = total;
	}


	/**
	 * Metodo get().
	 * @return id - Integer - identificador do estado.
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Metodo set().
	 * @param id - Integer - identificador do estado.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Metodo get().
	 * @return nome - String - nome do grafico.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo set().
	 * @param nome - String - nome do grafico.
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo get().
	 * @return total - Integer - total de cidades que o estado possui.
	 */
	public Long getTotal() {
		return this.total;
	}

	/**
	 * Metodo set().
	 * @param total - Integer - total de cidades que o estado possui.
	 */
	public void setTotal(final Long total) {
		this.total = total;
	}

	/**
	 * Metodo hashCode (Comparar objetos por valor)
	 * Faz uma comparação entre o id
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Metodo equals (Comparar objetos por valor)
	 * Faz uma comparação entre o id
	 */	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatorioGrafico other = (RelatorioGrafico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
