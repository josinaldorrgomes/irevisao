<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<title>iEditora | Sistema de Gest&atilde;o Editorial</title>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="index.jsp"> iEditora</a>
			<ul class="nav">
				<li><a href="autor.jsp"><i class="icon-user"></i> Autor</a></li>
				<li><a href="obra.jsp"><i class="icon-book"></i> Obra</a></li>
				<li><a href="controller?logica=LogoutUsuarioLogica&parametro=logout"><i class="icon-circle-arrow-right"></i> Sair</a></li>
			</ul>
			<p class="navbar-text pull-right">Bem-vindo(a) ${sessionScope.usuario}</p>
		</div>
	</div>
</body>
</html>