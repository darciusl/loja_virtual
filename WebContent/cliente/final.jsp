<%@page import="dominio.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chuck Games</title>
					<!-- BOOTSTRAP -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css">
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-latest.js"></script>

<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/estilos.css">
</head>
<body>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/publico/CatalogoServlet"><span class="light">Chuck</span><span
				class="bold">Games</span></a>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet">Carrinho</a></li>
				<li><a href="<%=request.getContextPath()%>/administrador/catalogoRelatorio.jsp">Relatório de Produtos</a></li>
				<li><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD?cmd=novo">Adicionar novo Produto</a></li>
				
			</ul>
		</div>
		<!--.nav-collapse -->
	</div>
	</nav>
	<div class="container">
	<div class="navbar-header">
					<div class="col-md4 text-left">
					<div class="inner">
		<h1>Obrigado!</h1>
		<hr/>
<%
	Pedido pedido = (Pedido) request.getAttribute("pedido");
%>
<p>Pedido registrado com sucesso! Código: <%=pedido.getCodPedido() %></p>
<hr/>
		</div>
				</div>
			</div>
</div>
</div>

	
</body>
</html>