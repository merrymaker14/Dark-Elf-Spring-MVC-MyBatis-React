<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<title>Поиск</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

    <jsp:include page="../fragments/header.jsp" />

    <div class="container">

	<h1>Поиск</h1>

	<br />

	<spring:url value="/book/books" var="bookActionUrl" />

	<form class="form-horizontal" method="get" action="${bookActionUrl}">

		  <div class="form-group">
			<label class="col-sm-2 control-label">Название</label>
			<div class="col-sm-10">
				<input name="name" type="text" class="form-control" 
                                id="name" placeholder="Название">
			</div>
		  </div>
		
		  <div class="form-group">
			<label class="col-sm-2 control-label">Издательство</label>
			<div class="col-sm-10">
				<input name="publishingHouse" type="text" class="form-control" 
                                id="publishingHouse" placeholder="Издательство">
			</div>
		  </div>
		
		  <div class="form-group">
			<label class="col-sm-2 control-label">Год издания</label>
			<div class="col-sm-10">
				<input name="theYearOfPublishing" type="text" class="form-control" 
                                id="theYearOfPublishing" placeholder="Год издания">
			</div>
		  </div>

		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <button type="submit" class="btn-lg btn-primary pull-right">Поиск</button>
		  </div>
		</div>
	</form>
	
	</div>

    <a href='<spring:url value="/book/books"/>' class='btn btn-primary'>
        Назад
    </a>

    <jsp:include page="../fragments/footer.jsp" />

</body>
</html>