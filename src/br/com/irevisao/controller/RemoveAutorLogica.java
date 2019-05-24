package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Autor;
import br.com.irevisao.model.AutorDAO;

public class RemoveAutorLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Autor autor = new Autor();
		int idAutor = Integer.parseInt(request.getParameter("idAutor"));
		autor.setIdAutor(idAutor);
		AutorDAO dao = new AutorDAO();
		dao.remove(autor);
		request.getRequestDispatcher("listar-autores.jsp").forward(request, response);
	}
}