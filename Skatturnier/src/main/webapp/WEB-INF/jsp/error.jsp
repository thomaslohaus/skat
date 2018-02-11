<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ooops! Algo deu errado...</title>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">

<link rel="stylesheet" href="<c:url value="/resources/css/skat.css"/>">
</head>
<body>
	<main>
		<div class="row">
			<div class="col s12 m6 offset-m3">
				<div class="card center-align">
					<div class="card-image">
						<img src="<c:url value="/resources/img/rats-playing-cards.jpg"/>">
						<span class="card-title card-title-right"><b>Kontra!</b></span>
					</div>
					<div class="card-content">
						<p>Algo deu errado. Você será redirecionado para a página principal em:</p>
						<h4 id="contador">5</h4>
					</div>
					<div class="card-action">
						<a href="${linkTo[DashboardController].paginaPrincipal()}">Ir agora...</a>
					</div>
				</div>
			</div>
		</div>
	<main>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.8/jquery.mask.min.js"></script>

	<!-- Compiled and minified JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>

	<!-- Custom scripts -->
	<script src="<c:url value="/resources/js/skat.js"/>" type="text/javascript"	charset="utf-8"></script>
	<script>
		$(function() {
			setInterval(function(){
				var cont = $("#contador").text();
				if (cont > 0) {
					$("#contador").text(cont - 1);
				} else {
					window.location.href = "${linkTo[DashboardController].paginaPrincipal()}";
				}
			}, 1000);
		})
	</script>
</body>
</html>