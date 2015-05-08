<%@page import="dominio.Produto"%>
<%@page import="dominio.Usuario"%>
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

<title>Chuck Games</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/estilos.css">
</head>
<body>

				<div class="inner">
					<h3 class="masthead-brand"><span class="light">Chuck</span><span class="bold">Games</span></h3>

					<ul class="nav masthead-nav">
						

						<li><a href="<%=request.getContextPath()%>/publico/CatalogoServlet">Produto</a></li>

						<li><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet">Carrinho</a></li>
						<li>
						<a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD">Administrativo</a>
						</li>
					</ul>
   </div>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		if (usuario != null) {
	%>
<!-- 	<a href=<c:url value="/j_spring_security_logout" />> -->
	<%=usuario.getNome()%>:Bem vindo!
<!-- 	</a> -->
	</li>
	<%
		} else {
	%>
	Fazer login
	<%
		}
	%>
	<hr />
	<h1>Catálogo</h1>
	<hr />
	<%
		List<Produto> lista = (List<Produto>) request.getAttribute("lista");
	%>

	<div class="container">
		<div class="row">
			<div class="row">
				<div class="col-md-9">
					<h3>Catalago de Produtos</h3>
				</div>
				<div class="col-md-3">

					<!-- Controls -->
					<div class="controls pull-right">
						<a class="left fa fa-chevron-left btn btn-success"
							href="#carousel-example" data-slide="prev"></a><a
							class="right fa fa-chevron-right btn btn-success"
							href="#carousel-example" data-slide="next"></a>
					</div>
				</div>
			</div>
					
			<div id="carousel-example" class="carousel slide">
				<!-- 			data-ride="carousel"> -->
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<div class="row">
							<%
								for (Produto x : lista) {
							%>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<img
										src="<%=request.getContextPath()%>/resources/IMG/<%=x.getImagem()%>"
										class="img-responsive" alt="<%=x.getImagem()%>" />
									<div class="caption">
										<h3><%=x.getNome()%></h3>
										<h4>
											R$
											<%=x.getPreco()%></h4>
										<p class="btn-add">
											<a style="color: #000"
												href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=inserir&cod=<%=x.getCodProduto()%>">Add
												Carrinho</a>
										</p>
										<p class="btn-details">
											<a style="color: #000"
												href="<%=request.getContextPath()%>/cliente/CarrinhoServlet?cmd=detalhes&cod=<%=x.getCodProduto()%>">Detalhes
											</a>
									</div>
								</div>
							</div>
					<%
								}
							%>
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
