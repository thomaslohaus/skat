<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="btn"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<body>
	<div class="container">
		<form method="post" action="">
			<input type="hidden" name="campeonato.id" value="${campeonato.id}">
			<div class="row">
				<h2>${campeonato.sigla} - ${campeonato.nome}</h2>
				<h5>${campeonato.numeroRodadas} rodada(s)</h5>
			</div>
			<div class="row">
				<table>
					<thead>
						<tr>
							<th>Rodada</th>
							<th>Data</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${campeonato.rodadas}" var="rodada">
							<tr>
								<td>${rodada.numero}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy - HH:mm" value="${rodada.data.time}" /></td>
								<td>${rodada.status}</td>
								<td>
									<btn:resultadosRodada idRodada="${rodada.id}" />
									<c:if test="${rodada.status != 'FINALIZADA'}">
										<btn:gerenciarRodada idRodada="${rodada.id}" />
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</form>
	</div>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />