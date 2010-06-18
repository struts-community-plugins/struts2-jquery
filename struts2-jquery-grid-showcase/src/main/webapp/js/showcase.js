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

	/*
	 * Menu Highlight
	 */
	$('div.ui-widget-header > ul > li').click(function() {
		$('div.ui-widget-header > ul > li').removeClass('ui-state-active');
		$(this).addClass('ui-state-active');
	}, function() {
	});
	$('div.ui-widget-header > ul > li').hover(function() {
		$(this).addClass('ui-state-hover');
	}, function() {
		$(this).removeClass('ui-state-hover');
	});

});
