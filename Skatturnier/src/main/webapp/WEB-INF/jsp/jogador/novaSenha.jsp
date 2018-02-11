<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">

<c:import url="/WEB-INF/jsp/header.jsp" />

<main>
	<fmt:setLocale value="${idioma}"/>
	
	<div class="container">
		<div class="card login-card">
			<div class="card-content">
				<form action="${linkTo[JogadorController].gerarNovaSenha(null, null, null)}" method="post">
					<div class="container">
						<div class="section center">
							<p class="center">Para definir uma nova senha, preencha os campos abaixo:</p>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input type="password" id="senhaAtual" name="senhaAtual">
								<label for="senhaAtual">Senha Atual</label>
							</div>
							<div class="input-field col s12">
								<input type="password" id="senhaNova" name="senhaNova">
								<label for="senhaNova">Senha Nova</label>
							</div>
							<div class="input-field col s12">
								<input type="password" id="senhaNovaRepetir" name="senhaNovaRepetir">
								<label for="senhaNovaRepetir">Repita Senha Nova</label>
							</div>
						</div>
						<div class="row">
							<p class="validation-error">${errors.from('login_invalido')} ${errors.from('login_campos_vazios')}</p>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<button class="waves-effect waves-light btn-large btn-full pink" type="submit">
									Enviar
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>

<c:import url="/WEB-INF/jsp/footer.jsp" />