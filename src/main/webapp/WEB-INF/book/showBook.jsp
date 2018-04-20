<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>${book.name}</title>
</head>
<body>

    <jsp:include page="../fragments/header.jsp" />
    
	<h1>${book.name}</h1><br>
	Автор: ${book.author}<br>
	Издательство: ${book.publishingHouse}<br>
	Год издания: ${book.theYearOfPublishing}<br>
	Обложка: <img src="${book.cover}"><br>
	Описание: ${book.description}<br>
		
    <a href="http://localhost:8080/main/book/books" class="btn btn-primary">
        Назад
    </a>

    <jsp:include page="../fragments/footer.jsp" />

</body>
</html>