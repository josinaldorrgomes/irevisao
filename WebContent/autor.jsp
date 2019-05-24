<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang='pt-BR'>
<head>
<meta charset="UTF-8">
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
				<h4>M&oacute;dulo Autor</h4>
				<hr>
				<ul class="nav nav-pills nav-stacked">
					<li class="nav-header">Funcionalidades</li>
					<li><a href="cadastrar-autor.jsp">Cadastrar um novo autor</a></li>
					<li><a href="listar-autores.jsp">Exibir a lista de autores cadastrados</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>