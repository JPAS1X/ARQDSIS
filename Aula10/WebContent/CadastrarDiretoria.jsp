<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SistemaICEQ - Cadastrar Diretoria</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	
<!-- container principal -->
	<div id="main" class="container">
		<h2>Cadastro de Diretores</h2><br><br>
		
		<form action="controller.do" method = "post">     <!--coloca o .do para indicar que faz algo  --> 

	  <div class="row">
    
			<div class="form-group col-md-6">
				<label for="Nome" >Nome: </label><br>
				<input type="text" class="form-control" name="nome" size="40" maxlength="70" placeholder="nome completo">
			</div>
						
			<div class="form-group col-md-3">
				<label for="rg"> RG:  </label> <br>
				 <input type="text" class="form-control" name="rg" size="40" maxlength="20" placeholder="RG do aluno ou Responsável" required>
			</div>
			
			<div class="form-group col-md-3">
				<label for="endereco"> Unidade: </label><br>
				 <input type="text" class="form-control" name="unidade" size="40" maxlength="50" placeholder="informe a unidade">
			</div>
			
			
			<div class="form-group col-md-3">
				<label for="telefone"> Telefone: </label> <br>
				 <input type="text" class="form-control" name="foneF" size="40" maxlength="20" placeholder="digite no formato 99 9999-9999">
			</div>
			
			<div class="form-group col-md-3">
				<label for="telefone"> Celular: </label> <br>
				 <input type="text" class="form-control" name="fone" size="40" maxlength="20" placeholder="digite no formato 99 90000-0000">
			</div>
			
			<div class="form-group col-md-6">
				<label for="email"> E-mail:  </label>  <br>
				<input type="text" class="form-control" name="email" size="40" maxlength="50" placeholder="digite um e-mail válido">
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
			<button type="submit"  name="command" value="CadastrarDiretoria" class="btn btn-primary">Cadastrar
    			<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> 
    		</button>
    		
    		<a href="ListarAlunos.jsp" class="btn btn-default btn-default  active"> Cancelar 
    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 	
 			</a>
 			 </div>
 			</div>
  
</form>   

    
</div>     
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>