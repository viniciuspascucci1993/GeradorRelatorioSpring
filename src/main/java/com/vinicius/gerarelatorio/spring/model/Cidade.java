package com.vinicius.gerarelatorio.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Classe responsável por conter atributos de uma cidade.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Entity
public class Cidade implements Serializable{

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Representa o identificador da cidade.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	/**
	 * Representa o nome da cidade.
	 */
	private String nome;
	
	/**
	 * Representa o estado.
	 */
	@ManyToOne
	@JoinColumn( name = "estado_id")
	@JsonBackReference
	private Estado estado_id;
	
	/**
	 * Construtor vazio.
	 */
	public Cidade() { }

	/**
	 * Construtor com argumentos.
	 * @param id - Integer - identificador da cidade.
	 * @param nome - String - nome da cidade.
	 */
	public Cidade(Integer id, String nome, Estado estado_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado_id = estado_id;
	}

	/**
	 * Metodo get().
	 * @return id - Integer - identificador da cidade.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Metodo set().
	 * @param id - Integer - identificador da cidade.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Metodo get().
	 * @return nome - String - nome da cidade.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo set().
	 * @param nome - String - nome da cidade.
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo get().
	 * @return estados - Object - representa um estado.
	 */
	public Estado getEstados() {
		return this.estado_id;
	}

	/**
	 * Metodo set().
	 * @param estados - Object - representa um estado.
	 */
	public void setEstados(final Estado estado_id) {
		this.estado_id = estado_id;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
