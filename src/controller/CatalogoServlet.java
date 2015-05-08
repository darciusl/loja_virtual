package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistema.Consultas;
import controller.util.UsuarioUtil;
import dominio.Produto;
import dominio.Usuario;

@WebServlet("/publico/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String CATALOGO = "/publico/catalogo.jsp";

	@Inject
	private Consultas fachadaConsultas;
	@Inject
	private UsuarioUtil usuarioUtil;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = usuarioUtil.getUsuarioLogado();

		List<Produto> lista = fachadaConsultas.buscarTodosProdutos();

		request.setAttribute("lista", lista);
		request.setAttribute("usuario", usuario);
		String forward = CATALOGO;
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
