/**
 * @preserve
 * jquery.chart.struts2.js
 *
 * Integration of charts with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2010 - 2015 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window,  */
"use strict";
(function($) {
	/**
	 * Bind a Chart to Struts2 Component
	 */
	$.struts2_jquery_chart = {

		charts : [],

		// Render a Chart Area
		chart : function($elem, o) {
			var self = this,
				ajaxData = [],
				chartTopic = '_s2j_chart_topic',
				plot;

            // Detect IE7-8
			if ($.support.leadingWhitespace == false) {
				self.require("js/flot/excanvas" + self.minSuffix + ".js");
			}
			self.require("js/flot/jquery.flot" + self.minSuffix + ".js");
			if (o.crosshair) {
				self.require("js/flot/jquery.flot.crosshair" + self.minSuffix + ".js");
			}
			if ((o.xaxis && o.xaxis.mode === "time") || (o.yaxis && o.yaxis.mode === "time")) {
				self.require("js/flot/jquery.flot.time" + self.minSuffix + ".js");
			}
			if ((o.xaxis && o.xaxis.axisLabel) || (o.yaxis && o.yaxis.axisLabel)) {
				self.require("js/flot/jquery.flot.axislabels" + self.minSuffix + ".js");
			}
			if (o.fill) {
				self.require("js/flot/jquery.flot.fillbetween" + self.minSuffix + ".js");
			}
			if (o.stack) {
				self.require("js/flot/jquery.flot.stack" + self.minSuffix + ".js");
			}
			if (o.series && o.series.curvedLines) {
				self.require("js/flot/curvedLines" + self.minSuffix + ".js");
			}
			if (o.series && o.series.pie) {
				self.require("js/flot/jquery.flot.pie" + self.minSuffix + ".js");
			}
			if (o.autoresize) {
				self.require("js/flot/jquery.flot.resize" + self.minSuffix + ".js");
			}

			self.charts[o.id] = [];
			$.each(o.data, function(i, d) {
				if(d.href) {
					d.plot = o;
					d.plot.data = null;
					ajaxData.push(d);
				}
				else {
					self.charts[o.id].push(d);
				}
			});

			if(o.onclick || o.onhover) {
				o.grid = {};
				if(o.onclick) {
					o.grid.clickable = true;
				}
				if(o.onhover) {
					o.grid.hoverable = true;
				}
			}

			plot = $.plot($elem, self.charts[o.id], o);

			if(o.onclick) {
				$elem.bind("plotclick", function (event, pos, item) {
					var orginal = {};
					orginal.plot = plot;
					orginal.event = event;
					orginal.pos = pos;
					orginal.item = item;
					self.publishTopic($elem, o.onclick, orginal);
		    });
			}
			if(o.onhover) {
				$elem.bind("plothover", function (event, pos, item) {
					var orginal = {};
					orginal.plot = plot;
					orginal.event = event;
					orginal.pos = pos;
					orginal.item = item;
					self.publishTopic($elem, o.onhover, orginal);
				});
			}

			$.each(ajaxData, function(i, ad) {
				var topic = chartTopic+o.id+i;
				self.subscribeTopics($elem, topic, '_s2j_chart', ad);
				self.subscribeTopics($elem, ad.reloadtopics, '_s2j_chart', ad);
				self.subscribeTopics($elem, ad.listentopics, '_s2j_chart', ad);
				if (!ad.deferredloading) {
					$elem.publish(topic, ad);
				}
			});
		}
	};

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_chart, $.struts2_jquery);
	$.struts2_jquery_chart.debugPrefix = "[struts2_jquery_chart] ";

	/**
	 * Chart logic Register handler to load a chart
	 */
	$.subscribeHandler('_s2j_chart', function(event, data) {

		var s2j = $.struts2_jquery,
			c = $(event.target),
			params = {},
			o = {},
			indi;
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}

		indi = o.indicatorid;
		s2j.showIndicator(indi);

		// publish all 'before' and 'always' topics
		s2j.publishTopic(c, o.onalw, o);
		s2j.publishTopic(c, o.onbef, o);

		params.complete = s2j.pubCom(event.target, o.onalw, o.oncom, o.targets, indi, o);
		params.error = s2j.pubErr(event.target, o.onalw, o.onerr, o.errortext, 'html');

		params.success = function(data, status, request) {

			var orginal = {},
				x = 0,
				isMap = false,
				isFetched = false,
				floatOptions = o.plot,
				result = [];

			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			if (data[o.list] !== null) {
				if (!$.isArray(data[o.list])) {
					isMap = true;
				}
				$.each(data[o.list], function(j, val) {
					var value;
					if (isMap) {
						value = [];
						value.push(j);
						value.push(val);
						result.push(value);
					}
					else {
						if (o.listkey !== undefined && o.listvalue !== undefined) {
							value = [];
							value.push(val[o.listkey]);
							value.push(val[o.listvalue]);
							result.push(value);
						}
						else {
							value = [];
							value.push(x);
							value.push(data[o.list][x]);
							result.push(value);
						}
					}
					x++;
				});
				o.data = result;
				o.data = result;
				o.plot = null;

				$.each($.struts2_jquery_chart.charts[floatOptions.id], function(j, val) {
					if(val && val.id && val.id === o.id) {
						isFetched = true;
						val.data = result;
					}
				});

				if(!isFetched){
					$.struts2_jquery_chart.charts[floatOptions.id].push(o);
				}
				$.plot(c,$.struts2_jquery_chart.charts[floatOptions.id],floatOptions);
			}

			if (o.onsuc) {
				s2j.publishTopic(c, o.onsuc, orginal);
				s2j.publishTopic(c, o.onalw, orginal);
			}
		};

		// load container using ajax
		if (o.href) {
			params.url = o.href;
			params.data = '';
			if (o.hrefparameter) {
				params.data = o.hrefparameter;
			}
			if (o.requesttype) {
				params.type = o.requesttype;
			}
			else {
				params.type = "POST";
			}

			if (o.formids && params.data === '') {
				if (!s2j.loadAtOnce) {
					s2j.require("js/plugins/jquery.form" + s2j.minSuffix + ".js");
				}
				$.each(o.formids.split(','), function(i, fid) {
					var query = $(s2j.escId(fid)).formSerialize();
					if (params.data !== '') {
						params.data = params.data + '&' + query;
					}
					else {
						params.data = query;
					}
				});
			}

			params.dataType = "json";

			// fix 'issue' wherein IIS will reject post without data
			if (!params.data) {
				params.data = {};
			}

			o.options = params;
			// publish all 'before' and 'always' topics
			s2j.publishTopic(c, o.onalw, o);
			s2j.publishTopic(c, o.onbef, o);

			// Execute Ajax Request
			$.ajax(params);
		}
});

})(jQuery);