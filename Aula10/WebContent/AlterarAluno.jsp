<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>SistemaICEQ - Alterar Aluno</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Aluno #${aluno.id }</h3>
                    <!-- Formulario para alteração de alunos -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${aluno.id }" />
                        <div class="row">
                            <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${aluno.nome}">
                </div>
                <div class="form-group col-md-6">
                    <label for="nomeM">Nome da Mãe</label>
                    <input type="text" class="form-control" name="nomeM" id="nomeM" required maxlength="100" value="${aluno.nomeM}" placeholder="opcional; alunos da creche devem ter o nome da mãe no cadastro">
                </div>
                <div class="form-group col-md-3">
                    <label for="rg">RG</label>
                    <input type="text" class="form-control" name="rg" id="rg" required maxlength="100" value="${aluno.rg}" placeholder="Próprio ou do Responsável" >
                </div>
                <div class="form-group col-md-9">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" name="endereco" id="endereco" required maxlength="100" value="${aluno.endereco}" placeholder="Digite o endereço, seguido do Número">
                </div>
                </div>
            <div class="row">
                <div class="form-group col-md-3">
                    <label for="foneF">Fixo</label>
                    <input type="tel" class="form-control" name="foneF" id="foneF" maxlength="15"  value="${aluno.foneF}" placeholder="opcional; Telefone com ddd no formato (99) 9999-9999">
                </div>
                <div class="form-group col-md-3">
                    <label for="fone">Celular</label>
                    <input type="tel" class="form-control" name="fone" id="fone" maxlength="15" value="${aluno.fone}" placeholder="obrigatório; celular com ddd no formato (99) 99999-9999">
                </div>
                
                <div class="form-group col-md-6">
                    <label for="email">E-Mail</label>
                    <input type="text" class="form-control" name="email" id="email" required maxlength="100" value="${aluno.email}" placeholder="Digite um e-mail válido">
                </div>
                <div class="form-group col-md-3">
                    <label for="codProfessor">Código Professor</label>
                    <input type="text" class="form-control" name="codProfessor" id="codProfessor" required maxlength="100" value="${aluno.codProfessor}" placeholder="Digite o código do professor">
                </div>
                 <div class="form-group col-md-3">
                    <label for="usuario">Usuário</label>
                    <input type="text" class="form-control" name="usuario" id="usuario" maxlength="60" value="${aluno.usuario}" placeholder="informe um nome de usuário">
                </div>
                <div class="form-group col-md-3">
                    <label for="senha">Senha</label>
                    <input type="text" class="form-control" name="senha" id="senha" maxlength="20"  value="${aluno.senha}" placeholder="digite a senha">
                </div>
            	 <div class="form-group col-md-3">
            	 <label for="permissao"> Permissão Acesso: </label> <br>
            	<select id="permissao" name="permissao" class="form-control"  onchange="ChamarLink();">
							<option value="">${aluno.permissao}</option>
							<option value="Adm">Administrador</option>
							<option value="Dir">Diretoria</option>
							<option value="Prof">Professor</option>
							<option value="Alu">Aluno</option>
						</select>
            	</div>
            
            </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarAluno">Salvar</button>
                                <a href="ListarAlunos.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html> 