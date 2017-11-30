<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<body>
	<div class="container">
		<div class="row">
			<div class="col m5">
				<ul class="collection with-header" id="jogadoresInscritos">
					<li class="collection-header">
						<h4>Inscritos</h4>
					</li>
					<c:forEach items="${jogadores}" var="jogador">
						<li class="collection-item">
							<div>
								<input class="secondary-content" type="checkbox" id="jogador${jogador.id}"/>
								<label for="jogador${jogador.id}">${jogador.nome}</label>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />