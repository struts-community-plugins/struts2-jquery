// Inspired from jquery UI Combobox Example
(function( $ ) {
    $.widget( "s2j.combobox", {
        options: {
            icon:  false
        },
        _create: function() {
            this.wrapper = $( "<span>" )
                .addClass( "s2j-combobox" )
                .insertAfter( this.element );
            this.element.hide();
            this._createAutocomplete();
            if(this.options.icon === true){
                this._createShowAllButton();
            }
        },
        _createAutocomplete: function() {
            var self = this.element;
            var selected = this.element.children( ":selected" ),
                value = selected.val() ? selected.text() : "";
            this.input = $( "<input>" )
                .appendTo( this.wrapper )
                .val( value )
                .attr( "title", "" )
                .addClass( "s2j-combobox-input" )
                .autocomplete({
                    delay: 0,
                    minLength: 0,
                    source: $.proxy( this, "_source" )
                });
            this._on( this.input, {
                autocompleteselect: function( event, ui ) {
                    ui.item.option.selected = true;
                    this._trigger( "select", event, {
                        item: ui.item.option
                    });
                    event.ui = ui;
                    if(this.options.onselecttopics) {
                        $.each(this.options.onselecttopics.split(','), function(i, sts) {
                            self.publish(sts, { item: ui.item }, event);
                        });
                    }
                },
                autocompletefocus: function( event, ui ) {
                    this._trigger( "focus", event, { item: ui.item } )
                    event.ui = ui;
                    if(this.options.onfocustopics ) {
                        $.each(this.options.onfocustopics .split(','), function(i, fts) {
                            self.publish(fts, { item: ui.item }, event);
                        });
                    }
                },
                autocompletechange: function( event, ui ) {
                    this._removeIfInvalid(event, ui);
                    if ( !ui.item ) {
                        var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
                            valid = false;
                        self.children( "option" ).each(function() {
                            if ( this.value.match( matcher ) ) {
                                this.selected = valid = true;
                                return false;
                            }
                        });
                        if ( !valid ) {
                            // remove invalid value, as it didn't match anything
                            $( this ).val( "" );
                            self.val( "" );
                            return false;
                        }
                    }
                    this._trigger( "change", event, { item: ui.item } );
                    event.ui = ui;
                    if(this.options.oncha) {
                        $.each(this.options.oncha.split(','), function(i, cts) {
                            self.publish(cts, { item: ui.item }, event);
                        });
                    }
                }
            });
        },
        _createShowAllButton: function() {
            var input = this.input,
                wasOpen = false;
            $( "<a>" )
                .attr( "tabIndex", -1 )
                .appendTo( this.wrapper )
                .button({
                    icons: {
                        primary: "ui-icon-triangle-1-s"
                    },
                    text: false
                })
                .removeClass( "ui-corner-all" )
                .addClass( "s2j-combobox-toggle ui-corner-right" )
                .mousedown(function() {
                    wasOpen = input.autocomplete( "widget" ).is( ":visible" );
                })
                .click(function() {
                    input.focus();
// Close if already visible
                    if ( wasOpen ) {
                        return;
                    }
// Pass empty string as value to search for, displaying all results
                    input.autocomplete( "search", "" );
                });
        },
        _source: function( request, response ) {
            var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
            response( this.element.children( "option" ).map(function() {
                var text = $( this ).text();
                if ( this.value && ( !request.term || matcher.test(text) ) )
                    return {
                        label: text,
                        value: text,
                        option: this
                    };
            }) );
        },
        _removeIfInvalid: function( event, ui ) {
// Selected an item, nothing to do
            if ( ui.item ) {
                return;
            }
// Search for a match (case-insensitive)
            var value = this.input.val(),
                valueLowerCase = value.toLowerCase(),
                valid = false;
            this.element.children( "option" ).each(function() {
                if ( $( this ).text().toLowerCase() === valueLowerCase ) {
                    this.selected = valid = true;
                    return false;
                }
            });
// Found a match, nothing to do
            if ( valid ) {
                return;
            }
// Remove invalid value
            this.input
                .val( "" );
            this.element.val( "" );
            this.input.data( "ui-autocomplete" ).term = "";
        },
        _destroy: function() {
            this.wrapper.remove();
            this.element.show();
        }
    });
})( jQuery );