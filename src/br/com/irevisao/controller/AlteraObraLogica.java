package br.com.irevisao.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Obra;
import br.com.irevisao.model.ObraDAO;

/**
 * Classe do pacote de logicas que altera os dados da obra.
 * 
 * @author josinaldo
 */

public class AlteraObraLogica implements Logica {
	/**
	 * Classe que executa a logica de alterar uma nova obra.
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getParameter("parametro").equalsIgnoreCase("altera")) {
			this.altera(request, response);
		} else if (request.getParameter("parametro").equalsIgnoreCase("popula")) {
			this.popula(request, response);
		}
	}

	/**
	 * Classe que executa a logica de alterar os dados de uma obra.
	 */
	public void altera(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Obra obra = new Obra();
		int idAutor = Integer.parseInt(request.getParameter("idAutor"));
		obra.setIdAutor(idAutor);
		int idObra = Integer.parseInt(request.getParameter("idObra"));
		obra.setIdObra(idObra);
		obra.setGenero(request.getParameter("genero"));
		obra.setTitulo(request.getParameter("titulo"));
		int qtPaginas = Integer.parseInt(request.getParameter("qtPaginas"));
		obra.setQtPaginas(qtPaginas);
		int qtCapitulos = Integer.parseInt(request.getParameter("qtCapitulos"));
		obra.setQtCapitulos(qtCapitulos);
		obra.setTipo(request.getParameter("tipo"));
		obra.setEditora(request.getParameter("editora"));
		String dataTextoEntrada = request.getParameter("dataEntrada");
		Date dateEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataTextoEntrada);
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.setTime(dateEntrada);
		obra.setDataEntrada(dataEntrada);
		obra.setStatus(request.getParameter("status"));
		ObraDAO dao = new ObraDAO();
		dao.altera(obra);
		request.getRequestDispatcher("listar-obras.jsp").forward(request, response);
	}

	/**
	 * Classe que executa a logica de popular os dados de uma obra no formulario
	 * de alteracao dos dados.
	 */
	public void popula(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("obra", new ObraDAO().getObraById(request.getParameter("idObra")));
		request.getRequestDispatcher("alterar-obra.jsp").forward(request, response);

	}
}
