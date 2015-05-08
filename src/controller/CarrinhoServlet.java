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

import sistema.Consultas;
import sistema.GerenciadorDeCarrinho;
import dominio.Carrinho;
import dominio.Produto;

@WebServlet("/cliente/CarrinhoServlet") 
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String CARRINHO = "/cliente/carrinho.jsp";
	private static String DETALHES = "/cliente/detalhes.jsp";

	@Inject
	private GerenciadorDeCarrinho fachadaCarrinho;
	@Inject
	private Consultas fachadaConsultas;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);
		Carrinho car = (Carrinho) sessao.getAttribute("carrinho");
		if (car == null) {
			car = new Carrinho();
			sessao.setAttribute("carrinho", car);
		}
		
		String cmd = request.getParameter("cmd");
		if (cmd == null)
			cmd = "";

		String forward = CARRINHO;
		
		if (cmd.equalsIgnoreCase("detalhes")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			Produto prod = fachadaConsultas.buscarProduto(cod);
			request.setAttribute("produto", prod);
			forward = DETALHES;
		}

		if (cmd.equalsIgnoreCase("inserir")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			fachadaCarrinho.inserirItem(car, cod, 1);
			forward = CARRINHO;
		}
		if (cmd.equalsIgnoreCase("incrementar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			fachadaCarrinho.incrementarItem(car, cod);
			forward = CARRINHO;
		}

		if (cmd.equalsIgnoreCase("decrementar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			fachadaCarrinho.decrementarItem(car, cod);
			forward = CARRINHO;
		}
		
		if (cmd.equalsIgnoreCase("excluir")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			fachadaCarrinho.removerItem(car, cod);
			forward = CARRINHO;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
