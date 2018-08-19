/**
 * @preserve
 * jquery.handlebars.struts2.js
 *
 * Integration of HandleBarsJS with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2010 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window,  */
"use strict";
(function ($) {

	/**
	 * Handle handlebars JS Template engine
	 */
	$.struts2_jquery_handlebars = {
			
        handler : {
           
        },

		// Handle handlebars JS Template engine
		handlebars : function ( o ) {
			var self = this;			
			self.require("js/handlebars/handlebars.runtime" + self.minSuffix + ".js");
			if (!o.url){
				self.compileTemplate($(self.escId(o.id)).html(),o.name);
			}
			else if(o.type === 'precompiled'){
				self.require(o.url);
			}
			else if (o.type === 'template'){
				self.log('loading remote handlebars template ' + (o.url));
				$.ajax( {
					type :"GET",
					scriptCharset:"UTF-8",
					url :o.url,
					success :function(data){
						$.struts2_jquery_handlebars.compileTemplate(data,o.name);
					},
					dataType :"text",				
					cache :true,
					async :false
				});
			}
			$.each(o.targets.split(','), function(idx, target){
				$.each(o.listenTopics.split(','),function(idx,topic){
					var eltId = $.struts2_jquery_handlebars.escId(target);
					//If an element has previously subscribed to this topic, unsubscribe to avoid multiple
					//topic subscription in one page style apps ...
					if ($(eltId).isSubscribed(topic)){
						$(eltId).unsubscribe(topic);
					}					
					$(eltId).subscribe(topic,function(event,data){						
						if (!event.originalEvent.templateResult){
							event.originalEvent.templateResult = self.runTemplate(o.name,event.originalEvent.data);
						}
						$(this).html(event.originalEvent.templateResult);
					});
				});	
			});
        },
        compileTemplate : function(source,name){
        	//only runtime could have been loaded before so save compiled templates
        	var saved_templates = null;
        	if (Handlebars && Handlebars.templates){
        		saved_templates = jQuery.extend(true, {}, Handlebars.templates);
        	}       	
        	$.struts2_jquery_handlebars.require("js/handlebars/handlebars" + $.struts2_jquery_handlebars.minSuffix + ".js", function(){
        		if (saved_templates){ 
        			//restore saved templates
        			Handlebars.templates = saved_templates;
        		}
        	});
        	$.struts2_jquery_handlebars.log('compiling handlebars template ' + name);
        	if (!Handlebars.templates){
        		
        		Handlebars.templates = {};
        	}
        	Handlebars.templates[name] = Handlebars.compile(source);
        	
        },
        runTemplate : function(name,data){
        	$.struts2_jquery_handlebars.log('running handlebars template ' + name );
        	return Handlebars.templates[name](data);      	
        }             
	};
		
	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_handlebars, $.struts2_jquery);
	$.struts2_jquery_handlebars.debugPrefix = "[struts2_jquery_handlebars] ";

})(jQuery);
