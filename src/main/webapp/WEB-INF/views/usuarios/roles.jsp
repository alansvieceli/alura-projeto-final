<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuários">
	<p>
	<div class="container">
		<h1>Cadastro de Usuário</h1>
		<form:form action="${s:mvcUrl('UC#gravarRoles').build() }"
			method="post" commandName="usuario">

			<form:hidden path="email" cssClass="form-control" />

			<div class="form-group">
				Permissões:
				<form:checkboxes path="roles" items="${roles}" />
			</div>


			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
	</p>

</tags:pageTemplate>