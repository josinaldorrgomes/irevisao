<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h4>Cadastrar Autor</h4>
				<hr>
				<form class="form-horizontal" action="controller" method="post">
					<div class="control-group">
						<label class="control-label" for="nome">Nome</label>
						<div class="controls">
							<input class="input-xlarge" type="text" max="255" name="nome" placeholder="Nome" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="instituicao">Institui&ccedil;&atilde;o</label>
						<div class="controls">
							<input class="input-xlarge" type="text" max="255" name="instituicao" placeholder="Institui&ccedil;&atilde;o" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">E-mail</label>
						<div class="controls">
							<input class="input-xlarge" type="email" max="255" name="email" placeholder="exemplo@exemplo.com" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="telefone">Telefone</label>
						<div class="controls">
							<input class="input-xlarge" pattern="^\d{2}-\d{5}-\d{4}$" type="tel" max="11" step="10" name="telefone" placeholder="84-99999-9999" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="departamento">Departamento</label>
						<div class="controls">
							<input class="input-xlarge" type="text" max="255" name="departamento" placeholder="Departamento" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="areaAtuacao">&Aacute;rea de atua&ccedil;&atilde;o</label>
						<div class="controls">
							<input class="input-xlarge" type="text" max="255" name="areaAtuacao" placeholder="&Aacute;rea de atua&ccedil;&atilde;o" required="required">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="logica" value="CadastrarAutorLogica" />
							<input type="submit" class="btn btn-primary" value="Confirmar cadastro" />
							<button class="btn btn-warning" type="reset">Limpar tudo</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>