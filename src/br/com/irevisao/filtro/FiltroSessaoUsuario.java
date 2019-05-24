package br.com.irevisao.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroSessaoUsuario
 */
@WebFilter(urlPatterns = { "*.jsp" })
public class FiltroSessaoUsuario implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length())
					.replaceAll("[/]+$", "");
			if (httpRequest.getSession().getAttribute("usuario") == null) {
				if (!(path.equalsIgnoreCase("/login.jsp") || path.equalsIgnoreCase("/erro-login.jsp"))) {
					httpRequest.getRequestDispatcher("login.jsp").forward(httpRequest, httpResponse);
				}
			}
			chain.doFilter(httpRequest, httpResponse);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro no filtro de sessao do usuario.", e);
		}
	}

	public void destroy() {

	}
}
