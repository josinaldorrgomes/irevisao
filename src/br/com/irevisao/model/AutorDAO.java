package br.com.irevisao.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

	public AutorDAO() {
	}

	public void adiciona(Autor autor) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(
					"insert into Autor (nome,instituicao,email,telefone,departamento,areaAtuacao) values (?,?,?,?,?,?)");
			stmt.setString(1, autor.getNome());
			stmt.setString(2, autor.getInstituicao());
			stmt.setString(3, autor.getEmail());
			stmt.setString(4, autor.getTelefone());
			stmt.setString(5, autor.getDepartamento());
			stmt.setString(6, autor.getAreaAtuacao());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel adicionar o autor no banco de dados!!! Verifique o que ocorreu de errado!!!", e);
		}
	}

	public List<Autor> getLista() {
		try {
			List<Autor> autores = new ArrayList<Autor>();
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Autor order by idAutor");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idAutor"));
				autor.setNome(rs.getString("nome"));
				autor.setInstituicao(rs.getString("instituicao"));
				autor.setEmail(rs.getString("email"));
				autor.setTelefone(rs.getString("telefone"));
				autor.setDepartamento(rs.getString("departamento"));
				autor.setAreaAtuacao(rs.getString("areaAtuacao"));
				autores.add(autor);
			}
			rs.close();
			stmt.close();
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel listar os autores do banco de dados!!! Verifique o que houve de errado!!!", e);
		}
	}

	public void altera(Autor autor) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(
					"update Autor set nome=?, instituicao=?, email=?, telefone=?, departamento=?, areaAtuacao=? where idAutor=?");
			stmt.setInt(7, autor.getIdAutor());
			stmt.setString(1, autor.getNome());
			stmt.setString(2, autor.getInstituicao());
			stmt.setString(3, autor.getEmail());
			stmt.setString(4, autor.getTelefone());
			stmt.setString(5, autor.getDepartamento());
			stmt.setString(6, autor.getAreaAtuacao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel realizar a alteracao dos dados do autor!!! Verifique o que houve de errado!!!",
					e);
		}
	}

	public void remove(Autor autor) throws Exception {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("delete from Autor where idAutor=?");
			stmt.setInt(1, autor.getIdAutor());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel remover o autor do banco de dados!!! Verifique o que ocorreu de errado!!!");
		}
	}

	public Autor getAutorById(String idAutor) {
		Autor autor = new Autor();
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Autor where idAutor=?");
			stmt.setInt(1, Integer.parseInt(idAutor));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				autor.setIdAutor(rs.getInt("idAutor"));
				autor.setNome(rs.getString("nome"));
				autor.setInstituicao(rs.getString("instituicao"));
				autor.setEmail(rs.getString("email"));
				autor.setTelefone(rs.getString("telefone"));
				autor.setDepartamento(rs.getString("departamento"));
				autor.setAreaAtuacao(rs.getString("areaAtuacao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar o autor!!!", e);
		}
		return autor;
	}
}