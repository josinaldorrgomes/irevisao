package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Relatorio;
import br.com.irevisao.model.RelatorioDAO;

public class RemoveRelatorioLogica implements Logica {
	/**
	 * Metodo que executa a logica de remocao do Relatorio.
	 * 
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Relatorio relatorio = new Relatorio();
		relatorio.setIdRelatorio(Integer.parseInt(request.getParameter("idRelatorio")));
		RelatorioDAO dao = new RelatorioDAO();
		dao.remove(relatorio);
		request.getRequestDispatcher("listar-relatorios.jsp").forward(request, response);
	}
}