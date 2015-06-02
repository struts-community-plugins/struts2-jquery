;(function($){
    /**
     * jqGrid Chinese (Taiwan) Translation for v4.2
     * linquize
     * https://github.com/linquize/jqGrid
     * Dual licensed under the MIT and GPL licenses:
     * http://www.opensource.org/licenses/mit-license.php
     * http://www.gnu.org/licenses/gpl.html
     *
     **/
    $.jgrid = $.jgrid || {};
    $.extend($.jgrid,{
        defaults : {
            recordtext: "{0} - {1} å…± {2} æ¢�",
            emptyrecords: "æ²’æœ‰è¨˜éŒ„",
            loadtext: "è¼‰å…¥ä¸­...",
            pgtext : " {0} å…± {1} é �",
            pgfirst : "First Page",
            pglast : "Last Page",
            pgnext : "Next Page",
            pgprev : "Previous Page",
            pgrecs : "Records per Page",
            showhide: "Toggle Expand Collapse Grid"
        },
        search : {
            caption: "æ�œå°‹...",
            Find: "æ�œå°‹",
            Reset: "é‡�è¨­",
            odata: [{ oper:'eq', text:"ç­‰æ–¼ "},{ oper:'ne', text:"ä¸�ç­‰æ–¼ "},{ oper:'lt', text:"å°�æ–¼ "},{ oper:'le', text:"å°�æ–¼ç­‰æ–¼ "},{ oper:'gt', text:"å¤§æ–¼ "},{ oper:'ge', text:"å¤§æ–¼ç­‰æ–¼ "},{ oper:'bw', text:"é–‹å§‹æ–¼ "},{ oper:'bn', text:"ä¸�é–‹å§‹æ–¼ "},{ oper:'in', text:"åœ¨å…¶ä¸­ "},{ oper:'ni', text:"ä¸�åœ¨å…¶ä¸­ "},{ oper:'ew', text:"çµ�æ�Ÿæ–¼ "},{ oper:'en', text:"ä¸�çµ�æ�Ÿæ–¼ "},{ oper:'cn', text:"åŒ…å�« "},{ oper:'nc', text:"ä¸�åŒ…å�« "},{ oper:'nu', text:'is null'},{ oper:'nn', text:'is not null'}],
            groupOps: [	{ op: "AND", text: "æ‰€æœ‰" },	{ op: "OR",  text: "ä»»ä¸€" }	],
            operandTitle : "Click to select search operation.",
            resetTitle : "Reset Search Value"
        },
        edit : {
            addCaption: "æ–°å¢žè¨˜éŒ„",
            editCaption: "ç·¨è¼¯è¨˜éŒ„",
            bSubmit: "æ��äº¤",
            bCancel: "å�–æ¶ˆ",
            bClose: "é—œé–‰",
            saveData: "è³‡æ–™å·²æ”¹è®Šï¼Œæ˜¯å�¦å„²å­˜ï¼Ÿ",
            bYes : "æ˜¯",
            bNo : "å�¦",
            bExit : "å�–æ¶ˆ",
            msg: {
                required:"æ­¤æ¬„å¿…è¦�",
                number:"è«‹è¼¸å…¥æœ‰æ•ˆçš„æ•¸å­—",
                minValue:"å€¼å¿…é ˆå¤§æ–¼ç­‰æ–¼ ",
                maxValue:"å€¼å¿…é ˆå°�æ–¼ç­‰æ–¼ ",
                email: "ä¸�æ˜¯æœ‰æ•ˆçš„e-mailåœ°å�€",
                integer: "è«‹è¼¸å…¥æœ‰æ•ˆæ•´æ•°",
                date: "è«‹è¼¸å…¥æœ‰æ•ˆæ™‚é–“",
                url: "ç¶²å�€ç„¡æ•ˆã€‚å‰�ç¶´å¿…é ˆç‚º ('http://' æˆ– 'https://')",
                nodefined : " æœªå®šç¾©ï¼�",
                novalue : " éœ€è¦�å‚³å›žå€¼ï¼�",
                customarray : "è‡ªè¨‚å‡½æ•¸æ‡‰å‚³å›žé™£åˆ—ï¼�",
                customfcheck : "è‡ªè¨‚æª¢æŸ¥æ‡‰æœ‰è‡ªè¨‚å‡½æ•¸ï¼�"

            }
        },
        view : {
            caption: "æŸ¥çœ‹è¨˜éŒ„",
            bClose: "é—œé–‰"
        },
        del : {
            caption: "åˆªé™¤",
            msg: "åˆªé™¤å·²é�¸è¨˜éŒ„ï¼Ÿ",
            bSubmit: "åˆªé™¤",
            bCancel: "å�–æ¶ˆ"
        },
        nav : {
            edittext: "",
            edittitle: "ç·¨è¼¯å·²é�¸åˆ—",
            addtext:"",
            addtitle: "æ–°å¢žåˆ—",
            deltext: "",
            deltitle: "åˆªé™¤å·²é�¸åˆ—",
            searchtext: "",
            searchtitle: "æ�œå°‹è¨˜éŒ„",
            refreshtext: "",
            refreshtitle: "é‡�æ–°æ•´ç�†è¡¨æ ¼",
            alertcap: "è­¦å‘Š",
            alerttext: "è«‹é�¸æ“‡åˆ—",
            viewtext: "",
            viewtitle: "æª¢è¦–å·²é�¸åˆ—"
        },
        col : {
            caption: "é�¸æ“‡æ¬„",
            bSubmit: "ç¢ºå®š",
            bCancel: "å�–æ¶ˆ"
        },
        errors : {
            errcap : "éŒ¯èª¤",
            nourl : "æœªè¨­å®šURL",
            norecords: "ç„¡éœ€è¦�è™•ç�†çš„è¨˜éŒ„",
            model : "colNames å’Œ colModel é•·åº¦ä¸�å�Œï¼�"
        },
        formatter : {
            integer : {thousandsSeparator: " ", defaultValue: '0'},
            number : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0.00'},
            currency : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
            date : {
                dayNames:   [
                    "æ—¥", "ä¸€", "äºŒ", "ä¸‰", "å››", "äº”", "å…­",
                    "æ˜ŸæœŸæ—¥", "æ˜ŸæœŸä¸€", "æ˜ŸæœŸäºŒ", "æ˜ŸæœŸä¸‰", "æ˜ŸæœŸå››", "æ˜ŸæœŸäº”", "æ˜ŸæœŸå…­"
                ],
                monthNames: [
                    "ä¸€", "äºŒ", "ä¸‰", "å››", "äº”", "å…­", "ä¸ƒ", "å…«", "ä¹�", "å��", "å��ä¸€", "å��äºŒ",
                    "ä¸€æœˆ", "äºŒæœˆ", "ä¸‰æœˆ", "å››æœˆ", "äº”æœˆ", "å…­æœˆ", "ä¸ƒæœˆ", "å…«æœˆ", "ä¹�æœˆ", "å��æœˆ", "å��ä¸€æœˆ", "å��äºŒæœˆ"
                ],
                AmPm : ["ä¸Šå�ˆ","ä¸‹å�ˆ","ä¸Šå�ˆ","ä¸‹å�ˆ"],
                S: function (j) {return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th';},
                srcformat: 'Y-m-d',
                newformat: 'm-d-Y',
                parseRe : /[#%\\\/:_;.,\t\s-]/,
                masks : {
                    ISO8601Long:"Y-m-d H:i:s",
                    ISO8601Short:"Y-m-d",
                    ShortDate: "Y/j/n",
                    LongDate: "l, F d, Y",
                    FullDateTime: "l, F d, Y g:i:s A",
                    MonthDay: "F d",
                    ShortTime: "g:i A",
                    LongTime: "g:i:s A",
                    SortableDateTime: "Y-m-d\\TH:i:s",
                    UniversalSortableDateTime: "Y-m-d H:i:sO",
                    YearMonth: "F, Y"
                },
                reformatAfterEdit : false,
                userLocalTime : false
            },
            baseLinkUrl: '',
            showAction: '',
            target: '',
            checkbox : {disabled:true},
            idName : 'id'
        }
    });
})(jQuery);
