<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Professor</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>

	<c:import url="Menu.jsp"/>

	<!-- Container Principal -->
	<div id="main" class="container">
	
		<h3 class="page-header"> Alterar Professor código: ${infoTO.codigo}</h3>
		<!-- Formulario para alteração de aluno -->
		
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="codigo" value="${infoTO.codigo}" />
			
		<div class="form-group col-md-6">
			<label for="nome" >Nome: </label><br>
			<input type="text" class="form-control" name="nome" size="40" maxlength="30" placeholder="nome completo" value="${infoTO.nome}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="rg" >RG: </label><br> 
			<input type="text" class="form-control" name="rg" size="40" maxlength="20" placeholder="digite o RG" value="${infoTO.dataInicio}">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataAdm" >Data Admissão: </label><br>
			<input type="text" class="form-control" name="dataAdm" size="40" maxlength="20" placeholder="data de Admissão" value="${infoTO.dataAdm}">
		</div>
		
		<div class="form-group col-md-3">
			<label for="telefone" >Telefone: </label><br> 
			<input type="text" class="form-control" name="telefone" size="40" maxlength="10" placeholder="telefone fixo" value="${infoTO.telefone}">
		</div>
			
		<div class="form-group col-md-3">
			<label for="celular" >Celular: </label><br>
		 	<input type="text" class="form-control" name="celular" size="40" maxlength="10" placeholder="celular" value="${infoTO.celular}">
		</div>
			
			
		<div class="form-group col-md-6">
			<label for="email" >Email: </label><br>
			<input type="text" class="form-control" name="email" size="40" maxlength="10" placeholder="informe um email válido" value="${infoTO.email}">
		</div>
	
		
		<div class="form-group col-md-6">
			<label for="curso" >Curso: </label><br> 
			<input type="text" class="form-control" name="curso" size="40" maxlength="20" placeholder="curso" value="${infoTO.curso}">
		</div>
		<div class="form-group col-md-6">
				<label for="usuario"> Usuário: </label> <br> 
				<input type="text" class="form-control" name="usuario" size="40" maxlength="20" placeholder="nome de usuário" value="${infoTO.usuario}">
			</div>
	
			<div class="form-group col-md-3">
				<label for="senha"> Senha: </label> <br> 
				<input type="password"  class="form-control" name="senha" size="40" maxlength="20" placeholder="senha" value="${infoTO.senha}">
			</div>
			
			<div class="form-group col-md-3">
				<label for="permissao"> Permissão Acesso: </label> <br>
			<select id="permissao" name="permissao" class="form-control"  onchange="ChamarLink();">
							<option value="">Selecione...</option>
							<option value="Adm">Administrador</option>
							<option value="Dir">Diretoria</option>
							<option value="Prof">Professor</option>
							<option value="Alu">Aluno</option>
						</select>
		</div>

	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button type="submit" class="btn btn-primary" name="command" value="AlterarProfessor">Salvar</button>
			<a href="ListarProfessor.jsp" class="btn btn-default">Cancelar</a>
		</div>
	</div>
	
	</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>