package br.com.irevisao.model;

import java.util.Calendar;

/**
 * Classe Obra que eh referente a entidade Obra do banco de dados. A classe Obra
 * possui 10 atributos e seus respectivos getters e setters.
 * 
 * @author josinaldo
 */

public class Obra {

	private int idObra;
	private int idAutor;
	private String genero;
	private String titulo;
	private int qtPaginas;
	private int qtCapitulos;
	private String tipo;
	private String editora;
	private Calendar dataEntrada;
	private String status;

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQtPaginas() {
		return qtPaginas;
	}

	public void setQtPaginas(int qtPaginas) {
		this.qtPaginas = qtPaginas;
	}

	public int getQtCapitulos() {
		return qtCapitulos;
	}

	public void setQtCapitulos(int qtCapitulos) {
		this.qtCapitulos = qtCapitulos;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
