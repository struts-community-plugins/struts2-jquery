/*
 * Format a Column as Link
 */
function formatLink(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog("+cellvalue+")'>" + cellvalue + "</a>";
}

/*
 * Open Dialog with Employee Details
 */
function openDialog(employee) {
	$("#employees_details").load(employee_detail_url+"?id="+employee);
	$("#employees_details").dialog('open');
}

/*
 * Handle Error Messages for Form Editing
 */
function isError(text) {
	
	if(text.indexOf('ERROR') >= 0) { 
		return [false, text]; 
	}
	
	return [true,''];
}

$(document).ready(function() {

	/*
	 * Topic for Drag and Drop Example.
	 */
	$.subscribe('ondrop', function(event, data) {
		var dragElem = $(event.originalEvent.ui.draggable);
		var dropElem = $(event.originalEvent.event.target);
		$("#dndmessages")
			.html('Move Customer '+ dragElem.attr("id") +' to grid '+dropElem.attr("id"));
	});

});
