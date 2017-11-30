<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<link rel="stylesheet" href="<c:url value="/resources/css/bororos.css"/>">

<body>
	<ul class="collapsible popout" data-collapsible="expandable">
		<c:forEach items="${areas}" var="area">
			<li>
				<div class="collapsible-header">${area.nome}</div>
				<div class="collapsible-body">
						<ul class="collection">
							<c:forEach items="${requisitos.get(area)}" var="req">
								<li class="collection-item">${req.descricao}</li>
							</c:forEach>
						</ul>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>


<c:import url="/WEB-INF/jsp/footer.jsp" />