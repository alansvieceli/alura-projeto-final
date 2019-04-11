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
		<p>${menssagem}</p>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Roles</th>
				<th></th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
					<td>${usuario.roles }</td>
					<td>
					<a href="${s:mvcUrl('UC#roles').arg(0, usuario.email).build() }">
					<img alt="Alterar/Inserir Role" src="https://storage.googleapis.com/helpdocs-assets/pxEGJf5ac2/articles/YMDw6yh4Pi/1518808666761/add-team-member.png" /> 
					</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</tags:pageTemplate>