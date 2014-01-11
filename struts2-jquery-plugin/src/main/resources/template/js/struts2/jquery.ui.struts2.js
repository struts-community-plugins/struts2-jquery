/*!
 * jquery.ui.struts2.js
 *
 * Integration of jquery and jquery ui with struts 2
 * for ajax, widget and interactions support in struts 2
 *
 * Requires use of jQuery and jQuery UI.
 * Tested with jQuery 1.10 and jQuery UI 1.10
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

(function ($) {
    "use strict";

    /**
     * Bind Struts2 Components for jQuery UI functions
     */
    $.struts2_jquery_ui = {

        handler: {
            open_dialog: '_s2j_open_dialog',
            close_dialog: '_s2j_close_dialog',
            destroy_dialog: '_s2j_destroy_dialog'
        },

        /** opens a dialog if attribute openDialog in Anchor or Submit Tag is set to true */
        opendialog: function ($elem, o) {
            var self = this,
                dialog,
                openTopic = '_s2j_dialog_open_' + o.id;
            self.log('open dialog : ' + o.opendialog);

            if (o.opendialog) {
                dialog = $(self.escId(o.opendialog));
                $elem.bind('click', function (event) {
                    if ($(this).prop("disabled")) {
                        return false;
                    }
                    self.subscribeTopics(dialog, openTopic, self.handler.open_dialog, o);
                    dialog.publish(openTopic, o);
                    return false;
                });
            }
        },

        /** handle interaction draggable */
        draggable: function ($elem, o) {
            var self = this,
                daos = o.draggableoptions,
                dao = window[daos];
            self.log("draggable : " + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js" ]);
            }
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
        droppable: function ($elem, o) {
            var self = this,
                doos = o.droppableoptions,
                doo = window[doos];
            self.log("droppable : " + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.ui.droppable" + self.minSuffix + ".js" ]);
            }
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
        selectable: function ($elem, o) {
            var self = this,
                seos = o.selectableoptions,
                seo = window[seos];
            self.log('selectable : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.selectable" + self.minSuffix + ".js" ]);
            }
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
        sortable: function ($elem, o) {
            var self = this,
                soos = o.sortableoptions,
                soo = window[soos];
            self.log('sortable : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
            }
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
        resizable: function ($elem, o) {
            var self = this,
                ros = o.resizableoptions,
                ro = window[ros];
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
            }
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
        dialog: function ($elem, o) {
            var self = this;
            self.log('dialog : ' + o.id);

            var jsFiles = [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.dialog" + self.minSuffix + ".js" ];
            if (o.hide || o.show) {
                jsFiles.push("js/base/jquery.ui.effect" + self.minSuffix + ".js");
            }
            if (o.hide) {
                jsFiles.push("js/base/jquery.ui.effect-" + o.hide + self.minSuffix + ".js");
            }
            if (o.show) {
                jsFiles.push("js/base/jquery.ui.effect-" + o.show + self.minSuffix + ".js");
            }
            if (o.resizable) {
                jsFiles.push("js/base/jquery.ui.resizable" + self.minSuffix + ".js");
            }
            if (o.draggable) {
                jsFiles.push("js/base/jquery.ui.draggable" + self.minSuffix + ".js");
            }
            if (!self.loadAtOnce) {
                self.require(jsFiles);
            }

            if (o.opentopics) {
                self.subscribeTopics($elem, o.opentopics, self.handler.open_dialog, o);
            }

            if (o.closetopics) {
                self.subscribeTopics($elem, o.closetopics, self.handler.close_dialog, o);
            }

            if (o.destroytopics) {
                self.subscribeTopics($elem, o.destroytopics, self.handler.destroy_dialog, o);
            }

            o.open = function (event, ui) {
                var data = {},
                    divTopic = '_s2j_topic_load_' + o.id;

                data.event = event;
                data.ui = ui;

                if (o.href && o.href !== '#') {
                    self.subscribeTopics($elem, divTopic, self.handler.load, o);
                    $elem.publish(divTopic);
                }

                self.publishTopic($elem, o.onalw, data);
                self.publishTopic($elem, o.onbef, data);
                self.publishTopic($elem, o.onopentopics, data);
            };
            o.close = self.pubTops($elem, o.onalw, o.onclosetopics);
            o.focus = self.pubTops($elem, o.onalw, o.onfocustopics);
            o.beforeClose = function () {

                var data = {};
                data.close = true;

                self.publishTopic($elem, o.onalw, data);
                self.publishTopic($elem, o.onbeforeclosetopics, data);

                return data.close;
            };


            o.drag = self.pubTops($elem, o.onalw, o.oncha);

            $elem.data('s2j_options', o);

            $elem.dialog(o);
        },

        /** Handle the TabbedPanel Widget */
        tabbedpanel: function ($elem, o) {
            var self = this,
                ahp = {},
                disabledtabsStr = o.disabledtabs,
                disabledtabs = window[disabledtabsStr],
                tabs = $elem.data('taboptions'),
                tabStr = "",
                closable = false,
                l, tab;
            self.log('tabbedpanel : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.tabs" + self.minSuffix + ".js" ]);
            }

            if (o.disabledtabs && o.disabledtabs !== 'false') {
                if (!disabledtabs) {
                    o.disabled = eval("( " + disabledtabsStr + " )");
                }
            }
            if (o.openonmouseover) {
                o.event = 'mouseover';
            }
            if (o.cookie) {
                self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
            }

            if (o.selectedtab) {
                o.active = o.selectedtab;
            } else if (o.cookie) {
                o.active = $.cookie($elem.prop('id'));
            }


            if (o.show) {
                self.require("js/base/jquery.ui.effect" + self.minSuffix + ".js");
                if (typeof o.show == "string") {
                    self.require("js/base/jquery.ui.effect-" + o.show + self.minSuffix + ".js");
                }
            }
            if (o.hide) {
                self.require("js/base/jquery.ui.effect" + self.minSuffix + ".js");
                if (typeof o.hide == "string") {
                    self.require("js/base/jquery.ui.effect-" + o.hide + self.minSuffix + ".js");
                }
            }

            o.ajaxOptions = {
                dataType: "html"
            };

            o.beforeLoad = function (event, ui) {
                var data = {},
                    form = ui.tab.data("form"),
                    links;
                data.event = event;
                data.ui = ui;

                if (form) {
                    ui.ajaxSettings.url = self.addForms(form, ui.ajaxSettings.url);
                }

                if (o.onbef) {
                    self.publishTopic($elem, o.onbef, data);
                    self.publishTopic($elem, o.onalw, data);
                }
                if (o.cache) {
                    if (ui.tab.data("loaded")) {
                        event.preventDefault();
                        return;
                    }

                    ui.jqXHR.success(function () {
                        ui.tab.data("loaded", true);
                    });
                }
            };
            o.activate = function (event, ui) {
                var data = {},
                    form = $elem.data("tab" + ui.index),
                    links;
                data.event = event;
                data.ui = ui;

                if (o.cookie) {
                    $.cookie($elem.prop('id'), ui.newTab.index(), { name: "tab" + o.id, expires: 365 });
                }

                if (o.oncha) {
                    self.publishTopic($elem, o.oncha, data);
                    self.publishTopic($elem, o.onalw, data);
                }
            };

            if (o.oncom) {
                o.load = self.pubTops($elem, o.onalw, o.oncom);
            }
            if (o.onactivatetopics) {
                o.load = self.pubTops($elem, o.onalw, o.onactivatetopics);
            }
            if (o.onbefacttopics) {
                o.load = self.pubTops($elem, o.onalw, o.onbefacttopics);
            }

            if (tabs) {
                for (l = 0; l < tabs.length; l++) {
                    tab = tabs[l];
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
                    if (tab.formIds) {
                        tabStr += "data-form='" + tab.formIds + "' ";
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
                }
                $(self.escId(o.id) + ' > ul').html(tabStr);
            }

            $elem.tabs(o);

            if (o.sortable) {
                if (!self.loadAtOnce) {
                    self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
                }
                $elem.find(".ui-tabs-nav").sortable({axis: 'x'});
            }

            if (closable) {
                $("#" + o.id + " span.s2j-tab-closable").live('click', function () {
                    var index = $('li', $elem).index($(this).parent());
                    $elem.tabs('remove', index);
                });
            }
            // History and Bookmarking for Tabs
            if (self.ajaxhistory) {
                ahp.id = o.id;
                $elem.find('ul.ui-tabs-nav a').bind('click', ahp, function (e) {
                    var idx = $(self.escId(e.data.id)).tabs('option', 'selected');
                    self.historyelements[e.data.id] = idx;
                    $.bbq.pushState(self.historyelements);
                    return false;
                });

                $(window).bind('hashchange', ahp, function (e) {
                    var idx = e.getState(e.data.id, true) || 0;
                    $(self.escId(e.data.id)).tabs('option', 'active', idx);
                });
            }
        },
        /** Load Ressources for Datepicker Widget */
        initDatepicker: function (timepicker) {
            var self = this;
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.datepicker" + self.minSuffix + ".js" ]);
                if (self.local !== "en") {
                    self.require("i18n/jquery.ui.datepicker-" + self.local + ".min.js");
                }
            }
            if (timepicker) {
                if (!self.loadAtOnce) {
                    self.require([ "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.slider" + self.minSuffix + ".js" ]);
                }
                self.require([ "js/plugins/jquery-ui-timepicker-addon" + self.minSuffix + ".js" ]);
                self.requireCss("themes/jquery-ui-timepicker-addon.css");
                if (self.timeLocal !== "en") {
                    self.require("i18n/jquery-ui-timepicker-" + self.timeLocal + ".js");
                }
            }

        },
        /** Handle the Datepicker Widget */
        datepicker: function ($elem, o) {
            var self = this,
                params = {},
                oat = o.onalw, noms, nom, sos, so;
            self.log('datepicker : ' + o.id);

            $.extend(params, o);


            if (o.onbef) {
                params.beforeShow = function (input, inst) {
                    var $input = $(input),
                        data = {};
                    data.input = input;
                    data.inst = inst;
                    self.publishTopic($input, o.onbef, data);
                    self.publishTopic($input, oat, data);
                };
            }

            if (o.onbeforeshowdaytopics) {
                params.beforeShowDay = function (date) {
                    var data = {};
                    data.date = date;
                    data.returnValue = [true, "", ""];
                    self.publishTopic($elem, o.onbeforeshowdaytopics, data);
                    self.publishTopic($elem, oat, data);
                    return data.returnValue;
                };
            }

            if (o.onchangemonthyeartopics) {
                params.onChangeMonthYear = function (year, month, inst) {
                    var data = {};
                    data.year = year;
                    data.month = month;
                    data.inst = inst;
                    self.publishTopic($elem, o.onchangemonthyeartopics, data);
                    self.publishTopic($elem, oat, data);
                };
            }

            if (o.oncha || o.inline) {
                params.onSelect = function (dateText, inst) {
                    if (o.inline) {
                        $(self.escId(o.id)).val(dateText);
                    }
                    if (o.oncha) {
                        var data = {};
                        data.dateText = dateText;
                        data.inst = inst;
                        self.publishTopic($elem, o.oncha, data);
                        self.publishTopic($elem, oat, data);
                    }
                };
            }

            if (o.oncom) {
                params.onClose = function (dateText, inst) {
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
                    self.require("js/base/jquery.ui.effect" + self.minSuffix + ".js");
                }
            }

            if (o.numberofmonths) {
                noms = o.numberofmonths;
                nom = window[noms];
                if (!nom) {
                    params.numberOfMonths = eval("( " + noms + " )");
                }
            }

            if (o.showoptions) {
                sos = o.showoptions;
                so = window[sos];
                if (!so) {
                    params.showOptions = eval("( " + sos + " )");
                }
            }

            if (o.inline) {
                $elem = $(self.escId(o.id) + '_inline');
            }

            if (o.timepicker) {
                if (o.tponly) {
                    $elem.timepicker(params);
                }
                else {
                    $elem.datetimepicker(params);
                }
                if (o.year !== undefined) {
                    $elem.datetimepicker('setDate', new Date(o.year, o.month, o.day, o.hour, o.minute, o.second));
                }
            }
            else {
                $elem.datepicker(params);
                if (o.year !== undefined) {
                    $elem.val($.datepicker.formatDate(params.dateFormat, new Date(o.year, o.month, o.day)));
                }
            }

            if (o.zindex) {
                $('#ui-datepicker-div').css("z-index", o.zindex);
            }
        },

        /** Handle the Slider Widget */
        slider: function ($elem, o) {
            var self = this,
                data = {};
            self.log('slider : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.slider" + self.minSuffix + ".js" ]);
            }

            o.start = self.pubTops($elem, o.onalw, o.onbef);
            o.change = self.pubTops($elem, o.onalw, o.oncha);
            o.stop = self.pubTops($elem, o.onalw, o.oncom);

            o.slide = function (event, ui) {
                if (o.hiddenid) {
                    if (o.value !== undefined) {
                        $(self.escId(o.hiddenid)).val(ui.value);
                    }
                    if (o.values) {
                        $(self.escId(o.hiddenid)).val(ui.values[0] + "," + ui.values[1]);
                    }
                }
                if (o.displayvalueelement) {
                    if (o.value !== undefined) {
                        $(self.escId(o.displayvalueelement)).html(ui.value);
                    }
                    if (o.values) {
                        $(self.escId(o.displayvalueelement)).html(ui.values[0] + " - " + ui.values[1]);
                    }
                }
                if (o.onslidetopics) {
                    data.event = event;
                    data.ui = ui;

                    self.publishTopic($elem, o.onalw, data);
                    self.publishTopic($elem, o.onslidetopics, data);
                }
            };
            if (o.range && o.range === 'true') {
                o.range = true;
            }

            $elem.slider(o);
        },

        /** Handle the Spinner Widget */
        spinner: function ($elem, o) {
            var self = this;
            self.log('spinner : ' + o.id);
            self.container($elem, o);
            if (!self.loadAtOnce) {
                self.require("js/base/jquery.ui.widget" + self.minSuffix + ".js");
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/base/jquery.ui.spinner" + self.minSuffix + ".js" ]);
            }
            if (o.mouseWheel) {
                self.require("js/plugins/jquery.mousewheel" + self.minSuffix + ".js");
            }

            if (o.oncha) {
                o.change = self.pubTops($elem, o.onalw, o.oncha);
            }

            var currentValue = $elem.val();

            $elem.spinner(o);
            if (o.numberFormat && Globalize) {
                $elem.spinner("value", Globalize.format(parseFloat(currentValue), o.numberFormat));
            }
        },

        /** Handle the Progressbar Widget */
        progressbar: function ($elem, o) {
            var self = this,
                params = {};
            self.log('progressbar : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.progressbar" + self.minSuffix + ".js" ]);
            }
            if (o) {

                params.change = self.pubTops($elem, o.onalw, o.oncha);

                if (o.value > 0) {
                    params.value = o.value;
                }
                else {
                    params.value = 0;
                }
            }
            $elem.progressbar(params);
        },

        /** Handle the Menu Widget */
        menu: function ($elem, o) {
            var self = this,
                params = {};
            self.log('menu : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.menu" + self.minSuffix + ".js" ]);
            }


            $elem.menu(o);
        },

        /** Handle the Menu Item */
        menuItem: function ($elem, o) {
            var self = this;
            self.anchor($elem, o);
        },

        /** Handle the Accordion Widget */
        accordion: function ($elem, o) {
            var self = this,
                data = {},
                active = true,
                aktivItem;
            self.log('accordion : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.accordion" + self.minSuffix + ".js" ]);
            }
            if (!o.header) {
                o.header = 'h3';
            }
            if (o.active) {
                if (o.active === 'true') {
                    o.active = true;
                }
                else if (o.active === 'false') {
                    o.active = false;
                    active = false;
                }
                else {
                    o.active = parseInt(o.active, 10);
                }
            }

            o.beforeActivate = function (event, ui) {
                if (o.href) {
                    if (typeof $(ui.newHeader).find('a').data('keys') !== "undefined") {
                        var keys = $(ui.newHeader).find('a').data('keys').split(','),
                            values = $(ui.newHeader).find('a').data('values').split(','),
                            valueparams = {};
                        $.each(keys, function (i, val) {
                            valueparams[val] = values[i];
                        });
                        ui.newPanel.load(o.href, valueparams, function () {
                        });
                    }
                }
                if (o.onbef) {
                    data.event = event;
                    data.ui = ui;

                    self.publishTopic($elem, o.onalw, data);
                    self.publishTopic($elem, o.onbef, data);
                }
            };

            o.activate = self.pubTops($elem, o.onalw, o.oncha);
            o.create = self.pubTops($elem, o.onalw, o.oncreate);

            $elem.accordion(o);
            if (o.href && active === true) {
                aktivItem = $(self.escId(o.id) + " " + o.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
                if (typeof $(aktivItem).data('keys') !== "undefined") {
                    var keys = $(aktivItem).data('keys').split(','),
                        values = $(aktivItem).data('values').split(','),
                        valueparams = {};
                    $.each(keys, function (i, val) {
                        valueparams[val] = values[i];
                    });
                    $(self.escId(o.id) + " div").filter('.ui-accordion-content-active').load(o.href, valueparams, function () {
                    });
                }
            }
        },

        /** Handle the Accordion Item */
        accordionItem: function ($elem, o) {
            if (o.onclick) {
                $.each(o.onclick.split(','), function (i, topic) {
                    $elem.publishOnEvent('click', topic, o);
                });
            }
        },

        /** Handle the Autocompleter Widget */
        autocompleter: function ($elem, o) {
            var self = this,
                params = {},
                url = '';
            self.log('autocompleter for : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.menu" + self.minSuffix + ".js", "js/base/jquery.ui.autocomplete" + self.minSuffix + ".js" ]);
            }
            if (o.href && o.href !== '#') {
                url = o.href;
                if (o.hrefparameter) {
                    url = url + '?' + o.hrefparameter;
                }
            }
            if (url !== '') {
                if (o.list) {
                    params.source = function (request, response) {
                        var self = $.struts2_jquery;
                        jQuery.ui.autocomplete.prototype._renderItem = function (ul, item) {
                            return $("<li></li>")
                                .data("item.autocomplete", item)
                                .append("<a>" + item.label + "</a>")
                                .appendTo(ul);
                        };

                        self.abortReq(o.id);
                        self.showIndicator(o.indicatorid);
                        self.currentXhr[o.id] = $.ajax({
                            url: self.addForms(o.formids, url),
                            dataType: "json",
                            data: {
                                term: request.term
                            },
                            complete: function (request, status) {
                                self.hideIndicator(o.indicatorid);
                            },
                            success: function (data) {
                                self.currentXhr[o.id] = null;
                                var x = 0,
                                    isMap = false,
                                    result = [];
                                if (data[o.list] !== null) {
                                    if (!$.isArray(data[o.list])) {
                                        isMap = true;
                                    }
                                    $.each(data[o.list], function (j, val) {
                                        if (isMap) {
                                            result.push({
                                                label: val.replace(
                                                    new RegExp(
                                                        "(?![^&;]+;)(?!<[^<>]*)(" +
                                                            $.ui.autocomplete.escapeRegex(request.term) +
                                                            ")(?![^<>]*>)(?![^&;]+;)", "gi"
                                                    ), "<strong>$1</strong>"),
                                                value: val,
                                                key: j
                                            });
                                        }
                                        else {
                                            if (o.listkey !== undefined && o.listvalue !== undefined) {
                                                var label;
                                                if (o.listlabel) {
                                                    label = val[o.listlabel];
                                                }
                                                else {
                                                    label = val[o.listvalue].replace(
                                                        new RegExp(
                                                            "(?![^&;]+;)(?!<[^<>]*)(" +
                                                                $.ui.autocomplete.escapeRegex(request.term) +
                                                                ")(?![^<>]*>)(?![^&;]+;)", "gi"
                                                        ), "<strong>$1</strong>");
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
                                                        ), "<strong>$1</strong>"),
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
                    params.source = self.addForms(o.formids, url);
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
                $elem.keyup(function (e) {
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
            params.select = function (event, ui) {
                if (o.onselecttopics) {
                    params.select = self.pubTops($elem, o.onalw, o.onselecttopics);
                    var data = {};
                    data.event = event;
                    data.ui = ui;

                    self.publishTopic($elem, o.onalw, data);
                    self.publishTopic($elem, o.onselecttopics, data);
                }
                if (ui.item) {
                    if (ui.item.option) {
                        $(self.escId(o.hiddenid)).val(ui.item.option.value);
                    }
                    else if (ui.item.key) {
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
                if (!self.loadAtOnce) {
                    self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
                }
                self.requireCss("themes/s2j-combobox.css");
                self.require([ "js/plugins/jquery.combobox" + self.minSuffix + ".js" ]);
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
        jquerybutton: function ($elem, o) {
            var self = this,
                params = {};
            self.log('button for : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
            }
            if (o.button) {
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
        buttonset: function ($elem, o) {
            var self = this,
                buttonsetLoadTopic = '_s2j_topic_load_' + o.id,
                buttonsetTopic = 's2j_butonset_' + o.id;
            self.log('buttonset for : ' + o.id);
            if (!self.loadAtOnce) {
                self.require([ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
            }

            if (o.href && o.href !== '#') {


                if ($elem.isSubscribed(buttonsetTopic)) {
                    $elem.destroyTopic(buttonsetTopic);
                }

                // Init Buttonset after elements loaded via AJAX.
                $elem.subscribe(buttonsetTopic, function (event, data) {
                    if (o.oncha) {
                        var selectString = self.escId(o.id) + " > input",
                            elements = $(selectString);

                        if (($.support.leadingWhitespace == false) && o.type === 'radio') {
                            elements.click(function () {
                                this.blur();
                                this.focus();
                                $.each(o.oncha.split(','), function (i, cts) {
                                    $elem.publish(cts);
                                });
                            });
                        }
                        else {
                            elements.change(function () {
                                $.each(o.oncha.split(','), function (i, cts) {
                                    $elem.publish(cts);
                                });
                            });
                        }
                    }

                    if (o.buttonset) {
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
                    $(self.escId(o.id) + " > input").change(function () {
                        $.each(o.oncha.split(','), function (i, cts) {
                            $elem.publish(cts);
                        });
                    });
                }

                if (o.buttonset) {
                    $elem.buttonset(o);
                }
            }
        }
    };

    /**
     * handler to open a dialog
     */
    $.subscribeHandler($.struts2_jquery_ui.handler.open_dialog, function (event, data) {
        var s2j = $.struts2_jquery_ui,
            o = $(this).data('s2j_options');
        if (data) {
            if (data.href && data.href !== '#') {
                o.href = data.href;
            }
            if (data.hrefparameter) {
                o.hrefparameter = data.hrefparameter;
            }
            if (data.formids) {
                o.formids = data.formids;
            }
            if (data.opendialogtitle) {
                o.opendialogtitle = data.opendialogtitle;
            }
        }

        $(this).dialog("option", "open", function (event, ui) {
            var data = {},
                divTopic = '_s2j_topic_load_' + o.id;
            data.event = event;
            data.ui = ui;

            if (o.href && o.href !== '#') {
                s2j.subscribeTopics($(this), divTopic, s2j.handler.load, o);
                $(this).publish(divTopic);
            }

            s2j.publishTopic($(this), o.onalw, data);
            s2j.publishTopic($(this), o.onbef, data);
            s2j.publishTopic($(this), o.onopentopics, data);
        });
        if (o.opendialogtitle) {
            $(this).dialog("option", "title", o.opendialogtitle);
        }
        $(this).dialog("open");
    });

    /**
     * handler to close a dialog
     */
    $.subscribeHandler($.struts2_jquery_ui.handler.close_dialog, function (event, data) {
        $(this).dialog('close');
    });

    /**
     * handler to destroy a dialog
     */
    $.subscribeHandler($.struts2_jquery_ui.handler.destroy_dialog, function (event, data) {
        $(this).dialog('destroy');
    });

    // Extend it from orginal plugin
    $.extend(true, $.struts2_jquery_ui, $.struts2_jquery);
    $.struts2_jquery_ui.debugPrefix = "[struts2_jquery_ui] ";

})(jQuery);
