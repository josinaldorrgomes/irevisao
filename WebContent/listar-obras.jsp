<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	$(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>
<link rel="shortcut icon" href="img/cchla.png">
<title></title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.irevisao.model.ObraDAO" />
	<div class="container-fluid">
		<c:import url="cabecalho.jsp" />
		<div class="row-fluid">
			<div class="span12">
				<h4>Lista de obras</h4>
				<hr>
				<table class="table table-hover table-striped table-condensed">
					<tr class="info">
						<td>G&ecirc;nero</td>
						<td>P&aacute;ginas</td>
						<td>Cap&iacute;tulos</td>
						<td>T&iacute;tulo</td>
						<td>Tipo</td>
						<td>Editora</td>
						<td>Data de entrada</td>
						<td>Status</td>
						<td>Op&ccedil;&otilde;es</td>
					</tr>
					<c:forEach var="obra" items="${dao.lista}">
						<tr>
							<td>${obra.genero}</td>
							<td>${obra.qtPaginas}</td>
							<td>${obra.qtCapitulos}</td>
							<td>${obra.titulo}</td>
							<td>${obra.tipo}</td>
							<td>${obra.editora}</td>
							<td><fmt:formatDate value="${obra.dataEntrada.time}" pattern="dd/MM/yyyy" /></td>
							<td>${obra.status}</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-small dropdown-toggle" data-toggle="dropdown">Escolher<span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li><a href="controller?logica=AlteraObraLogica&parametro=popula&idObra=${obra.idObra}"><i class="icon-edit"></i> Alterar</a></li>
										<li><a href="cadastrar-relatorio.jsp?idObra=${obra.idObra}"><i class="icon-file"></i> Cadastrar relat&oacute;rio</a></li>
										<li><a href="controller?logica=ListarRelatoriosObraLogica&idObra=${obra.idObra}"><i class="icon-list-alt"></i> Listar relat&oacute;rios</a></li>
										<li><a href="controller?logica=RemoveObraLogica&idObra=${obra.idObra}"><i class="icon-trash"></i>Excluir</a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<p>Total: ${fn:length(dao.lista)}</p>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>