package br.com.irevisao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutUsuarioLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getParameter("parametro").equalsIgnoreCase("logout")) {
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
