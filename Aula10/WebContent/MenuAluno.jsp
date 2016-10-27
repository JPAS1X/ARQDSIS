<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	
	<script type="text/javascript">
		function confirma(sair){
			
			if(confirm("Tem certeza que deseja sair?")){
				window.open("Logout.jsp");
				window.close('this');
			
			}else return false;
				
		}
	</script>
    
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="MenuAluno.jsp">nome do aluno logado</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    
                    <li><a href="controller.do?command=ListarInformativoAulaReiniciar">Informativo Aulas</a>
                    </li>
                    <li><a href="">Curso</a>
                    </li>
                    <li><a href="">Matrícula</a>
                    </li>
                    <li><a href="#"onclick="confirma('sair')">Sair</a>
                    </li>
               
                </ul>
            </div>
        </div>
    </nav>