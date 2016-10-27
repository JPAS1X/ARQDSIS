<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
  	<div class="container">
    <p class="navbar-text navbar-right"><span class="glyphicon glyphicon-education" aria-hidden="true"></span>
    <em>USJT - 2016 - Prof. Sergio Bonato  </em></p>
    <p class="navbar-text navbar-left"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
    <c:if test="${not empty logado.nome}">
    		${logado.nome}
    	</c:if>
    	<c:if test="${empty logado.nome}">
    		nenhum usuário logado
    	</c:if>	
    </p>
  	</div> 
	</nav>