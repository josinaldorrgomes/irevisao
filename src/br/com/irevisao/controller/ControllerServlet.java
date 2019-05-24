package br.com.irevisao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe ControllerServlet que serve para controlar as acoes do sistema como
 * adicionar, ler, atualizar ou remover dados do banco de dados atraves das
 * logicas.
 */

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Class<?> classe = Class.forName("br.com.irevisao.controller." + request.getParameter("logica"));
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException(
					"A logica de negocios do controllerServlet causou uma excecao", e);
		}
	}
}