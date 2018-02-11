<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<main>
	<div class="container">
		<form method="post" action="${linkTo[CampeonatoController].salvar(null, null)}">
			<input type="hidden" name="campeonato.id" value="${campeonato.id}">
			<input type="hidden" value="${fn:length(campeonato.rodadas)}">
			
			<div class="row valign-wrapper">
				<div class="col s8">
					<h2 id="titulo">${campeonato.nome}</h2>
				</div>
				<div class="col s4 right-align">
					<button class="btn-floating btn-large waves-effect waves-light pink" type="submit" name="tipo" value="salvar">
						<i class="material-icons">save</i>
					</button>
				</div>
			</div>
			<div class="row center-align">
				
			</div>
			<div class="row">
				<div class="input-field col m12 l6">
					<input type="text" id="nome" name="campeonato.nome" value="${campeonato.nome}" onkeyup="copiarTitulo(this)">
					<label for="nome">Nome</label>
				</div>
				<div class="input-field col m12 l6">
					<input type="text" id="sigla" name="campeonato.sigla" value="${campeonato.sigla}">
					<label for="sigla">Sigla</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col m6 l6">
					<input type="text" class="datepicker" id="dataInicio" name="campeonato.dataInicio" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${campeonato.dataInicio.time}" />">
					<label for="dataInicio">Data Início</label>
				</div>
				<div class="input-field col m6 l6">
					<input type="text" class="datepicker" id="dataInicio" name="campeonato.dataFim" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${campeonato.dataFim.time}" />">
					<label for="dataInicio">Data Fim</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col m6 l6">
					<input type="number" id="numeroRodadas" name="campeonato.numeroRodadas" value="${campeonato.numeroRodadas}">
					<label for="numeroRodadas">Número de Rodadas</label>
				</div>
			</div>
			<div class="row">
				<a class="waves-effect waves-light btn" name="tipo" value="rodada">Gerar Rodadas</a>
			</div>
			<div class="divider"></div>
			<div class="section">
				<h5>Rodadas</h5>
				<table class="responsive-table">
				<thead>
					<tr>
						<th class="width-10">#</th>
						<th class="width-20">Data</th>
						<th>Local</th>
						<th class="width-20">Nr Séries</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${campeonato.rodadas}" var="rodada" varStatus="r">
						<tr style="text-align: center">
							<input type="hidden" name="campeonato.rodadas[${r.index}].id" value="${rodada.id}" />
							<input type="hidden" name="campeonato.rodadas[${r.index}].numero" value="${rodada.numero}" />
							<td>${rodada.numero}</td>
							<td><input type="text" class="datepicker center-align" name="campeonato.rodadas[${r.index}].data" 
								value="<fmt:formatDate pattern="dd/MM/yyyy" value="${rodada.data.time}" />" />
							</td>
							<td><input name="campeonato.rodadas[${r.index}].local" value="${rodada.local}"/></td>
							<td><input type="number" class="center-align" name="campeonato.rodadas[${r.index}].numeroSeries" value="${rodada.numeroSeries}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</form>
	</div>
</main>

<c:import url="/WEB-INF/jsp/footer.jsp" />