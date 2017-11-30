<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="btn"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<body>
	<nav>
		<div class="nav-wrapper">
			<div class="col s12">
				<a href="${linkTo[CampeonatoController].listar()}" class="breadcrumb">Campeonatos</a>
				<a href="${linkTo[CampeonatoController].gerenciar(2)}" class="breadcrumb">PSM2018</a>
				<a href="${linkTo[RodadaController].resultados(6)}" class="breadcrumb">Rodada 1</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<input type="hidden" name="rodada.id" value="${rodada.id}">
		<div class="row">
			<h2>${rodada.campeonato.sigla} - ${rodada.campeonato.nome}</h2>
			<h5>Rodada ${rodada.numero}</h5>
		</div>
		<div class="row">
			<table class="striped">
				<thead>
					<tr style="text-align: center;">
						<th rowspan="2">Posição</th>
						<th rowspan="2" class="table-border-right">Jogador</th>
						<c:forEach begin="1" end="${rodada.numeroSeries}" varStatus="s">
							<th colspan="3" class="table-border-right" style="text-align: center;">Serie ${s.count}</th>
						</c:forEach>
						<th rowspan="2">Total</th>
					</tr>
					<tr>
						<c:forEach begin="1" end="${rodada.numeroSeries}" varStatus="s">
							<th>Jogos Ganhos</th>
							<th>Jogos Perdidos</th>
							<th class="table-border-right">Pontos</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resultadosRodadaJogador}" var="resultadoJogador">
						<tr>
							<td>${resultadoJogador.classificacao}</td>
							<td class="table-border-right table-highlight-content">${resultadoJogador.jogador.nome}</td>
							<c:forEach items="${resultadoJogador.series}" var="serie">
								<td>${serie.jogosGanhos}</td>
								<td>${serie.jogosPerdidos}</td>
								<td class="table-border-right">${serie.pontosTotais}</td>
							</c:forEach>
							<td class="table-highlight-content">${resultadoJogador.pontosTotais}</td>
						</tr>
					</c:forEach>
					<tr><td></td></tr>
					<tr><td class="table-border-right table-highlight-content" colspan="2">Estatísticas</td></tr>
					<tr>
						<td class="table-border-right table-highlight-content" colspan="2">Soma</td>
						<c:set var="somaRodada" value="0" />
						<c:forEach items="${estatisticasRodada}" var="estatisticas">
							<c:set var="somaRodada" value="${somaRodada + estatisticas.pontosTotais}" />
							<td>${estatisticas.jogosGanhos}</td>
							<td>${estatisticas.jogosPerdidos}</td>
							<td class="table-border-right">${estatisticas.pontosTotais}</td>
						</c:forEach>
						<td class="table-highlight-content">${somaRodada}</td>
					</tr>
					<tr>
						<td class="table-border-right table-highlight-content" colspan="2">Média</td>
						<c:set var="numeroJogadores" value="0" />
						<c:forEach items="${estatisticasRodada}" var="estatisticas">
							<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${estatisticas.mediaJogosGanhos}" /></td>
							<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${estatisticas.mediaJogosPerdidos}" /></td>
							<td class="table-border-right"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${estatisticas.mediaPontosTotais}" /></td>
							<c:if test="${estatisticas.numeroJogadores > numeroJogadores}">
								<c:set var="numeroJogadores" value="${estatisticas.numeroJogadores}" />
							</c:if>
						</c:forEach>
						<td class="table-border-right table-highlight-content"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${somaRodada / numeroJogadores}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />