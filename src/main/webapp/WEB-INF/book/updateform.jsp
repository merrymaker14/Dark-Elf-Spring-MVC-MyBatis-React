<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<h1>Редактирование книги</h1>

	<br />

	<spring:url value="/book/update" var="bookActionUrl" />

	<form:form class="form-horizontal" method="post" 
                modelAttribute="updateForm" action="${bookActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="name">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Название</label>
			<div class="col-sm-10">
				<form:input path="name" type="text" class="form-control" 
                                id="name" placeholder="Название" />
				<form:errors path="name" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="author">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Автор</label>
			<div class="col-sm-10">
				<form:input path="author" type="text" class="form-control" 
                                id="author" placeholder="Автор" />
				<form:errors path="author" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="publishingHouse">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Издательство</label>
			<div class="col-sm-10">
				<form:input path="publishingHouse" type="text" class="form-control" 
                                id="theYearOfPublishing" placeholder="Издательство" />
				<form:errors path="theYearOfPublishing" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="theYearOfPublishing">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Год издания</label>
			<div class="col-sm-10">
				<form:input path="theYearOfPublishing" type="text" class="form-control" 
                                id="theYearOfPublishing" placeholder="Год издательства" />
				<form:errors path="theYearOfPublishing" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="cover">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Обложка</label>
			<div class="col-sm-10">
				<form:input path="cover" type="text" class="form-control" 
                                id="cover" placeholder="Обложка" />
				<form:errors path="cover" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="description">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Описание</label>
			<div class="col-sm-10">
				<form:textarea path="description" rows="5" class="form-control" 
                                id="description" placeholder="Описание" />
				<form:errors path="description" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <button type="submit" class="btn-lg btn-primary pull-right">Обновить</button>
		  </div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>