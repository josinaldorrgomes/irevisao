package br.com.irevisao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Connection Factory responsavel por implementar a conexao com o banco
 * de dados e genrenciar essas conexoes.
 * 
 * @author josinaldo
 */

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/irevisao_db", "root", "1123581f");
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel conectar-se com o banco de dados!!! Verifique o que houve de errado!!!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Classe nao encontrada!!! Verifique o que causou esse erro!!!");
		}
	}
}
