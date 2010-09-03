/*!
 * jquery.chart.struts2.js
 *
 * Integration of charts with struts 2 
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
(function($) {

	/**
	 * Bind a Chart to Struts2 Component
	 */
	$.struts2_jquery_chart = {

		debugPrefix : '[struts2_jquery_chart] ',
		charts : [],

		// Render a Chart Area
		chart : function($elem, o) {
			var self = this;
			self.require("js/flot/jquery.flot.js");
			
			var ajaxData = [];
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
			
			var plot = $.plot($elem, self.charts[o.id], o);
			
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

			var chartTopic = '_s2j_chart_topic';
			$.each(ajaxData, function(i, ad) {
				var topic = chartTopic+i;
				self.subscribeTopics($elem, topic, '_s2j_chart', ad);
				$elem.publish(topic, ad);
			});
		}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_chart, $.struts2_jquery);

	/**
	 * Chart logic Register handler to load a chart
	 */
	$.subscribeHandler('_s2j_chart', function(event, data) {

		var _s2j = $.struts2_jquery;

		var c = $(event.target);
		var o = {};
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}

		var indi = o.indicatorid;
		_s2j.showIndicator(indi);

		// publish all 'before' and 'always' topics
		_s2j.publishTopic(c, o.onalw, o);
		_s2j.publishTopic(c, o.onbef, o);

		var params = {};
		params.complete = _s2j.pubCom(event.target, o.onalw, o.oncom, o.targets, indi, o);
		params.error = _s2j.pubErr(event.target, o.onalw, o.onerr, o.errortext, 'html');

		params.success = function(data, status, request) {

			var orginal = {};
			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			var x = 0;
			if (data[o.list] !== null) {
				var isMap = false;
				if (!$.isArray(data[o.list])) {
					isMap = true;
				}
				var result = [];
				$.each(data[o.list], function(j, val) {
					if (isMap) {
						var mapValue = [];
						mapValue.push(j);
						mapValue.push(val);
						result.push(mapValue);
					}
					else {
						if (o.listkey !== undefined && o.listvalue !== undefined) {
							var listValue = [];
							listValue.push(val[o.listkey]);
							listValue.push(val[o.listvalue]);
							result.push(listValue);
						}
						else {
							var arrayValue = [];
							arrayValue.push(x);
							arrayValue.push(data[o.list][x]);
							result.push(arrayValue);
						}
					}
					x++;
				});
				o.data = result;
				var floatOptions = o.plot;
				o.data = result;
				o.plot = null;
				$.struts2_jquery_chart.charts[floatOptions.id].push(o);
				$.plot(c,$.struts2_jquery_chart.charts[floatOptions.id],floatOptions);
			}

			if (o.onsuc) {
				_s2j.publishTopic(c, o.onsuc, orginal);
				_s2j.publishTopic(c, o.onalw, orginal);
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
				if (!_s2j.loadAtOnce) {
					_s2j.require("js/plugins/jquery.form" + _s2j.minSuffix + ".js");
				}
				$.each(o.formids.split(','), function(i, fid) {
					var query = $(_s2j.escId(fid)).formSerialize();
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
			_s2j.publishTopic(c, o.onalw, o);
			_s2j.publishTopic(c, o.onbef, o);

			// Execute Ajax Request
			$.ajax(params);
		}
});

})(jQuery);