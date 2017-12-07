<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<body>
	<div class="container">
		<div class="row valign-wrapper">
			<div class="col s8">
				<h2>Campeonatos</h2>
			</div>
			<div class="col s4">
				<a class="btn-floating btn-large waves-effect waves-light pink" href="${linkTo[CampeonatoController].novo()}"><i class="material-icons">add</i></a>
			</div>
		</div>
		<div class="row">
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Sigla</th>
						<th>Data Início</th>
						<th>Data Fim</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${campeonatos}" var="campeonato">
						<tr>
							<td>${campeonato.nome}</td>
							<td>${campeonato.sigla}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${campeonato.dataInicio.time}" /></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${campeonato.dataFim.time}" /></td>
							<td>
								<a class="btn-floating blue" href="#"><i class="material-icons">event_note</i></a>
								<a class="btn-floating yellow darken-1" href="${linkTo[CampeonatoController].info(campeonato.id)}"><i class="material-icons">edit</i></a>
								<a class="btn-floating green" href="${linkTo[CampeonatoController].gerenciar(campeonato.id)}"><i class="material-icons">send</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />