<%@page import="dominio.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chuck Games - Catalogo de Produtos</title>

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

<%
		List<Produto> lista = (List<Produto>) request.getAttribute("lista");
	%>

	<div class="container">
		<div class="row">
			<div class="row">
				
				<br>
			</div>
			<br><br>
		<h1>Catalago de Produtos</h1>	
	    <br>
		<table border=1>
		        <thead>
		            <tr>
		                <th>Código</th>
		                <th>Nome</th>
		                <th>Descrição</th>
		                <th>Quantidade</th>
		                <th>Valor</th>
		                <th>Plataforma</th>
		                <th>Desenvolvedor</th>
		                <th>Gênero</th>
		                <th>Faixa Etária</th>
		                <th>Peso em gramas</th>
		                <th colspan=2>Ação</th>
		            </tr>
		        </thead>
		        <tbody>
		           <%
								for (Produto x : lista) {
							%>
		                <tr>
		                    <td><%=x.getCodProduto()%></td>
		                    <td><%=x.getNome()%></td>
		                    <td><%=x.getDescricao()%></td>
		                    <td><%=x.getQtdEstoque()%></td>
		                    <td><%=x.getPreco()%></td>
		                    <td><%=x.getPlataforma()%></td>
		                    <td><%=x.getDesenvolvedor()%></td>
		                    <td><%=x.getGenero()%></td>
		                    <td><%=x.getFaixaEtaria()%></td>
		                    <td><%=x.getPeso()%></td>
		                    <td><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD?cmd=editar&cod=<%=x.getCodProduto()%>">Editar</a></td>
		                    <td><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD?cmd=deletar&cod=<%=x.getCodProduto()%>">Excluir</a></td>
		                    
		                </tr>
		                <%
								}
							%>
		            
		        </tbody>
		    </table>
</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="rodape">
		<%@ include file="/resources/template/rodape.jsp"%>
	</div>
</body>
</html>
