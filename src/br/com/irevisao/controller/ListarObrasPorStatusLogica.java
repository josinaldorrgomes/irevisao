package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.ObraDAO;

/**
 * Classe do pacote de logicas que lista as obras por status.
 * 
 * @author josinaldo
 */
public class ListarObrasPorStatusLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("listarObrasPorStatus", new ObraDAO().getListarObrasPorStatus(request.getParameter("status")));
		request.getRequestDispatcher("listar-obras.jsp").forward(request, response);
	}
}
