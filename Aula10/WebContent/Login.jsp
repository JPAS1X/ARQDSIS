<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
   

<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
    <script lang="javascript">
    function ChamarLink() {
        var valorCombo = document.getElementById("permissao");
        var itemSelecionado = valorCombo.options[valorCombo.selectedIndex].value;
    	<!-- alert(itemSelecionado);-->
    	
    }
</script>
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="TelaLogin.jsp"/>	
    <!-- Container Principal -->
    <div id="main" class="container">
       <h2 class="page-header">Login</h2><br>
       
       <!-- Formulario de Login -->
        
				
			<!-- combobox login -->	
				<form action="login.do" method="post">
				<div class="row col-md-12">
					<div class="form-group">
						<div class="input-group col-md-4">
							<select id="permissao" name="permissao" class="form-control"  onchange="ChamarLink();">
								<option value="">Selecione seu acesso...</option>
								<option value="Adm">Administrador</option>
								<option value="Dir">Diretoria</option>
								<option value="Prof">Professor</option>
								<option value="Alu">Aluno</option>
							</select>
						</div>
					</div>
				</div>
								
				<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-envelop" aria-hidden="true"></span></div> 
					   <input type="text" name="usuario" id="usuario" class="form-control" maxlength="60" placeholder="Login" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontl" aria-hidden="true"></span></div> 
					   <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				</div>
				<div class="row col-md-12">
				<div class="input-group col-md-4">
					<button type="submit" class="btn btn-primary" name="command" value="FazerLogin"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Ok</button>
				</div>
				</div>
			
			</form>    
			
			</div>
			<div class="row col-md-11">
			<div class="form-group">
			<h1 class="page-header" ></h1> <!-- linha de divisão -->
			</div>
			</div>
    <script src="js/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
    
</body>

</html>