<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscar Matrícula</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Matrícula</h4>
				</div>
				<div class="modal-body">
				Deseja realmente excluir essa matrícula?
				</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirMatricula">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!--  menu -->

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />

	<!-- Container Principal -->
	<div id="main" class="container-fluid">
		<form action="controller.do" method="post">
			<div id="top" class="row">
				<div class="col-md-3">

					<h2>Matrícula</h2>
				</div>

				<div class="col-md-6">

					<div class="input-group h2">
						<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Matrícula(deixe vazio para trazer todos)">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="command" value="ListarMatriculaBuscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>

				<div class="col-md-3">
					<a href="CadastrarMatricula.jsp" class="btn btn-primary pull-right h2">Cadastrar Matrícula</a>
				</div>
			</div>


			<!-- /#top -->
		</form>
		<hr />
			<c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Código:</th>
								<th>Valor:</th>
								<th>Data:</th>
								<th>Status Pagamento:</th>
								<th>Status Matrícula:</th>
								<th>Código Professor:</th>
								<th>Aluno:</th>
								<th>Curso:</th>

								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="infoTO" items="${lista}">
							<tr>
								<td>${infoTO.codigo}</td>
								<td>${infoTO.valor}</td>
								<td>${infoTO.data}</td>
								<td>${infoTO.statusPagamento}</td>
								<td>${infoTO.statusMatricula}</td>
								<td>${infoTO.codProfessor}</td>
								<td>${infoTO.aluno}</td>
								<td>${infoTO.curso}</td>


								<td class="actions">
								<a class="btn btn-success btn-xs" href="controller.do?command=ConsultarMatricula&codigo=${infoTO.codigo}">Visualizar</a>
						    	<a class="btn btn-warning btn-xs" href="controller.do?command=EditarMatricula&codigo=${infoTO.codigo}">Editar</a>

								<button id="btn${infoTO.codigo}%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${infoTO.codigo}">Excluir</button>


								</td>
							</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<!-- /#list -->

			<div id="bottom" class="row">
				<div class="col-md-12">
					<!-- paginação ainda não foi implementada -->
					<ul class="pagination">
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->

				</div>
			</div>
		</c:if>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('matricula');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>

</html>