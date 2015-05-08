<%@page import="sistema.GerenciadorDeCarrinho"%>
<%@page import="dominio.ItemPedido"%>
<%@page import="dominio.ItemCarrinho"%>
<%@page import="dominio.Carrinho"%>
<%@page import="dominio.Produto"%>
<%@page import="dominio.ItemCarrinho"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chuck Games - Carrinho de Compras</title>

<!-- BOOTSTRAP -->
<!-- <script -->
<!-- 	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css">
<!-- <script -->
<%-- 	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script> --%>
<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/estilos.css">


</head>
<body>
<div class="inner">
					<h3 class="masthead-brand"><span class="light">Chuck</span><span class="bold">Games</span></h3>

					<ul class="nav masthead-nav">
						

						<li><a href="<%=request.getContextPath()%>/publico/CatalogoServlet">Produto</a></li>

						<li><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet">Carrinho</a></li>
						
					</ul>
   </div>
   <br><br>
	<%
					Carrinho car = (Carrinho) session.getAttribute("carrinho");
				%>
	<div class="container">
	<div class="row">
		<h1>Carrinho</h1>
		<br><br>
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Produto</th>
					<th style="width: 10%">Preço</th>
					<th style="width: 8%">Quantidade</th>
					<th style="width: 4%">Alterar</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>

				<%
				
				
			for (ItemCarrinho ic : car.getItens()) {
				
				
		%>
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img src="<%=request.getContextPath()%>/resources/IMG/<%=ic.getProduto().getImagem()%>" alt="imagem do produto"
									class="img-responsive" />
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin"><%=ic.getProduto().getNome() %>
									1
								</h4>
							</div>
						</div>
					</td>


				<td>R$ <%=ic.getProduto().getPreco() %></td>
				<td><%=ic.getQtde() %></td>
				<td><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=incrementar&cod=<%=ic.getProduto().getCodProduto()%>">+</a>
					| <a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=decrementar&cod=<%=ic.getProduto().getCodProduto()%>">-</a></td>
				<td>R$ <%=ic.subTotal() %></td>
				<td><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=excluir&cod=<%=ic.getProduto().getCodProduto()%>">excluir</a></td>
			
				</tr>
			</tbody>
			
			<%
			}
			%>
			<tfoot>
				<tr>
					<td><a href="<%=request.getContextPath()%>/publico/CatalogoServlet" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continue comprando</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Total <%=car.total() %></strong></td>
					<td><a href="<%=request.getContextPath()%>/cliente/PedidoServlet" class="btn btn-success btn-block">Fechar Pedido
					</a></td>
				</tr>
			</tfoot>
		</table>
		</div>
	</div>
	<hr />
	
	
</body>
</html>
