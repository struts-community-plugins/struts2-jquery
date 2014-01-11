/*
 Transform a table to a jqGrid.
 Peter Romianowski <peter.romianowski@optivo.de> 
 If the first column of the table contains checkboxes or
 radiobuttons then the jqGrid is made selectable.
 */
// Addition - selector can be a class or id
function tableToGrid(a, b) {
    jQuery(a).each(function () {
        if (this.grid) {
            return
        }
        jQuery(this).width("99%");
        var m = jQuery(this).width();
        var o = jQuery("tr td:first-child input[type=checkbox]:first", jQuery(this));
        var h = jQuery("tr td:first-child input[type=radio]:first", jQuery(this));
        var d = o.length > 0;
        var g = !d && h.length > 0;
        var i = d || g;
        var k = [];
        var n = [];
        jQuery("th", jQuery(this)).each(function () {
            if (k.length === 0 && i) {
                k.push({name: "__selection__", index: "__selection__", width: 0, hidden: true});
                n.push("__selection__")
            } else {
                k.push({name: jQuery(this).attr("id") || jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"), index: jQuery(this).attr("id") || jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"), width: jQuery(this).width() || 150});
                n.push(jQuery(this).html())
            }
        });
        var f = [];
        var e = [];
        var l = [];
        jQuery("tbody > tr", jQuery(this)).each(function () {
            var q = {};
            var p = 0;
            jQuery("td", jQuery(this)).each(function () {
                if (p === 0 && i) {
                    var r = jQuery("input", jQuery(this));
                    var s = r.attr("value");
                    e.push(s || f.length);
                    if (r.is(":checked")) {
                        l.push(s)
                    }
                    q[k[p].name] = r.attr("value")
                } else {
                    q[k[p].name] = jQuery(this).html()
                }
                p++
            });
            if (p > 0) {
                f.push(q)
            }
        });
        jQuery(this).empty();
        jQuery(this).addClass("scroll");
        jQuery(this).jqGrid(jQuery.extend({datatype: "local", width: m, colNames: n, colModel: k, multiselect: d}, b || {}));
        var j;
        for (j = 0; j < f.length; j++) {
            var c = null;
            if (e.length > 0) {
                c = e[j];
                if (c && c.replace) {
                    c = encodeURIComponent(c).replace(/[.\-%]/g, "_")
                }
            }
            if (c === null) {
                c = j + 1
            }
            jQuery(this).jqGrid("addRowData", c, f[j])
        }
        for (j = 0; j < l.length; j++) {
            jQuery(this).jqGrid("setSelection", l[j])
        }
    })
};