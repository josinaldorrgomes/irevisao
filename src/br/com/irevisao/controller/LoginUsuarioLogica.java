package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.irevisao.model.Usuario;
import br.com.irevisao.model.UsuarioDAO;

public class LoginUsuarioLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		HttpSession sessao = request.getSession();
		if (new UsuarioDAO().validaLogin(usuario)) {
			sessao.setAttribute("usuario", usuario.getEmail());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("erro-login.jsp").forward(request, response);
		}
	}
}
