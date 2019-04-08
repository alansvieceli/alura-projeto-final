<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Pedidos">

	<div class="container">
		<h2>Lista de Pedidos atuais</h2>	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Id</th>
				<th>Valor</th>
				<th>Data do Pedido</th> 
				<th>Título</th>
			</tr>
			<c:forEach items="${pedidos }" var="pedido">
				<tr>
					<td>${pedido.id }</a> </td>
					<td>${pedido.valor }</td>
					<td><span><fmt:formatDate value="${pedido.data.time }" pattern="dd/MM/yyyy"/></span></td>
					<td>${pedido.getTitulos() }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</tags:pageTemplate>