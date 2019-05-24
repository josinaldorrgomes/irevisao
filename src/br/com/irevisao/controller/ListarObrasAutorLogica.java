package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.ObraDAO;

/**
 * Classe do pacote de logicas que lista as obras de um autor especifico.
 * 
 * @author josinaldo
 */
public class ListarObrasAutorLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("listarObrasAutor", new ObraDAO().getListarObrasAutor(request.getParameter("idAutor")));
		request.getRequestDispatcher("listar-obras-autor.jsp").forward(request, response);
	}
}
