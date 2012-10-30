/*
 * Function for Theme Handling
 *
 */
function changeTheme(newTheme) {
	if (newTheme=='showcase')
		themePathPrefix = "themes/";
	else {
		themeHref = $('#jquery_theme_link').attr('href');
		if ($("#google").attr('checked')) {
			if (themeHref.indexOf("http:")==0) {
				prefixIndex = themeHref.indexOf("themes/")+7;
				themePathPrefix=themeHref.substring(0,prefixIndex);
			}
			else {
				$("#themeform").submit();
				return false;
			}
		}
		else {
			themePathPrefix = "struts/themes/";
		}
	}
	$('#jquery_theme_link').attr('href',themePathPrefix+newTheme+'/jquery-ui.css');
}

/*
 * Function for Custome Validation Example
 *
 */
function customeValidation(form, errors) {

	// List for errors
	var list = $('#formerrors');

	// Handle non field errors
	if (errors.errors) {
		$.each(errors.errors, function(index, value) {
			list.append('<li>' + value + '</li>\n');
		});
	}

	// Handle field errors
	if (errors.fieldErrors) {
		$.each(errors.fieldErrors, function(index, value) {
			var elem = $('#' + index + 'Error');
			if (elem) {
				elem.html(value[0]);
				elem.addClass('ym-error');
			}
		});
	}
}

/*
 * Function for Tree Node Delete Example
 *
 */
function deleteTreeNode(url, obj) {
	$("#result2").load(url +"?echo=Delete%20Node%20"+obj[0].id);
}

