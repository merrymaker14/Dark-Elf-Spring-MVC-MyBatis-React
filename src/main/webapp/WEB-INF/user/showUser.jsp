<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>${user.userName}</title>
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
	        $('#example').DataTable( {
	            responsive: {
	                details: {
	                    type: 'column'
	                }
	            },
	            colReorder: true,
	            responsive: true,
                language: {
                    "processing": "Подождите...",
                    "search": "Поиск:",
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
    	<div style="text-align: center;">Список книг</div>
    	<button type="button" class="btn btn-primary" style="text-align: right;">
	        Расширенный поиск по атрибутам
	    </button>
	    <br><br>
        <table id="example" class="display nowrap" style="width:100%">
        <thead>
            <tr>
                <th></th>
                <th>Название</th>
                <th>Автор</th>
                <th>Издательство</th>
                <th></th>
                <th></th>
	        </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <th><a href="#">Название</a></th>
                <td>${user.userName}</td>
                <th>Издательство</th>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Редактировать
					</button>
                </td>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Удалить
					</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <th><a href="#">Название</a></th>
                <td>${user.userName}</td>
                <th>Издательство</th>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Редактировать
					</button>
                </td>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Удалить
					</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <th><a href="#">Название</a></th>
                <td>${user.userName}</td>
                <th>Издательство</th>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Редактировать
					</button>
                </td>
                <td>
                	<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
					  Удалить
					</button>
                </td>
            </tr>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary" style="text-align: right;">
	    Выйти
	</button>
   
    <!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
    </body>
</html>