package br.com.irevisao.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	/**
	 * Metodo para verificar se o usuario esta cadastrado no sistema.
	 * 
	 * @author josinaldo
	 * 
	 */
	public boolean validaLogin(Usuario usuario) {
		boolean validacao = false;
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("select * from Usuario where email=? and senha=?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("email").equals(usuario.getEmail())) {
					if (rs.getString("senha").equals(usuario.getSenha())) {
						validacao = true;
					}
				}
			}
			rs.close();
			stmt.close();
			return validacao;
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar o usuario!!!", e);
		}
	}

}