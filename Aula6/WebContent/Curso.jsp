<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="to.CursoTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Curso</title>
</head>
<body>
	<% CursoTO to = (CursoTO) request.getAttribute("curso"); %>
	Codigo:<%= to.getCodigo() %><br>
	Nome:<%= to.getNome() %><br>
	Tipo:<%= to.getTipo() %><br>
	Data de Inicio:<%= to.getDataDeInicio() %><br>
	Data de Termino:<%= to.getDataDeTermino() %><br>
	Horario:<%= to.getHorario() %><br>
	Valor:<%= to.getValor() %><br>
	Número de vagas:<%= to.getNumeroDeVagas() %><br>
	Tipos de Laboratorios:<%= to.getTipoLab() %><br>
	Softwares:<%= to.getSoftwares() %><br>
	Livros:<%= to.getLivros() %><br>
	Descrição:<%= to.getDescricao() %><br>
</body>
</html>