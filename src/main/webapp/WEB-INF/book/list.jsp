<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Книги серии "Темный эльф"</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.dataTables.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
    <script>
	    $(document).ready(function() {
	    	var myTable = $('#example').DataTable( {
	            responsive: {
	                details: {
	                    type: 'column'
	                }
	            },
	            colReorder: true,
	            responsive: true,
                language: {
                    "processing": "Подождите...",
                    "search": "Фильтр:",
                    "lengthMenu": " _MENU_ ",
                    "info": "Показано с _START_ до _END_ книг из _TOTAL_",
                    "infoEmpty": "Записи с 0 до 0 из 0 книг",
                    "infoFiltered": "(отфильтровано из _MAX_ книг)",
                    "infoPostFix": "",
                    "loadingRecords": "Загрузка книг...",
                    "zeroRecords": "Книги отсутствуют.",
                    "emptyTable": "В таблице отсутствуют книги",
                    "paginate": {
                    "first": "Первая",
                    "previous": "<",
                    "next": ">",
                    "last": "Последняя"
                    },
                    "aria": {
                    "sortAscending": ": активировать для сортировки столбца по возрастанию",
                    "sortDescending": ": активировать для сортировки столбца по убыванию"
                    }
                },
	            columnDefs: [ {
	                className: 'control',
	                orderable: false,
	                targets:   0
	            } ],
	            dom: 'lBfrtip',
	            buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	            ],
	            order: [ 1, 'asc' ]
	        } );
	    } );
    </script>
</head>
    <body>
        <c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
    
    	<jsp:include page="../fragments/header.jsp" />
    	<h2 style="text-align: center;">Книги серии "Темный эльф"</h2>
    	<!--<div id="react"></div>-->
    	Привет, 
    	<c:choose>
		    <c:when test="${not empty user.login}">
		        <b>${user.login}</b>
		    </c:when>
		    <c:otherwise>
		        гость
		    </c:otherwise>
		</c:choose><br>
    	<c:if test="${user.isAdmin}">
    	<a href="http://localhost:8080/main/book/add" class="btn btn-primary float-right">
	        Добавить запись
	    </a>
	    </c:if>
    	<a href="http://localhost:8080/main/book/search" class="btn btn-primary float-right">
	        Расширенный поиск
	    </a>
	    <br><br>
        <table id="example" class="display nowrap" style="width:100%">
	        <thead>
	            <tr>
	                <th></th>
	                <th>Название</th>
	                <th>Автор</th>
	                <th>Издательство</th>
	                <th>Год издания</th>
	                <c:if test="${user.isAdmin}">
	                <th></th>
	                <th></th>
	                </c:if>
		        </tr>
	        </thead>
	        <tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td></td>
						<td><a href="http://localhost:8080/main/book/book?id=${book.id}">${book.name}</a></td>
						<td>${book.author}</td>
						<td>${book.publishingHouse}</td>
						<td>${book.theYearOfPublishing}</td>
						<c:if test="${user.isAdmin}">
						<td>
							<a href="http://localhost:8080/main/book/${book.id}/update" class="btn btn-primary">
							  Редактировать
							</a>
						</td>
						<td>
							<!-- Button trigger modal -->
							<button type="button" data-id="${book.id}" class="open-DeleteBookDialog btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
							  Удалить
							</button>
						</td>
						</c:if>
					</tr>
				</c:forEach>
	        </tbody>
	    </table>
	    <a href='<spring:url value="/user/logout"/>' class='btn btn-primary' style='text-align: right;'>
		    Выйти
		</a>
	   
	    <!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Вы действительно хотите удалить запись?</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
		        <form method="post" id="delete" action=""> 
		          <input type="submit" id="deleteBook" class="btn btn-primary" value="Удалить">
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		<script src='<spring:url value="/resources/script.js"/>'></script>
		<jsp:include page="../fragments/footer.jsp" />
    </body>
</html>