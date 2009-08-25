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
					
					var widget = $el.attr("jqueryaction");
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
			
		container: function($elem, options){

			var containerLoadHandlerName = '_struts2_jquery_container_load';
			var effectHandlerName = '_struts2_jquery_effects';
			

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
				
				var divEffectTopic = '_struts2_jquery_div_effect_' + options.id;
				if(options.id && options.effect) {
					var effect = {};
					effect.targets = options.id;
					effect.effect = options.effect;
					effect.effectoptions = options.effectoptions;
					effect.effectduration = options.effectduration;
		    		$elem.subscribe(divEffectTopic, effectHandlerName, effect);
				}


				if(options.events || options.bindon) {

					var $bindElement = $elem;
					var eventsStr = 'click';
					if(options.bindon)
						$bindElement = $('#'+options.bindon);
					if(options.events) { eventsStr = options.events; }

					var events = eventsStr.split(',');
					for ( var i = 0; i < events.length; i++) {
						var event = events[i];
						if(options.onbeforetopics) {
							var btopics = options.onbeforetopics.split(',');
							for ( var i = 0; i < btopics.length; i++) {
								$bindElement.publishOnEvent(event, btopics[i]);
							}
						}
						$bindElement.publishOnEvent(event, divEffectTopic);
						if(options.oncompletetopics) {
							var ctopics = options.oncompletetopics.split(',');
							for ( var i = 0; i < ctopics.length; i++) {
								$bindElement.publishOnEvent(event, ctopics[i]);
							}
						}
					}
				}
				else {
					if(options.onbeforetopics) {
						var btopics = options.onbeforetopics.split(',');
						for ( var i = 0; i < btopics.length; i++) {
							$bindElement.publish(btopics[i], $elem);
						}
					}
					$elem.publish(divEffectTopic, $elem);	
					if(options.oncompletetopics) {
						var ctopics = options.oncompletetopics.split(',');
						for ( var i = 0; i < ctopics.length; i++) {
							$bindElement.publish(ctopics[i], $elem);
						}
					}
				}
				
				if(options.resizable == 'true') {

			        var ros = options.resizableoptions;
			        var ro = window[ros];
			        if (!ro) {
			        	ro = eval ("( " + ros + " )" );
			        }
			        else {
			        	ro = {};
			        }
			        ro.start = publishTopics($elem, options.onalwaystopics, options.resizableonstarttopics);
			        ro.stop = publishTopics($elem, options.onalwaystopics, options.resizableonstoptopics);
			        ro.resize = publishTopics($elem, options.onalwaystopics, options.resizableonresizetopics);
					$elem.resizable(ro);
				}
			}

			if(options.draggable == 'true') {
				
		        var daos = options.draggableoptions;
		        var dao = window[daos];
		        if (!dao) {
		        	dao = eval ("( " + daos + " )" );
		        }
		        else {
		        	dao = {};
		        }
		        dao.start = publishTopics($elem, options.onalwaystopics, options.draggableonstarttopics);
		        dao.stop = publishTopics($elem, options.onalwaystopics, options.draggableonstoptopics);
		        dao.drap = publishTopics($elem, options.onalwaystopics, options.draggableondragtopics);
				$elem.draggable(dao);
			}
			
			if(options.droppable == 'true') {

		        var doos = options.droppableoptions;
		        var doo = window[doos];
		        if (!doo) {
		        	doo = eval ("( " + doos + " )" );
		        }
		        else {
		        	doo = {};
		        }
		        doo.activate = publishTopics($elem, options.onalwaystopics, options.droppableonactivatetopics);
		        doo.deactivate = publishTopics($elem, options.onalwaystopics, options.droppableondeactivatetopics);
		        doo.start = publishTopics($elem, options.onalwaystopics, options.droppableonstarttopics);
		        doo.stop = publishTopics($elem, options.onalwaystopics, options.droppableonstoptopics);
		        doo.drop = publishTopics($elem, options.onalwaystopics, options.droppableondroptopics);
				$elem.droppable(doo);
			}
			
			if(options.selectable == 'true') {

		        var seos = options.selectableoptions;
		        var seo = window[seos];
		        if (!seo) {
		        	seo = eval ("( " + seos + " )" );
		        }
		        else {
		        	seo = {};
		        }
		        seo.selected = publishTopics($elem, options.onalwaystopics, options.selectableonselectedtopics);
		        seo.selecting = publishTopics($elem, options.onalwaystopics, options.selectableonselectingtopics);
		        seo.start = publishTopics($elem, options.onalwaystopics, options.selectableonstarttopics);
		        seo.stop = publishTopics($elem, options.onalwaystopics, options.selectableonstoptopics);
		        seo.unselected = publishTopics($elem, options.onalwaystopics, options.selectableonunselectedtopics);
		        seo.unselecting = publishTopics($elem, options.onalwaystopics, options.selectableonunselectingTtopics);
				$elem.selectable(seo);
			}

			if(options.sortable == 'true') {

		        var soos = options.sortableoptions;
		        var soo = window[soos];
		        if (!soo) {
		        	soo = eval ("( " + soos + " )" );
		        }
		        else {
		        	soo = {};
		        }
		        soo.beforeStop = publishTopics($elem, options.onalwaystopics, options.sortableonbeforestoptopics);
		        soo.stop = publishTopics($elem, options.onalwaystopics, options.sortableonstoptopics);
		        soo.start = publishTopics($elem, options.onalwaystopics, options.sortableonstarttopics);
		        soo.sort = publishTopics($elem, options.onalwaystopics, options.sortableonsorttopics);
		        soo.activate = publishTopics($elem, options.onalwaystopics, options.sortableonactivatetopics);
		        soo.deactivate = publishTopics($elem, options.onalwaystopics, options.sortableondeactivatetopics);
		        soo.over = publishTopics($elem, options.onalwaystopics, options.sortableonovertopics);
		        soo.out = publishTopics($elem, options.onalwaystopics, options.sortableonouttopics);
		        soo.remove = publishTopics($elem, options.onalwaystopics, options.sortableonremovetopics);
		        soo.receive = publishTopics($elem, options.onalwaystopics, options.sortableonreceivetopics);
		        soo.change = publishTopics($elem, options.onalwaystopics, options.sortableonchangetopics);
		        soo.update = publishTopics($elem, options.onalwaystopics, options.sortableonupdatetopics);
				$elem.sortable(soo);
			}

		},
		
		anchor: function($elem, options){
			
			var containerLoadHandlerName = '_struts2_jquery_container_load';

			if(options.formids) {
				this.formsubmit($elem, options);
			}
			else {
				this.action($elem, options, containerLoadHandlerName, 'a');
			}
		},
		
		button: function($elem, options){
			var containerLoadHandlerName = '_struts2_jquery_container_load';
			
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
			
			var params = {};
			params.autoOpen = eval(options.autoopen ? options.autoopen : false);
			params.modal = eval(options.modal ? options.modal : false);
			params.resizable = eval(options.resizable ? options.resizable : true);
			params.draggable = eval(options.draggable ? options.draggable : true);
			if(options.height) { params.height = eval(options.height); }
			if(options.width) { params.width = eval(options.width); }
			if(options.position) { params.position = eval(options.position); }
			if(options.zindex) { params.zIndex = parseInt(options.zindex); }
			if(options.backgroundcolor) { params.backgroundColor = options.backgroundcolor; }
			if(options.hide) { params.hide = options.hide; }
			if(options.show) { params.show = options.show; }
			
			if(options.title) { params.title = options.title; }
			
			if(options.buttons) {
		        var buttonsStr = options.buttons;
		        var buttons = window[buttonsStr];
		        if (!buttons) {
		        	params.buttons = eval ("( " + buttonsStr + " )" );
		        }
			}
			params.open = function(event, ui) {
				var data = {};
				data.event = event;
				data.ui = ui;

				if(options.href) {
					
					var containerLoadHandlerName = '_struts2_jquery_container_load';
			    	var divTopic = '_struts2_jquery_topic_load_' + options.id;
		    		$elem.subscribe(divTopic, containerLoadHandlerName);
		    		$elem.publish(divTopic,options);				
				}			
				if(options.onalwaystopics) {			  
					var topics = options.onalwaystopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.publish(topics[i], $elem, data);
					}
				}
				if(options.onbeforetopics) {			  
					var topics = options.onbeforetopics.split(',');
					for ( var i = 0; i < topics.length; i++) {
						$elem.publish(topics[i], $elem, data);
					}
				}
			};
			params.close = publishTopics($elem, options.onalwaystopics, options.oncompletetopics);
			params.drag = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
			$elem.dialog(params);
		},
		
		tabbedpanel: function($elem, options){
			
	    	//instantiate the tabbed pane
			if(!options) { options = {}};
			var params = {};
			
			if(options.disabled) {
		        var disabledStr = options.disabled;
		        var disabled = window[disabledStr];
		        if (!disabled) {
		        	params.disabled = eval ("( " + disabledStr + " )" );
		        }
			}
			if(options.cache && options.cache == 'true')	params.cache = true;
			if(options.animate && options.animate == 'true')	params.fx = { opacity: 'toggle' };
			if(options.cookie && options.cookie == 'true')	params.cookie = { expires: 30 };
			if(options.collapsible && options.collapsible == 'true')	params.collapsible = true;
			if(options.openonmouseover && options.openonmouseover == 'true')	params.event = 'mouseover';
			if(options.orientation)	params.orientation = options.orientation;
			if(options.spinner)	params.spinner = options.spinner;
			if(options.selectedtab)	params.selected = parseInt(options.selectedtab);
			params.ajaxOptions = { dataType:'html' };
			params.ajaxOptions.complete = publishCompleteTopics(options.id, options.onalwaystopics, options.oncompletetopics, null, null, {});
			params.show = publishTopics($elem, options.onalwaystopics, options.onbeforetopics);
			params.select = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
			params.enable = publishTopics($elem, options.onalwaystopics, options.onenabletopics);
			params.disable = publishTopics($elem, options.onalwaystopics, options.ondisabletopics);
			params.add = publishTopics($elem, options.onalwaystopics, options.onaddtopics);
			params.remove = publishTopics($elem, options.onalwaystopics, options.onremovetopics);
			
			$elem.find('ul div').appendTo($elem);
	    	$elem.tabs(params);
		},
		
		datepicker: function($elem, options) {
			
			var params = {};
			
			if(options) {
				
				var oat = options.onalwaystopics;
				
				if(options.onbeforetopics) {  
					var obt = options.onbeforetopics.split(',');
					params.beforeShow = function(input){
						var $input = $(input);
						for ( var i = 0; i < obt.length; i++) {
							$input.publish(obt[i], $input);
						}

						if(oat) {  
							var topics = oat.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$input.publish(topics[i], $input);
							}
						}
					};
				}
				
				if(options.onbeforeshowdaytopics) {  
					var obsdt = options.onbeforeshowdaytopics.split(',');
					params.beforeShowDay = function(date){
						var $date = $(date);
						for ( var i = 0; i < obsdt.length; i++) {
							$elem.publish(obsdt[i], $date);
						}

						if(oat) {  
							var topics = oat.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$elem.publish(topics[i], $date);
							}
						}
					};
				}

				if(options.onchangemonthyeartopics) {  
					var ocmyt = options.onchangemonthyeartopics.split(',');
					params.onChangeMonthYear = function(year, month, inst){
						var data = {};
						data.year = year;
						data.month = month;
						data.inst = inst;
						var $inst = $(inst);
						for ( var i = 0; i < ocmyt.length; i++) {
							$inst.publish(ocmyt[i],$inst, data);
						}

						if(oat) {  
							var topics = oat.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i],$inst, data);
							}
						}
					};
				}

				if(options.onchangetopics) {  
					var ocat = options.onchangetopics.split(',');
					params.onSelect = function(dateText, inst){
						var $inst = $(inst);
						var data = {};
						data.dateText = dateText;
						for ( var i = 0; i < ocat.length; i++) {
							$inst.publish(ocat[i], $inst, data);
						}

						if(oat) {  
							var topics = oat.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i], $inst, data);
							}
						}
					};
				}
				
				if(options.oncompletetopics) {  
					var ocot = options.oncompletetopics.split(',');
					params.onClose = function(dateText, inst){
						var $inst = $(inst);
						var data = {};
						data.dateText = dateText;
						for ( var i = 0; i < ocot.length; i++) {
							$inst.publish(ocot[i], $inst, data);
						}

						if(oat) {  
							var topics = oat.split(',');
							for ( var i = 0; i < topics.length; i++) {
								$inst.publish(topics[i], $inst, data);
							}
						}
					};
				}
				
				if(options.changemonth && options.changemonth == 'true')	params.changeMonth = true;
				if(options.changeyear && options.changeyear == 'true')	params.changeYear = true;
				if(options.showbuttonpanel && options.showbuttonpanel == 'true')	params.showButtonPanel = true;
				params.dateFormat = options.displayformat;
				params.buttonImageOnly = options.buttonimageonly;
				params.buttonImage = options.buttonimage;
				params.showOn = options.showon;
				params.buttonText = options.buttontext;
				params.showAnim = options.showanim;
				params.firstDay = options.firstday;
				params.yearRange = options.yearrange;
		        
				if(options.numberofmonths) {
			        var numberofmonthsStr = options.numberofmonths;
			        var numberofmonths = window[numberofmonthsStr];
			        if (!numberofmonths) {
			        	params.numberOfMonths = eval ("( " + numberofmonthsStr + " )" );
			        }
				}
				
				if(options.showoptions) {
			        var userOptionsStr = options.showoptions;
			        var userOptions = window[userOptionsStr];
			        if (!userOptions) {
			        	params.showOptions = eval ("( " + userOptionsStr + " )" );
			        }
				}
			}
			
			$elem.datepicker(params);
			
		    if(options.year && options.month && options.day) {
		    	$elem.val($.datepicker.formatDate(options.displayformat, new Date(options.year, options.month, options.day)));
		    }
		    if(options.zindex) {
		    	$('#ui-datepicker-div').css("z-index", options.zindex); 
		    }
		    
			if(options.disabled == 'true') {

				$elem.attr("disabled","disabled");
				$elem.addClass("disabled");
			}
		},
		slider: function($elem, options) {
			
			var params = {};
			if(options) {
				
				params.start = publishTopics($elem, options.onalwaystopics, options.onbeforetopics);
				params.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
				params.stop = publishTopics($elem, options.onalwaystopics, options.oncompletetopics);
				
				params.slide = function(event, ui){
					 $('#'+options.hiddenid).val(ui.value);
					 if (options.displayvalueelement) {
					 	$('#'+options.displayvalueelement).html(ui.value);
					 }
				};
				
				if(options.animate && options.animate == 'true')	params.animate = true;
				var value = parseInt(options.value);
				if(value > 0) params.value = value;
				else params.value = 0;
				if(options.max)	params.max = parseInt(options.max);
				if(options.min)	params.min = parseInt(options.min);
				if(options.orientation)	params.orientation = options.orientation;
				if(options.step) params.step = parseInt(options.step);

				if(options.range) {
					if(options.range == 'true')	{
						params.range = true;
					}
					else {
						params.range = options.range;
					}
				}
			}
			
			$elem.slider(params);
		},
		progressbar: function($elem, options) {
			
			var params = {};
			if(options) {
				
				params.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
				
				var value = parseInt(options.value);
				if(value > 0) params.value = value;
				else params.value = 0;
			}
			$elem.progressbar(params);
		},
		accordion: function($elem, options) {
			
			var params = {};
			if(options) {

				if(options.fillspace && options.fillspace == 'true')	params.fillSpace = true;
				if(options.collapsible && options.collapsible == 'true')	params.collapsible = true;
				if(options.clearstyle && options.clearstyle == 'true')	params.clearStyle = true;
				if(options.autoheight && options.autoheight == 'true')	params.autoHeight = true;
				if(options.fillspace && options.fillspace == 'true')	params.fillSpace = true;
				if(options.event)	params.event = options.event;
				if(options.header)	params.header = options.header;
				else				params.header = 'h3';
				if(options.animated)
				{
					if(options.animated == 'true') params.animated = true;
					else if(options.animated == 'false') params.animated = false;
					else params.animated = options.animated;
				}
				
				active = true;
				if(options.active)
				{
					if(options.active == 'true') { params.active = true; }
					else if(options.active == 'false') { params.active = false; active = false; }
					else { params.active = parseInt(options.active); }
				}
				
				var onAlwaysTopics = options.onalwaystopics;
				params.changestart = function(event, ui) {
					if(options.href)
					{
						if ( typeof $(ui.newHeader).find('a').attr('paramkeys') != "undefined" )
						{
						    var keys = $(ui.newHeader).find('a').attr('paramkeys').split(',');
						    var values = $(ui.newHeader).find('a').attr('paramvalues').split(',');
							var valueparams = {};
							jQuery.each(keys, function(i, val) {
								valueparams[val] = values[i];
			    			});
							ui.newContent.load(options.href,valueparams,function() {});
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
				
				params.change = publishTopics($elem, options.onalwaystopics, options.onchangetopics);
			}
			$elem.accordion(params);
			if(options.href && active == true)
			{
				var aktiv = $("#"+options.id+" li "+params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
				if ( typeof $(aktiv).attr('paramkeys') != "undefined" )
				{
					var keys = $(aktiv).attr('paramkeys').split(',');
					var values = $(aktiv).attr('paramvalues').split(',');
					var valueparams = {};
					jQuery.each(keys, function(i, val) {
						valueparams[val] = values[i];
			    	});
					$("#"+options.id+" li div").filter('.ui-accordion-content-active').load(options.href,valueparams,function() {});
				}
			}
		}
	};		
		
	Struts2jQuery = _struts2_jquery;
	
	
	/**
	 * STRUTS2 JQUERY BUILT-IN ELEMENT HANDLERS 
	 */
		
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
				
				var setvalue = false;
				if(options.type && options.type == 'text')
					setvalue = true;
				
				options.success = publishSuccessTopics(event.target, onAlwaysTopics, options.onsuccesstopics, indicatorId, true, setvalue);
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
		
		var params = {};
		if(options.clearform && options.clearform == 'true')	params.clearForm = true;
		if(options.iframe && options.iframe == 'true')	params.iframe = true;
		if(options.resetform && options.resetform == 'true')	params.resetForm = true;
		if(options.timeout)	params.timeout = parseInt(options.timeout);
		if(options.datatype)	params.dataType = options.datatype;
		
		params.target = '';
		if(options.targets) {
		var targets = options.targets.split(',');
			for ( var i = 0; i < targets.length; i++) {
				var target = targets[i];
				if(params.target == '') {
					params.target = '#' + target;
	    		} else {
	    			params.target = params.target +',#' + target;
	    		}
				
		    	//Set pre-loading text (if any)
				if(options.loadingtext) { $('#' + target).html(options.loadingtext); }
			}
		}
		
		if(options.indicatorid) { $('#' + options.indicatorid).show(); }

		params.beforeSubmit = function (formData, form, formoptions) {
			
			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;

			if(options.onalwaystopics) {  
				var topics = options.onalwaystopics.split(',');
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
   	
	    				
		params.success = publishSuccessTopics(event.target, options.onalwaystopics, options.onsuccesstopics, options.indicatorid, false, false);
		params.complete = publishCompleteTopics(event.target, options.onalwaystopics, options.oncompletetopics, options.targets, options.indicatorid, options);
		params.error = publishErrorTopics(event.target, options.onalwaystopics, options.onerrortopics, options.errortext);
		
		var forms = options.formids.split(',');
		for ( var i = 0; i < forms.length; i++) {
	       $('#'+forms).ajaxSubmit(params);
		}
        
        return false;
	});
	
	/** Effects */	
    //Register handler for effects
    $.subscribeHandler('_struts2_jquery_effects', function(event, data) {
		var options = {};
		$.extend(options,event.data);
		if(options.targets || options.effect) {
			var eo = {};
			var duration = 2000;
			if(options.effectoptions) {
		        var eos = options.effectoptions;
		        eo = window[eos];
		        if (!eo) {
		        	eo = eval ("( " + eos + " )" );
		        }
			}
			if(options.effectduration) {
				duration = parseInt(options.effectduration);
			}
	        $("#"+options.targets).effect(options.effect,eo,duration);
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
	function publishSuccessTopics(cid, always, stopics, indi, sethtml, setvalue) {
		var container = $(cid);
			return function (data, textStatus) {
			
			var orginal = {};
			orginal.status = textStatus;
			
			if(indi) { $('#' + indi).hide(); }
			
			if(sethtml == true)
				container.html(data);
			if(setvalue == true)
				container.val(data);
					
			if(stopics) {			  
				var topics = stopics.split(',');
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
	function publishCompleteTopics(cid, always, ctopics, targets, indi, options) {
		var container = $(cid);
		return function (request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			if(indi) { $('#' + indi).hide(); }
			
			if(ctopics) {			  
				var topics = ctopics.split(',');
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
			
			var ec = targets;
			if(!ec)
				ec = options.id;
			if(ec) {
				var targetArray = ec.split(',');
				var divEffectTopic = '_struts2_jquery_div_effect_';
				for ( var i = 0; i < targetArray.length; i++) {
					$element = $('#'+targetArray[i]);
					$element.publish(divEffectTopic+targetArray[i], $element);
				}
			}
			
			if(options.resizable == 'true') {

		        var ros = options.resizableoptions;
		        var ro = window[ros];
		        if (!ro) {
		        	ro = eval ("( " + ros + " )" );
		        }
		        else {
		        	ro = {};
		        }
		        ro.start = publishTopics(container, options.onalwaystopics, options.resizableonstarttopics);
		        ro.stop = publishTopics(container, options.onalwaystopics, options.resizableonstoptopics);
		        ro.resize = publishTopics(container, options.onalwaystopics, options.resizableonresizetopics);
		        container.resizable(ro);
			}
		};
	}

	/** Publish Error topics */	
	function publishErrorTopics(cid, always, etopics, etext) {
		var container = $(cid);
		if(etopics || etext)	{
			return function (request, status, error) {
				var orginal = {};
				orginal.request = request;
				orginal.status = status;
				orginal.error = error;

				if(etext) { container.html(etext); }
				
				if(etopics || errortext)	{
					var topics = etopics.split(',');
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
		else { 
			return null;
		}
	}
})(jQuery);