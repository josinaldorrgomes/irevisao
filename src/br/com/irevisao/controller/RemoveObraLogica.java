package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Obra;
import br.com.irevisao.model.ObraDAO;

public class RemoveObraLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Obra obra = new Obra();
		int idObra = Integer.parseInt(request.getParameter("idObra"));
		obra.setIdObra(idObra);
		ObraDAO dao = new ObraDAO();
		dao.remove(obra);
		request.getRequestDispatcher("listar-obras.jsp").forward(request, response);
	}
}