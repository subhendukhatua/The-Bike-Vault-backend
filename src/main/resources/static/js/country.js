$('document').ready(function(){
	$(' table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href=$(this).attr('href');
		$.get(href, function(country,status){
			$('#idEdit').val(country.id); 
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#descriptionEdit').val(country.description);
			$('#nationalityEdit').val(country.nationality);		
		});
		
		$('#editModal').modal();
	});
		

});


/*$('document').ready(function() {
	
	$('table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#codeEdit').val(country.Code);
		});			
		$('#editModal').modal();		
	});*/
	
	/*$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});
*/

