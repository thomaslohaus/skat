<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Skatturnier</title>
		
		<meta name=viewport content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		
		<link rel="icon" type="image/png" href="<c:url value="/resources/img/logo.png"/>">
		
		<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		
		<!-- Compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.min.css">
			
		<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">
	</head>
	<body class="cyan">
		<fmt:setLocale value="${locale}"/>
		
		<div class="container ">
			<div class="card login-card">
				<div class="card-content">
					<form action="${linkTo[LoginController].enviarNovaSenha(null)}" method="post">
						<div class="container">
							<div class="row">
								<div class="col s3 center">
									<img src="<c:url value="/resources/img/logo.png"/>" class="responsive-img login-img ">
								</div>
								<div class="col s9 center">
									<h6 class="center"><fmt:message key="login.lbl.saudacao"/></h6>
									<h5 class="center"><fmt:message key="login.lbl.titulo-aplicacao"/></h5>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<i class="material-icons prefix">person_outline</i>
									<input type="text" id="login" name="login" value="${login}">
									<label for="login"><fmt:message key="login.txt.login"/></label>
								</div>
								<div class="input-field col s12">
									<i class="material-icons prefix">lock_outline</i>
									<input type="password" id="senha" name="senha">
									<label for="senha"><fmt:message key="login.txt.senha"/></label>
								</div>
							</div>
							<div class="row">
								<p class="validation-error">${errors.from('login_invalido')} ${errors.from('login_campos_vazios')}</p>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<button class="waves-effect waves-light btn-large btn-full pink" type="submit"><fmt:message key="login.btn.login"/></button>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="card-action">
					<div class="row center-align">
						<div class="col s6">
							<a href="#"><fmt:message key="login.btn.criar-conta"/></a>
						</div>
						<div class="col s6">
							<a href="#"><fmt:message key="login.btn.esqueceu-senha"/></a>
						</div>
					</div>
					<div class="row center-align">
						<c:forEach items="${idiomas}" var="idioma">
							<a href="${linkTo[LoginController].login(idioma.sigla)}"><img src="<c:url value="/resources/img/${idioma.iconeBandeira}"/>"></a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<!-- jQuery -->
		<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		
		<!-- Compiled and minified JavaScript -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
		
		<!-- Custom scripts -->
		<script src="<c:url value="/resources/js/skat.js"/>" type="text/javascript" charset="utf-8"></script>
	</body>
</html>