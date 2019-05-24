package br.com.irevisao.model;

/**
 * Classe Usuario que eh referente a entidade Usuario do banco de dados. A
 * classe Usuario possui 3 atributos e seus respectivos getters e setters.
 * 
 * @author josinaldo
 */

public class Usuario {

	private int idUsuario;
	private String email;
	private String senha;
	/**
	 * @return the iduSuario
	 */
	public int getIdusuario() {
		return idUsuario;
	}
	/**
	 * @param iduSuario the iduSuario to set
	 */
	public void setIdusuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
