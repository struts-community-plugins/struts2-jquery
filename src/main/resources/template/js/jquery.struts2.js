(function($){
	
	/**
	 * STRUTS2 JQUERY COMPONENT/WIDGET BINDING
	 */
	_struts2_jquery = {
			
		//pre-binding function of the type function(element){}. called before binding the element
		// returning false will prevent the binding of this element
		preBind: null,
		
		//post-binding function of the type function(element){}. called before binding the element
		postBind: null,
			
		bind: function(el) {
			
			if(el) {
				var $el = $(el);
				el = $el[0];
				var attributes = el.attributes;
				var options = {};
				
				//attributes names are sometimes returned all lower/upper case so we need to force to a case for uniformity
				for(var i = 0; i < attributes.length; i++) {
					options[attributes[i].name.toLowerCase()] = attributes[i].value;
				}
				
				var tag = el.tagName.toLowerCase();
				
				//extension point to allow custom pre-binding processing
				if(typeof(_struts2_jquery.preBind) != "function" || _struts2_jquery.preBind($el)) {
					
					var widget = $el.attr("widget");
					if(!widget)
						widget = tag;
									
					this[widget]($el, options);
				
					//extension point to allow custom post-binding processing
					if(_struts2_jquery.postBind && (typeof(_struts2_jquery.postBind) == "function")) {
						return _struts2_jquery.postBind(el);
					}
				}
				
			}
		},
		
		// register a custom widget, providing the widget name and a bind handler function of the form: 
		//	   function($elem, options) - where '$elem' will be the jquery object of the widget element and 'options' will be a name/value hash of the element attributes
		// The widget element must have a 'widget' attribute attribute with the widget's name as its value.
		widget: function(name, binder) {
			
			if(name && binder) {
			
				this[name] = binder;
			}
		},
		
		base:  function($elem, options){
		
			if(options.onhidetopics) {			  
				var topics = options.hidetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_hide',options);
				}
			}

			if(options.onshowtopics) {			  
				var topics = options.showtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_show',options);
				}
			}

			if(options.onremovetopics) {			  
				var topics = options.removetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_remove',options);
				}
			}
			
			if(options.disabled == 'true') {

				$elem.attr("disabled","disabled");
				$elem.addClass("disabled");
			}
		},
		
		interactive:  function($elem, options){

			if(options.enabletopics) {			  
				var topics = options.enabletopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_enable',options);
				}
			}

			if(options.disabletopics) {			  
				var topics = options.disabletopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_disable',options);
				}
			}
		},
		
		action: function($elem, options, containerLoadHandlerName, type){

			if($elem.attr('href')) {options.src = $elem.attr('href')}
	    	if($elem.attr('href') && type == 'a') { $elem.attr('href','#'); }
	    				
			if(options.opendialog) {
				$elem.bind('click', function(event) {
					$('#'+options.opendialog).dialog('open');
				});
			}
			
	    	//bind event to onClick topics
			if(options.onclicktopics) {  
				var topics = options.onclicktopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
									
					var topic = topics[i];
					$elem.createTopic(topic);
					$elem.bind('click', function(event){
						
						$target = $(this);
						
						if(!$target.disabled || $target.disabled != true) {

							var publishOptions = event.data || {};
							publishOptions.disabled = false;
							
							$target.publish(topic, publishOptions, event);
						}
					});
				}
			}
			
	    	var actionTopic = '_struts2_jquery_action_topic_' + options.id;
	    	
	    	var href = options.href;
	    	
	    	if(href == null || href == "") {
	    		href = "#";
	    		options.href = href;
	    	}

			var effectTopic = '_struts2_jquery_div_effect_';
			var effect = {};
			effect.effect = options.effect;
			effect.effectoptions = options.effectoptions;
			effect.effectduration = options.effectduration;

			//subscribe all targets to this action's custom execute topic
	    	if(options.targets) {  
	    		
	    		//target subscription needs to be done after document load in case element exists in the dom AFTER the current action object 
	    		$(function() {
					var targets = options.targets.split(',');
					for ( var i = 0; i < targets.length; i++) {
						var target = targets[i];
						if('#tab' == target) {
							$elem.closest('.ui-tabs-panel').subscribe(actionTopic, containerLoadHandlerName, options);
			    		} else {
							effect.targets = target;
			    			$('#' + target).subscribe(actionTopic, containerLoadHandlerName, options);
			    			$('#' + target).subscribe(effectTopic+target, '_struts2_jquery_effects', effect);
			    		}
					}
	    		});
	    		
			} else {   // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container

				effect.targets = options.id;
				$('#' + options.id).subscribe(effectTopic+options.id, '_struts2_jquery_effects', effect);
					
				//bind event topic listeners
		    	if(options.onbeforetopics || options.oncompletetopics || options.onsuccesstopics || options.onerrortopics) {
			    		$elem.subscribe(actionTopic, containerLoadHandlerName, options);
		    	}
			}

	    	if(type == "a") {
		    	options.src = href;
				$elem.publishOnEvent('click', actionTopic);			//bind custom action topic to click event
	    	}
			
		},
			
		div: function($elem, options){

			var containerLoadHandlerName = '_struts2_jquery_container_load';
			var effectHandlerName = '_struts2_jquery_effects';
			
			this.base($elem, options);
			this.action($elem, options, containerLoadHandlerName, 'div');


			//load div using ajax
			if(options.src) {

				//publishing not triggering to prevent event propagation issues
		    	var divTopic = '_struts2_jquery_div_load_' + options.id;
	    		$elem.subscribe(divTopic, containerLoadHandlerName);
				if(options.bindon) {
					var $bindElement = $('#'+options.bindon);
					if(options.events) {
						var events = options.events.split(',');
						for ( var i = 0; i < events.length; i++) {
							$bindElement.publishOnEvent(events[i], divTopic);
						}
					}
					else {
						$bindElement.publishOnEvent('click', divTopic);
					}
				}
				else {
					$elem.publish(divTopic,options);	
				}
			}
			else {
				
				var divEffectTopic = '_struts2_jquery_div_effect_';
				if(options.id && options.effect) {
					var effect = {};
					effect.targets = options.id;
					effect.effect = options.effect;
					effect.effectoptions = options.effectoptions;
					effect.effectduration = options.effectduration;
		    		$elem.subscribe(divEffectTopic+options.id, effectHandlerName, effect);
				}


				if(options.events || options.bindon) {

					var $bindElement = $elem;
					if(options.bindon)
						$bindElement = $('#'+options.bindon);

					if(options.events) {
						
						var events = options.events.split(',');
						for ( var i = 0; i < events.length; i++) {
							$bindElement.publishOnEvent(events[i], divEffectTopic+options.id);
						}
					}
					else {
							$bindElement.publishOnEvent('click', divEffectTopic+options.id);
					}
				}
				else {
					$elem.publish(divEffectTopic+options.id, $elem);	
				}
				
				if(options.resizable == 'true') {

			        var resizableOptionsStr = options.resizableoptions;
			        var resizableOptions = window[resizableOptionsStr];
			        if (!resizableOptions) {
			        	resizableOptions = eval ("( " + resizableOptionsStr + " )" );
			        }
					$elem.resizable(resizableOptions);
				}
			}

			if(options.draggable == 'true') {
				
		        var draggableOptionsStr = options.draggableoptions;
		        var draggableOptions = window[draggableOptionsStr];
		        if (!draggableOptions) {
		        	draggableOptions = eval ("( " + draggableOptionsStr + " )" );
		        }
				$elem.draggable(draggableOptions);
			}
			
			if(options.droppable == 'true') {

		        var droppableOptionsStr = options.droppableoptions;
		        var droppableOptions = window[droppableOptionsStr];
		        if (!droppableOptions) {
		        	droppableOptions = eval ("( " + droppableOptionsStr + " )" );
		        }
				$elem.droppable(droppableOptions);
			}
			
			if(options.selectable == 'true') {

		        var selectableOptionsStr = options.selectableoptions;
		        var selectableOptions = window[selectableOptionsStr];
		        if (!selectableOptions) {
		        	selectableOptions = eval ("( " + selectableOptionsStr + " )" );
		        }
				$elem.selectable(selectableOptions);
			}

			if(options.sortable == 'true') {

		        var sortableOptionsStr = options.sortableoptions;
		        alert(sortableOptionsStr);
		        var sortableOptions = window[sortableOptionsStr];
		        if (!sortableOptions) {
		        	sortableOptions = eval ("( " + sortableOptionsStr + " )" );
		        }
				$elem.sortable(sortableOptions);
			}

		},
		
		a: function($elem, options){
			
			var containerLoadHandlerName = '_struts2_jquery_container_load';

			this.base($elem, options);
			this.interactive($elem, options);
			if(options.formids) {
				this.formsubmit($elem, options);
			}
			else {
				this.action($elem, options, containerLoadHandlerName, 'a');
			}
		},
		
		button: function($elem, options){
			var containerLoadHandlerName = '_struts2_jquery_container_load';
			
			this.base($elem, options);
			this.interactive($elem, options);
			if(options.formids) {
				this.formsubmit($elem, options);
			}
			else {
				this.action($elem, options, containerLoadHandlerName, 'a');
			}
			$elem.attr('type','button');  
			//(not permitted by ie - covered by renderer)
			$elem.removeAttr('name');
		},
		formsubmit: function($elem, options){
			var submitHandlerName = '_struts2_jquery_form_submit';
	    	var formsubmitTopic = '_struts2_jquery_formsubmit_topic_' + options.id;
    		$elem.subscribe(formsubmitTopic, submitHandlerName, options);
	    	if(options.targets) {  
				var targets = options.targets.split(',');
				for ( var i = 0; i < targets.length; i++) {
					var target = targets[i];
	    			$('#' + target).subscribe(formsubmitTopic, '_struts2_jquery_effects', options);
				}
			}
			$elem.publishOnEvent('click', formsubmitTopic);			//bind custom action topic to click event
		},
		
		dialog: function($elem, options){
			
			var parameters = {};
			parameters.autoOpen = eval(options.autoopen ? options.autoopen : false);
			parameters.modal = eval(options.modal ? options.modal : false);
			parameters.resizable = eval(options.resizable ? options.resizable : true);
			parameters.draggable = eval(options.draggable ? options.draggable : true);
			if(options.height) { parameters.height = eval(options.height); }
			if(options.width) { parameters.width = eval(options.width); }
			if(options.position) { parameters.position = eval(options.position); }
			if(options.zindex) { parameters.zIndex = parseInt(options.zindex); }
			if(options.backgroundcolor) { parameters.backgroundColor = options.backgroundcolor; }
			if(options.hide) { parameters.hide = options.hide; }
			if(options.show) { parameters.show = options.show; }
			
			if(options.title) { parameters.title = options.title; }
			
			if(options.buttons) {
		        var buttonsStr = options.buttons;
		        var buttons = window[buttonsStr];
		        if (!buttons) {
		        	parameters.buttons = eval ("( " + buttonsStr + " )" );
		        }
			}
			parameters.open = function() {
				if(options.href) {
					
					var containerLoadHandlerName = '_struts2_jquery_container_load';
			    	var divTopic = '_struts2_jquery_topic_load_' + options.id;
		    		$elem.subscribe(divTopic, containerLoadHandlerName);
		    		$elem.publish(divTopic,options);				
				}			
				if(options.showtopics) {			  
					var topics = options.showtopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_dialog_open',options);
					}
				}
			}
			$elem.dialog(parameters);
		},
		
		tabbedpanel: function($elem, options){
			
	    	//instantiate the tabbed pane
			if(!options) { options = {}};
			var parameter = {};
			
			if(options.disabled) {
		        var disabledStr = options.disabled;
		        var disabled = window[disabledStr];
		        if (!disabled) {
		        	parameter.disabled = eval ("( " + disabledStr + " )" );
		        }
			}
			if(options.cache && options.cache == 'true')	parameter.cache = true;
			if(options.animate && options.animate == 'true')	parameter.fx = { opacity: 'toggle' };
			if(options.cookie && options.cookie == 'true')	parameter.cookie = { expires: 30 };
			if(options.collapsible && options.collapsible == 'true')	parameter.collapsible = true;
			if(options.openonmouseover && options.openonmouseover == 'true')	parameter.event = 'mouseover';
			if(options.orientation)	parameter.orientation = options.orientation;
			if(options.spinner)	parameter.spinner = options.spinner;
			if(options.selectedtab)	parameter.selected = parseInt(options.selectedtab);
			parameter.ajaxOptions = { dataType:'html' };
			parameter.ajaxOptions.complete = publishCompleteTopics(options.id, options.onalwaystopics, options.oncompletetopics, null, null, {});
			parameter.show = publishTopics($elem, options.onalwaystopics, options.onbeforetopics);
			parameter.select = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
			parameter.enable = publishTopics($elem, options.onalwaystopics, options.onenabletopics);
			parameter.disable = publishTopics($elem, options.onalwaystopics, options.ondisabletopics);
			parameter.add = publishTopics($elem, options.onalwaystopics, options.onaddtopics);
			parameter.remove = publishTopics($elem, options.onalwaystopics, options.onremovetopics);
			
			$elem.find('ul div').appendTo($elem);
	    	$elem.tabs(parameter);
		},
		
		datepicker: function($elem, options) {
			
			var dpOptions = {};
			
			if(options) {
				
				if(options.hidetopics) {			  
					var topics = options.hidetopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_datepicker_hide',options);
					}
				}

				if(options.showtopics) {			  
					var topics = options.showtopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_datepicker_show',options);
					}
				}

				if(options.removetopics) {			  
					var topics = options.removetopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_datepicker_destroy',options);
					}
				}
				
				if(options.enabletopics) {			  
					var topics = options.enabletopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_datepicker_enable',options);
					}
				}

				if(options.disabletopics) {			  
					var topics = options.disabletopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_datepicker_disable',options);
					}
				}
				
				var onAlwaysTopics = options.onalwaystopics;
				
				if(options.onbeforetopics) {  
					var onBeforeTopics = options.onbeforetopics.split(',');
					dpOptions.beforeShow = function(input){
						var $input = $(input);
						for ( var i = 0; i < onBeforeTopics.length; i++) {
							$input.publish(onBeforeTopics[i], $input);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$input.publish(topics[i], $input);
							}
						}
					};
				}
				
				if(options.onbeforeshowdaytopics) {  
					var onBeforeShowDayTopics = options.onbeforeshowdaytopics.split(',');
					dpOptions.beforeShowDay = function(date){
						var $date = $(date);
						for ( var i = 0; i < onBeforeShowDayTopics.length; i++) {
							$elem.publish(onBeforeShowDayTopics[i], $date);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$elem.publish(topics[i], $date);
							}
						}
					};
				}

				if(options.onchangemonthyeartopics) {  
					var onChangeMonthYearTopics = options.onchangemonthyeartopics.split(',');
					dpOptions.onChangeMonthYear = function(year, month, inst){
						var data = {};
						data.year = year;
						data.month = month;
						data.inst = inst;
						var $inst = $(inst);
						for ( var i = 0; i < onChangeMonthYearTopics.length; i++) {
							$inst.publish(onChangeMonthYearTopics[i],$inst, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i],$inst, data);
							}
						}
					};
				}

				if(options.onchangetopics) {  
					var onChangeTopics = options.onchangetopics.split(',');
					dpOptions.onSelect = function(dateText, inst){
						var $inst = $(inst);
						var data = {};
						data.dateText = dateText;
						for ( var i = 0; i < onChangeTopics.length; i++) {
							$inst.publish(onChangeTopics[i], $inst, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i], $inst, data);
							}
						}
					};
				}
				
				if(options.oncompletetopics) {  
					var onCompleteTopics = options.oncompletetopics.split(',');
					dpOptions.onClose = function(dateText, inst){
						var $inst = $(inst);
						var data = {};
						data.dateText = dateText;
						for ( var i = 0; i < onCompleteTopics.length; i++) {
							$inst.publish(onCompleteTopics[i], $inst, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i], $inst, data);
							}
						}
					};
				}
				
				dpOptions.changeMonth = options.changemonth;
				dpOptions.changeYear = options.changeyear;
				dpOptions.dateFormat = options.displayformat;
				dpOptions.showButtonPanel = options.showbuttonpanel;
				dpOptions.buttonImageOnly = options.buttonimageonly;
				dpOptions.buttonImage = options.buttonimage;
				dpOptions.showOn = options.showon;
				dpOptions.buttonText = options.buttontext;
				dpOptions.showAnim = options.showanim;
				dpOptions.firstDay = options.firstday;
				dpOptions.yearRange = options.yearrange;
		        
				if(options.numberofmonths) {
			        var numberofmonthsStr = options.numberofmonths;
			        var numberofmonths = window[numberofmonthsStr];
			        if (!numberofmonths) {
			        	dpOptions.numberOfMonths = eval ("( " + numberofmonthsStr + " )" );
			        }
				}
				
				if(options.showoptions) {
			        var userOptionsStr = options.showoptions;
			        var userOptions = window[userOptionsStr];
			        if (!userOptions) {
			        	dpOptions.showOptions = eval ("( " + userOptionsStr + " )" );
			        }
				}
			}
			
			$elem.datepicker(dpOptions);
			
		    if(options.year && options.month && options.day) {
		    	$elem.val($.datepicker.formatDate(options.displayformat, new Date(options.year, options.month, options.day)));
		    }
		    if( options.zindex) {
		    	$('#ui-datepicker-div').css("z-index", options.zindex); 
		    }
		    
			if(options.disabled == 'true') {

				$elem.attr("disabled","disabled");
				$elem.addClass("disabled");
			}
		},
		slider: function($elem, options) {
			
			var parameter = {};
			if(options) {
				
				parameter.start = publishTopics($elem, options.onalwaystopics, options.onbeforetopics);
				parameter.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
				parameter.stop = publishTopics($elem, options.onalwaystopics, options.oncompletetopics);
				
				parameter.slide = function(event, ui){
					 $('#'+options.hiddenid).val(ui.value);
					 if (options.displayvalueelement) {
					 	$('#'+options.displayvalueelement).html(ui.value);
					 }
				};
				
				if(options.animate && options.animate == 'true')	parameter.animate = true;
				var value = parseInt(options.value);
				if(value > 0) parameter.value = value;
				else parameter.value = 0;
				if(options.max)	parameter.max = parseInt(options.max);
				if(options.min)	parameter.min = parseInt(options.min);
				if(options.orientation)	parameter.orientation = options.orientation;
				if(options.step) parameter.step = parseInt(options.step);

				if(options.range) {
					if(options.range == 'true')	{
						parameter.range = true;
					}
					else {
						parameter.range = options.range;
					}
				}
			}
			
			$elem.slider(parameter);
		},
		progressbar: function($elem, options) {
			
			var parameter = {};
			if(options) {
				
				parameter.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
				
				var value = parseInt(options.value);
				if(value > 0) parameter.value = value;
				else parameter.value = 0;
			}
			$elem.progressbar(parameter);
		},
		accordion: function($elem, options) {
			
			var parameter = {};
			if(options) {

				if(options.fillspace && options.fillspace == 'true')	parameter.fillSpace = true;
				if(options.collapsible && options.collapsible == 'true')	parameter.collapsible = true;
				if(options.clearstyle && options.clearstyle == 'true')	parameter.clearStyle = true;
				if(options.autoheight && options.autoheight == 'true')	parameter.autoHeight = true;
				if(options.fillspace && options.fillspace == 'true')	parameter.fillSpace = true;
				if(options.event)	parameter.event = options.event;
				if(options.header)	parameter.header = options.header;
				else				parameter.header = 'h3';
				if(options.animated)
				{
					if(options.animated == 'true') parameter.animated = true;
					else if(options.animated == 'false') parameter.animated = false;
					else parameter.animated = options.animated;
				}
				
				active = true;
				if(options.active)
				{
					if(options.active == 'true') { parameter.active = true; }
					else if(options.active == 'false') { parameter.active = false; active = false; }
					else { parameter.active = parseInt(options.active); }
				}
				
				var onAlwaysTopics = options.onalwaystopics;
				parameter.changestart = function(event, ui) {
					if(options.href)
					{
						if ( typeof $(ui.newHeader).find('a').attr('paramkeys') != "undefined" )
						{
						    var keys = $(ui.newHeader).find('a').attr('paramkeys').split(',');
						    var values = $(ui.newHeader).find('a').attr('paramvalues').split(',');
							var params = {};
							jQuery.each(keys, function(i, val) {
			      				params[val] = values[i];
			    			});
							ui.newContent.load(options.href,params,function() {});
						 }
					}			
					if(options.onbeforetopics) {  
						var onBeforeTopics = options.onbeforetopics.split(',');
								var data = {};
								data.event = event;
								data.ui = ui;
							for ( var i = 0; i < onBeforeTopics.length; i++) {
								$elem.publish(onBeforeTopics[i], $elem, data);
							}

							if(onAlwaysTopics) {  
								var topics = onAlwaysTopics.split(',');
								for ( var i = 0; i < topics.length; i++) {
									$elem.publish(topics[i], $elem, data);
								}
							}
					}
				};
				
				parameter.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
			}
			$elem.accordion(parameter);
			if(options.href && active == true)
			{
				var aktiv = $("#"+options.id+" li "+parameter.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
				if ( typeof $(aktiv).attr('paramkeys') != "undefined" )
				{
					var keys = $(aktiv).attr('paramkeys').split(',');
					var values = $(aktiv).attr('paramvalues').split(',');
					var params = {};
					jQuery.each(keys, function(i, val) {
			      		params[val] = values[i];
			    	});
					$("#"+options.id+" li div").filter('.ui-accordion-content-active').load(options.href,params,function() {});
				}
			}
		}
	};		
		
	Struts2jQuery = _struts2_jquery;
	
	
	/**
	 * STRUTS2 JQUERY BUILT-IN ELEMENT HANDLERS 
	 */
		
	
	/** Base logic */
	//Register handler to hide an element
	$.subscribeHandler('_struts2_jquery_hide', function(event, data) {
		
		$(this).hide();
	});
	//Register handler to show an element
	$.subscribeHandler('_struts2_jquery_show', function(event, data) {
		
		$(this).show();
	});
	//Register handler to remove an element
	$.subscribeHandler('_struts2_jquery_remove', function(event, data) {
		
		$(this).remove();
	});
	
	
	/** Interactive logic */
	//Register handler to hide an element
	$.subscribeHandler('_struts2_jquery_enable', function(event, data) {
		
		$(this).attr("disabled","false");
		$(this).removeClass("disabled");
	});
	//Register handler to show an element
	$.subscribeHandler('_struts2_jquery_disable', function(event, data) {

		$(this).attr("disabled","true");
		$(this).addClass("disabled");
	});
	

	/** Input logic */	
	//Register handler to focus an input
	$.subscribeHandler('_struts2_jquery_focus',  function(event, data) {
		$(this).focus();
	});
	//Register handler to focus an input
	$.subscribeHandler('_struts2_jquery_blur',  function(event, data) {
		$(this).blur();
	});
	
	
	/** Container logic */
	//Register handler to load a container
	$.subscribeHandler('_struts2_jquery_container_load', function(event, data) {

		var container = $(event.target);
		
		//need to also make use of original attributes registered with the container (such as onCompleteTopics)
		var attributes = container[0].attributes;
		var options = {};
		for(var i = 0; i < attributes.length; i++) {
			options[attributes[i].name.toLowerCase()] = attributes[i].value;
		}
		
		$.extend(options,event.data);
		if(data && !data.id) { //we don;t want to merge 'options; when passed an element as the data (such as when published from an onsuccesstopic)
			$.extend(options,data);
		}
		
		var isDisabled = false;
		isDisabled = options.disabled == null ? isDisabled : options.disabled;
		isDisabled = container.attr('disabled') == null ? isDisabled : container.attr('disabled');
		if(event.originalEvent) {	//means that container load is being triggered by other action (link button/link click) need to see if that button/link is disabled
			isDisabled = $(event.originalEvent.currentTarget).attr("disabled") == null ? isDisabled : $(event.originalEvent.currentTarget).attr("disabled");
		}
							
		if(isDisabled != true && isDisabled != 'true') {
			
			//Show indicator element (if any)
			if(options) {
	
				var indicatorId = options.indicatorid;
				if(indicatorId) { $('#' + indicatorId).show(); }
		
				var onAlwaysTopics = options.onalwaystopics;
				
		    	//publish all 'before' and 'always' topics
				if(onAlwaysTopics) {  
					var topics = onAlwaysTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						container.publish(topics[i], container);
					}
				}
				
				if(options.onbeforetopics) {  
					var topics = options.onbeforetopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						container.publish(topics[i], container);
					}
				}
		    	
		    	//Set pre-loading text (if any)
				if(options.loadingtext) { container.html(options.loadingtext); }
				    				
				options.success = publishSuccessTopics(event.target, onAlwaysTopics, options.onsuccesstopics, indicatorId);
				options.complete = publishCompleteTopics(event.target, onAlwaysTopics, options.oncompletetopics, options.targets, indicatorId, options);
				options.error = publishErrorTopics(event.target, onAlwaysTopics, options.onerrortopics, options.errortext);
				
				//if reloadtopics exist, need to reset reload topics with new options
				if(options.reloadtopics) {			  
					var topics = options.reloadtopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						container.unsubscribe(topics[i]);
						container.subscribe(topics[i], '_struts2_jquery_container_load', options);
					}
				}
	
				//load container using ajax
				if(options.href) {
					
					options.type = "POST";
					options.url = options.href;
					if(options.hrefparameter) {
						options.data = options.hrefparameter;
					}
					if(options.datatype) {
						options.dataType = options.datatype;
					}
					if(!options.data) { options.data = {}; }	//fix 'issue' wherein IIS will reject post without data
					$.ajax(options);
				
				}
			}
		}
	});

	/** Form logic */	
	//Register handler to submit a form element
	$.subscribeHandler('_struts2_jquery_form_submit', function(event, data) {
		var container = $(event.target);
		
		//need to also make use of original attributes registered with the container (such as onCompleteTopics)
		var attributes = container[0].attributes;
		var options = {};
		for(var i = 0; i < attributes.length; i++) {
			options[attributes[i].name.toLowerCase()] = attributes[i].value;
		}
		
		$.extend(options,event.data);
		if(data && !data.id) { //we don;t want to merge 'options; when passed an element as the data (such as when published from an onsuccesstopic)
			$.extend(options,data);
		}
		
		var parameters = {};
		if(options.clearform && options.clearform == 'true')	parameters.clearForm = true;
		if(options.iframe && options.iframe == 'true')	parameters.iframe = true;
		if(options.resetform && options.resetform == 'true')	parameters.resetForm = true;
		if(options.timeout)	parameters.timeout = parseInt(options.timeout);
		if(options.datatype)	parameters.dataType = options.datatype;
		
		parameters.target = '';
		if(options.targets) {
		var targets = options.targets.split(',');
			for ( var i = 0; i < targets.length; i++) {
				var target = targets[i];
				if(parameters.target == '') {
					parameters.target = '#' + target;
	    		} else {
					parameters.target = parameters.target +',#' + target;
	    		}
				
		    	//Set pre-loading text (if any)
				if(options.loadingtext) { $('#' + target).html(options.loadingtext); }
			}
		}
		
		var indicatorId = options.indicatorid;
		if(indicatorId) { $('#' + indicatorId).show(); }

		var onAlwaysTopics = options.onalwaystopics;

		parameters.beforeSubmit = function (formData, form, formoptions) {
			
			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;

			if(onAlwaysTopics) {  
				var topics = onAlwaysTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			
			if(options.onbeforetopics) {  
				var topics = options.onbeforetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
		}
   	
		    				
		parameters.success = publishSuccessTopics(event.target, onAlwaysTopics, options.onsuccesstopics, indicatorId);
		parameters.complete = publishCompleteTopics(event.target, onAlwaysTopics, options.oncompletetopics, options.targets, indicatorId, options);
		parameters.error = publishErrorTopics(event.target, onAlwaysTopics, options.onerrortopics, options.errortext);
		
       $('#'+options.formids).ajaxSubmit(parameters);
        
        return false;
	});
	
	/** Effects */	
    //Register handler for effects
    $.subscribeHandler('_struts2_jquery_effects', function(event, data) {
		var options = {};
		$.extend(options,event.data);
		if(options.targets || options.effect) {
			var effectOptions = {};
			var duration = 2000;
			if(options.effectoptions) {
		        var effectOptionsStr = options.effectoptions;
		        effectOptions = window[effectOptionsStr];
		        if (!effectOptions) {
		        	effectOptions = eval ("( " + effectOptionsStr + " )" );
		        }
			}
			if(options.effectduration) {
				duration = parseInt(options.effectduration);
			}
	        $("#"+options.targets).effect(options.effect,effectOptions,duration);
		}
    });
	
	/** Publish UI topics */	
	function publishTopics($elem, always, topics) {

		if(topics)	{
			var onTopics = topics.split(',');
			return function(event, ui){
					var data = {};
					data.event = event;
					data.ui = ui;
				for ( var i = 0; i < onTopics.length; i++) {
					$elem.publish(onTopics[i], $elem, data);
				}

				if(always) {  
					var alwaysTopics = always.split(',');
					for ( var i = 0; i < alwaysTopics.length; i++) {
						$elem.publish(alwaysTopics[i], $elem, data);
					}
				}
			};
		}
		else { 
			return null;
		}
	}
	
	/** Publish Success topics */	
	function publishSuccessTopics(containerid, always, successtopics, indicatorId) {
		var container = $(containerid);
			return function (data, textStatus) {
			
			var orginal = {};
			orginal.status = textStatus;
			
			if(indicatorId) { $('#' + indicatorId).hide(); }
			
			container.html(data);
					
			if(successtopics) {			  
				var topics = successtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			if(always) {
				var topics = always.split(',');  
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
		};
	}

	/** Publish Complete topics */	
	function publishCompleteTopics(containerid, always, completetopics, targets, indicatorId, options) {
		var container = $(containerid);
		return function (request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			if(indicatorId) { $('#' + indicatorId).hide(); }
			
			if(completetopics) {			  
				var topics = completetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			if(always) {  
				var topics = always.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			
			var effectcontainer = targets;
			if(!effectcontainer)
				effectcontainer = options.id;
			if(effectcontainer) {
				var targetArray = effectcontainer.split(',');
				var divEffectTopic = '_struts2_jquery_div_effect_';
				for ( var i = 0; i < targetArray.length; i++) {
					$element = $('#'+targetArray[i]);
					$element.publish(divEffectTopic+targetArray[i], $element);
				}
			}
			
			if(options.resizable == 'true') {

		        var resizableOptionsStr = options.resizableoptions;
		        var resizableOptions = window[resizableOptionsStr];
		        if (!resizableOptions) {
		        	resizableOptions = eval ("( " + resizableOptionsStr + " )" );
		        }
		        container.resizable(resizableOptions);
			}
		};
	}

	/** Publish Error topics */	
	function publishErrorTopics(containerid, always, errortopics, errortext) {
		var container = $(containerid);
		if(errortopics || errortext)	{
			return function (request, status, error) {
				var orginal = {};
				orginal.request = request;
				orginal.status = status;
				orginal.error = error;

				if(errortext) { container.html(errortext); }
				
				if(errortopics || errortext)	{
					var onErrorTopics = errortopics.split(',');
					for ( var i = 0; i < onErrorTopics.length; i++) {
						container.publish(onErrorTopics[i], container, orginal);
					}
				}

				if(always) {  
					var topics = always.split(',');
					for ( var i = 0; i < topics.length; i++) {
						container.publish(topics[i], container, orginal);
					}
				}
			};
		}
		else { 
			return null;
		}
	}


})(jQuery);