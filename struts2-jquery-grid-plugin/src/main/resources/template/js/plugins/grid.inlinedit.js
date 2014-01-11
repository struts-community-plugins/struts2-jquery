/**
 * jqGrid extension for manipulating Grid Data
 * Tony Tomov tony@trirand.com
 * http://trirand.com/blog/
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl-2.0.html
 **/
(function (b) {
    b.jgrid.inlineEdit = b.jgrid.inlineEdit || {};
    b.jgrid.extend({editRow: function (u, a, m, r, v, q, s, p, o) {
        var t = {}, n = b.makeArray(arguments).slice(1);
        if (b.type(n[0]) === "object") {
            t = n[0]
        } else {
            if (a !== undefined) {
                t.keys = a
            }
            if (b.isFunction(m)) {
                t.oneditfunc = m
            }
            if (b.isFunction(r)) {
                t.successfunc = r
            }
            if (v !== undefined) {
                t.url = v
            }
            if (q !== undefined) {
                t.extraparam = q
            }
            if (b.isFunction(s)) {
                t.aftersavefunc = s
            }
            if (b.isFunction(p)) {
                t.errorfunc = p
            }
            if (b.isFunction(o)) {
                t.afterrestorefunc = o
            }
        }
        t = b.extend(true, {keys: false, oneditfunc: null, successfunc: null, url: null, extraparam: {}, aftersavefunc: null, errorfunc: null, afterrestorefunc: null, restoreAfterError: true, mtype: "POST"}, b.jgrid.inlineEdit, t);
        return this.each(function () {
            var e = this, i, d, g, f = 0, j = null, k = {}, h, l, c;
            if (!e.grid) {
                return
            }
            h = b(e).jqGrid("getInd", u, true);
            if (h === false) {
                return
            }
            c = b.isFunction(t.beforeEditRow) ? t.beforeEditRow.call(e, t, u) : undefined;
            if (c === undefined) {
                c = true
            }
            if (!c) {
                return
            }
            g = b(h).attr("editable") || "0";
            if (g === "0" && !b(h).hasClass("not-editable-row")) {
                l = e.p.colModel;
                b('td[role="gridcell"]', h).each(function (E) {
                    i = l[E].name;
                    var F = e.p.treeGrid === true && i === e.p.ExpandColumn;
                    if (F) {
                        d = b("span:first", this).html()
                    } else {
                        try {
                            d = b.unformat.call(e, this, {rowId: u, colModel: l[E]}, E)
                        } catch (D) {
                            d = (l[E].edittype && l[E].edittype === "textarea") ? b(this).text() : b(this).html()
                        }
                    }
                    if (i !== "cb" && i !== "subgrid" && i !== "rn") {
                        if (e.p.autoencode) {
                            d = b.jgrid.htmlDecode(d)
                        }
                        k[i] = d;
                        if (l[E].editable === true) {
                            if (j === null) {
                                j = E
                            }
                            if (F) {
                                b("span:first", this).html("")
                            } else {
                                b(this).html("")
                            }
                            var C = b.extend({}, l[E].editoptions || {}, {id: u + "_" + i, name: i});
                            if (!l[E].edittype) {
                                l[E].edittype = "text"
                            }
                            if (d === "&nbsp;" || d === "&#160;" || (d.length === 1 && d.charCodeAt(0) === 160)) {
                                d = ""
                            }
                            var B = b.jgrid.createEl.call(e, l[E].edittype, C, d, true, b.extend({}, b.jgrid.ajaxOptions, e.p.ajaxSelectOptions || {}));
                            b(B).addClass("editable");
                            if (F) {
                                b("span:first", this).append(B)
                            } else {
                                b(this).append(B)
                            }
                            b.jgrid.bindEv.call(e, B, C);
                            if (l[E].edittype === "select" && l[E].editoptions !== undefined && l[E].editoptions.multiple === true && l[E].editoptions.dataUrl === undefined && b.jgrid.msie) {
                                b(B).width(b(B).width())
                            }
                            f++
                        }
                    }
                });
                if (f > 0) {
                    k.id = u;
                    e.p.savedRow.push(k);
                    b(h).attr("editable", "1");
                    b("td:eq(" + j + ") input", h).focus();
                    if (t.keys === true) {
                        b(h).bind("keydown", function (A) {
                            if (A.keyCode === 27) {
                                b(e).jqGrid("restoreRow", u, t.afterrestorefunc);
                                if (e.p._inlinenav) {
                                    try {
                                        b(e).jqGrid("showAddEditButtons")
                                    } catch (C) {
                                    }
                                }
                                return false
                            }
                            if (A.keyCode === 13) {
                                var B = A.target;
                                if (B.tagName === "TEXTAREA") {
                                    return true
                                }
                                if (b(e).jqGrid("saveRow", u, t)) {
                                    if (e.p._inlinenav) {
                                        try {
                                            b(e).jqGrid("showAddEditButtons")
                                        } catch (D) {
                                        }
                                    }
                                }
                                return false
                            }
                        })
                    }
                    b(e).triggerHandler("jqGridInlineEditRow", [u, t]);
                    if (b.isFunction(t.oneditfunc)) {
                        t.oneditfunc.call(e, u)
                    }
                }
            }
        })
    }, saveRow: function (ab, ae, ag, af, R, U, ak) {
        var ai = b.makeArray(arguments).slice(1), V = {};
        if (b.type(ai[0]) === "object") {
            V = ai[0]
        } else {
            if (b.isFunction(ae)) {
                V.successfunc = ae
            }
            if (ag !== undefined) {
                V.url = ag
            }
            if (af !== undefined) {
                V.extraparam = af
            }
            if (b.isFunction(R)) {
                V.aftersavefunc = R
            }
            if (b.isFunction(U)) {
                V.errorfunc = U
            }
            if (b.isFunction(ak)) {
                V.afterrestorefunc = ak
            }
        }
        V = b.extend(true, {successfunc: null, url: null, extraparam: {}, aftersavefunc: null, errorfunc: null, afterrestorefunc: null, restoreAfterError: true, mtype: "POST"}, b.jgrid.inlineEdit, V);
        var X = false;
        var L = this[0], aj, e = {}, W = {}, Z = {}, T, ac, ah, o;
        if (!L.grid) {
            return X
        }
        o = b(L).jqGrid("getInd", ab, true);
        if (o === false) {
            return X
        }
        var P = b.isFunction(V.beforeSaveRow) ? V.beforeSaveRow.call(L, V, ab) : undefined;
        if (P === undefined) {
            P = true
        }
        if (!P) {
            return
        }
        T = b(o).attr("editable");
        V.url = V.url || L.p.editurl;
        if (T === "1") {
            var O;
            b('td[role="gridcell"]', o).each(function (g) {
                O = L.p.colModel[g];
                aj = O.name;
                if (aj !== "cb" && aj !== "subgrid" && O.editable === true && aj !== "rn" && !b(this).hasClass("not-editable-cell")) {
                    switch (O.edittype) {
                        case"checkbox":
                            var d = ["Yes", "No"];
                            if (O.editoptions) {
                                d = O.editoptions.value.split(":")
                            }
                            e[aj] = b("input", this).is(":checked") ? d[0] : d[1];
                            break;
                        case"text":
                        case"password":
                        case"textarea":
                        case"button":
                            e[aj] = b("input, textarea", this).val();
                            break;
                        case"select":
                            if (!O.editoptions.multiple) {
                                e[aj] = b("select option:selected", this).val();
                                W[aj] = b("select option:selected", this).text()
                            } else {
                                var c = b("select", this), f = [];
                                e[aj] = b(c).val();
                                if (e[aj]) {
                                    e[aj] = e[aj].join(",")
                                } else {
                                    e[aj] = ""
                                }
                                b("select option:selected", this).each(function (l, j) {
                                    f[l] = b(j).text()
                                });
                                W[aj] = f.join(",")
                            }
                            if (O.formatter && O.formatter === "select") {
                                W = {}
                            }
                            break;
                        case"custom":
                            try {
                                if (O.editoptions && b.isFunction(O.editoptions.custom_value)) {
                                    e[aj] = O.editoptions.custom_value.call(L, b(".customelement", this), "get");
                                    if (e[aj] === undefined) {
                                        throw"e2"
                                    }
                                } else {
                                    throw"e1"
                                }
                            } catch (h) {
                                if (h === "e1") {
                                    b.jgrid.info_dialog(b.jgrid.errors.errcap, "function 'custom_value' " + b.jgrid.edit.msg.nodefined, b.jgrid.edit.bClose)
                                }
                                if (h === "e2") {
                                    b.jgrid.info_dialog(b.jgrid.errors.errcap, "function 'custom_value' " + b.jgrid.edit.msg.novalue, b.jgrid.edit.bClose)
                                } else {
                                    b.jgrid.info_dialog(b.jgrid.errors.errcap, h.message, b.jgrid.edit.bClose)
                                }
                            }
                            break
                    }
                    ah = b.jgrid.checkValues.call(L, e[aj], g);
                    if (ah[0] === false) {
                        return false
                    }
                    if (L.p.autoencode) {
                        e[aj] = b.jgrid.htmlEncode(e[aj])
                    }
                    if (V.url !== "clientArray" && O.editoptions && O.editoptions.NullIfEmpty === true) {
                        if (e[aj] === "") {
                            Z[aj] = "null"
                        }
                    }
                }
            });
            if (ah[0] === false) {
                try {
                    var al = b(L).jqGrid("getGridRowById", ab), S = b.jgrid.findPos(al);
                    b.jgrid.info_dialog(b.jgrid.errors.errcap, ah[1], b.jgrid.edit.bClose, {left: S[0], top: S[1] + b(al).outerHeight()})
                } catch (k) {
                    alert(ah[1])
                }
                return X
            }
            var a, N = L.p.prmNames, Y = ab;
            if (L.p.keyIndex === false) {
                a = N.id
            } else {
                a = L.p.colModel[L.p.keyIndex + (L.p.rownumbers === true ? 1 : 0) + (L.p.multiselect === true ? 1 : 0) + (L.p.subGrid === true ? 1 : 0)].name
            }
            if (e) {
                e[N.oper] = N.editoper;
                if (e[a] === undefined || e[a] === "") {
                    e[a] = ab
                } else {
                    if (o.id !== L.p.idPrefix + e[a]) {
                        var i = b.jgrid.stripPref(L.p.idPrefix, ab);
                        if (L.p._index[i] !== undefined) {
                            L.p._index[e[a]] = L.p._index[i];
                            delete L.p._index[i]
                        }
                        ab = L.p.idPrefix + e[a];
                        b(o).attr("id", ab);
                        if (L.p.selrow === Y) {
                            L.p.selrow = ab
                        }
                        if (b.isArray(L.p.selarrrow)) {
                            var M = b.inArray(Y, L.p.selarrrow);
                            if (M >= 0) {
                                L.p.selarrrow[M] = ab
                            }
                        }
                        if (L.p.multiselect) {
                            var ad = "jqg_" + L.p.id + "_" + ab;
                            b("input.cbox", o).attr("id", ad).attr("name", ad)
                        }
                    }
                }
                if (L.p.inlineData === undefined) {
                    L.p.inlineData = {}
                }
                e = b.extend({}, e, L.p.inlineData, V.extraparam)
            }
            if (V.url === "clientArray") {
                e = b.extend({}, e, W);
                if (L.p.autoencode) {
                    b.each(e, function (c, d) {
                        e[c] = b.jgrid.htmlDecode(d)
                    })
                }
                var Q, aa = b(L).jqGrid("setRowData", ab, e);
                b(o).attr("editable", "0");
                for (Q = 0; Q < L.p.savedRow.length; Q++) {
                    if (String(L.p.savedRow[Q].id) === String(Y)) {
                        ac = Q;
                        break
                    }
                }
                if (ac >= 0) {
                    L.p.savedRow.splice(ac, 1)
                }
                b(L).triggerHandler("jqGridInlineAfterSaveRow", [ab, aa, e, V]);
                if (b.isFunction(V.aftersavefunc)) {
                    V.aftersavefunc.call(L, ab, aa, V)
                }
                X = true;
                b(o).removeClass("jqgrid-new-row").unbind("keydown")
            } else {
                b("#lui_" + b.jgrid.jqID(L.p.id)).show();
                Z = b.extend({}, e, Z);
                Z[a] = b.jgrid.stripPref(L.p.idPrefix, Z[a]);
                b.ajax(b.extend({url: V.url, data: b.isFunction(L.p.serializeRowData) ? L.p.serializeRowData.call(L, Z) : Z, type: V.mtype, async: false, complete: function (g, c) {
                    b("#lui_" + b.jgrid.jqID(L.p.id)).hide();
                    if (c === "success") {
                        var d = true, h, f;
                        h = b(L).triggerHandler("jqGridInlineSuccessSaveRow", [g, ab, V]);
                        if (!b.isArray(h)) {
                            h = [true, e]
                        }
                        if (h[0] && b.isFunction(V.successfunc)) {
                            h = V.successfunc.call(L, g)
                        }
                        if (b.isArray(h)) {
                            d = h[0];
                            e = h[1] || e
                        } else {
                            d = h
                        }
                        if (d === true) {
                            if (L.p.autoencode) {
                                b.each(e, function (l, j) {
                                    e[l] = b.jgrid.htmlDecode(j)
                                })
                            }
                            e = b.extend({}, e, W);
                            b(L).jqGrid("setRowData", ab, e);
                            b(o).attr("editable", "0");
                            for (f = 0; f < L.p.savedRow.length; f++) {
                                if (String(L.p.savedRow[f].id) === String(ab)) {
                                    ac = f;
                                    break
                                }
                            }
                            if (ac >= 0) {
                                L.p.savedRow.splice(ac, 1)
                            }
                            b(L).triggerHandler("jqGridInlineAfterSaveRow", [ab, g, e, V]);
                            if (b.isFunction(V.aftersavefunc)) {
                                V.aftersavefunc.call(L, ab, g)
                            }
                            X = true;
                            b(o).removeClass("jqgrid-new-row").unbind("keydown")
                        } else {
                            b(L).triggerHandler("jqGridInlineErrorSaveRow", [ab, g, c, null, V]);
                            if (b.isFunction(V.errorfunc)) {
                                V.errorfunc.call(L, ab, g, c, null)
                            }
                            if (V.restoreAfterError === true) {
                                b(L).jqGrid("restoreRow", ab, V.afterrestorefunc)
                            }
                        }
                    }
                }, error: function (d, g, c) {
                    b("#lui_" + b.jgrid.jqID(L.p.id)).hide();
                    b(L).triggerHandler("jqGridInlineErrorSaveRow", [ab, d, g, c, V]);
                    if (b.isFunction(V.errorfunc)) {
                        V.errorfunc.call(L, ab, d, g, c)
                    } else {
                        var f = d.responseText || d.statusText;
                        try {
                            b.jgrid.info_dialog(b.jgrid.errors.errcap, '<div class="ui-state-error">' + f + "</div>", b.jgrid.edit.bClose, {buttonalign: "right"})
                        } catch (h) {
                            alert(f)
                        }
                    }
                    if (V.restoreAfterError === true) {
                        b(L).jqGrid("restoreRow", ab, V.afterrestorefunc)
                    }
                }}, b.jgrid.ajaxOptions, L.p.ajaxRowOptions || {}))
            }
        }
        return X
    }, restoreRow: function (g, a) {
        var h = b.makeArray(arguments).slice(1), f = {};
        if (b.type(h[0]) === "object") {
            f = h[0]
        } else {
            if (b.isFunction(a)) {
                f.afterrestorefunc = a
            }
        }
        f = b.extend(true, {}, b.jgrid.inlineEdit, f);
        return this.each(function () {
            var c = this, p, n, d = {}, o;
            if (!c.grid) {
                return
            }
            n = b(c).jqGrid("getInd", g, true);
            if (n === false) {
                return
            }
            var e = b.isFunction(f.beforeCancelRow) ? f.beforeCancelRow.call(c, cancelPrm, sr) : undefined;
            if (e === undefined) {
                e = true
            }
            if (!e) {
                return
            }
            for (o = 0; o < c.p.savedRow.length; o++) {
                if (String(c.p.savedRow[o].id) === String(g)) {
                    p = o;
                    break
                }
            }
            if (p >= 0) {
                if (b.isFunction(b.fn.datepicker)) {
                    try {
                        b("input.hasDatepicker", "#" + b.jgrid.jqID(n.id)).datepicker("hide")
                    } catch (k) {
                    }
                }
                b.each(c.p.colModel, function () {
                    if (this.editable === true && c.p.savedRow[p].hasOwnProperty(this.name)) {
                        d[this.name] = c.p.savedRow[p][this.name]
                    }
                });
                b(c).jqGrid("setRowData", g, d);
                b(n).attr("editable", "0").unbind("keydown");
                c.p.savedRow.splice(p, 1);
                if (b("#" + b.jgrid.jqID(g), "#" + b.jgrid.jqID(c.p.id)).hasClass("jqgrid-new-row")) {
                    setTimeout(function () {
                        b(c).jqGrid("delRowData", g);
                        b(c).jqGrid("showAddEditButtons")
                    }, 0)
                }
            }
            b(c).triggerHandler("jqGridInlineAfterRestoreRow", [g]);
            if (b.isFunction(f.afterrestorefunc)) {
                f.afterrestorefunc.call(c, g)
            }
        })
    }, addRow: function (a) {
        a = b.extend(true, {rowID: null, initdata: {}, position: "first", useDefValues: true, useFormatter: false, addRowParams: {extraparam: {}}}, a || {});
        return this.each(function () {
            if (!this.grid) {
                return
            }
            var g = this;
            var j = b.isFunction(a.beforeAddRow) ? a.beforeAddRow.call(g, a.addRowParams) : undefined;
            if (j === undefined) {
                j = true
            }
            if (!j) {
                return
            }
            a.rowID = b.isFunction(a.rowID) ? a.rowID.call(g, a) : ((a.rowID != null) ? a.rowID : b.jgrid.randId());
            if (a.useDefValues === true) {
                b(g.p.colModel).each(function () {
                    if (this.editoptions && this.editoptions.defaultValue) {
                        var c = this.editoptions.defaultValue, d = b.isFunction(c) ? c.call(g) : c;
                        a.initdata[this.name] = d
                    }
                })
            }
            b(g).jqGrid("addRowData", a.rowID, a.initdata, a.position);
            a.rowID = g.p.idPrefix + a.rowID;
            b("#" + b.jgrid.jqID(a.rowID), "#" + b.jgrid.jqID(g.p.id)).addClass("jqgrid-new-row");
            if (a.useFormatter) {
                b("#" + b.jgrid.jqID(a.rowID) + " .ui-inline-edit", "#" + b.jgrid.jqID(g.p.id)).click()
            } else {
                var i = g.p.prmNames, h = i.oper;
                a.addRowParams.extraparam[h] = i.addoper;
                b(g).jqGrid("editRow", a.rowID, a.addRowParams);
                b(g).jqGrid("setSelection", a.rowID)
            }
        })
    }, inlineNav: function (a, d) {
        d = b.extend(true, {edit: true, editicon: "ui-icon-pencil", add: true, addicon: "ui-icon-plus", save: true, saveicon: "ui-icon-disk", cancel: true, cancelicon: "ui-icon-cancel", addParams: {addRowParams: {extraparam: {}}}, editParams: {}, restoreAfterSelect: true}, b.jgrid.nav, d || {});
        return this.each(function () {
            if (!this.grid) {
                return
            }
            var c = this, o, l = b.jgrid.jqID(c.p.id);
            c.p._inlinenav = true;
            if (d.addParams.useFormatter === true) {
                var p = c.p.colModel, m;
                for (m = 0; m < p.length; m++) {
                    if (p[m].formatter && p[m].formatter === "actions") {
                        if (p[m].formatoptions) {
                            var i = {keys: false, onEdit: null, onSuccess: null, afterSave: null, onError: null, afterRestore: null, extraparam: {}, url: null}, n = b.extend(i, p[m].formatoptions);
                            d.addParams.addRowParams = {keys: n.keys, oneditfunc: n.onEdit, successfunc: n.onSuccess, url: n.url, extraparam: n.extraparam, aftersavefunc: n.afterSave, errorfunc: n.onError, afterrestorefunc: n.afterRestore}
                        }
                        break
                    }
                }
            }
            if (d.add) {
                b(c).jqGrid("navButtonAdd", a, {caption: d.addtext, title: d.addtitle, buttonicon: d.addicon, id: c.p.id + "_iladd", onClickButton: function () {
                    b(c).jqGrid("addRow", d.addParams);
                    if (!d.addParams.useFormatter) {
                        b("#" + l + "_ilsave").removeClass("ui-state-disabled");
                        b("#" + l + "_ilcancel").removeClass("ui-state-disabled");
                        b("#" + l + "_iladd").addClass("ui-state-disabled");
                        b("#" + l + "_iledit").addClass("ui-state-disabled")
                    }
                }})
            }
            if (d.edit) {
                b(c).jqGrid("navButtonAdd", a, {caption: d.edittext, title: d.edittitle, buttonicon: d.editicon, id: c.p.id + "_iledit", onClickButton: function () {
                    var e = b(c).jqGrid("getGridParam", "selrow");
                    if (e) {
                        b(c).jqGrid("editRow", e, d.editParams);
                        b("#" + l + "_ilsave").removeClass("ui-state-disabled");
                        b("#" + l + "_ilcancel").removeClass("ui-state-disabled");
                        b("#" + l + "_iladd").addClass("ui-state-disabled");
                        b("#" + l + "_iledit").addClass("ui-state-disabled")
                    } else {
                        b.jgrid.viewModal("#alertmod", {gbox: "#gbox_" + l, jqm: true});
                        b("#jqg_alrt").focus()
                    }
                }})
            }
            if (d.save) {
                b(c).jqGrid("navButtonAdd", a, {caption: d.savetext || "", title: d.savetitle || "Save row", buttonicon: d.saveicon, id: c.p.id + "_ilsave", onClickButton: function () {
                    var f = c.p.savedRow[0].id;
                    if (f) {
                        var g = c.p.prmNames, h = g.oper, e = {};
                        if (b("#" + b.jgrid.jqID(f), "#" + l).hasClass("jqgrid-new-row")) {
                            d.addParams.addRowParams.extraparam[h] = g.addoper;
                            e = d.addParams.addRowParams
                        } else {
                            if (!d.editParams.extraparam) {
                                d.editParams.extraparam = {}
                            }
                            d.editParams.extraparam[h] = g.editoper;
                            e = d.editParams
                        }
                        if (b(c).jqGrid("saveRow", f, e)) {
                            b(c).jqGrid("showAddEditButtons")
                        }
                    } else {
                        b.jgrid.viewModal("#alertmod", {gbox: "#gbox_" + l, jqm: true});
                        b("#jqg_alrt").focus()
                    }
                }});
                b("#" + l + "_ilsave").addClass("ui-state-disabled")
            }
            if (d.cancel) {
                b(c).jqGrid("navButtonAdd", a, {caption: d.canceltext || "", title: d.canceltitle || "Cancel row editing", buttonicon: d.cancelicon, id: c.p.id + "_ilcancel", onClickButton: function () {
                    var e = c.p.savedRow[0].id, f = {};
                    if (e) {
                        if (b("#" + b.jgrid.jqID(e), "#" + l).hasClass("jqgrid-new-row")) {
                            f = d.addParams.addRowParams
                        } else {
                            f = d.editParams
                        }
                        b(c).jqGrid("restoreRow", e, f);
                        b(c).jqGrid("showAddEditButtons")
                    } else {
                        b.jgrid.viewModal("#alertmod", {gbox: "#gbox_" + l, jqm: true});
                        b("#jqg_alrt").focus()
                    }
                }});
                b("#" + l + "_ilcancel").addClass("ui-state-disabled")
            }
            if (d.restoreAfterSelect === true) {
                if (b.isFunction(c.p.beforeSelectRow)) {
                    o = c.p.beforeSelectRow
                } else {
                    o = false
                }
                c.p.beforeSelectRow = function (e, f) {
                    var g = true;
                    if (c.p.savedRow.length > 0 && c.p._inlinenav === true && (e !== c.p.selrow && c.p.selrow !== null)) {
                        if (c.p.selrow === d.addParams.rowID) {
                            b(c).jqGrid("delRowData", c.p.selrow)
                        } else {
                            b(c).jqGrid("restoreRow", c.p.selrow, d.editParams)
                        }
                        b(c).jqGrid("showAddEditButtons")
                    }
                    if (o) {
                        g = o.call(c, e, f)
                    }
                    return g
                }
            }
        })
    }, showAddEditButtons: function () {
        return this.each(function () {
            if (!this.grid) {
                return
            }
            var a = b.jgrid.jqID(this.p.id);
            b("#" + a + "_ilsave").addClass("ui-state-disabled");
            b("#" + a + "_ilcancel").addClass("ui-state-disabled");
            b("#" + a + "_iladd").removeClass("ui-state-disabled");
            b("#" + a + "_iledit").removeClass("ui-state-disabled")
        })
    }})
})(jQuery);
