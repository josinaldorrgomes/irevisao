package br.com.irevisao.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Relatorio;
import br.com.irevisao.model.RelatorioDAO;

/**
 * Classe do pacote de l�gicas que altera os dados da obra.
 * 
 * @author josinaldo
 */
public class AlteraRelatorioLogica implements Logica {
	/**
	 * Classe que executa a logica de alterar um novo autor.
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getParameter("parametro").equalsIgnoreCase("altera")) {
			this.altera(request, response);
		} else if (request.getParameter("parametro").equalsIgnoreCase("popula")) {
			this.popula(request, response);
		}
	}
	/**
	 * Classe que executa a logica de alterar os dados de um relatorio.
	 */
	public void altera(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Relatorio relatorio = new Relatorio();
		int idRelatorio = Integer.parseInt(request.getParameter("idRelatorio"));
		relatorio.setIdRelatorio(idRelatorio);
		int idObra = Integer.parseInt(request.getParameter("idObra"));
		relatorio.setIdObra(idObra);
		relatorio.setTipo(request.getParameter("tipo"));
		relatorio.setDescricao(request.getParameter("descricao"));
		String dataTextoRegistro = request.getParameter("dataRegistro");
		Date dateRegistro = new SimpleDateFormat("dd/MM/yyyy").parse(dataTextoRegistro);
		Calendar dataRegistro = Calendar.getInstance();
		dataRegistro.setTime(dateRegistro);
		relatorio.setDataRegistro(dataRegistro);
		RelatorioDAO dao = new RelatorioDAO();
		dao.altera(relatorio);
		request.getRequestDispatcher("listar-relatorios.jsp").forward(request, response);
	}

	/**
	 * Classe que executa a logica de popular os dados de um relatorio no
	 * formulario de alteracao de dados.
	 */
	public void popula(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("relatorio", new RelatorioDAO().getRelatorioById(request.getParameter("idRelatorio")));
		request.getRequestDispatcher("alterar-relatorio.jsp").forward(request, response);
	}

}
