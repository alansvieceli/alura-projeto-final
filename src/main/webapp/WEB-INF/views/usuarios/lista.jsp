<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Usuários">

	<div class="container">

		<h2>
			<a href="${s:mvcUrl('UC#form').build() }" rel="nofollow">Novo de
				Usuário</a>
		</h2>

		<h2>Lista de Usuários</h2>
		<p>${message}</p>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</tags:pageTemplate>