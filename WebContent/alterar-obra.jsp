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
<script>
	$(function() {
		$("#date").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
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
				<h4>Alterar dados da obra</h4>
				<hr>
				<form class="form-horizontal" action="controller" method="post">
					<div class="control-group">
						<label class="control-label" for="idObra">Obra N&ordm;</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="idObra" readonly="readonly" value="${obra.idObra}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="idAutor">Autor N&ordm;</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="idAutor" readonly="readonly" value="${obra.idAutor}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="genero">G&ecirc;nero</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="genero" value="${obra.genero}" required>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="qtPaginas">N&ordm; de p&aacute;ginas</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="qtPaginas" value="${obra.qtPaginas}" required>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="qtCapitulos">N&ordm; de cap&iacute;tulos</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="qtCapitulos" value="${obra.qtCapitulos}" required>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="titulo">T&iacute;tulo</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="titulo" value="${obra.titulo}" required>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="tipo">Tipo</label>
						<div class="controls">
							<select class="input-xlarge" name="tipo" required>
								<c:if test="${obra.tipo == 'Impresso'}">
									<option value="Impresso" selected="selected">Impresso</option>
									<option value="Digital">Digital</option>
								</c:if>
								<c:if test="${obra.tipo == 'Digital'}">
									<option value="Impresso">Impresso</option>
									<option value="Digital" selected="selected">Digital</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="editora">Editora</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="editora" value="${obra.editora}" required>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="dataEntrada">Data de entrada</label>
						<div class="controls">
							<input id="date" class="input-xlarge" type="text" name="dataEntrada" required value="<fmt:formatDate value="${obra.dataEntrada.time}" pattern="dd/MM/yyyy"/>">
							<span class="add-on"><i class="icon-calendar"></i></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="status">Status</label>
						<div class="controls">
							<select class="input-xlarge" name="status">
								<c:if test="${obra.status == 'Recebida'}">
									<option value="Recebida" selected="selected">Recebida</option>
									<option value="Revisando">Revisando</option>
									<option value="Finalizada">Finalizada</option>
								</c:if>
								<c:if test="${obra.status == 'Revisando'}">
									<option value="Recebida">Recebida</option>
									<option value="Revisando" selected="selected">Revisando</option>
									<option value="Finalizada">Finalizada</option>
								</c:if>
								<c:if test="${obra.status == 'Finalizada'}">
									<option value="Recebida">Recebida</option>
									<option value="Revisando">Revisando</option>
									<option value="Finalizada" selected="selected">Finalizada</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="logica" value="AlteraObraLogica" />
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