<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<body>
	<div class="container">
		<form method="post" action="${linkTo[CampeonatoController].salvar(null)}">
			<input type="hidden" name="campeonato.id" value="${campeonato.id}">
			<input type="hidden" value="${fn:length(campeonato.rodadas)}">
			
			<div class="row">
				<div class="input-field col m12 l6">
					<input type="text" id="nome" name="campeonato.nome" value="${campeonato.nome}">
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
			
			<div class="fixed-action-btn">
				<button class="btn-floating btn-large halfway-fab waves-effect waves-light pink" type="submit"><i class="material-icons">save</i></button>
			</div>
		</form>
	</div>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />