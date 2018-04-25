$(document).on("click", ".open-DeleteBookDialog", function () {
	var myBookId = $(this).data('id');
	var action = 'http://localhost:8080/main/book/' + myBookId + '/delete';
	
	var tr = $(this).closest('tr');
	
	document.getElementById('delete').addEventListener("submit", function(e) {
		e.preventDefault();
		
		console.log("action:", action);
		fetch(action, {
			method: 'post'
		})
		.then(function (response) {
			tr.remove();
			$('#exampleModalCenter').modal('hide');
		})
		.then(function (result) {
			
		})
		.catch (function (error) {
			
		});
	});
});