
<!-- TEM QUE ARRUMAR  -->



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Matrícula</title>

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
                                    <input type="hidden" name="codigo" value=" ${matriculaTO.codigo}" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirMatricula">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                
                    
                
                
       			<c:import url="Menu.jsp"/>   
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Matricula: ${matriculaTO.codigo}</h3>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Valor:</strong>
                             ${matriculaTO.valor}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Data:</strong>
                             ${matriculaTO.data}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Status Pagamento:</strong>
                             ${matriculaTO.statusPagamento}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Status Matrícula:</strong>
                             ${matriculaTO.statusMatricula}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Curso:</strong>
                             ${matriculaTO.curso}
                            </p>
                        </div>
                        
                          <div class="col-md-12">
                            <p><strong>Aluno:</strong>
                             ${matriculaTO.aluno}
                            </p>
                        </div>
                        
                        
                          <div class="col-md-12">
                            <p><strong>Código Professor:</strong>
                         	 ${matriculaTO.codProfessor}
                            </p>
                        </div>
                       
                        
                      <hr />
                    
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarMatricula&cpf=${matriculaTO.codigo}" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarMatricula.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                  </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>






