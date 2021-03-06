<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>${book.name}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

    <jsp:include page="../fragments/header.jsp" />
    
	<h1>${book.name}</h1><br>
	Автор: ${book.author}<br>
	Издательство: ${book.publishingHouse}<br>
	Год издания: ${book.theYearOfPublishing}<br>
	Обложка: <img src="${book.cover}"><br>
	Описание: ${book.description}<br>
		
    <a href='<spring:url value="/book/books"/>' class='btn btn-primary'>
        Назад
    </a>

    <jsp:include page="../fragments/footer.jsp" />

</body>
</html>