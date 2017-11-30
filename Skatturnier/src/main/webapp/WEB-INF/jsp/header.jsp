<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="navbar-fixed ">
	<ul id="dropdown-user-menu" class="dropdown-content dropdown-menu-list">
		<li><a>${jogadorLogado.jogador.nomeCompleto}</a></li>
		<li class="divider"></li>
		<li><a href="#!">Seus Dados<i class="material-icons left">contacts</i></a></li>
		<li><a href="#!">Idioma<i class="material-icons left">language</i></a></li>
		<li class="divider"></li>
		<li><a href="${linkTo[LoginController].deslogar()}">Logout<i class="material-icons left">exit_to_app</i></a></li>
	</ul>
	
	
	<nav class="nav-extended cyan">
		<div class="nav-wrapper">
			<div class="container">
				<a href="#" class="brand-logo">Skatturnier</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="${linkTo[CampeonatoController].listar()}">Campeonatos</a></li>
					<li><a href="#">Jogadores</a></li>
					<li class="divider"></li>
					<li><a class="dropdown-button nav-border-left" href="#!" data-activates="dropdown-user-menu">${jogadorLogado.jogador.nomeCompleto}<i class="material-icons right">person</i></a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
	
	