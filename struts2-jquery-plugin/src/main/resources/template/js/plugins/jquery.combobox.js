// Taken from jquery UI Combobox Example
( function($) {
	$.widget("ui.combobox", {
		_create : function() {
			var self = this;
			var select = this.element.hide();
			$("<input>").insertAfter(select).autocomplete( {
			source : function(request, response) {
				var matcher = new RegExp(request.term, "i");
				response(select.children("option").map( function() {
					var text = $(this).text();
					if (!request.term || matcher.test(text)) { return {
					id :$(this).val(),
					label :text.replace(new RegExp("(?![^&;]+;)(?!<[^<>]*)(" + request.term.replace(/([\^\$\(\)\[\]\{\}\*\.\+\?\|\\])/gi, "\\$1") + ")(?![^<>]*>)(?![^&;]+;)", "gi"), "<strong>$1</strong>"),
					value :text
					}; }
				}));
			},
			delay :0,
			select : function(e, ui) {
				if (!ui.item) {
					// remove invalid value, as it didn't match anything
					$(this).val("");
					return false;
				}
				$(this).focus();
				select.val(ui.item.id);
				self._trigger("selected", null, {
					item :select.find("[value='" + ui.item.id + "']")
				});

			},
			minLength :0
			}).addClass("ui-widget ui-widget-content ui-corner-left");
		}
	});
})(jQuery);
