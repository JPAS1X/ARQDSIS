<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>Matrícula</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />

	<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro de matrículas</h2><br><br>

		<form action="controller.do" method="post">
			<!--coloca o .do para indicar que faz algo  -->

			

				<br><div class="form-group col-md-3">
					<label for="valor"> Valor: </label> <br> 
					<input type="text" class="form-control" name="valor" size="40" maxlength="20" placeholder="Valor da matrícula" required>
				</div>

				<div class="form-group col-md-3">
					<label for="data"> Data: </label> <br> <input type="text"
						class="form-control" name="data" size="40" maxlength="20"
						placeholder="Data">
				</div>

				<div class="form-group col-md-6">
					<label for="statusPagamento"> Status Pagamento: </label><br> <input
						type="text" class="form-control" name="statusPagamento" size="40"
						maxlength="50" placeholder="Status do pagamento">
				</div>


				<div class="form-group col-md-6">
					<label for="statusMatricula"> Status Matrícula: </label> <br>
					<input type="text" class="form-control" name="statusMatricula"
						size="40" maxlength="20" placeholder="Status da matrícula">

				</div>
				<div class="form-group col-md-6">
					<label for="aluno"> Aluno: </label> <br> <input type="text"
						class="form-control" name="aluno" size="40" maxlength="20"
						placeholder="aluno">
				</div>

				<div class="form-group col-md-6">
					<label for="curso"> Curso: </label><br> <input
						type="text" class="form-control" name="curso" size="40"
						maxlength="50" placeholder="digite o curso">
				</div>


				<div class="form-group col-md-6">
					<label for="codProfessor"> Código Professor: </label> <br>
					<input type="text" class="form-control" name="codProfessor"
						size="40" maxlength="20" placeholder="informe o código do respectivo professor"><br><br>
				</div>


				<div class="form-group col-md-6">
					<button type="submit" name="command" value="CadastrarMatricula"	class="btn btn-primary">
						Cadastrar <span class="glyphicon glyphicon-floppy-save"	aria-hidden="true"></span>
					</button>

					<a href="ListarMatricula.jsp"
						class="btn btn-default btn-default active"> Cancelar <span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</a>
				</div>

			</form>
			
			</div>
	
</body>
</html>