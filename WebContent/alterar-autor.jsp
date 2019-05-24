<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<script src="js/bootstrap.js"></script>
<script src="js/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<link rel="shortcut icon" href="img/cchla.png">
<title></title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="cabecalho.jsp" />
		<div class="row-fluid">
			<div class="span12">
				<h4>Alterar dados do autor</h4>
				<hr>
				<form class="form-horizontal" action="controller" method="post">
					<div class="control-group">
						<label class="control-label" for="idAutor">Autor(a) N&ordm;</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="idAutor" readonly="readonly" value="${autor.idAutor}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="nome">Nome</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="nome" value="${autor.nome}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="instituicao">Institui&ccedil;&atilde;o</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="instituicao" value="${autor.instituicao}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">Email</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="email" value="${autor.email}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="telefone">Telefone</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="telefone" value="${autor.telefone}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="departamento">Departamento</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="departamento" value="${autor.departamento}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="areaAtuacao">&Aacute;rea de atua&ccedil;&atilde;o</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="areaAtuacao" value="${autor.areaAtuacao}">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="logica" value="AlteraAutorLogica" />
							<input type="hidden" name="parametro" value="altera" />
							<input type="submit" class="btn btn-primary" value="Confirmar altera&ccedil;&atilde;o" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>