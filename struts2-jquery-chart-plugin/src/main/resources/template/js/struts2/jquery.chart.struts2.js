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

		// Render a Chart Area
		chart : function($elem, o) {
			var self = this;
			self.require("js/flot/jquery.flot.js");
			$.plot($elem, o.data, o);
		}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_chart, $.struts2_jquery);

	/**
	 * Chart logic Register handler to load a chart
	 */
	$.subscribeHandler('_s2j_chart', function(event, data) {

		var _s2j = $.struts2_jquery;

		var container = $(event.target);
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
		_s2j.publishTopic(container, o.onalw, o);
		_s2j.publishTopic(container, o.onbef, o);

		var params = {};
		params.complete = _s2j.pubCom(event.target, o.onalw, o.oncom, o.targets, indi, o);
		params.error = _s2j.pubErr(event.target, o.onalw, o.onerr, o.errortext, modus);

		params.success = function(data, status, request) {

			var orginal = {};
			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			container.data('loaded', true);

			if (typeof (data) == "object" || $.isArray(data)) {

			if (typeof (data) == "object") {
					for (i in data) {
						if(i) {
						var series = data[i];
						if (series && typeof (series.data) == "object") {
							var seriesData = series.data;
							var seriesDataArray = [];
							for (x in seriesData) {
								if(x){
								seriesDataArray.push( [ x, seriesData[x] ]);
								}
							}
							series.data = seriesDataArray;
						}
						}
					}
				}

				$.plot(container, data, o);
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
			_s2j.publishTopic(container, o.onalw, o);
			_s2j.publishTopic(container, o.onbef, o);

			// Execute Ajax Request
			$.ajax(params);
		}
});

})(jQuery);