$(document).ready(function() {

	$.subscribe('changeTextfield', function(event, data) {
		$('#result').html('Textfield '+data.id+' value is '+data.value);
	});

	/*
	 * Subscribe Topics for AJAX Link Event Example
	 */
	$.subscribe('beforeLink', function(event, data) {
		alert('Before request ');
		$('#result').html('Loading ...');
	});
	$.subscribe('completeLink', function(event, data) {
		$('#result').append('<br/><br/><strong>Completed request ' + event.originalEvent.request.statusText + ' completed with ' + event.originalEvent.status + '.</strong><br/>Status: ' + event.originalEvent.request.status);
	});
	$.subscribe('errorStateLink', function(event, data) {
		$('#result').html('<br/><br/><strong>Error request ' + event.originalEvent.request.statusText + ' completed with ' + event.originalEvent.status + '.</strong><br/>Status: ' + event.originalEvent.request.status);
	});

	/*
	 * Subscribe Topics for AJAX Div Event Example
	 */
	$.subscribe('beforeDiv', function(event, data) {
		alert('Before request ');
	});
	$.subscribe('completeDiv', function(event, data) {
		if (event.originalEvent.status == "success") {
			$('#resultnormal').append('<br/><br/><strong>Completed request ' + event.originalEvent.request.statusText + ' completed with ' + event.originalEvent.status + '.</strong><br/>Status: ' + event.originalEvent.request.status);
		}
	});
	$.subscribe('errorDiv', function(event, data) {
		$('#resulterror').html('<br/><br/><strong>Error request ' + event.originalEvent.request.statusText + ' completed with ' + event.originalEvent.status + '.</strong><br/>Status: ' + event.originalEvent.request.status);
	});

	/*
	 * Subscribe Topics for AJAX Form Event Example
	 */
	$.subscribe('beforeForm', function(event, data) {
		var fData = event.originalEvent.formData;
		alert('About to submit: \n\n' + fData[0].value + ' to target ' + event.originalEvent.options.target + ' with timeout ' + event.originalEvent.options.timeout);
		var form = event.originalEvent.form[0];
		if (form.echo.value.length < 2) {
			alert('Please enter a value with min 2 characters');
			event.originalEvent.options.submit = false;
		}
	});
	$.subscribe('completeForm', function(event, data) {
		alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + '\n\nThe output div should have already been updated with the responseText.');
	});
	$.subscribe('errorStateForm', function(event, data) {
		alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' + event.originalEvent.request.status);
	});

	/*
	 * Subscribe Topics for AJAX Datepicker Examples
	 */
  $.subscribe('onDpChangeMonthAndYear', function(event,data) {
    alert('Change month to : '+event.originalEvent.month+' and year to '+event.originalEvent.year);
  });
	$.subscribe('onDpClose', function(event,data) {
	    alert('Selected Date : '+event.originalEvent.dateText);
	});
	$.subscribe('beforeDatepickerShow', function(event, data) {
	   var date = event.originalEvent.date;
	   if (date.getDay() == 6 || date.getDay() == 0){
	  	 event.originalEvent.returnValue = [false,"","Not allowed!"];    
	   }
	   else{
	  	 event.originalEvent.returnValue = [true,"",""];
	   }
	});



	/*
	 * Subscribe Topics for Dialog Event Example
	 */
	$.subscribe('dialogopentopic', function(event, ui) {
		alert('run topic on dialog open');
	});
	$.subscribe('dialogclosetopic', function(event, ui) {
		alert('run topic on dialog close');
	});
	$.subscribe('dialogbeforeclosetopic', function(event, ui) {
		alert('run topic before dialog close');
	});

	/*
	 * Subscribe Topics for Grid Loadonce Example
	 */
	$.subscribe('showloadcolumns', function(event, data) {
		$.struts2_jquery.require("js/plugins/grid.setcolumns.js");
		$("#gridloadtable").jqGrid('setColumns', {});
	});

	/*
	 * Subscribe Topics for GridEdit Event Example
	 */
	$.subscribe('rowselect', function(event, data) {
		$("#gridinfo").html('<p>Edit Mode for Row : ' + event.originalEvent.id + '</p>');
	});
    $.subscribe('oneditsuccess', function(event, data){
		var message = event.originalEvent.response.statusText;
		$("#gridinfo").html('<p>Status: ' + message + '</p>');
	});
	$.subscribe('rowadd', function(event, data) {
		$("#gridedittable").jqGrid('editGridRow', "new", {
			height : 280,
			reloadAfterSubmit : false
		});
	});
	$.subscribe('searchgrid', function(event, data) {
		$("#gridedittable").jqGrid('searchGrid', {
			sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
		});
	});
	$.subscribe('showcolumns', function(event, data) {
		$.struts2_jquery.require("js/plugins/grid.setcolumns.js");
		$("#gridedittable").jqGrid('setColumns', {});
	});

	/*
	 * Subscribe Topics for Grid Multiselect Example
	 */
	$.subscribe('getselectedids', function(event, data) {
		var s;
		s = $("#gridmultitable").jqGrid('getGridParam', 'selarrrow');
		alert('Selected Rows : ' + s);
	});

	/*
	 * Subscribe Topics for Progressbar Change Example
	 */
	$.subscribe('progressbarchangetopic', function(event, data) {
		alert('value changed to : ' + $("#progressbarchange").progressbar('option', 'value'));
	});
	$.subscribe('progressbarclicktopic', function(event, data) {
		$("#progressbarchange").progressbar('value', parseInt((Math.random() * (90)), 10));
	});

	/*
	 * Subscribe Topics for Slider Range Example
	 */
	$.subscribe('sliderStop', function(event, data) {
		alert('Slider stoped with value : ' + event.originalEvent.ui.value);
	});
	$.subscribe('sliderRangeStop', function(event, data) {
		alert('Slider stoped with values : ' + event.originalEvent.ui.values[0] + ' - ' + event.originalEvent.ui.values[1]);
	});

	/*
	 * Subscribe Topics for Remote Tabs Example
	 */
	$.subscribe('tabchange', function(event, data) {

		var tab = event.originalEvent.ui.newTab.attr("id");
		$('#changepanel').html('Change to Tab <strong>' + event.originalEvent.ui.newTab.attr("id") + '.</strong>');
		$('#infopanel').html('');
		if (tab === "tab3") {
			$('#remotetabs').tabs('enable', 3);
		} else if (tab === "tab4") {
			$('#remotetabs').tabs('enable', 4);
		}
	});
	$.subscribe('tabcomplete', function(event, ui) {
		$('#infopanel').html('<strong>Request for Tab '+event.originalEvent.ui.newTab.attr("id") +' completed!</strong>');
	});


	/*
	 * Remove Error Labels when Validation Forms are successfully
	 */
	$.subscribe('removeErrors', function(event, data) {
		$('.errorLabel').html('').removeClass('errorLabel');
		$('#formerrors').html('');
	});

	/*
	 * Topic for Remote Link with JSON Result.
	 */
	$.subscribe('handleJsonResult', function(event, data) {
		$('#result').html("<ul id='languagesList'></ul>");
		var list = $('#languagesList');
		$.each(event.originalEvent.data, function(index, value) {
			list.append('<li>' + value + '</li>\n');
		});
	});

	/*
	 * Hide the target after action is complete.
	 */
	$.subscribe('hideTarget', function(event, data) {
				$('#'+event.originalEvent.targets).delay(2000).hide("blind", 2500);
	});

	/*
	 * Topic for Drag and Drop Example.
	 */
	$.subscribe('ondrop', function(event,data) {
    $(data).addClass('ui-state-highlight').find('p').html($(event.originalEvent.ui.draggable).attr('id')+' dropped!');
    $(event.originalEvent.ui.draggable).find('p').html('I was dragged!');
	});

	/*
	 * Topic for Reload Div Examples.
	 */
  var refreshDiv1 = 0;
	var refreshDiv2 = 0;
	var refreshDiv3 = 0;
	var refreshList = 0;

	$.subscribe('refreshlist', function(event, data) {
		$.publish('reloadlist');
	});
	$.subscribe('refreshdiv', function(event, data) {
		$.publish('reloaddiv1');
	});
	$.subscribe('completediv1', function(event, data) {
		if (event.originalEvent.status == "success") {
			$('#counter1').html(++refreshDiv1);
		}
	});
	$.subscribe('completediv2', function(event, data) {
		if (event.originalEvent.status == "success") {
			$('#counter2').html(++refreshDiv2);
			setTimeout( function() {
				$.publish('reloaddiv2');
			}, 10000);
		}
	});
	$.subscribe('completediv3', function(event, data) {
		if (event.originalEvent.status == "success") {
			$('#counter4').html(++refreshDiv3);
			setTimeout( function() {
				$.publish('reloaddiv3');
			}, 15000);
		}
	});
	$.subscribe('completelist', function(event, data) {
		if (event.originalEvent.status == "success") {
			$('#counter3').html(++refreshList);
		}
	});

  $.subscribe('autocompleteChange', function(event, data) {
  	var ui = event.originalEvent.ui;
  	if(ui.item) {
    	var message = ui.item.value;
    	if(ui.item.key) {
    		message = '( '+ ui.item.key +' ) '+message;
    	}
  		$('#topics').html('<b>'+message+'</b>');
  	}
	});

  $.subscribe('autocompleteFocus', function(event, data) {
  	var ui = event.originalEvent.ui;
  	var message = ui.item.value;
  	if(ui.item.key) {
  		message = '( '+ ui.item.key +' ) '+message;
  	}
		$('#topics').html('<u>'+message+'</u>');
	});

  $.subscribe('autocompleteSelect', function(event, data) {
  	var ui = event.originalEvent.ui;
  	var message = ui.item.value;
  	if(ui.item.key) {
  		message = '( '+ ui.item.key +' ) '+message;
  	}
		$('#topics').html('<i>'+message+'</i>');
	});

	/*
	 * Subscribe Topics for Chart Example
	 */
	$.subscribe('chartHover', function(event, data) {
    $("#topicsHover").text(event.originalEvent.pos.x.toFixed(2)+','+event.originalEvent.pos.y.toFixed(2));
	});
	$.subscribe('chartClick', function(event, data) {
		var item = event.originalEvent.item;
    if (item) {
      $("#topicsClick").text("You clicked point " + item.dataIndex + " ("+item.datapoint[0]+","+item.datapoint[1]+") in " + item.series.label + ".");
      event.originalEvent.plot.highlight(item.series, item.datapoint);
    }
	});

	/*
	 * Subscribe Topics for Tree Example
	 */
	$.subscribe('treeClicked', function(event, data) {
		  var item = event.originalEvent.data.rslt.obj;
		  alert('Clicked ID : ' + item.attr("id") + ' - Text ' + item.text());
	});

	/*
	 * Subscribe Topics for Reichtext Example
	 */
	$.subscribe('focusRichtext', function(event, data) {
		$("#result").addClass('ui-state-active');
		$("#result").removeClass('ui-state-highlight');
	});
	$.subscribe('blurRichtext', function(event, data) {
		$("#result").removeClass('ui-state-active');
		$("#result").removeClass('ui-state-highlight');
	});
	$.subscribe('highlightRichtext', function(event, data) {
		$("#result").removeClass('ui-state-active');
		$("#result").addClass('ui-state-highlight');
	});
});
