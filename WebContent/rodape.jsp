<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<title></title>
</head>
<body>
	<jsp:useBean id="dataAtual" class="java.util.Date" />
	<div class="footer">
		<div class="container-fluid">
			<hr>
			<p class="muted credit">
				<small>Copyrigth <fmt:formatDate pattern="yyyy" value="${dataAtual}" /> - Todos os direitos reservados</small><br>
				<small>Desenvolvido por <a href="https://github.com/josinaldorrgomes" target="_blank"> josinaldorrgomes</a></small><br>
				<small>Vers&atilde;o 1.1.0</small>
			</p>
		</div>
	</div>
</body>
</html>