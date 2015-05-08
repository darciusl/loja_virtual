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
					<ul>
			<li><a href="<%=request.getContextPath()%>" title="Início">Início</a></li>
			<li>
				<%
					String login = org.springframework.security.core.context.SecurityContextHolder
							.getContext().getAuthentication().getName();
					if (!login.equals("anonymousUser")) {
				%>
			
			<li><a href="<c:url value="/j_spring_security_logout" />"
				title="Fazer logout"><%=login%>: Logout</a></li>
			<%
				}
			%>
		</ul>
				</div>
			</div>

			<div class="inner cover">
				<h1 class="cover-heading">Games</h1>

				<p class="lead">Os games apresentam um mundo virtual que encanta
					jogadores de diversas idades. Há várias opções de consoles que
					podem deixar essa experiência mais interessante, como  Xbox 360,
					Xbox ONE, Playstation 3 e o Playstation 4.</p>


			</div>

		</div>
	</div>
</div>