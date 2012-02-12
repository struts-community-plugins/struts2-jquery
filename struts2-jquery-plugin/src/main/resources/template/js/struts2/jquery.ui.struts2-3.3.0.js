/*!
 * jquery.ui.struts2.js
 *
 * Integration of jquery and jquery ui with struts 2
 * for ajax, widget and interactions support in struts 2
 *
 * Requires use of jQuery and jQuery UI.
 * Tested with jQuery 1.7 and jQuery UI 1.8
 *
 * Copyright (c) 2012 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, document, window, StrutsUtils  */
/*jslint evil: true */

( function($) {

	/**
	 * Bind Struts2 Components for jQuery UI functions
	 */
	$.struts2_jquery_ui = {

	debugPrefix :'[struts2_jquery_ui] ',
	handler : {
		open_dialog :'_s2j_open_dialog',
		close_dialog :'_s2j_close_dialog',
		destroy_dialog :'_s2j_destroy_dialog'
	},

	/** opens a dialog if attribute openDialog in Anchor or Submit Tag is set to true */
	opendialog : function($elem, o) {
		var self = this;
		self.log('open dialog : ' + o.opendialog);

		if (o.opendialog) {
			var dialog = $(self.escId(o.opendialog));
			$elem.bind('click', function(event) {
				if ($(this).prop("disabled")) {
					return false;
				}
				var openTopic = '_s2j_dialog_open_' + o.id;
				self.subscribeTopics(dialog, openTopic, self.handler.open_dialog, o);
				dialog.publish(openTopic, o);
				return false;
			});
		}
	},
	
	/** handle interaction draggable */
	draggable : function($elem, o) {
		var self = this;
		self.log('draggable : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js" ]);
		}
		var daos = o.draggableoptions;
		var dao = window[daos];
		if (!dao) {
			dao = eval("( " + daos + " )");
		}
		else {
			dao = {};
		}
		dao.start = self.pubTops($elem, o.onalw, o.draggableonstarttopics);
		dao.stop = self.pubTops($elem, o.onalw, o.draggableonstoptopics);
		dao.drap = self.pubTops($elem, o.onalw, o.draggableondragtopics);
		$elem.draggable(dao);
	},
	
	/** handle interaction droppable */
	droppable : function($elem, o) {
		var self = this;
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.ui.droppable" + self.minSuffix + ".js" ]);
		}
		var doos = o.droppableoptions;
		var doo = window[doos];
		if (!doo) {
			doo = eval("( " + doos + " )");
		}
		else {
			doo = {};
		}
		doo.activate = self.pubTops($elem, o.onalw, o.droppableonactivatetopics);
		doo.deactivate = self.pubTops($elem, o.onalw, o.droppableondeactivatetopics);
		doo.start = self.pubTops($elem, o.onalw, o.droppableonstarttopics);
		doo.stop = self.pubTops($elem, o.onalw, o.droppableonstoptopics);
		doo.drop = self.pubTops($elem, o.onalw, o.droppableondroptopics);
		doo.over = self.pubTops($elem, o.onalw, o.droppableonovertopics);
		doo.out = self.pubTops($elem, o.onalw, o.droppableonouttopics);
		$elem.droppable(doo);
	},
	
	/** handle interaction selectable */
	selectable : function($elem, o) {
		var self = this;
		self.log('selectable : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.selectable" + self.minSuffix + ".js" ]);
		}
		var seos = o.selectableoptions;
		var seo = window[seos];
		if (!seo) {
			seo = eval("( " + seos + " )");
		}
		else {
			seo = {};
		}
		seo.selected = self.pubTops($elem, o.onalw, o.selectableonselectedtopics);
		seo.selecting = self.pubTops($elem, o.onalw, o.selectableonselectingtopics);
		seo.start = self.pubTops($elem, o.onalw, o.selectableonstarttopics);
		seo.stop = self.pubTops($elem, o.onalw, o.selectableonstoptopics);
		seo.unselected = self.pubTops($elem, o.onalw, o.selectableonunselectedtopics);
		seo.unselecting = self.pubTops($elem, o.onalw, o.selectableonunselectingtopics);
		$elem.selectable(seo);
	},
	
	/** handle interaction sortable */
	sortable : function($elem, o) {
		var self = this;
		self.log('sortable : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
		}
		var soos = o.sortableoptions;
		var soo = window[soos];
		if (!soo) {
			soo = eval("( " + soos + " )");
		}
		else {
			soo = {};
		}
		soo.beforeStop = self.pubTops($elem, o.onalw, o.sortableonbeforestoptopics);
		soo.stop = self.pubTops($elem, o.onalw, o.sortableonstoptopics);
		soo.start = self.pubTops($elem, o.onalw, o.sortableonstarttopics);
		soo.sort = self.pubTops($elem, o.onalw, o.sortableonsorttopics);
		soo.activate = self.pubTops($elem, o.onalw, o.sortableonactivatetopics);
		soo.deactivate = self.pubTops($elem, o.onalw, o.sortableondeactivatetopics);
		soo.over = self.pubTops($elem, o.onalw, o.sortableonovertopics);
		soo.out = self.pubTops($elem, o.onalw, o.sortableonouttopics);
		soo.remove = self.pubTops($elem, o.onalw, o.sortableonremovetopics);
		soo.receive = self.pubTops($elem, o.onalw, o.sortableonreceivetopics);
		soo.change = self.pubTops($elem, o.onalw, o.sortableonchangetopics);
		soo.update = self.pubTops($elem, o.onalw, o.sortableonupdatetopics);
		$elem.sortable(soo);
	},
	
	/** handle interaction resizable */
	resizable : function($elem, o) {
		var self = this;
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
		}
		var ros = o.resizableoptions;
		var ro = window[ros];
		if (!ro) {
			ro = eval("( " + ros + " )");
		}
		else {
			ro = {};
		}
		ro.start = self.pubTops($elem, o.onalw, o.resizableonstarttopics);
		ro.stop = self.pubTops($elem, o.onalw, o.resizableonstoptopics);
		ro.resize = self.pubTops($elem, o.onalw, o.resizableonresizetopics);
		$elem.resizable(ro);
	},

	/** Handle the Dialog Widget */
	dialog : function($elem, o) {
		var self = this;
		self.log('dialog : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.bgiframe" + self.minSuffix + ".js", "js/base/jquery.ui.dialog" + self.minSuffix + ".js" ]);
		}

		// Remove existing Dialog Instances
		var widgetInst = $(".ui-dialog:has("+self.escId(o.id)+")");
		if(widgetInst.length > 0) {
			$("div"+self.escId(o.id)).dialog("destroy");
			$("div"+self.escId(o.id)).remove();
		}

		var params = {};
		$.extend(params, o);
		params.bgiframe = true;

		if(o.opentopics) {
			self.subscribeTopics($elem, o.opentopics, self.handler.open_dialog, o);
		}

		if(o.closetopics) {
			self.subscribeTopics($elem, o.closetopics, self.handler.close_dialog, o);
		}

		if(o.destroytopics) {
			self.subscribeTopics($elem, o.destroytopics, self.handler.destroy_dialog, o);
		}

		if (o.hide) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.effects.core" + self.minSuffix + ".js", "js/base/jquery.effects." + o.hide + self.minSuffix + ".js" ]);
			}
			params.hide = o.hide;
		}
		if (o.show) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.effects.core" + self.minSuffix + ".js", "js/base/jquery.effects." + o.show + self.minSuffix + ".js" ]);
			}
			params.show = o.show;
		}
		params.open = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (o.href && o.href !== '#') {
				var divTopic = '_s2j_topic_load_' + o.id;
				self.subscribeTopics($elem, divTopic, self.handler.load, o);
				$elem.publish(divTopic);
			}

			self.publishTopic($elem, o.onalw, data);
			self.publishTopic($elem, o.onbef, data);
			self.publishTopic($elem, o.onopentopics, data);
		};
		params.close = self.pubTops($elem, o.onalw, o.onclosetopics);
		params.focus = self.pubTops($elem, o.onalw, o.onfocustopics);
		params.beforeclose = function() {

			var data = {};
			data.close = true;

			self.publishTopic($elem, o.onalw, data);
			self.publishTopic($elem, o.onbeforeclosetopics, data);

			return data.close;
		};


		params.drag = self.pubTops($elem, o.onalw, o.oncha);
		
		$elem.data('s2j_options', o);

		$elem.dialog(params);
	},

	/** Handle the TabbedPanel Widget */
	tabbedpanel : function($elem, o) {
		var self = this;
		self.log('tabbedpanel : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.tabs" + self.minSuffix + ".js" ]);
		}
		if (!o) {
			o = {};
		}
		var para = {};

		if (o.disabledtabs && o.disabledtabs !== 'false') {
			var disabledtabsStr = o.disabledtabs;
			var disabledtabs = window[disabledtabsStr];
			if (!disabledtabs) {
				para.disabled = eval("( " + disabledtabsStr + " )");
			}
		}
		if (o.cache) {
			para.cache = true;
		}
		if (o.animate) {
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.effects.core" + self.minSuffix + ".js");
			}
			para.fx = {
				opacity :'toggle'
			};
		}
		if (o.cookie) {
			self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
			para.cookie = {
				expires :30
			};
		}
		if (o.collapsible) {
			para.collapsible = true;
		}
		if (o.openonmouseover) {
			para.event = 'mouseover';
		}
		if (o.orientation) {
			para.orientation = o.orientation;
		}

		if (o.spinner !== undefined) {
			para.spinner = o.spinner;
		}
		else if (self.defaults.loadingText !== null) {
			para.spinner = self.defaults.loadingText;
		}

		if (o.selectedtab) {
			para.selected = o.selectedtab;
		}
		if (o.oncom) {
			para.ajaxOptions = {
			dataType :'html',
			complete :self.pubCom(o.id, o.onalw, o.oncom, null, null, {})
			};
		}
		else {
			para.ajaxOptions = {
				dataType :'html'
			};
		}
		if (o.onbef) {
			para.show = self.pubTops($elem, o.onalw, o.onbef);
		}
		para.select = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			var form = $elem.data("tab"+ui.index);
			if(form){
				var links = $(self.escId(o.id)+" > ul").find("li a"); 
				$elem.tabs('url', ui.index, self.addForms(form, $.data(links[ui.index], 'href.tabs')));
			}
			
			if(o.oncha) {
				self.publishTopic($elem, o.oncha, data);
				self.publishTopic($elem, o.onalw, data);
			}
		};
		if (o.onenabletopics) {
			para.enable = self.pubTops($elem, o.onalw, o.onenabletopics);
		}
		if (o.ondisabletopics) {
			para.disable = self.pubTops($elem, o.onalw, o.ondisabletopics);
		}
		if (o.onaddtopics) {
			para.add = self.pubTops($elem, o.onalw, o.onaddtopics);
		}
		if (o.onremovetopics) {
			para.remove = self.pubTops($elem, o.onalw, o.onremovetopics);
		}
		if (o.oncom) {
			para.load = self.pubTops($elem, o.onalw, o.oncom);
		}

		var tabs = $elem.data('taboptions');
		var closable = false;
		if (tabs) {
			var tabStr = "", l;
			for (l = 0; l < tabs.length; l++) {
				var tab = tabs[l];
				tabStr += "<li ";
				if (tab.id) {
					tabStr += "id='" + tab.id + "' ";
				}
				if (tab.cssstyle) {
					tabStr += "style='" + tab.cssstyle + "' ";
				}
				if (tab.cssclass) {
					tabStr += "class='" + tab.cssclass + "' ";
				}

				tabStr += "><a href='" + tab.href + "' ";

				if (tab.label) {
					tabStr += "title='" + tab.label + "' ";
				}
				tabStr += "><span>";
				if (tab.label) {
					tabStr += tab.label;
				}
				tabStr += "</span></a>";
				if (tab.closable) {
					tabStr += "<span class='ui-icon ui-icon-close s2j-tab-closable' style='float: left; margin: 0.4em 0.2em 0 0; cursor: pointer;'>&nbsp;</span>";
					closable = true;
				}
				tabStr += "</li>";
				if (tab.formIds) {
					$elem.data("tab"+l, tab.formIds);
				}

			}
			$(self.escId(o.id) + ' > ul').html(tabStr);
		}

		$elem.tabs(para);

		if (o.sortable) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
			}
			$elem.find(".ui-tabs-nav").sortable({axis:'x'});
		}

		if (closable) {
			$("#"+o.id+" span.s2j-tab-closable").live('click', function() {
				var index = $('li',$elem).index($(this).parent());
				$elem.tabs('remove', index);
			});
		}
		// History and Bookmarking for Tabs
		if (self.ajaxhistory) {
			var ahp = {};
			ahp.id = o.id;
			$elem.find('ul.ui-tabs-nav a').bind('click', ahp, function(e) {
				var idx = $(self.escId(e.data.id)).tabs('option', 'selected');
				self.historyelements[e.data.id] = idx;
				$.bbq.pushState(self.historyelements);
				return false;
			});

			$(window).bind('hashchange', ahp, function(e) {
				var idx = e.getState(e.data.id, true) || 0;
				$(self.escId(e.data.id)).tabs('select', idx);
			});
		}
	},
	/** Load Ressources for Datepicker Widget */
	initDatepicker : function(timepicker) {
		var self = this;
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.datepicker" + self.minSuffix + ".js" ]);
			if (self.local !== "en") {
				self.require("i18n/jquery.ui.datepicker-" + self.local + ".min.js");
			}
		}
		if(timepicker) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.slider" + self.minSuffix + ".js" ]);
			}
			self.require( [ "js/plugins/jquery-ui-timepicker-addon" + self.minSuffix + ".js" ]);
			self.requireCss("themes/jquery-ui-timepicker-addon.css");
			if (self.timeLocal !== "en") {
				self.require("i18n/jquery-ui-timepicker-" + self.timeLocal + ".js");
			}
		}

	},
	/** Handle the Datepicker Widget */
	datepicker : function($elem, o) {
		var self = this;
		self.log('datepicker : ' + o.id);

		var params = {};
		$.extend(params, o);

		var oat = o.onalw;

		if (o.onbef) {
			params.beforeShow = function(input, inst) {
				var $input = $(input);
				var data = {};
				data.input = input;
				data.inst = inst;
				self.publishTopic($input, o.onbef, data);
				self.publishTopic($input, oat, data);
			};
		}

		if (o.onbeforeshowdaytopics) {
			params.beforeShowDay = function(date) {
				var data = {};
				data.date = date;
				data.returnValue = [true,"",""];
				self.publishTopic($elem, o.onbeforeshowdaytopics, data);
				self.publishTopic($elem, oat, data);
				return data.returnValue;
			};
		}

		if (o.onchangemonthyeartopics) {
			params.onChangeMonthYear = function(year, month, inst) {
				var data = {};
				data.year = year;
				data.month = month;
				data.inst = inst;
				self.publishTopic($elem, o.onchangemonthyeartopics, data);
				self.publishTopic($elem, oat, data);
			};
		}

		if (o.oncha || o.inline) {
			params.onSelect = function(dateText, inst) {
				if(o.inline) {
					$elem.val(dateText);
				}
				if(o.oncha) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					self.publishTopic($elem, o.oncha, data);
					self.publishTopic($elem, oat, data);
				}
			};
		}

		if (o.oncom) {
			params.onClose = function(dateText, inst) {
				var data = {};
				data.dateText = dateText;
				data.inst = inst;
				self.publishTopic($elem, o.oncom, data);
				self.publishTopic($elem, oat, data);
			};
		}

		if (o.displayformat) {
			params.dateFormat = o.displayformat;
		}
		else {
			params.dateFormat = $.datepicker._defaults.dateFormat;
		}

		if (o.showAnim) {
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.effects.core" + self.minSuffix + ".js");
			}
		}

		if (o.numberofmonths) {
			var numberofmonthsStr = o.numberofmonths;
			var numberofmonths = window[numberofmonthsStr];
			if (!numberofmonths) {
				params.numberOfMonths = eval("( " + numberofmonthsStr + " )");
			}
		}

		if (o.showoptions) {
			var userOptionsStr = o.showoptions;
			var userOptions = window[userOptionsStr];
			if (!userOptions) {
				params.showOptions = eval("( " + userOptionsStr + " )");
			}
		}
		
		var ins = $elem;

		if(o.inline) {
			ins = $(self.escId(o.id)+'_inline');
		}

		if(o.timepicker) {
			if(o.tponly) {
				ins.timepicker(params);
			} 
			else { 
				ins.datetimepicker(params);
			}
			if (o.year!==undefined) {
				ins.datetimepicker('setDate', new Date(o.year, o.month, o.day, o.hour, o.minute, o.second));
			}
		}
		else {
			ins.datepicker(params);
			if (o.year!==undefined) {
				ins.val($.datepicker.formatDate(params.dateFormat, new Date(o.year, o.month, o.day)));
			}
		}
		
		if (o.zindex) {
			$('#ui-datepicker-div').css("z-index", o.zindex);
		}
	},

	/** Handle the Slider Widget */
	slider : function($elem, o) {
		var self = this;
		self.log('slider : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.slider" + self.minSuffix + ".js" ]);
		}

		o.start = self.pubTops($elem, o.onalw, o.onbef);
		o.change = self.pubTops($elem, o.onalw, o.oncha);
		o.stop = self.pubTops($elem, o.onalw, o.oncom);

		o.slide = function(event, ui) {
			if (o.hiddenid) {
				if(o.value != undefined) {
					$(self.escId(o.hiddenid)).val(ui.value);
				}
				if(o.values) {
					$(self.escId(o.hiddenid)).val(ui.values[0]+","+ui.values[1]);
				}
			}
			if (o.displayvalueelement) {
				if(o.value != undefined) {
					$(self.escId(o.displayvalueelement)).html(ui.value);
				}
				if(o.values) {
					$(self.escId(o.displayvalueelement)).html(ui.values[0]+" - "+ui.values[1]);
				}
			}
			if (o.onslidetopics) {
				var data = {};
				data.event = event;
				data.ui = ui;

				self.publishTopic($elem, o.onalw, data);
				self.publishTopic($elem, o.onslidetopics, data);
			}
		};
    if (o.range && o.range === 'true'){o.range=true;}

		$elem.slider(o);
	},

	/** Handle the Spinner Widget */
	spinner : function($elem, o) {
		var self = this;
		self.log('spinner : ' + o.id);
		self.container($elem, o);
		if (!self.loadAtOnce) {
			self.require("js/base/jquery.ui.widget" + self.minSuffix + ".js");
			if (o.mouseWheel) {
				self.require("js/base/jquery.ui.mouse" + self.minSuffix + ".js");
			}
		}
		self.require("js/plugins/jquery.ui.spinner" + self.minSuffix + ".js");
		self.requireCss("themes/ui.spinner.css");

		if (o.oncha) {
			o.change = self.pubTops($elem, o.onalw, o.oncha);
		}

		$elem.spinner(o);
	},

	/** Handle the Progressbar Widget */
	progressbar : function($elem, o) {
		var self = this;
		self.log('progressbar : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.progressbar" + self.minSuffix + ".js" ]);
		}
		var params = {};
		if (o) {

			params.change = self.pubTops($elem, o.onalw, o.oncha);

			var value = o.value;
			if (value > 0) {
				params.value = value;
			}
			else {
				params.value = 0;
			}
		}
		$elem.progressbar(params);
	},

	/** Handle the Accordion Widget */
	accordion : function($elem, o) {
		var self = this;
		self.log('accordion : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.accordion" + self.minSuffix + ".js" ]);
		}
		var params = {};
		var active = true;
		if (o) {

			if (o.fillspace) {
				params.fillSpace = true;
			}
			if (o.collapsible) {
				params.collapsible = true;
			}
			if (o.clearstyle) {
				params.clearStyle = true;
			}
			if (o.autoheight !== undefined) {
				if (o.autoheight) {
					params.autoHeight = true;
				}
				else {
					params.autoHeight = false;
				}
			}
			if (o.event) {
				params.event = o.event;
			}
			if (o.header) {
				params.header = o.header;
			}
			else {
				params.header = 'h3';
			}
			if (o.animated) {
				if (o.animated === 'true') {
					params.animated = true;
				}
				else if (o.animated === false) {
					params.animated = false;
				}
				else {
					params.animated = o.animated;
				}
			}

			if (o.active) {
				if (o.active === 'true') {
					params.active = true;
				}
				else if (o.active === 'false') {
					params.active = false;
					active = false;
				}
				else {
					params.active = parseInt(o.active, 10);
				}
			}

			var onAlwaysTopics = o.onalw;
			params.changestart = function(event, ui) {
				if (o.href) {
					if (typeof $(ui.newHeader).find('a').attr('paramkeys') !== "undefined") {
						var keys = $(ui.newHeader).find('a').attr('paramkeys').split(',');
						var values = $(ui.newHeader).find('a').attr('paramvalues').split(',');
						var valueparams = {};
						$.each(keys, function(i, val) {
							valueparams[val] = values[i];
						});
						ui.newContent.load(o.href, valueparams, function() {
						});
					}
				}
				if (o.onbef) {
					var data = {};
					data.event = event;
					data.ui = ui;

					self.publishTopic($elem, onAlwaysTopics, data);
					self.publishTopic($elem, o.onbef, data);
				}
			};

			params.change = self.pubTops($elem, o.onalw, o.oncha);
		}
		$elem.accordion(params);
		if (o.href && active === true) {
			var aktiv = $(self.escId(o.id) + " li " + params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
			if (typeof $(aktiv).attr('paramkeys') !== "undefined") {
				var keys = $(aktiv).attr('paramkeys').split(',');
				var values = $(aktiv).attr('paramvalues').split(',');
				var valueparams = {};
				$.each(keys, function(i, val) {
					valueparams[val] = values[i];
				});
				$(self.escId(o.id) + " li div").filter('.ui-accordion-content-active').load(o.href, valueparams, function() {
				});
			}
		}
	},
	
	/** Handle the Accordion Item */
	accordionItem : function($elem, o) {
		var self = this;

		if (o.onclick) {
			var a = $(self.escId(o.id) + "_link");
			$.each(o.onclick.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic, o);
			});
		}
	},

	/** Handle the Autocompleter Widget */
	autocompleter : function($elem, o) {
		var self = this;
		self.log('autocompleter for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.autocomplete" + self.minSuffix + ".js" ]);
		}
		var params = {};
		var url = '';
		if (o.href && o.href !== '#') {
			url = o.href;
			if (o.hrefparameter) {
				url = url + '?' + o.hrefparameter;
			}
		}
		if(url !== '') {
			url = self.addForms(o.formids, url);
			if(o.list) {
				params.source = function(request, response) {
					var self = $.struts2_jquery;
					jQuery.ui.autocomplete.prototype._renderItem = function( ul, item ) {
					  return $( "<li></li>" )
					    .data( "item.autocomplete", item )
					    .append( "<a>" + item.label + "</a>" )
					    .appendTo( ul );
					};

					self.abortReq(o.id);
					self.showIndicator(o.indicatorid);
					self.currentXhr[o.id] = $.ajax({
						url: url,
						dataType: "json",
						data: {
						term: request.term
						},
						complete: function(request, status) {
							self.hideIndicator(o.indicatorid);
						},
						success: function(data) {
							self.currentXhr[o.id] = null;
							var x = 0;
							if (data[o.list] !== null) {
								var isMap = false;
								if (!$.isArray(data[o.list])) {
									isMap = true;
								}
								var result = [];
								$.each(data[o.list], function(j, val) {
									if (isMap) {
										result.push({
											label: val.replace(
													new RegExp(
															"(?![^&;]+;)(?!<[^<>]*)(" +
															$.ui.autocomplete.escapeRegex(request.term) +
															")(?![^<>]*>)(?![^&;]+;)", "gi"
														), "<strong>$1</strong>" ),
											value: val,
											key: j
										});
									}
									else {
										if (o.listkey !== undefined && o.listvalue !== undefined) {
											var label;
											if(o.listlabel) {
												label = val[o.listlabel];
											}
											else {
												label = val[o.listvalue].replace(
														new RegExp(
																"(?![^&;]+;)(?!<[^<>]*)(" +
																$.ui.autocomplete.escapeRegex(request.term) +
																")(?![^<>]*>)(?![^&;]+;)", "gi"
															), "<strong>$1</strong>" );
											}
											result.push({
												label: label,
												value: val[o.listvalue],
												key: val[o.listkey]
											});
										}
										else {
											result.push({
												label: data[o.list][x].replace(
														new RegExp(
																"(?![^&;]+;)(?!<[^<>]*)(" +
																$.ui.autocomplete.escapeRegex(request.term) +
																")(?![^<>]*>)(?![^&;]+;)", "gi"
															), "<strong>$1</strong>" ),
												value: data[o.list][x],
												key: data[o.list][x]
											});
										}
									}
									x++;
								});
								response(result);
							}
						}
					});
				};
			}
			else {
				params.source = url;
			}
		}
		else if (o.list && o.selectBox === false) {
			params.source = o.list;
		}
		if (o.delay) {
			params.delay = o.delay;
		}
		if (o.minimum) {
			params.minLength = o.minimum;
		}
		if (o.forceValidOption === false) {
			$elem.keyup(function(e) {
				$(self.escId(o.hiddenid)).val($elem.val());
			});
		}

		if (o.onsuc) {
			params.open = self.pubTops($elem, o.onalw, o.onsuc);
		}
		if (o.oncha) {
			params.change = self.pubTops($elem, o.onalw, o.oncha);
		}
		if (o.oncom) {
			params.close = self.pubTops($elem, o.onalw, o.oncom);
		}
		if (o.onsearchtopics) {
			params.search = self.pubTops($elem, o.onalw, o.onsearchtopics);
		}
		if (o.onfocustopics) {
			params.focus = self.pubTops($elem, o.onalw, o.onfocustopics);
		}
		params.select = function( event, ui ) {
			if (o.onselecttopics) {
				params.select = self.pubTops($elem, o.onalw, o.onselecttopics);
				var data = {};
				data.event = event;
				data.ui = ui;

				self.publishTopic($elem, o.onalw, data);
				self.publishTopic($elem, o.onselecttopics, data);
			}
      if(ui.item){
      	if(ui.item.option) {
      		$(self.escId(o.hiddenid)).val(ui.item.option.value);
      	}
      	else if(ui.item.key) {
      		$(self.escId(o.hiddenid)).val(ui.item.key);
      	}
      	else {
      		$(self.escId(o.hiddenid)).val(ui.item.value);
      	}
      }
		};


		if (o.selectBox === false) {
			$elem.autocomplete(params);
		}
		else {
			self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/plugins/jquery.combobox" + self.minSuffix + ".js" ]);
			if (o.selectBoxIcon) {
				params.icon = true;
			}
			else {
				params.icon = false;
			}
			$elem.combobox(params);
		}
	},

	/** Handle the Button Widget for Anchor or Submit Tag*/
	jquerybutton : function($elem, o) {
		var self = this;
		self.log('button for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
		}
		if (o.button) {
			var params = {};
			params.icons = {};
			if (o.bicon) {
				params.icons.primary = o.bicon;
			}
			if (o.bicon2) {
				params.icons.secondary = o.bicon2;
			}
			if (o.btext !== undefined) {
				params.text = o.btext;
			}
			$elem.button(params);
		}
	},

	/** Handle the Buttonset Widget for Radiobuttons or Checkboxes */
	buttonset : function($elem, o) {
		var self = this;
		self.log('buttonset for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
		}
		var buttonsetLoadTopic = '_s2j_topic_load_' + o.id;

		if (o.href && o.href !== '#') {

			var buttonsetTopic = 's2j_butonset_' + o.id;

			if ($elem.isSubscribed(buttonsetTopic)) {
				$elem.destroyTopic(buttonsetTopic);
			}

			// Init Buttonset after elements loaded via AJAX.
			$elem.subscribe(buttonsetTopic, function(event, data) {
				if (o.oncha) {
					var selectString = self.escId(o.id) + " > input";
					var elements = $(selectString);

					if ($.browser.msie && o.type === 'radio') {
						elements.click( function() {
							this.blur();
							this.focus();
							$.each(o.oncha.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
					else {
						elements.change( function() {
							$.each(o.oncha.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
				}

				if(o.buttonset) {
					$elem.buttonset(o);
				}
			});
			if (o.onsuc && o.onsuc !== '') {
				o.onsuc = buttonsetTopic;
			}
			else {
				o.onsuc = buttonsetTopic;
			}

			self.subscribeTopics($elem, o.reloadtopics, self.handler.load, o);
			self.subscribeTopics($elem, o.listentopics, self.handler.load, o);

			$elem.subscribe(buttonsetLoadTopic, self.handler.load);
			$elem.publish(buttonsetLoadTopic, o);
		}
		else {
			if (o.oncha) {
				$(self.escId(o.id) + " > input").change( function() {
					$.each(o.oncha.split(','), function(i, cts) {
						$elem.publish(cts);
					});
				});
			}

			if(o.buttonset) {
				$elem.buttonset(o);
			}
		}
	}
	};

	/**
	 * handler to open a dialog
	 */
	$.subscribeHandler($.struts2_jquery_ui.handler.open_dialog, function(event, data) {
		var _s2j = $.struts2_jquery_ui;
		var o = $(this).data('s2j_options');
		if (event.data) {
			$.extend(o, event.data);
		}
		if (data) {
			if (data.href) {
				o.href = data.href;
			}
			if (data.hrefparameter) {
				o.hrefparameter = data.hrefparameter;
			}
		}

		$(this).dialog("option", "open", function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (o.href && o.href !== '#') {
				var divTopic = '_s2j_topic_load_' + o.id;
				_s2j.subscribeTopics($(this), divTopic, _s2j.handler.load, o);
				$(this).publish(divTopic);
			}

			_s2j.publishTopic($(this), o.onalw, data);
			_s2j.publishTopic($(this), o.onbef, data);
			_s2j.publishTopic($(this), o.onopentopics, data);
		});
		$(this).dialog("open");
	});

	/**
	 * handler to close a dialog
	 */
	$.subscribeHandler($.struts2_jquery_ui.handler.close_dialog, function(event, data) {
		$(this).dialog('close');
	});

	/**
	 * handler to destroy a dialog
	 */
	$.subscribeHandler($.struts2_jquery_ui.handler.destroy_dialog, function(event, data) {
		$(this).dialog('destroy');
	});

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_ui, $.struts2_jquery);

})(jQuery);
