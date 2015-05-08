<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="dominio.Produto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Chuck Games</title>
	<!-- BOOTSTRAP -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
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
				<li><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD">Administrativo</a></li>
				<li><a href="<%=request.getContextPath()%>/administrador/CatalogoCRUD?cmd=novo">Adicionar novo Produto</a></li>
				
			</ul>
		</div>
		<!--.nav-collapse -->
	</div>
	</nav>
	<div class="container">
	<div class="navbar-header">
					<div class="col-md4 text-left">

<% Produto prod =new Produto(); %>

	
		
			
				<div class="inner">
		<br><br>

		       <form method="get" action="<%=request.getContextPath()%>/RelatServlet">

		<h1>Gerar Relatório</h1>
		<input type=hidden value="produto" readonly="readonly" name="nomeRelat"><br>
		<br> Valor Mínimo: <input type=number required name="valorMin" style="color: #000"><br>
		<br> Valor Máximo: <input type=number required name="valorMax" style="color: #000"><br>
		<br> <input type=submit aling=center value="Relatorio" class="btn btn-warning"><i
							class="fa fa-angle-left"></i>

	</form>
	
</div>
				
			
		
				</div>
			</div>

		</div>
	</div>

</body>
</html>