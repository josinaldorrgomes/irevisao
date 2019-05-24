package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.irevisao.model.Autor;
import br.com.irevisao.model.AutorDAO;

/**
 * Classe do pacote de logicas que altera os dados do autor.
 * 
 * @author josinaldo
 */
public class AlteraAutorLogica implements Logica {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getParameter("parametro").equalsIgnoreCase("altera")) {
			this.altera(request, response);
		} else if (request.getParameter("parametro").equalsIgnoreCase("popula")) {
			this.popula(request, response);
		}
	}

	/**
	 * Classe que executa a logica de alterar os dados de um autor.
	 */
	public void altera(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Autor autor = new Autor();
		int idAutor = Integer.parseInt(request.getParameter("idAutor"));
		autor.setIdAutor(idAutor);
		autor.setNome(request.getParameter("nome"));
		autor.setInstituicao(request.getParameter("instituicao"));
		autor.setEmail(request.getParameter("email"));
		autor.setTelefone(request.getParameter("telefone"));
		autor.setDepartamento(request.getParameter("departamento"));
		autor.setAreaAtuacao(request.getParameter("areaAtuacao"));
		AutorDAO dao = new AutorDAO();
		dao.altera(autor);
		request.getRequestDispatcher("listar-autores.jsp").forward(request, response);
	}

	/**
	 * Classe que executa a logica de popular os dados de um autor no formulario de
	 * alteracao dos dados.
	 */
	public void popula(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Autor autor = new AutorDAO().getAutorById(request.getParameter("idAutor"));
		request.setAttribute("autor", autor);
		request.getRequestDispatcher("alterar-autor.jsp").forward(request, response);
	}
}