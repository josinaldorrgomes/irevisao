package br.com.irevisao.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Obra;
import br.com.irevisao.model.ObraDAO;

public class CadastrarObraLogica implements Logica {

	/**
	 * Classe que executa a logica de adicionar uma nova obra.
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Obra obra = new Obra();
			int idAutor = Integer.parseInt(request.getParameter("idAutor"));
			obra.setIdAutor(idAutor);
			obra.setGenero(request.getParameter("genero"));
			obra.setTitulo(request.getParameter("titulo"));
			int qtPaginas = Integer.parseInt(request.getParameter("qtPaginas"));
			obra.setQtPaginas(qtPaginas);
			int qtCapitulos = Integer.parseInt(request.getParameter("qtCapitulos"));
			obra.setQtCapitulos(qtCapitulos);
			obra.setTipo(request.getParameter("tipo"));
			obra.setEditora(request.getParameter("editora"));
			// Convertendo a data de entrada da obra para o tipo Calendar.
			String dataTextoEntrada = request.getParameter("dataEntrada");
			Date dateEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataTextoEntrada);
			Calendar dataEntrada = Calendar.getInstance();
			dataEntrada.setTime(dateEntrada);
			obra.setDataEntrada(dataEntrada);
			obra.setStatus(request.getParameter("status"));
			ObraDAO dao = new ObraDAO();
			dao.adiciona(obra);
			request.getRequestDispatcher("listar-autores.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("O executa do AdicionaObraLogica causou um erro!!!", e);
		}
	}
}
