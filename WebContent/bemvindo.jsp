<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
					<h3 class="masthead-brand"><span class="light">Chuck</span><span class="bold">Games</span></h3>

					<ul class="nav masthead-nav">
						

						<li><a href="<%=request.getContextPath()%>/publico/CatalogoServlet">Produto</a></li>

						<li><a href="<%=request.getContextPath()%>/cliente/CarrinhoServlet">Carrinho</a></li>
						
					</ul>
					<div class="col-md4 text-left">
	<h1>ChuckGames</h1>
	<hr />
	Login ok!
	<br />
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
</div>
				</div>
			</div>

			<div class="inner cover">
				<div class="col-md-4 text-center">
			<p>Chuck Games - Rua Blanche Galassi, 150</p>
		</div>
		<address class="col-md-4 text-center">
			<strong><a href="http://megalobacana.net" >megalobacana.net</a></strong>
		</address>

	</div>

				
			</div>

		</div>
	</div>

</body>
</html>