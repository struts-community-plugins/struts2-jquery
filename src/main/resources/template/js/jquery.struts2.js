


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
		
			if(options.hidetopics) {			  
				var topics = options.hidetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_hide',options);
				}
			}

			if(options.showtopics) {			  
				var topics = options.showtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_show',options);
				}
			}

			if(options.removetopics) {			  
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
		
		container:  function($elem, options, loadHandlerName){

			if(options.reloadtopics) {			  
				var topics = options.reloadtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i], loadHandlerName, options);
				}
			}
		},
	
		input:  function($elem, options, loadHandlerName){
			
			if(!options) { return; }
			
			if(options.reloadtopics) {			  
				var topics = options.reloadtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i], loadHandlerName, options);
				}
			}
			
			if(options.focustopics) {			  
				var topics = options.focustopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_focus',options);
				}
			}	
			
			if(options.blurtopics) {			  
				var topics = options.blurtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.subscribe(topics[i],'_struts2_jquery_blur',options);
				}
			}	
			
			//bind change event to onChange topics
			if(options.onchangetopics) {  
				var topics = options.onchangetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.publishOnEvent('change',topics[i]);
				}
			}	
			
			//bind focus event to onFocus topics
			if(options.onfocustopics) {  
				var topics = options.onfocustopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.publishOnEvent('focus',topics[i]);
				}
			}	
			
			//bind blur event to onBlur topics
			if(options.onblurtopics) {  
				var topics = options.onblurtopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.publishOnEvent('blur',topics[i]);
				}
			}
		},
				
		
		action: function($elem, options, containerLoadHandlerName, linkLoadHandlerName, type){

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
			    			$('#' + target).subscribe(actionTopic, containerLoadHandlerName, options);
			    		}
					}
	    		});
	    		
			} else {   // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container
					
				//bind event topic listeners
		    	if(options.onbeforetopics || options.oncompletetopics || options.onsuccesstopics || options.onerrortopics) {
			    		$elem.subscribe(actionTopic, linkLoadHandlerName, options);
		    	}
			}

	    	if(type == "a") {
		    	options.src = href;
				$elem.publishOnEvent('click', actionTopic);			//bind custom action topic to click event
	    	}
			
		},
			
		select: function($elem, options){

			var loadHandlerName = '_struts2_jquery_select_load';
			
			this.base($elem, options);
			this.interactive($elem, options);
			//this.container($elem, options, loadHandlerName);  (reloadTopics already implemented by input)
			this.input($elem, options, loadHandlerName);

	    	//load select using ajax
			if(options.src) {

				//publishing not triggering to prevent event propagation issues
		    	var selectTopic = '_struts2_jquery_topic_load_' + options.id;
	    		$elem.subscribe(selectTopic, loadHandlerName);
	    		$elem.publish(selectTopic,options);
			}
		},
		
		div: function($elem, options){

			var linkLoadHandlerName = '_struts2_jquery_action_request';
			var containerLoadHandlerName = '_struts2_jquery_container_load';
			
			this.base($elem, options);
			this.container($elem, options, containerLoadHandlerName);
			this.action($elem, options, containerLoadHandlerName, linkLoadHandlerName, 'div');

	    	//load div using ajax
			if(options.src) {

				//publishing not triggering to prevent event propagation issues
		    	var divTopic = '_struts2_jquery_topic_load_' + options.id;
	    		$elem.subscribe(divTopic, containerLoadHandlerName);
	    		$elem.publish(divTopic,options);				
			}
			else {

				effects($elem.attr('id'), options);
				
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
		        var sortableOptions = window[sortableOptionsStr];
		        if (!sortableOptions) {
		        	sortableOptions = eval ("( " + sortableOptionsStr + " )" );
		        }
				$elem.sortable(sortableOptions);
			}

		},
		
		form: function($elem, options){

			var submitHandlerName = '_struts2_jquery_form_submit';
			var containerLoadHandlerName = '_struts2_jquery_container_load';
			
			this.base($elem, options);
	    	
			//bind submit event to onSubmit topics
			if(options.onsubmittopics) {  
				var topics = options.onsubmittopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					$elem.publishOnEvent('submit',topics[i]);
				}
			}	
			
			if(options.submittopics) {			  
				var topics = options.submittopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					
					var targetId = options.targetid;
					if(targetId) {
						options.src = options.action;
						options.formids = options.id;
						if('#tab' == targetId) {
							$elem.closest('.ui-tabs-panel').subscribe(topics[i], containerLoadHandlerName, options);
			    		} else {
			    			$('#' + targetId).subscribe(topics[i], containerLoadHandlerName, options);
			    		}
					} else {

						$elem.subscribe(topics[i], submitHandlerName, options);
					}	
				}

			}
		},
		
		a: function($elem, options){
			
			var linkLoadHandlerName = '_struts2_jquery_action_request';
			var containerLoadHandlerName = '_struts2_jquery_container_load';

			this.base($elem, options);
			this.interactive($elem, options);
			this.action($elem, options, containerLoadHandlerName, linkLoadHandlerName, 'a');
		},
		
		button: function($elem, options){
			var linkLoadHandlerName = '_struts2_jquery_action_request';
			var containerLoadHandlerName = '_struts2_jquery_container_load';
			
			this.base($elem, options);
			//	this.container($elem, options, containerLoadHandlerName);
			this.interactive($elem, options);
			if(options.formids) {
				this.formsubmit($elem, options);
			}
			else {
				this.action($elem, options, containerLoadHandlerName, linkLoadHandlerName, 'a');
			}
			//$elem.attr('type','button');  (not permitted by ie - covered by renderer)
			$elem.removeAttr('name');
		},
		formsubmit: function($elem, options){
			var submitHandlerName = '_struts2_jquery_form_submit';
	    	var formsubmitTopic = '_struts2_jquery_formsubmit_topic_' + options.id;
	    	if(options.targets) {  
	    		$elem.subscribe(formsubmitTopic, submitHandlerName, options);
			}
			$elem.publishOnEvent('click', formsubmitTopic);			//bind custom action topic to click event
		},
		
		dialog: function($elem, options){
			
//			if(options.hidetopics) {			  
//				var topics = options.hidetopics.split(',');
//				for ( var i = 0; i < topics.length; i++) {
//					$elem.subscribe(topics[i],'_struts2_jquery_dialog_close',options);
//				}
//			}
//
//			if(options.removetopics) {			  
//				var topics = options.removetopics.split(',');
//				for ( var i = 0; i < topics.length; i++) {
//					$elem.subscribe(topics[i],'_struts2_jquery_dialog_destroy',options);
//				}
//			}
//			
//			if(options.enabletopics) {			  
//				var topics = options.enabletopics.split(',');
//				for ( var i = 0; i < topics.length; i++) {
//					$elem.subscribe(topics[i],'_struts2_jquery_dialog_enable',options);
//				}
//			}
//
//			if(options.disabletopics) {			  
//				var topics = options.disabletopics.split(',');
//				for ( var i = 0; i < topics.length; i++) {
//					$elem.subscribe(topics[i],'_struts2_jquery_dialog_disable',options);
//				}
//			}
			
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
//			if(options.data) {  $elem.data = options.data; }	
			
			if(options.buttons) {
		        var buttonsStr = options.buttons;
		        var buttons = window[buttonsStr];
		        if (!buttons) {
		        	parameters.buttons = eval ("( " + buttonsStr + " )" );
		        }
			}
//			if(options.buttons) {
//				
//				parameters.buttons = {};
//				
//				var buttontopics;
//				if(options.buttontopics) {
//					buttontopics = options.buttontopics.split(',');
//				} else {
//					buttontopics = [];
//				}
//				
//				var $dialog = $elem;  //used for closure
//				$dialog.data('buttonTopics',{});  //used for closure
//								
//				var buttons = options.buttons.split(',');
//				for ( var i = 0; i < buttons.length; i++) {
//					var button = buttons[i];
//					var topic = buttontopics[i];
//					if(buttontopics.length >= i+1) {
//						$dialog.data('buttonTopics')[button] = topic;  
//						parameters.buttons[button] = function(event) { 
//							$elem.publish($dialog.data('buttonTopics')[event.target.innerHTML], $dialog) 
//						};
//					} else {
//						parameters.buttons[button] = function(event) {};
//					}
//				}
//			}
//
//			$elem.css("display", "none");
			parameters.open = function() {
				if(options.href) {
					
					var containerLoadHandlerName = '_struts2_jquery_container_load';
			    	var divTopic = '_struts2_jquery_topic_load_' + options.id;
		    		$elem.subscribe(divTopic, containerLoadHandlerName);
		    		$elem.publish(divTopic,options);				
	//				$elem.bind('dialogopen', function(event, ui) {
	
//						var loadHandlerName = '_struts2_jquery_container_load';
//						
//						//var $dialogContent = $(".ui-dialog-content",$elem)  //the dialog element has been moved within the dialog frame ($elem not points to contents)
//						$elem.unbind('struts2_jquery_topic_load');
//						$elem.bind('struts2_jquery_topic_load', null, _subscribe_handlers[loadHandlerName]);
//						$elem.trigger('struts2_jquery_topic_load', options);
						
						//$(".ui-dialog-content",$elem).load(options.src);
	//				});
				}			
				if(options.showtopics) {			  
					var topics = options.showtopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.subscribe(topics[i],'_struts2_jquery_dialog_open',options);
					}
				}
			}
