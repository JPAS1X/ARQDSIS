<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Informativo Aula</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>

	<c:import url="Menu.jsp"/>

	<!-- Container Principal -->
	<div id="main" class="container">
	
		<h3 class="page-header"> Alterar InformativoAula código: ${infoTO.codigo}</h3>
		<!-- Formulario para alteração de aluno -->
		
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="codigo" value="${infoTO.codigo}" />
			
		<div class="form-group col-md-6">
			<label for="nome" >Data: </label><br>
			<input type="text" class="form-control" name="data" size="40" maxlength="30" placeholder="informe a data atual" value="${infoTO.data}">
		</div>
	
		   <div class="form-group col-md-6">
							<label for="nome" >Nome do Professor: </label><br>
							<input type="text" class="form-control" name="nomeProfessor" size="40" maxlength="30" placeholder="nome completo" value="${infoTO.nomeProfessor}" >
						</div>
                        <div class="row">
                            <div class="form-group col-md-12">
                    			<label for="nome">Informações:</label><br>
                    			<textarea name="conteudo" rows="16" cols="156" maxlength="999999999999999" >${infoTO.conteudo}</textarea>
               				</div>
                		</div>

	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button type="submit" class="btn btn-primary" name="command" value="AlterarInformativoAula">Salvar</button>
			<a href="ListarInformativoAula.jsp" class="btn btn-default">Cancelar</a>
		</div>
	</div>
	
	</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>