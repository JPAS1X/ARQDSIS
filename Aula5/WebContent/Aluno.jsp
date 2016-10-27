<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="to.AlunoTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>Aluno</title>
</head>
<body>
	<% AlunoTO to = (AlunoTO) request.getAttribute("aluno"); %>
	
	Código: <%= to.getCodigo() %><br>
	Nome: <%= to.getNome() %><br>
	Sexo: <%= to.getSexo() %><br>
	Data de nascimento: <%= to.getDataNascimento() %><br>
	Endereço: <%= to.getEndereco() %><br>
	Número: <%= to.getNumero() %><br>
	Complemento: <%= to.getComplemento() %><br>
	RG: <%= to.getComplemento() %><br>
	CPF: <%= to.getCPF() %><br>
	Telefone: <%= to.getTelefone() %><br>
	Email: <%= to.getEmail() %><br>
</body>
</html>