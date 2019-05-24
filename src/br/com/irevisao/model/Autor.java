package br.com.irevisao.model;

/**
 * Classe Autor que eh referente a entidade Autor do banco de dados. A classe
 * Autor possui 6 atributos e seus respectivos getters e setters.
 * 
 * @author josinaldo
 * */
public class Autor {
	private int idAutor;
	private String nome;
	private String instituicao;
	private String email;
	private String telefone;
	private String departamento;
	private String areaAtuacao;
	/**
	 * @return the idAutor
	 */
	public int getIdAutor() {
		return idAutor;
	}

	/**
	 * @param idAutor the idAutor to set
	 */
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
}