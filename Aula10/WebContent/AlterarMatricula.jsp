<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>SistemaICEQ - Alterar Matricula</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Matricula #${matricula.codigo }</h3>
                    <!-- Formulario para alteração de matriculas -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="codigo" value="${matricula.codigo }" />
                 <div class="row">
                   <div class="form-group col-md-6">
                    <br><div class="form-group col-md-3">
					<label for="valor"> Valor: </label> <br> 
					<input type="text" class="form-control" name="valor" size="40" maxlength="20" placeholder="Valor da matrícula" required>
				</div>

				<div class="form-group col-md-3">
					<label for="data"> Data: </label> <br> 
					<input type="text" class="form-control" name="data" size="40" maxlength="20" placeholder="Data">
				</div>

				<div class="form-group col-md-6">
					<label for="statusPagamento"> Status Pagamento: </label><br> 
					<input type="text" class="form-control" name="statusPagamento" size="40"maxlength="50" placeholder="Status do pagamento">
				</div>


				<div class="form-group col-md-6">
					<label for="statusMatricula"> Status Matrícula: </label> <br>
					<input type="text" class="form-control" name="statusMatricula" size="40" maxlength="20" placeholder="Status da matrícula">

				</div>
				<div class="form-group col-md-6">
					<label for="aluno"> Aluno: </label> <br> 
					<input type="text" class="form-control" name="aluno" size="40" maxlength="20" placeholder="aluno">
				</div>

				<div class="form-group col-md-6">
					<label for="curso"> Curso: </label><br> 
					<input type="text" class="form-control" name="curso" size="40" maxlength="50" placeholder="digite o curso">
				</div>


				<div class="form-group col-md-6">
					<label for="codProfessor"> Código Professor: </label> <br>
					<input type="text" class="form-control" name="codProfessor" size="40" maxlength="20" placeholder="informe o código do respectivo professor"><br><br>
				</div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarMatricula">Salvar</button>
                                <a href="ListarMatricula.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                   	 </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html> 