package br.com.irevisao.model;

import java.util.Calendar;

/**
 * Classe Relatorio que eh referente a entidade Relatorio do banco de dados. A
 * classe Relatorio possui 7 atributos e seus respectivos getters e setters.
 * 
 * @author josinaldo
 */

public class Relatorio {

	private int idRelatorio;
	private int idObra;
	private String tipo;
	private String descricao;
	private Calendar dataRegistro;

	public int getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(int idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
