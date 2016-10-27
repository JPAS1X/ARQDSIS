<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>SistemaICEQ - Conteúdo Aulas</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="MenuProfessor.jsp"/>
                <!-- Container Principal -->
                 <div id="main" class="container">
                    <h3 class="page-header">Informativo das Aulas</h3>
                    <!-- Formulario para alteração de alunos -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                          <div id="main" class="container">
                    
                        <div class="form-group col-md-6">
							<label for="data" >Data: </label><br>
							<input type="text" class="form-control" name="data" size="40" maxlength="20" placeholder="data">
						</div>
                        <div class="form-group col-md-6">
							<label for="nome" >Nome do Professor: </label><br>
							<input type="text" class="form-control" name="nomeProfessor" size="40" maxlength="30" placeholder="nome completo" >
						</div>
                        <div class="row">
                            <div class="form-group col-md-12">
                    			<label for="nome">Informações:</label><br>
                    			<textarea name="conteudo" rows="16" cols="156" maxlength="999999999999999">Digite a data, a turma e depois seu conteúdo</textarea>
               				</div>
                		</div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="CadastrarInformativoAula">Salvar</button>
                                <a href="ListarInformativoAula.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                           </div>
                        </div>
                    </form>
                </div>
                
                
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html> 