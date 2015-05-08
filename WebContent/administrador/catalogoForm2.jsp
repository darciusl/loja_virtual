<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Chuck Games</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/estilos.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css" />
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
				<li><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD">Administrativo</a></li>
				<li><a href="<%=request.getContextPath()%>/administrador/catalogoRelatorio.jsp">Relatório de Produtos</a></li>
				
				
			</ul>
		</div>
		<!--.nav-collapse -->
	</div>
	</nav>
	<div class="container">
		<form class=" col-lg-12" method="post"
			action="<%=request.getContextPath()%>/administrador/CatalogoCRUD"
			name="formAlb">
			<div class="row">
				<div class="col-lg-12 well" style="margin-top:50px;padding-top:30px">
					<h1>Cadastro</h1>
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Nome</label>
						<div class="col-md-8">
							<input id="textinput" name="nome" value="${pro.nome}"
								type="text" class="form-control input-md"> <br><br>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Preço</label>
						<div class="col-md-8">
							<input id="textinput" name="preco" value="${pro.preco}"
								type="text" class="form-control input-md"> <br><br>
						</div>
					</div>
					<div class="form-group"> 
 						<label class="col-md-4 control-label" for="textinput">Quantidade</label> 
 						<div class="col-md-8"> 
 							<input id="textinput" name="qtdEstoque" 
 								value="${pro.qtdEstoque}"  readonly=readonly type="number" 
 								class="form-control input-md"> <br><br> 
 						</div> 
 					</div> 

					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Descrição</label>
						<div class="col-md-8">
						<input id="textinput" name="descricao"
								value="${pro.descricao}" type="textarea"
								class="form-control input-md">
							<br><br>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12">
							<button class="btn btn-primary pull-right" type="submit">Enviar</button>
							<br>
						</div>
					</div>
				</div>
			</div>
		</form>
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

</body>
</html>
