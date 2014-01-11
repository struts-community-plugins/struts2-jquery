// Grouping module
(function (a) {
    a.extend(a.jgrid, {template: function (e) {
        var c = a.makeArray(arguments).slice(1), b, d = c.length;
        if (e == null) {
            e = ""
        }
        return e.replace(/\{([\w\-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g, function (f, j) {
            if (!isNaN(parseInt(j, 10))) {
                return c[parseInt(j, 10)]
            }
            for (b = 0; b < d; b++) {
                if (a.isArray(c[b])) {
                    var h = c[b], g = h.length;
                    while (g--) {
                        if (j === h[g].nm) {
                            return h[g].v
                        }
                    }
                }
            }
        })
    }});
    a.jgrid.extend({groupingSetup: function () {
        return this.each(function () {
            var g = this, e, d, f, c = g.p.colModel, b = g.p.groupingView;
            if (b !== null && ((typeof b === "object") || a.isFunction(b))) {
                if (!b.groupField.length) {
                    g.p.grouping = false
                } else {
                    if (b.visibiltyOnNextGrouping === undefined) {
                        b.visibiltyOnNextGrouping = []
                    }
                    b.lastvalues = [];
                    b.groups = [];
                    b.counters = [];
                    for (e = 0; e < b.groupField.length; e++) {
                        if (!b.groupOrder[e]) {
                            b.groupOrder[e] = "asc"
                        }
                        if (!b.groupText[e]) {
                            b.groupText[e] = "{0}"
                        }
                        if (typeof b.groupColumnShow[e] !== "boolean") {
                            b.groupColumnShow[e] = true
                        }
                        if (typeof b.groupSummary[e] !== "boolean") {
                            b.groupSummary[e] = false
                        }
                        if (b.groupColumnShow[e] === true) {
                            b.visibiltyOnNextGrouping[e] = true;
                            a(g).jqGrid("showCol", b.groupField[e])
                        } else {
                            b.visibiltyOnNextGrouping[e] = a("#" + a.jgrid.jqID(g.p.id + "_" + b.groupField[e])).is(":visible");
                            a(g).jqGrid("hideCol", b.groupField[e])
                        }
                    }
                    b.summary = [];
                    for (d = 0, f = c.length; d < f; d++) {
                        if (c[d].summaryType) {
                            if (c[d].summaryDivider) {
                                b.summary.push({nm: c[d].name, st: c[d].summaryType, v: "", sd: c[d].summaryDivider, vd: "", sr: c[d].summaryRound, srt: c[d].summaryRoundType || "round"})
                            } else {
                                b.summary.push({nm: c[d].name, st: c[d].summaryType, v: "", sr: c[d].summaryRound, srt: c[d].summaryRoundType || "round"})
                            }
                        }
                    }
                }
            } else {
                g.p.grouping = false
            }
        })
    }, groupingPrepare: function (d, e, b, c) {
        this.each(function () {
            var n = this.p.groupingView, g = this, h, m = n.groupField.length, o, l, k, j, f = 0;
            for (h = 0; h < m; h++) {
                o = n.groupField[h];
                k = n.displayField[h];
                l = b[o];
                j = k == null ? null : b[k];
                if (j == null) {
                    j = l
                }
                if (l !== undefined) {
                    if (c === 0) {
                        n.groups.push({idx: h, dataIndex: o, value: l, displayValue: j, startRow: c, cnt: 1, summary: []});
                        n.lastvalues[h] = l;
                        n.counters[h] = {cnt: 1, pos: n.groups.length - 1, summary: a.extend(true, [], n.summary)};
                        a.each(n.counters[h].summary, function () {
                            if (a.isFunction(this.st)) {
                                this.v = this.st.call(g, this.v, this.nm, b)
                            } else {
                                this.v = a(g).jqGrid("groupingCalculations.handler", this.st, this.v, this.nm, this.sr, this.srt, b);
                                if (this.st.toLowerCase() === "avg" && this.sd) {
                                    this.vd = a(g).jqGrid("groupingCalculations.handler", this.st, this.vd, this.sd, this.sr, this.srt, b)
                                }
                            }
                        });
                        n.groups[n.counters[h].pos].summary = n.counters[h].summary
                    } else {
                        if (typeof l !== "object" && (a.isArray(n.isInTheSameGroup) && a.isFunction(n.isInTheSameGroup[h]) ? !n.isInTheSameGroup[h].call(g, n.lastvalues[h], l, h, n) : n.lastvalues[h] !== l)) {
                            n.groups.push({idx: h, dataIndex: o, value: l, displayValue: j, startRow: c, cnt: 1, summary: []});
                            n.lastvalues[h] = l;
                            f = 1;
                            n.counters[h] = {cnt: 1, pos: n.groups.length - 1, summary: a.extend(true, [], n.summary)};
                            a.each(n.counters[h].summary, function () {
                                if (a.isFunction(this.st)) {
                                    this.v = this.st.call(g, this.v, this.nm, b)
                                } else {
                                    this.v = a(g).jqGrid("groupingCalculations.handler", this.st, this.v, this.nm, this.sr, this.srt, b);
                                    if (this.st.toLowerCase() === "avg" && this.sd) {
                                        this.vd = a(g).jqGrid("groupingCalculations.handler", this.st, this.vd, this.sd, this.sr, this.srt, b)
                                    }
                                }
                            });
                            n.groups[n.counters[h].pos].summary = n.counters[h].summary
                        } else {
                            if (f === 1) {
                                n.groups.push({idx: h, dataIndex: o, value: l, displayValue: j, startRow: c, cnt: 1, summary: []});
                                n.lastvalues[h] = l;
                                n.counters[h] = {cnt: 1, pos: n.groups.length - 1, summary: a.extend(true, [], n.summary)};
                                a.each(n.counters[h].summary, function () {
                                    if (a.isFunction(this.st)) {
                                        this.v = this.st.call(g, this.v, this.nm, b)
                                    } else {
                                        this.v = a(g).jqGrid("groupingCalculations.handler", this.st, this.v, this.nm, this.sr, this.srt, b);
                                        if (this.st.toLowerCase() === "avg" && this.sd) {
                                            this.vd = a(g).jqGrid("groupingCalculations.handler", this.st, this.vd, this.sd, this.sr, this.srt, b)
                                        }
                                    }
                                });
                                n.groups[n.counters[h].pos].summary = n.counters[h].summary
                            } else {
                                n.counters[h].cnt += 1;
                                n.groups[n.counters[h].pos].cnt = n.counters[h].cnt;
                                a.each(n.counters[h].summary, function () {
                                    if (a.isFunction(this.st)) {
                                        this.v = this.st.call(g, this.v, this.nm, b)
                                    } else {
                                        this.v = a(g).jqGrid("groupingCalculations.handler", this.st, this.v, this.nm, this.sr, this.srt, b);
                                        if (this.st.toLowerCase() === "avg" && this.sd) {
                                            this.vd = a(g).jqGrid("groupingCalculations.handler", this.st, this.vd, this.sd, this.sr, this.srt, b)
                                        }
                                    }
                                });
                                n.groups[n.counters[h].pos].summary = n.counters[h].summary
                            }
                        }
                    }
                }
            }
            e.push(d)
        });
        return e
    }, groupingToggle: function (b) {
        this.each(function () {
            var i = this, p = i.p.groupingView, e = b.split("_"), k = parseInt(e[e.length - 2], 10);
            e.splice(e.length - 2, 2);
            var n = e.join("_"), g = p.minusicon, m = p.plusicon, l = a("#" + a.jgrid.jqID(b)), c = l.length ? l[0].nextSibling : null, o = a("#" + a.jgrid.jqID(b) + " span.tree-wrap-" + i.p.direction), q = function (r) {
                var s = a.map(r.split(" "), function (t) {
                    if (t.substring(0, n.length + 1) === n + "_") {
                        return parseInt(t.substring(n.length + 1), 10)
                    }
                });
                return s.length > 0 ? s[0] : undefined
            }, j, d, h = false;
            if (o.hasClass(g)) {
                if (p.showSummaryOnHide) {
                    if (c) {
                        while (c) {
                            if (a(c).hasClass("jqfoot")) {
                                var f = parseInt(a(c).attr("jqfootlevel"), 10);
                                if (f <= k) {
                                    break
                                }
                            }
                            a(c).hide();
                            c = c.nextSibling
                        }
                    }
                } else {
                    if (c) {
                        while (c) {
                            j = q(c.className);
                            if (j !== undefined && j <= k) {
                                break
                            }
                            a(c).hide();
                            c = c.nextSibling
                        }
                    }
                }
                o.removeClass(g).addClass(m);
                h = true
            } else {
                if (c) {
                    d = undefined;
                    while (c) {
                        j = q(c.className);
                        if (d === undefined) {
                            d = j === undefined
                        }
                        if (j !== undefined) {
                            if (j <= k) {
                                break
                            }
                            if (j === k + 1) {
                                a(c).show().find(">td>span.tree-wrap-" + i.p.direction).removeClass(g).addClass(m)
                            }
                        } else {
                            if (d) {
                                a(c).show()
                            }
                        }
                        c = c.nextSibling
                    }
                }
                o.removeClass(m).addClass(g)
            }
            a(i).triggerHandler("jqGridGroupingClickGroup", [b, h]);
            if (a.isFunction(i.p.onClickGroup)) {
                i.p.onClickGroup.call(i, b, h)
            }
        });
        return false
    }, groupingRender: function (b, c) {
        return this.each(function () {
            var f = this, o = f.p.groupingView, j = "", k = "", l, n, h = o.groupCollapse ? o.plusicon : o.minusicon, d, i = [], g = o.groupField.length;
            h += " tree-wrap-" + f.p.direction;
            a.each(f.p.colModel, function (q, s) {
                var r;
                for (r = 0; r < g; r++) {
                    if (o.groupField[r] === s.name) {
                        i[r] = q;
                        break
                    }
                }
            });
            var e = 0;

            function p(t, u, q) {
                var r = false, s;
                if (u === 0) {
                    r = q[t]
                } else {
                    var v = q[t].idx;
                    if (v === 0) {
                        r = q[t]
                    } else {
                        for (s = t; s >= 0; s--) {
                            if (q[s].idx === v - u) {
                                r = q[s];
                                break
                            }
                        }
                    }
                }
                return r
            }

            var m = a.makeArray(o.groupSummary);
            m.reverse();
            a.each(o.groups, function (v, s) {
                e++;
                n = f.p.id + "ghead_" + s.idx;
                l = n + "_" + v;
                k = "<span style='cursor:pointer;' class='ui-icon " + h + "' onclick=\"jQuery('#" + a.jgrid.jqID(f.p.id) + "').jqGrid('groupingToggle','" + l + "');return false;\"></span>";
                try {
                    if (a.isArray(o.formatDisplayField) && a.isFunction(o.formatDisplayField[s.idx])) {
                        s.displayValue = o.formatDisplayField[s.idx].call(f, s.displayValue, s.value, f.p.colModel[i[s.idx]], s.idx, o);
                        d = s.displayValue
                    } else {
                        d = f.formatter(l, s.displayValue, i[s.idx], s.value)
                    }
                } catch (G) {
                    d = s.displayValue
                }
                j += '<tr id="' + l + '"' + (o.groupCollapse && s.idx > 0 ? ' style="display:none;" ' : " ") + 'role="row" class= "ui-widget-content jqgroup ui-row-' + f.p.direction + " " + n + '"><td style="padding-left:' + (s.idx * 12) + 'px;" colspan="' + c + '">' + k + a.jgrid.template(o.groupText[s.idx], d, s.cnt, s.summary) + "</td></tr>";
                var y = g - 1 === s.idx;
                if (y) {
                    var z = o.groups[v + 1], u, r, D;
                    var t = z !== undefined ? o.groups[v + 1].startRow : b.length;
                    for (r = s.startRow; r < t; r++) {
                        j += b[r].join("")
                    }
                    var w;
                    if (z !== undefined) {
                        for (w = 0; w < o.groupField.length; w++) {
                            if (z.dataIndex === o.groupField[w]) {
                                break
                            }
                        }
                        e = o.groupField.length - w
                    }
                    for (D = 0; D < e; D++) {
                        if (!m[D]) {
                            continue
                        }
                        var A = "";
                        if (o.groupCollapse && !o.showSummaryOnHide) {
                            A = ' style="display:none;"'
                        }
                        j += "<tr" + A + ' jqfootlevel="' + (s.idx - D) + '" role="row" class="ui-widget-content jqfoot ui-row-' + f.p.direction + '">';
                        var x = p(v, D, o.groups), C = f.p.colModel, B, E = x.cnt;
                        for (u = 0; u < c; u++) {
                            var q = "<td " + f.formatCol(u, 1, "") + ">&#160;</td>", F = "{0}";
                            a.each(x.summary, function () {
                                if (this.nm === C[u].name) {
                                    if (C[u].summaryTpl) {
                                        F = C[u].summaryTpl
                                    }
                                    if (typeof this.st === "string" && this.st.toLowerCase() === "avg") {
                                        if (this.sd && this.vd) {
                                            this.v = (this.v / this.vd)
                                        } else {
                                            if (this.v && E > 0) {
                                                this.v = (this.v / E)
                                            }
                                        }
                                    }
                                    try {
                                        B = f.formatter("", this.v, u, this)
                                    } catch (H) {
                                        B = this.v
                                    }
                                    q = "<td " + f.formatCol(u, 1, "") + ">" + a.jgrid.format(F, B) + "</td>";
                                    return false
                                }
                            });
                            j += q
                        }
                        j += "</tr>"
                    }
                    e = w
                }
            });
            a("#" + a.jgrid.jqID(f.p.id) + " tbody:first").append(j);
            j = null
        })
    }, groupingGroupBy: function (c, b) {
        return this.each(function () {
            var f = this;
            if (typeof c === "string") {
                c = [c]
            }
            var d = f.p.groupingView;
            f.p.grouping = true;
            if (d.visibiltyOnNextGrouping === undefined) {
                d.visibiltyOnNextGrouping = []
            }
            var e;
            for (e = 0; e < d.groupField.length; e++) {
                if (!d.groupColumnShow[e] && d.visibiltyOnNextGrouping[e]) {
                    a(f).jqGrid("showCol", d.groupField[e])
                }
            }
            for (e = 0; e < c.length; e++) {
                d.visibiltyOnNextGrouping[e] = a("#" + a.jgrid.jqID(f.p.id) + "_" + a.jgrid.jqID(c[e])).is(":visible")
            }
            f.p.groupingView = a.extend(f.p.groupingView, b || {});
            d.groupField = c;
            a(f).trigger("reloadGrid")
        })
    }, groupingRemove: function (b) {
        return this.each(function () {
            var e = this;
            if (b === undefined) {
                b = true
            }
            e.p.grouping = false;
            if (b === true) {
                var c = e.p.groupingView, d;
                for (d = 0; d < c.groupField.length; d++) {
                    if (!c.groupColumnShow[d] && c.visibiltyOnNextGrouping[d]) {
                        a(e).jqGrid("showCol", c.groupField)
                    }
                }
                a("tr.jqgroup, tr.jqfoot", "#" + a.jgrid.jqID(e.p.id) + " tbody:first").remove();
                a("tr.jqgrow:hidden", "#" + a.jgrid.jqID(e.p.id) + " tbody:first").show()
            } else {
                a(e).trigger("reloadGrid")
            }
        })
    }, groupingCalculations: {handler: function (f, i, g, j, h, b) {
        var c = {sum: function () {
            return parseFloat(i || 0) + parseFloat((b[g] || 0))
        }, min: function () {
            if (i === "") {
                return parseFloat(b[g] || 0)
            }
            return Math.min(parseFloat(i), parseFloat(b[g] || 0))
        }, max: function () {
            if (i === "") {
                return parseFloat(b[g] || 0)
            }
            return Math.max(parseFloat(i), parseFloat(b[g] || 0))
        }, count: function () {
            if (i === "") {
                i = 0
            }
            if (b.hasOwnProperty(g)) {
                return i + 1
            }
            return 0
        }, avg: function () {
            return c.sum()
        }};
        if (!c[f]) {
            throw ("jqGrid Grouping No such method: " + f)
        }
        var e = c[f]();
        if (j != null) {
            if (h === "fixed") {
                e = e.toFixed(j)
            } else {
                var d = Math.pow(10, j);
                e = Math.round(e * d) / d
            }
        }
        return e
    }}})
})(jQuery);