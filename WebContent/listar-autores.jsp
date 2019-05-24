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
	<jsp:useBean id="dao" class="br.com.irevisao.model.AutorDAO" />
	<div class="container-fluid">
		<c:import url="cabecalho.jsp" />
		<div class="row-fluid">
			<div class="span12">
				<h4>Lista de autores</h4>
				<hr>
				<table class="table table-hover table-striped table-condensed">
					<tr class="info">
						<td>Nome</td>
						<td>Institui&ccedil;&atilde;o</td>
						<td>Email</td>
						<td>Telefone</td>
						<td>Departamento</td>
						<td>&Aacute;rea de atua&ccedil;&atilde;o</td>
						<td>Op&ccedil;&otilde;es</td>
					</tr>
					<c:forEach var="autor" items="${dao.lista}">
						<tr>
							<td>${autor.nome}</td>
							<td>${autor.instituicao}</td>
							<td><a href="mailto:${autor.email}">${autor.email}</a></td>
							<td>${autor.telefone}</td>
							<td>${autor.departamento}</td>
							<td>${autor.areaAtuacao}</td>
							<td><div class="btn-group">
									<button type="button" class="btn btn-small dropdown-toggle" data-toggle="dropdown">Escolher<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="controller?logica=AlteraAutorLogica&parametro=popula&idAutor=${autor.idAutor}"><i class="icon-edit"></i> Alterar</a></li>
										<li><a href="cadastrar-obra.jsp?idAutor=${autor.idAutor}"><i class="icon-book"></i> Cadastrar obra</a></li>
										<li><a href="controller?logica=ListarObrasAutorLogica&idAutor=${autor.idAutor}"><i class="icon-th-list"></i> Listar obras</a></li>
										<li><a href="controller?logica=RemoveAutorLogica&idAutor=${autor.idAutor}"><i class="icon-trash"></i> Excluir</a></li>
									</ul>
								</div></td>
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