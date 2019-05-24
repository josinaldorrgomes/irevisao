package br.com.irevisao.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ObraDAO {

	public ObraDAO() {
	}

	public void adiciona(Obra obra) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(
					"insert into Obra (idAutor,genero,titulo,qtPaginas,qtCapitulos,tipo,editora,dataEntrada,status) values (?,?,?,?,?,?,?,?,?)");
			// seta os valores
			stmt.setInt(1, obra.getIdAutor());
			stmt.setString(2, obra.getGenero());
			stmt.setString(3, obra.getTitulo());
			stmt.setInt(4, obra.getQtPaginas());
			stmt.setInt(5, obra.getQtCapitulos());
			stmt.setString(6, obra.getTipo());
			stmt.setString(7, obra.getEditora());
			stmt.setDate(8, new Date(obra.getDataEntrada().getTimeInMillis()));
			stmt.setString(9, obra.getStatus());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel adicionar a obra no banco de dados!!! Verifique o que ocorreu de errado!!!", e);
		}
	}

	/**
	 * Metodo Lista da classe Obra. Este metodo implementa a lista de Obras que sera
	 * mostrada no arquivo lista-obras.jsp, ou seja todas as obras existentes. Eh
	 * feito o acesso ao banco de dados e atraves do PreparedStatement passando a
	 * String SQL para o Banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public List<Obra> getLista() {
		try {
			List<Obra> obras = new ArrayList<Obra>();
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Obra order by idObra");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Obra
				Obra obra = new Obra();
				obra.setIdObra(rs.getInt("idObra"));
				obra.setIdAutor(rs.getInt("idAutor"));
				obra.setGenero(rs.getString("genero"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setQtPaginas(rs.getInt("qtPaginas"));
				obra.setQtCapitulos(rs.getInt("qtCapitulos"));
				obra.setTipo(rs.getString("tipo"));
				obra.setEditora(rs.getString("editora"));
				// montando a dataEntrada atraves do Calendar
				Calendar dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(rs.getDate("dataEntrada"));
				obra.setDataEntrada(dataEntrada);
				obra.setStatus(rs.getString("status"));
				// adicionando o objeto ah lista
				obras.add(obra);
			}
			rs.close();
			stmt.close();
			return obras;
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel listar as obras do banco de dados!!! Verifique o que houve de errado!!!", e);
		}
	}

	/**
	 * Metodo altera da classe Obra. Implementa a String SQL para atualizacao das
	 * informacoes de uma Obra no banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public void altera(Obra obra) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(
					"update Obra set idAutor=?, genero=?, titulo=?, qtPaginas=?, qtCapitulos=?, tipo=?, editora=?, dataEntrada=?, status=? where idObra=?");
			stmt.setInt(10, obra.getIdObra());
			stmt.setInt(1, obra.getIdAutor());
			stmt.setString(2, obra.getGenero());
			stmt.setString(3, obra.getTitulo());
			stmt.setInt(4, obra.getQtPaginas());
			stmt.setInt(5, obra.getQtCapitulos());
			stmt.setString(6, obra.getTipo());
			stmt.setString(7, obra.getEditora());
			stmt.setDate(8, new Date(obra.getDataEntrada().getTimeInMillis()));
			stmt.setString(9, obra.getStatus());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel realizar a alteracao dos dados da obra!!! Verifique o que houve de errado!!!", e);
		}
	}

	/**
	 * Metodo remove da classe Obra. Implementa a String SQL para remocao de uma
	 * obra especifica do banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public void remove(Obra obra) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("delete from Obra where idObra=?");
			stmt.setInt(1, obra.getIdObra());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel remover a obra do banco de dados!!! Verifique o que ocorreu de errado!!!");
		}
	}

	/**
	 * Metodo buscar uma obra especifica no banco de dados. Este metodo eh utilizado
	 * para buscar uma obra para a realizacao da alteracao dos seus dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public Obra getObraById(String idObra) {
		Obra obra = new Obra();
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Obra where idObra=?");
			stmt.setInt(1, Integer.parseInt(idObra));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				obra.setIdObra(rs.getInt("idObra"));
				obra.setIdAutor(rs.getInt("idAutor"));
				obra.setGenero(rs.getString("genero"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setQtPaginas(rs.getInt("qtPaginas"));
				obra.setQtCapitulos(rs.getInt("qtCapitulos"));
				obra.setTipo(rs.getString("tipo"));
				obra.setEditora(rs.getString("editora"));
				// montando a dataEntrada atraves do Calendar
				Calendar dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(rs.getDate("dataEntrada"));
				obra.setDataEntrada(dataEntrada);
				obra.setStatus(rs.getString("status"));
			}
			rs.close();
			stmt.close();
			return obra;
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar a obra!!!", e);
		}
	}

	/**
	 * Metodo buscar as obras de uma autor especifico no banco de dados. Este metodo
	 * eh utilizado para buscar as obras de um autor pelo numero ID
	 * 
	 * @author josinaldo
	 * 
	 */
	public List<Obra> getListarObrasAutor(String idAutor) {
		try {
			List<Obra> obras = new ArrayList<Obra>();
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Obra where idAutor=?");
			stmt.setInt(1, Integer.parseInt(idAutor));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Obra obra = new Obra();
				obra.setIdObra(rs.getInt("idObra"));
				obra.setIdAutor(rs.getInt("idAutor"));
				obra.setGenero(rs.getString("genero"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setQtPaginas(rs.getInt("qtPaginas"));
				obra.setQtCapitulos(rs.getInt("qtCapitulos"));
				obra.setTipo(rs.getString("tipo"));
				obra.setEditora(rs.getString("editora"));
				// montando a dataEntrada atraves do Calendar
				Calendar dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(rs.getDate("dataEntrada"));
				obra.setDataEntrada(dataEntrada);
				obra.setStatus(rs.getString("status"));
				// adicionando a obra na lista de obras do autor
				obras.add(obra);
			}
			rs.close();
			stmt.close();
			return obras;

		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar as obras do autor!!!", e);
		}
	}

	/**
	 * Metodo buscar as obras recebidas no banco de dados. Este metodo eh utilizado
	 * para buscar as obras recebidas para serem revisadas.
	 * 
	 * @author josinaldo
	 * 
	 */
	public List<Obra> getListarObrasPorStatus(String status) {
		try {
			List<Obra> obras = new ArrayList<Obra>();
			PreparedStatement stmt = new ConnectionFactory().getConnection()
					.prepareStatement("select * from Obra where status=?");
			stmt.setString(1, status);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Obra obra = new Obra();
				obra.setIdObra(rs.getInt("idObra"));
				obra.setIdAutor(rs.getInt("idAutor"));
				obra.setGenero(rs.getString("genero"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setQtPaginas(rs.getInt("qtPaginas"));
				obra.setQtCapitulos(rs.getInt("qtCapitulos"));
				obra.setTipo(rs.getString("tipo"));
				obra.setEditora(rs.getString("editora"));
				// montando a dataEntrada atraves do Calendar
				Calendar dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(rs.getDate("dataEntrada"));
				obra.setDataEntrada(dataEntrada);
				obra.setStatus(rs.getString("status"));
				// adicionando a obra na lista de obras
				obras.add(obra);
			}
			rs.close();
			stmt.close();
			return obras;

		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar as obras recebidas!!!", e);
		}
	}
}