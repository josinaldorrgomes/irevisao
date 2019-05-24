package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.RelatorioDAO;
/**
 * Classe do pacote de logicas que lista os relatorios de uma obra especifica.
 * 
 * @author josinaldo
 */
public class ListarRelatoriosObraLogica implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("listarRelatoriosObra", new RelatorioDAO().getListarRelatoriosObra(request.getParameter("idObra")));
		request.getRequestDispatcher("listar-relatorios-obra.jsp").forward(request, response);
	}
}