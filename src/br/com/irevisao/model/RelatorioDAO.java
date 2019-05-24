package br.com.irevisao.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioDAO {

	/**
	 * Metodo adicionar um relatorio no banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public void adiciona(Relatorio relatorio) {
		try {
			// prepared statement para insercao no banco de dados
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("insert into Relatorio (idObra,tipo,descricao,dataRegistro) values (?,?,?,?)");
			// seta os valores
			stmt.setInt(1, relatorio.getIdObra());
			stmt.setString(2, relatorio.getTipo());
			stmt.setString(3, relatorio.getDescricao());
			stmt.setDate(4, new Date(relatorio.getDataRegistro().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel adicionar a obra no banco de dados!!! Verifique o que ocorreu de errado!!!", e);
		}
	}

	/**
	 * Metodo Lista da classe Relatorio. Este metodo implementa a lista de
	 * relatorios que sera mostrada no arquivo lista-relatorios.jsp. Eh feito o
	 * acesso ao banco de dados e atraves do PreparedStatement passando a String
	 * SQL para o Banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public List<Relatorio> getLista() {
		try {
			List<Relatorio> relatorios = new ArrayList<Relatorio>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("select * from Relatorio order by idRelatorio");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setIdRelatorio(rs.getInt("idRelatorio"));
				relatorio.setIdObra(rs.getInt("idObra"));
				relatorio.setTipo(rs.getString("tipo"));
				relatorio.setDescricao(rs.getString("descricao"));
				/*
				 * Montando a dataRegistro atraves do Calendar.
				 * */
				Calendar dataRegistro = Calendar.getInstance();
				dataRegistro.setTime(rs.getDate("dataRegistro"));
				relatorio.setDataRegistro(dataRegistro);
				relatorios.add(relatorio);
			}
			rs.close();
			stmt.close();
			return relatorios;
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel listar os relatorios do banco de dados!!! Verifique o que houve de errado!!!", e);
		}
	}

	/**
	 * Metodo altera da classe Relatorio. Implementa a String SQL para
	 * atualizacao das informacoes do Relatorio no banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public void altera(Relatorio relatorio) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("update Relatorio set idObra=?, tipo=?, descricao=?, dataRegistro=? where idRelatorio=?");
			stmt.setInt(5, relatorio.getIdRelatorio());
			stmt.setInt(1, relatorio.getIdObra());
			stmt.setString(2, relatorio.getTipo());
			stmt.setString(3, relatorio.getDescricao());
			stmt.setDate(4, new Date(relatorio.getDataRegistro().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel realizar a alteracao do relatorio!!! Verifique o que houve de errado!!!", e);
		}
	}

	/**
	 * Metodo remove da classe Relatorio. Implementa a String SQL para remocao
	 * de um relatorio especifico do banco de dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public void remove(Relatorio relatorio) {
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("delete from Relatorio where idRelatorio=?");
			stmt.setInt(1, relatorio.getIdRelatorio());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Nao foi possivel remover o relatorio do banco de dados!!! Verifique o que ocorreu de errado!!!");
		}
	}

	/**
	 * Metodo buscar um relatorio especifico no banco de dados. Este metodo eh
	 * utilizado para buscar um relatorio para a realizacao da alteracao dos
	 * seus dados.
	 * 
	 * @author josinaldo
	 * 
	 */
	public Relatorio getRelatorioById(String idRelatorio) {
		Relatorio relatorio = new Relatorio();
		try {
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("select * from Relatorio where idRelatorio=?");
			stmt.setInt(1, Integer.parseInt(idRelatorio));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				relatorio.setIdRelatorio(rs.getInt("idRelatorio"));
				relatorio.setIdObra(rs.getInt("idObra"));
				relatorio.setTipo(rs.getString("tipo"));
				relatorio.setDescricao(rs.getString("descricao"));
				/*
				 * Montando a dataRegistro atraves do Calendar.
				 * */
				Calendar dataRegistro = Calendar.getInstance();
				dataRegistro.setTime(rs.getDate("dataRegistro"));
				relatorio.setDataRegistro(dataRegistro);
			}
			rs.close();
			stmt.close();
			return relatorio;
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar o relatorio!!!", e);
		}
	}

	/**
	 * Metodo utilizado para buscar os relatorios de uma obra especifica no banco de dados.
	 * Este metodo eh utilizado para buscar os relatorios de uma obra pelo
	 * numero ID
	 * 
	 * @author josinaldo
	 * 
	 */
	public List<Relatorio> getListarRelatoriosObra(String idObra) {
		try {
			List<Relatorio> relatorios = new ArrayList<Relatorio>();
			PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("select * from Relatorio where idObra=?");
			stmt.setInt(1, Integer.parseInt(idObra));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setIdRelatorio(rs.getInt("idRelatorio"));
				relatorio.setIdObra(rs.getInt("idObra"));
				relatorio.setTipo(rs.getString("tipo"));
				relatorio.setDescricao(rs.getString("descricao"));
				/*
				 * Montando a dataRegistro atraves do Calendar.
				 * */
				Calendar dataRegistro = Calendar.getInstance();
				dataRegistro.setTime(rs.getDate("dataRegistro"));
				relatorio.setDataRegistro(dataRegistro);
				// adicionando o relatorio na lista de relatorios da obra.
				relatorios.add(relatorio);
			}
			rs.close();
			stmt.close();
			return relatorios;
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel conectar com o banco ou encontrar os relatorios da obra!!!",
					e);
		}
	}
}