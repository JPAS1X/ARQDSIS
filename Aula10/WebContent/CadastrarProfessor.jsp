<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title> Professores </title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>
<body>

 <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>

<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro de Professores</h2><br><br>
				
		<form action="controller.do" method = "post">     <!--coloca o .do para indicar que faz algo  --> 

	  	  
	  <div class="row">
	  
	  	<div class="form-group col-md-6">
			<label for="nome" >Nome: </label><br>
			<input type="text" class="form-control" name="nome" size="40" maxlength="30" placeholder="nome completo" >
		</div>
	
		<div class="form-group col-md-6">
			<label for="rg" >RG: </label><br> 
			<input type="text" class="form-control" name="rg" size="40" maxlength="20" placeholder="digite o RG">
		</div>
	
		<div class="form-group col-md-6">
			<label for="dataAdm" >Data Admissão: </label><br>
			<input type="text" class="form-control" name="dataAdm" size="40" maxlength="20" placeholder="data de Admissão">
		</div>
		
		<div class="form-group col-md-3">
			<label for="telefone" >Telefone: </label><br> 
			<input type="text" class="form-control" name="telefone" size="40" maxlength="10" placeholder="telefone fixo">
		</div>
			
		<div class="form-group col-md-3">
			<label for="celular" >Celular: </label><br>
		 	<input type="text" class="form-control" name="celular" size="40" maxlength="10" placeholder="celular">
		</div>
			
			
		<div class="form-group col-md-6">
			<label for="email" >Email: </label><br>
			<input type="text" class="form-control" name="email" size="40" maxlength="10" placeholder="informe um email válido">
		</div>
	
		
		<div class="form-group col-md-6">
			<label for="curso" >Curso: </label><br> 
			<input type="text" class="form-control" name="curso" size="40" maxlength="20" placeholder="curso">
		</div>
		<div class="form-group col-md-6">
				<label for="usuario"> Usuário: </label> <br> 
				<input type="text" class="form-control" name="usuario" size="40" maxlength="20" placeholder="nome de usuário">
			</div>
	
			<div class="form-group col-md-3">
				<label for="senha"> Senha: </label> <br> 
				<input type="password"  class="form-control" name="senha" size="40" maxlength="20" placeholder="senha">
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
		</div><br><br>
			 
			<div class="row">
			<div class="form-group col-md-6">
			<button type="submit"  name="command" value="CadastrarProfessor" class="btn btn-primary">Cadastrar
    			<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> 
    		</button>
    		
    		<a href="ListarProfessor.jsp" class="btn btn-default btn-default  active"> Cancelar 
    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 	
 			</a>
			 </div>
	 	</div>
    
</form>   

    
</div>     
</body>
</html>
