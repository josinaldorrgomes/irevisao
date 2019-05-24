<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script>
	$(function() {
		$("#date").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'
				});
	});
</script>
<title></title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="cabecalho.jsp" />
		<div class="row-fluid">
			<div class="span12">
				<h4>Cadastrar Relat&oacute;rio</h4>
				<hr>
				<form class="form-horizontal" action="controller" method="post">
					<div class="control-group">
						<label class="control-label" for="idObra">Obra N&ordm;</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="idObra" readonly="readonly" value="${param.idObra}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="tipo">Tipo de relat&oacute;rio</label>
						<div class="controls">
							<select class="input-xlarge" name="tipo" required autofocus>
								<option value="Feedback">Feedback</option>
								<option value="Recomendação">Recomenda&ccedil;&atilde;o</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="descricao">Descri&ccedil;&atilde;o</label>
						<div class="controls">
							<textarea rows="10" class="input-xlarge" name="descricao" placeholder="Digite a descri&ccedil;&atilde;o aqui" required></textarea>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="dataRegistro">Data de registro</label>
						<div class="controls">
							<input id="date" class="input-xlarge" type="text" name="dataRegistro" placeholder="dd/mm/aaaa" required>
							<span class="add-on"><i class="icon-calendar"></i></span>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="logica" value="CadastrarRelatorioLogica" />
							<input type="submit" class="btn btn-primary" value="Confirmar cadastro" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>