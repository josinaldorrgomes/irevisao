package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Autor;
import br.com.irevisao.model.AutorDAO;

/**
 * Classe do pacote de logicas que cadastra um novo autor.
 * 
 * @author josinaldo
 */

public class CadastrarAutorLogica implements Logica {
	/**
	 * Classe que executa a logica de cadastrar um novo autor.
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Autor autor = new Autor();
			autor.setNome(request.getParameter("nome"));
			autor.setInstituicao(request.getParameter("instituicao"));
			autor.setEmail(request.getParameter("email"));
			autor.setTelefone(request.getParameter("telefone"));
			autor.setDepartamento(request.getParameter("departamento"));
			autor.setAreaAtuacao(request.getParameter("areaAtuacao"));
			AutorDAO dao = new AutorDAO();
			dao.adiciona(autor);
			request.getRequestDispatcher("autor.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException("O executa do CadastraAutorLogica causou um erro!!!", e);
		}
	}
}
