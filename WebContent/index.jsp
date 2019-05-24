<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="shortcut icon" href="img/cchla.png">
<title></title>
</head>
<body>
	<div class="container-fluid">
	<c:import url="cabecalho.jsp" />
		<div class="row-fluid">
			<div class="span12">
				<h4>Relat&oacute;rio atual</h4>
				<hr>
				<table class="table table-bordered">
					<tr class="warning">
						<jsp:useBean id="daoAutor" class="br.com.irevisao.model.AutorDAO" />
						<td><i class="icon-user"></i><strong> Autores cadastrados</strong></td>
						<td><c:forEach var="autor" items="${daoAutor.lista}"></c:forEach>Total: ${fn:length(daoAutor.lista)}</td>
					</tr>
					<tr class="error">
						<jsp:useBean id="daoObra" class="br.com.irevisao.model.ObraDAO" />
						<td><i class="icon-book"></i><strong> Obras cadastradas</strong></td>
						<td><c:forEach var="obra" items="${daoObra.lista}"></c:forEach>Total: ${fn:length(daoObra.lista)}</td>
					</tr>
					<tr class="info">
						<jsp:useBean id="daoRelatorio" class="br.com.irevisao.model.RelatorioDAO" />
						<td><i class="icon-list-alt"></i><strong> Relat&oacute;rios cadastrados</strong></td>
						<td><c:forEach var="relatorio" items="${daoRelatorio.lista}"></c:forEach>Total: ${fn:length(daoRelatorio.lista)}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>