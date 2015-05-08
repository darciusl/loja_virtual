<%@page import="dominio.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chuck Games - Detalhes do Produto</title>

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
	<h1>Detalhes do Produto</h1>
	<hr />
	<%
		Produto prod = (Produto) request.getAttribute("produto");
	%>

	<div class="container">
		<div class="row">
			<div class="col-sm-5">
				<div class="product col-sm-5 service-image-left">

					<center>
						<img id="item-display"
							src="<%=request.getContextPath()%>/resources/IMG/<%=prod.getImagem()%>"alt="">
					</center>
				</div>
			</div>
				
				<div class="col-md-7">
					<div class="product-title"><%=prod.getNome() %></div>
					<div class="product-desc"><%=prod.getDescricao() %> </div>
					<hr>
					<div class="product-price">R$ <%=prod.getPreco() %></div>
					<div class="product-stock">Quantidade no estoque: <%=prod.getQtdEstoque() %></div>
					<hr>
					<div class="btn-group cart">
							<a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=inserir&cod=<%=prod.getCodProduto()%>" class="btn btn-success">Adicionar Carrinho</a> 
					</div>
				</div>
		</div>
	</div>

	<div id="rodape">
		<%@ include file="/resources/template/rodape.jsp"%>
	</div>
</body>
</html>
