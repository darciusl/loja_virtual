package controller;

import java.io.IOException;
import java.math.BigDecimal;




import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistema.Cruds;
import sistema.SistemaException;
import dominio.Produto;


@WebServlet("/administrador/CatalogoCRUD")
public class CatalogoCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSERIR = "/administrador/catalogoForm.jsp";
	private static String ALTERAR = "/administrador/catalogoForm.jsp";
	private static String LISTAR = "/administrador/catalogoListar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	private static String PEDIDO = "/publico/pedido.jsp";

	@Inject
	private Cruds cruds;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        //ok
		String forward = "";
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "listar";
        //ok
		if (cmd.equalsIgnoreCase("deletar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			try {
				cruds.deletarProduto(cod);
				request.setAttribute("lista", cruds.buscarTodos());
				forward = LISTAR;
			} catch (SistemaException e) {
				request.setAttribute("pedido", e.getMessage());
				forward = PEDIDO;
			}
		}
         //ok
		else if (cmd.equalsIgnoreCase("editar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			Produto pro = cruds.buscar(cod);
			request.setAttribute("pro", pro);
			forward = ALTERAR;
		}
		//ok
		else if (cmd.equalsIgnoreCase("listar")) {
			request.setAttribute("lista", cruds.buscarTodos());
			forward = LISTAR;
		}
		else if (cmd.equalsIgnoreCase("novo")) {
			
			Produto pro = new Produto();
			request.setAttribute("pro", pro);
			
			forward = INSERIR;
		}
	

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
//ok
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";

		try {
			Produto pro = instanciar(request);
			if (pro.getCodProduto() == null) {
				cruds.inserirProduto(pro);
			} else {
				cruds.atualizarProduto(pro);
			}
			request.setAttribute("lista", cruds.buscarTodos());
			forward = LISTAR;
		} catch (SistemaException e) {
			request.setAttribute("erro", e.getMessage());
			forward = ERRO;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
    
	//ok
	private Produto instanciar(HttpServletRequest req) {
		String aux;
		
		Produto x = new Produto();
		
		
		try {
			aux = req.getParameter("codProduto");
			if (aux!=null && !aux.isEmpty())
				x.setCodProduto(Integer.parseInt(aux));

			aux = req.getParameter("nome");
			x.setNome(aux);

			aux = req.getParameter("descricao");
			x.setDescricao(aux);
			
			aux = req.getParameter("plataforma");
			x.setPlataforma(aux);
			
			aux = req.getParameter("desenvolvedor");
			x.setDesenvolvedor(aux);
			
			aux = req.getParameter("faixaEtaria");
			x.setFaixaEtaria(aux);
			
			aux = req.getParameter("peso");
			x.setPeso(Integer.parseInt(aux));
			
			aux = req.getParameter("preco");
			x.setPreco(new BigDecimal(aux));

			
//			aux = req.getParameter("qtdEstoque");
			x.setQtdEstoque(0);

			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