//	        var userOptionsStr = options.options;
//	        var userOptions = window[userOptionsStr];
//	        if (!userOptions) {
//	        	userOptions = eval ("( " + userOptionsStr + " )" );
//	        }
//	        $.extend(options, userOptions);
	        
			//note: id is set on dialog contents
			$elem.dialog(parameters);
		},
		
		tabbedpane: function($elem, options){
			
	    	//instantiate the tabbed pane
			if(!options) { options = {}};
			options.cache = options.iscache || false;
			
	        var userOptionsStr = options.options;
	        var userOptions = window[userOptionsStr];
	        if (!userOptions) {
	        	userOptions = eval ("( " + userOptionsStr + " )" );
	        }
	        $.extend(options, userOptions);
	        
	        //fix for clash btwn ie & tabbedPane where ie automatically adds ALL possibel element properties as attributes
	        options.disabled = [];
	        
	    	var $tabs = $elem.tabs(options);
	    	
	    	$("a",$tabs).each( function(tabIndex, el){
	    			
	    		$tab = $(el);
	    		
	    		if($tab.attr("isdisabled") == 'true'){
					$tabs.tabs('disable', tabIndex);
	    		}
	    		
	    		if($tab.attr("isselected")){
					$tabs.tabs('select', tabIndex);
	    		}
	    		
	    		var hideTopics = $tab.attr("hidetopics");
				if(hideTopics) {			  
					var topics = hideTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_hideTab',tabIndex);
					}
				}

	    		var showTopics = $tab.attr("showtopics");
				if(showTopics) {			  
					var topics = showTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_showTab',tabIndex);
					}
				}

	    		var removeTopics = $tab.attr("removetopics");
				if(removeTopics) {			  
					var topics = removeTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_removeTab',tabIndex);
					}
				}

	    		var reloadTopics = $tab.attr("reloadtopics");
				if(reloadTopics) {			  
					var topics = reloadTopic.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_reloadTab',tabIndex);
					}
				}

	    		var focusTopics = $tab.attr("focustopics");
				if(focusTopics) {			  
					var topics = focusTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_selectTab',tabIndex);
					}
				}	

	    		var blurTopics = $tab.attr("blurtopics");
				if(options.blurtopics) {			  
					var topics = blurTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_blur',tabIndex);
					}
				}	

	    		var enableTopics = $tab.attr("enabletopics");
				if(enableTopics) {			  
					var topics = enableTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_enableTab',tabIndex);
					}
				}

	    		var disableTopics = $tab.attr("disabletopics");
				if(disableTopics) {			  
					var topics = disableTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.subscribe(topics[i],'_struts2_jquery_disableTab',tabIndex);
					}
				}

	    		var onChangeTopics = $tab.attr("onchangetopics");
				if(onChangeTopics) {  
					var topics = onChangeTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.publishOnEvent('change',topics[i]);
					}
				}	

	    		var onFocusTopics = $tab.attr("onfocustopics");
				if(onFocusTopics) {  
					var topics = onFocusTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.publishOnEvent('tabsshow',topics[i]);
					}
				}	

	    		var onBlurTopics = $tab.attr("onblurtopics");
				if(onBlurTopics) {  
					var topics = onBlurTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$tab.publishOnEvent('blur',topics[i]);
					}
				}
	    	});
		},
		
		textfield: function($elem, options){
			
			var loadHandlerName = '_struts2_jquery_textinput_load';
			
			this.base($elem, options);
			this.interactive($elem, options);
			this.input($elem, options, loadHandlerName);

	    	//load select using ajax
			if(options.src) {

				//publishing not triggering to prevent event propagation issues
		    	var textfieldTopic = '_struts2_jquery_topic_load_' + options.id;
	    		$elem.subscribe(textfieldTopic, loadHandlerName);
	    		$elem.publish(textfieldTopic,options);
			}				
		},
		
		textarea: function($elem, options){
			
			var loadHandlerName = '_struts2_jquery_textinput_load';
			
			this.base($elem, options);
			this.interactive($elem, options);
			this.input($elem, options, loadHandlerName);

	    	//load select using ajax
			if(options.src) {

				//publishing not triggering to prevent event propagation issues
		    	var textareaTopic = '_struts2_jquery_topic_load_' + options.id;
	    		$elem.subscribe(textareaTopic, loadHandlerName);
	    		$elem.publish(textareaTopic,options);
			}				
		},
		
		datepicker: function($elem, options) {
			
			var dpOptions = {};
//			dpOptions.altField = "#" + $elem.attr("id") + "_hidden";
//			dpOptions.altFormat = "yy-mm-dd'T'00:00:00";  			//set the alternate hidden submitted date format				
//			dpOptions.buttonImageOnly = true;						//show the button as an image
//			dpOptions.showOn = "focus";
			
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
							for ( var i = 0; i < onBeforeTopics.length; i++) {
								$input.publish(onBeforeTopics[i], $input);
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
							for ( var i = 0; i < onBeforeShowDayTopics.length; i++) {
								$elem.publish(onBeforeShowDayTopics[i], $date);
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
							for ( var i = 0; i < onChangeMonthYearTopics.length; i++) {
								$inst.publish(onChangeMonthYearTopics[i],$inst, data);
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
							for ( var i = 0; i < onChangeTopics.length; i++) {
								$inst.publish(onChangeTopics[i], $inst, data);
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
							for ( var i = 0; i < onCompleteTopics.length; i++) {
								$inst.publish(onCompleteTopics[i], $inst, data);
							}
						}
					};
				}
				
//				dpOptions.buttonImage = options.imageurl;
				
//				if(options.showbutton) {
//					dpOptions.showOn = "both";							//Have the datepicker appear automatically when the field receives focus and when the button is clicked		
//				} 
				
//				dpOptions.buttonText = options.imagetooltip;
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
//			        $.extend(dpOptions, userOptions);
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
				
				var onAlwaysTopics = options.onalwaystopics;
				
				if(options.onbeforetopics) {  
					var onBeforeTopics = options.onbeforetopics.split(',');
					parameter.start = function(event, ui){
						var $input = $(ui.handle);
						var data = {};
						data.event = event;
						data.ui = ui;
						for ( var i = 0; i < onBeforeTopics.length; i++) {
							$input.publish(onBeforeTopics[i], $input, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$input.publish(topics[i], $input, data);
							}
						}
					};
				}
				
				if(options.onchangetopics) {  
					var onChangeTopics = options.onchangetopics.split(',');
					parameter.start = function(event, ui){
							var $input = $(ui.handle);
							var data = {};
							data.event = event;
							data.ui = ui;
						for ( var i = 0; i < onChangeTopics.length; i++) {
							$input.publish(onChangeTopics[i], $input, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$input.publish(topics[i], $input, data);
							}
						}
					};
				}
				
				if(options.oncompletetopics) {  
					var onCompleteTopics = options.oncompletetopics.split(',');
					parameter.stop = function(event, ui){
						var $input = $(ui.handle);
						var data = {};
						data.event = event;
						data.ui = ui;
						for ( var i = 0; i < onCompleteTopics.length; i++) {
							$input.publish(onCompleteTopics[i], $input, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$input.publish(topics[i], $input, data);
							}
						}
					};
				}
				
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
				
				var onAlwaysTopics = options.onalwaystopics;
				
				if(options.onchangetopics) {  
					var onChangeTopics = options.onchangetopics.split(',');
					parameter.start = function(event, ui){
							var data = {};
							data.event = event;
							data.ui = ui;
						for ( var i = 0; i < onChangeTopics.length; i++) {
							$elem.publish(onChangeTopics[i], $elem, data);
						}

						if(onAlwaysTopics) {  
							var topics = onAlwaysTopics.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$elem.publish(topics[i], $elem, data);
							}
						}
					};
				}
				
				var value = parseInt(options.value);
				if(value > 0) parameter.value = value;
				else parameter.value = 0;
			}
			$elem.progressbar(parameter);
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
				    				
				var onSuccessTopics = options.onsuccesstopics;
				
				options.success = function (data, textStatus) {
									
					var orginal = {};
					orginal.status = textStatus;
					
					if(indicatorId) { $('#' + indicatorId).hide(); }
					
					container.html(data);
							
					if(onSuccessTopics) {			  
						var topics = onSuccessTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
					if(onAlwaysTopics) {
						var topics = onAlwaysTopics.split(',');  
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
				}
					
				var onCompleteTopics = options.oncompletetopics;
				options.complete = function (request, status) {
		
					var orginal = {};
					orginal.request = request;
					orginal.status = status;

					if(indicatorId) { $('#' + indicatorId).hide(); }
					
					if(onCompleteTopics) {			  
						var topics = onCompleteTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
					if(onAlwaysTopics) {  
						var topics = onAlwaysTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
					
					effects(container.attr('id'), options);
					
					if(options.resizable == 'true') {

				        var resizableOptionsStr = options.resizableoptions;
				        var resizableOptions = window[resizableOptionsStr];
				        if (!resizableOptions) {
				        	resizableOptions = eval ("( " + resizableOptionsStr + " )" );
				        }
						$elem.resizable(resizableOptions);
					}
					
				}
				
				var onErrorTopics = options.onerrortopics;
				options.error = function (request, status, error) {
					var orginal = {};
					orginal.request = request;
					orginal.status = status;
					orginal.error = error;
	
					if(options.errortext) { container.html(options.errortext); }
					
					if(onErrorTopics) {			
						var topics = onErrorTopics.split(',');  
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
					if(onAlwaysTopics) {  
						var topics = onAlwaysTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							container.publish(topics[i], container, orginal);
						}
					}
				}
				
				//serialize forms & elements
				var serializeData;
				
				var formIds = options.formids;
				if(formIds) {
							
					var forms = formIds.split(',');  
					for ( var i = 0; i < forms.length; i++) {
						serializeData = (serializeData ? (serializeData + "&") : "") + $("#" + forms[i]).serialize();
					}
				}    		
	
				var elementIds = options.elementids;
				if(elementIds) {
							
					var elements = elementIds.split(',');
					for ( var i = 0; i < elements.length; i++) {
						var element = $('#' + elements[i])[0];
						if(element && element.name){
							serializeData = (serializeData ? (serializeData + "&") : "") + element.name + "=" + element.value;
							//serializeData[element.name] = element.value;
						}
					}
				}    
				if(serializeData && options.validate) {
					serializeData['struts.enableJSONValidation'] = true;
				}
				
				$.extend(options,{data: serializeData});	
				
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

	
	/** Action logic */
	//Register handler to execute action with no target
	$.subscribeHandler('_struts2_jquery_action_request', function(event, data) {

		var action = $(event.target);
			
		var options = event.data;
		$.extend(options,data);

		var isDisabled = false;
		isDisabled = options.disabled == null ? isDisabled : options.disabled;
		isDisabled = action.attr('disabled') == null ? isDisabled : action.attr('disabled');
		if(event.originalEvent) {	//means that action is being triggered by other action (link button/link click) need to see if that button/link is disabled
			isDisabled = $(event.originalEvent.currentTarget).attr("disabled") == null ? isDisabled : $(event.originalEvent.currentTarget).attr("disabled");
		}
							
		if(isDisabled != true && isDisabled != 'true') {
			
			//Show indicator element (if any)
			if(options) {
					
				if(options.indicatorid) { $('#' + options.indicatorid).show(); }
					    				
				var indicatorId = options.indicatorid;
				var onSuccessTopics = options.onsuccesstopics;
				
				options.success = function (data, textStatus) {
									
					if(indicatorId) { $('#' + indicatorId).hide(); }
	
					if(options.errorelementid) { $("#" + options.errorelementid).hide(); }
					
					if(onSuccessTopics) {			  
						var topics = onSuccessTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							action.publish(topics[i], action);
						}
					}
				}
					
				var onCompleteTopics = options.oncompletetopics;
				options.complete = function (xhr, textStatus, errorThrown) {
		
					if(indicatorId) { $('#' + indicatorId).hide(); }
									
					if(onCompleteTopics) {			  
						var topics = onCompleteTopics.split(',');
						for ( var i = 0; i < topics.length; i++) {
							action.publish(topics[i], action);
						}
					}
				}
				
				var onErrorTopics = options.onerrortopics;
				options.error = function (XMLHttpRequest, textStatus, errorThrown) {
					
					if(options.errorelementid) {
					
						var errorElement = $("#" + options.errorelementid);
						
						if(errorElement) {
							
							var errors = options.errortext ? new Array(options.errortext) : new Array(xhr.statusText);
						
							if(errors[0]) {
								
								for(error in errors) {
								
									if(typeof errors[error] == "string") {
									
										errorElement.append($("<div/>").append(errors[error]));
									}
								}	
							}
							errorElement.show();
						}
					}
					
					if(onErrorTopics) {			
						var topics = onErrorTopics.split(',');  
						for ( var i = 0; i < topics.length; i++) {
							action.publish(topics[i], action);
						}
					}
				}
				
			    //serialize forms
				var formIds = options.formids;
				var serializeData;
				if(formIds) {
											
					var forms = formIds.split(',');  
					for ( var i = 0; i < forms.length; i++) {
						serializeData = (serializeData ? "&" : "") + $("#" + forms[i]).serialize();
					}
				}    
					
				var elementIds = options.elementids;
				if(elementIds) {
							
					var elements = elementIds.split(',');
					for ( var i = 0; i < elements.length; i++) {
						var element = $('#' + elements[i])[0];
						if(element && element.name){
							serializeData = (serializeData ? (serializeData + "&") : "") + element.name + "=" + element.value;
							//serializeData[element.name] = element.value;
						}
					}
				}     	    
				if(serializeData && options.validate) {
					serializeData['struts.enableJSONValidation'] = true;
				}
				
				$.extend(options,{data: serializeData});	
	
				
				//execute request using ajax
				if(options.src) {
					
					options.type = "POST";
					options.url = options.src;
					if(!options.data) { options.data = {}; }	//fix 'issue' wherein IIS will reject post without data
				
					$.ajax(options);
				
				}
			}
		}
	});
			
	/** Datepicker logic*/
	//Register handler to open a datepicker
	$.subscribeHandler('_struts2_jquery_datepicker_show', function(event, data) {
		
//		$(this).datepicker('show');
	});
	//Register handler to close a datepicker
	$.subscribeHandler('_struts2_jquery_datpicker_hide', function(event, data) {
		
		$(this).datepicker('hide');
	});
	//Register handler to remove/destroy a datepicker
	$.subscribeHandler('_struts2_jquery_datepicker_destroy', function(event, data) {
		
		$(this).datepicker('destroy');
	});
	//Register handler to enable a datepicker
	$.subscribeHandler('_struts2_jquery_datepicker_enable', function(event, data) {
		
		$(this).datepicker('enable');
	});
	//Register handler to disable a datepicker
	$.subscribeHandler('_struts2_jquery_datepicker_disable', function(event, data) {
		
		$(this).datepicker('disable');
	});
	
	
	/** Dialog logic*/
	//Register handler to open a dialog
	$.subscribeHandler('_struts2_jquery_dialog_open', function(event, data) {
		//TODO: handle disabled (don;t open dialod if disabled == true)s
//		$(this).dialog('open');
	});
	
	//Register handler to close a dialog
	$.subscribeHandler('_struts2_jquery_dialog_close', function(event, data) {
		
		$(this).dialog('close');
	});
	//Register handler to remove/destroy a dialog
	$.subscribeHandler('_struts2_jquery_dialog_destroy', function(event, data) {
		
		$(this).dialog('destroy');
	});
	//Register handler to enable a dialog
	$.subscribeHandler('_struts2_jquery_dialog_enable', function(event, data) {
		
		$(this).dialog('enable');
	});
	//Register handler to disable a dialog
	$.subscribeHandler('_struts2_jquery_dialog_disable', function(event, data) {
		
		$(this).dialog('disable');
	});
		
	
	/** Tabbed Pane logic */
	//Register handler to reload a tab
	$.subscribeHandler('_struts2_jquery_reloadTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('load', event.data);
	});
	//Register handler to select a tab
	$.subscribeHandler('_struts2_jquery_selectTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('select', event.data);
	});
	//Register handler to disable a tab
	$.subscribeHandler('_struts2_jquery_disableTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('disable', event.data);
	});
	//Register handler to enable a tab
	$.subscribeHandler('_struts2_jquery_enableTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('enable', event.data);
	});
	//Register handler to remove a tab
	$.subscribeHandler('_struts2_jquery_removeTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('remove', event.data);
	});
	//Register handler to show a tab
	$.subscribeHandler('_struts2_jquery_showTab',  function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('show', event.data);
	});
	//Register handler to hide a tab
	$.subscribeHandler('_struts2_jquery_hideTab', function(event, data) {
		$(this).closest("._struts2_jquery_class_tabbedpane").tabs('hide', event.data);
	});

	/** Select logic */	
	//Register handler to load an input element
	$.subscribeHandler('_struts2_jquery_select_load', function(event, data) {

		var input = $(event.target);
					
		//need to also make use of original attributes registered with the input (such as elementIds)
		var attributes = input[0].attributes;
		var options = {};
		for(var i = 0; i < attributes.length; i++) {
			options[attributes[i].name.toLowerCase()] = attributes[i].value;
		}
		$.extend(options,data);

		if(input.attr('disabled') != 'true' && options.disabled != 'true') {

			//Show indicator element (if any)
			var indicatorId = options.indicatorid;
			if(indicatorId) { $('#' + indicatorId).show(); }

	    	//Set pre-loading text (if any)
			if(options.loadingtext) { input.txt(options.loadingtext); }
				
			var onAlwaysTopics = options.onalwaystopics;
			
	    	//publish all 'before' and 'always' topics
			if(onAlwaysTopics) {  
				var topics = onAlwaysTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					input.publish(topics[i], input);
				}
			}
			
			if(options.onbeforetopics) {  
				var topics = options.onbeforetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					input.publish(topics[i], input);
				}
			}
			    				
			var onSuccessTopics = options.onsuccesstopics;
			options.success = function (data, textStatus) {
								
				if(indicatorId) { $('#' + indicatorId).hide(); }
				
				input[0].length = 0;
				                 
				if(typeof(data) == "object" || $.isArray(data)) {
					
					var i = -1;
					
					if(options.headerkey && options.headervalue) {
						var option = document.createElement("option");
						option.value = options.headerkey;
						option.text = options.headervalue;
						
						if(options.value == options.headervalue) {
							option.selected = true;
						}
						
						input[0].options[++i] = option;
					}
					
					if(options.emptyoption) {
						input[0].options[++i] = document.createElement("option");
					}
					
					for (var key in data) {
						
						var option = document.createElement("option");
						option.value = key;
						option.text = data[key];

						if(options.value == option.value) {
							option.selected = true;
						}
						
						input[0].options[++i] = option;
					}		
				}		        
		        
				if(onSuccessTopics) {			  
					var topics = onSuccessTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {
					var topics = onAlwaysTopics.split(',');  
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
				
			var onCompleteTopics = options.oncompletetopics;
			options.complete = function (xhr, textStatus, errorThrown) {
	
				if(indicatorId) { $('#' + indicatorId).hide(); }
								
				if(onCompleteTopics) {			  
					var topics = onCompleteTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {  
					var topics = onAlwaysTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
			
			var onErrorTopics = options.onerrortopics;
			options.error = function (XMLHttpRequest, textStatus, errorThrown) {

				if(options.errortext) { container.html(options.errortext); }
				
				if(onErrorTopics) {			
					var topics = onErrorTopics.split(',');  
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {  
					var topics = onAlwaysTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
			
		    //serialize forms & elements
			var serializeData;
			
			var formIds = options.formids;
			if(formIds) {
						
				var forms = formIds.split(',');  
				for ( var i = 0; i < forms.length; i++) {
					serializeData = (serializeData ? (serializeData + "&") : "") + $("#" + forms[i]).serialize();
				}
			}    		

			var elementIds = options.elementids;
			if(elementIds) {
						
				var elements = elementIds.split(',');
				for ( var i = 0; i < elements.length; i++) {
					var element = $('#' + elements[i])[0];
					if(element && element.name){
						serializeData = (serializeData ? (serializeData + "&") : "") + element.name + "=" + element.value;
						//serializeData[element.name] = element.value;
					}
				}
			}        
			if(serializeData && options.validate) {
				serializeData['struts.enableJSONValidation'] = true;
			}
			
			$.extend(options,{data: serializeData});			
			
	    	//load input using ajax
			if(options.src) {
				
				options.type = "GET";
				options.url = options.src;
				options.dataType = "json";
			
				$.ajax(options);
			
			}
		}
	});
	

	/** TextField logic */	
	//Register handler to load an input element
	$.subscribeHandler('_struts2_jquery_textinput_load', function(event, data) {

		var input = $(event.target);
		
		//need to also make use of original attributes registered with the input (such as elementIds)
		var attributes = input[0].attributes;
		var options = {};
		for(var i = 0; i < attributes.length; i++) {
			options[attributes[i].name.toLowerCase()] = attributes[i].value;
		}
		$.extend(options,data);

		if(input.attr('disabled') != 'true' && options.disabled != 'true') {

			//Show indicator element (if any)
			var indicatorId = options.indicatorid;
			if(indicatorId) { $('#' + indicatorId).show(); }

	    	//Set pre-loading text (if any)
			if(options.loadingtext) { input.txt(options.loadingtext); }
				
			var onAlwaysTopics = options.onalwaystopics;
			
	    	//publish all 'before' and 'always' topics
			if(onAlwaysTopics) {  
				var topics = onAlwaysTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					input.publish(topics[i], input);
				}
			}
			
			if(options.onbeforetopics) {  
				var topics = options.onbeforetopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					input.publish(topics[i], input);
				}
			}
			    				
			var onSuccessTopics = options.onsuccesstopics;
			options.success = function (data, textStatus) {
								
				if(indicatorId) { $('#' + indicatorId).hide(); }
								                 
				if(data) {
					
					$(input).val(data);
				}		        
		        
				if(onSuccessTopics) {			  
					var topics = onSuccessTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {
					var topics = onAlwaysTopics.split(',');  
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
				
			var onCompleteTopics = options.oncompletetopics;
			options.complete = function (xhr, textStatus, errorThrown) {
	
				if(indicatorId) { $('#' + indicatorId).hide(); }
								
				if(onCompleteTopics) {			  
					var topics = onCompleteTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {  
					var topics = onAlwaysTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
			
			var onErrorTopics = options.onerrortopics;
			options.error = function (XMLHttpRequest, textStatus, errorThrown) {

				if(options.errortext) { container.html(options.errortext); }
				
				if(onErrorTopics) {			
					var topics = onErrorTopics.split(',');  
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
				if(onAlwaysTopics) {  
					var topics = onAlwaysTopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						input.publish(topics[i], input);
					}
				}
			}
			
		    //serialize forms & elements
			var serializeData;
			
			var formIds = options.formids;
			if(formIds) {
						
				var forms = formIds.split(',');  
				for ( var i = 0; i < forms.length; i++) {
					serializeData = (serializeData ? (serializeData + "&") : "") + $("#" + forms[i]).serialize();
				}
			}    		

			var elementIds = options.elementids;
			if(elementIds) {
						
				var elements = elementIds.split(',');
				for ( var i = 0; i < elements.length; i++) {
					var element = $('#' + elements[i])[0];
					if(element && element.name){
						serializeData = (serializeData ? (serializeData + "&") : "") + element.name + "=" + element.value;
						//serializeData[element.name] = element.value;
					}
				}
			}        
			if(serializeData && options.validate) {
				serializeData['struts.enableJSONValidation'] = true;
			}
			
			$.extend(options,{data: serializeData});			
			
	    	//load input using ajax
			if(options.src) {
				
				options.type = "GET";
				options.url = options.src;
				options.dataType = "json";
			
				$.ajax(options);
			
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
   	
		    				
		var onSuccessTopics = options.onsuccesstopics;
		
		parameters.success = function (data, textStatus) {
							
			var orginal = {};
			orginal.status = textStatus;
			
			if(indicatorId) { $('#' + indicatorId).hide(); }
			
			container.html(data);
					
			if(onSuccessTopics) {			  
				var topics = onSuccessTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			if(onAlwaysTopics) {
				var topics = onAlwaysTopics.split(',');  
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
		}
			
		var onCompleteTopics = options.oncompletetopics;
		parameters.complete = function (request, status) {

			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			if(indicatorId) { $('#' + indicatorId).hide(); }
			
			if(onCompleteTopics) {			  
				var topics = onCompleteTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			if(onAlwaysTopics) {  
				var topics = onAlwaysTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			
			if(options.targets) {
				var targets = options.targets.split(',');
					for ( var i = 0; i < targets.length; i++) {
						effects(targets[i], options);
					}
				}
		}
		
		var onErrorTopics = options.onerrortopics;
		parameters.error = function (request, status, error) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;
			orginal.error = error;

			if(options.errortext) { container.html(options.errortext); }
			
			if(onErrorTopics) {			
				var topics = onErrorTopics.split(',');  
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
			if(onAlwaysTopics) {  
				var topics = onAlwaysTopics.split(',');
				for ( var i = 0; i < topics.length; i++) {
					container.publish(topics[i], container, orginal);
				}
			}
		}
		
       $('#'+options.formids).ajaxSubmit(parameters);
        
        return false;
	});
	
	/** Effects */	
	function effects (id, options) {
		
		if(options.effect) {
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
	        $("#"+id).effect(options.effect,effectOptions,duration);
		}
	}
	
})(jQuery);