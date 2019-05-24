package br.com.irevisao.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Relatorio;
import br.com.irevisao.model.RelatorioDAO;

public class CadastrarRelatorioLogica implements Logica {
	/**
	 * Classe que executa a logica de cadastrar um novo relatorio.
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Relatorio relatorio = new Relatorio();
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
			dao.adiciona(relatorio);
			request.getRequestDispatcher("listar-obras.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("O executa do CadastraRelatorioLogica causou um erro!!!", e);
		}
	}
}
