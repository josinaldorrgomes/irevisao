<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/signin.css">
<link rel="shortcut icon" href="img/cchla.png">
<title>iEditora | Sistema de gest&atilde;o de editora&ccedil;&atilde;o</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-signin" action="controller" method="post">
			<p align="center"><img src="img/cchla.png"></p>
			<hr>
			<h3>Fa&ccedil;a seu login</h3>
			<input type="text" name="email" class="input-block-level" placeholder="Email" required autofocus>
			<input type="password" name="senha" class="input-block-level" placeholder="Senha" required>
			<input type="hidden" class="input-block-level" name="logica" value="LoginUsuarioLogica" />
			<button class="btn btn-large btn-primary" type="submit">Entrar</button>
			<hr>
			<p class="muted credit">
				<small>Copyrigth <fmt:formatDate pattern="yyyy" value="${dataAtual}" /> - Todos os direitos reservados</small><br>
				<small>Desenvolvido por <a href="https://github.com/josinaldorrgomes" target="_blank"> josinaldorrgomes</a></small><br>
				<small>Vers&atilde;o 1.1.0</small>
			</p>
		</form>
	</div>
</body>
</html>