
<%@page import="dominio.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chuck Games</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/estilos.css">
</head>
<body>

	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">
							<span class="light">Chuck</span><span class="bold">Games</span>
						</h3>

						<ul class="nav masthead-nav">


							<li><a
								href="<%=request.getContextPath()%>/publico/CatalogoServlet">Produto</a></li>

							<li><a
								href="<%=request.getContextPath()%>/cliente/CarrinhoServlet">Carrinho</a></li>

						</ul>
						<div class="col-md4 text-left">
							<h1>Página de Pedido</h1>
							<hr />
							<%
								String pedido = (String) request.getAttribute("pedido");
							%>
							<p>O Produto não pode ser excluido por estar vinculado a
								um pedido!</p>
							<br>
							<p>
								<a
									href="<%=request.getContextPath()%>/administrador/CatalogoCRUD">Voltar</a>
							</p>
							<hr />
						</div>
					</div>
				</div>

				<div class="inner cover">
					<div class="col-md-4 text-center">
						<p>Chuck Games - Rua Blanche Galassi, 150</p>
					</div>
					<address class="col-md-4 text-center">
						<strong><a href="http://megalobacana.net">megalobacana.net</a></strong>
					</address>

				</div>


			</div>

		</div>
	</div>

</body>
</html>