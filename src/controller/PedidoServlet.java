package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistema.SistemaException;
import sistema.GerenciadorDePedido;
import dominio.Carrinho;
import dominio.Pedido;

@WebServlet("/cliente/PedidoServlet")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String ERRO = "/publico/erro.jsp";
	private static String SUCESSO = "/cliente/obrigado.jsp";
	
	@Inject
	private GerenciadorDePedido fachadaPedido;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);
		Carrinho car = (Carrinho) sessao.getAttribute("carrinho");
		if (car == null) {
			car = new Carrinho();
			sessao.setAttribute("carrinho", car);
		}

		String forward = SUCESSO;
		
		try {
			Pedido pedido = fachadaPedido.registrarPedido(car);
			request.setAttribute("pedido", pedido);
		} catch (SistemaException e) {
			request.setAttribute("erro", e.getMessage());
			forward = ERRO;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
