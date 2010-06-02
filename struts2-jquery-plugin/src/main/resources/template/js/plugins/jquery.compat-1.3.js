/*
 * Compatibility Plugin for jQuery 1.3 (on top of jQuery 1.4)
 * All code copied from jQuery 1.4
 * By John Resig
 * Dual licensed under MIT and GPL.
 */

(function(jQuery) {

	// .add() is no longer equivalent to .concat()
	// Results are now returned in document order
	jQuery.fn.add = function( selector, context ) {
		var set = typeof selector === "string" ?
				jQuery( selector, context || this.context ) :
				jQuery.makeArray( selector );

		return this.pushStack( jQuery.merge( this.get(), set ) );
	};
	
	// clone( true ) now copies over all data in addition to
	// the events
	jQuery.fn.clone = function( events ) {
		// Do the clone
		var ret = this.map(function() {
			if ( !jQuery.support.noCloneEvent && !jQuery.isXMLDoc(this) ) {
				// IE copies events bound via attachEvent when
				// using cloneNode. Calling detachEvent on the
				// clone will also remove the events from the orignal
				// In order to get around this, we use innerHTML.
				// Unfortunately, this means some modifications to
				// attributes in IE that are actually only stored
				// as properties will not be copied (such as the
				// the name attribute on an input).
				var html = this.outerHTML, ownerDocument = this.ownerDocument;
				if ( !html ) {
					var div = ownerDocument.createElement("div");
					div.appendChild( this.cloneNode(true) );
					html = div.innerHTML;
				}

				return jQuery.clean([html.replace(/ jQuery\d+="(?:\d+|null)"/g, "")
					.replace(/^\s+/, "")], ownerDocument)[0];
			} else {
				return this.cloneNode(true);
			}
		});

		// Copy the events from the original to the clone
		if ( events === true ) {
			cloneCopyEvent( this, ret );
			cloneCopyEvent( this.find("*"), ret.find("*") );
		}

		// Return the cloned set
		return ret;
	};

	function cloneCopyEvent(orig, ret) {
		var i = 0;

		ret.each(function() {
			if ( this.nodeName !== (orig[i] && orig[i].nodeName) ) {
				return;
			}

			var oldData = jQuery.data( orig[i++] ), events = oldData && oldData.events;

			if ( events ) {
				for ( var type in events ) {
					for ( var handler in events[ type ] ) {
						jQuery.event.add( this, type, events[ type ][ handler ], events[ type ][ handler ].data );
					}
				}
			}
		});
	}
	
	// jQuery.data(elem) no longer returns an ID,
	// returns the data object instead.
	var windowData = {}, uuid = 0;

	jQuery.data = function( elem, name, data ) {
		if ( elem.nodeName && jQuery.noData[elem.nodeName.toLowerCase()] ) {
			return;
		}

		elem = elem == window ?
			windowData :
			elem;

		var id = elem[ jQuery.expando ], cache = jQuery.cache, thisCache;

		// Handle the case where there's no name immediately
		if ( !name && !id ) {
			return null;
		}

		// Compute a unique ID for the element
		if ( !id ) { 
			id = ++uuid;
		}

		// Avoid generating a new cache unless none exists and we
		// want to manipulate it.
		if ( typeof name === "object" ) {
			elem[ jQuery.expando ] = id;
			thisCache = cache[ id ] = jQuery.extend(true, {}, name);
		} else if ( cache[ id ] ) {
			thisCache = cache[ id ];
		} else if ( typeof data === "undefined" ) {
			thisCache = {};
		} else {
			thisCache = cache[ id ] = {};
		}

		// Prevent overriding the named cache with undefined values
		if ( data !== undefined ) {
			elem[ jQuery.expando ] = id;
			thisCache[ name ] = data;
		}

		return typeof name === "string" ? thisCache[ name ] : id;
	};
	
	// jQuery() now returns an empty jQuery set, not jQuery(document)
	
	var oldinit = jQuery.fn.init;
	
	jQuery.fn.init = function( selector ) {
		if ( selector === undefined ) {
			return jQuery( document );
		}
		
		return oldinit.apply( this, arguments );
	};
	
	jQuery.fn.init.prototype = oldinit.prototype;
	
	// .val("...") on radio and checkbox elements was amgiuous,
	// it only selects on value now (which is much less ambiguous)
	var oldval = jQuery.fn.val;
	
	jQuery.fn.val = function( value ) {
		if ( value !== undefined ) {
			var isFunction = jQuery.isFunction(value);

			return this.each(function(i) {
				var self = jQuery(this), val = value;

				if ( this.nodeType !== 1 ) {
					return;
				}

				if ( isFunction ) {
					val = value.call(this, i, self.val());
				}

				// Typecast each time if the value is a Function and the appended
				// value is therefore different each time.
				if ( typeof val === "number" ) {
					val += "";
				}

				if ( jQuery.isArray(val) && rradiocheck.test( this.type ) ) {
					this.checked = jQuery.inArray( self.val(), val ) >= 0 ||
						jQuery.inArray(this.name, value) >= 0;

				} else if ( jQuery.nodeName( this, "select" ) ) {
					var values = jQuery.makeArray(val);

					jQuery( "option", this ).each(function() {
						this.selected = jQuery.inArray( jQuery(this).val(), values ) >= 0 ||
							jQuery.inArray( this.text, values ) >= 0;
					});

					if ( !values.length ) {
						this.selectedIndex = -1;
					}

				} else {
					this.value = val;
				}
			});
		}
		
		return oldval.apply( this, arguments );
	};
	
	// jQuery.browser.version now exclusively matches based upon the rendering engine
	jQuery.browser.version = (navigator.userAgent.toLowerCase().match( /.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ) || [0,'0'])[1];

	// jQuery.ajax() is now strict about JSON input (must follow the spec)
	// Also, it auto-executes scripts that have no dataType and have a content-type of "text/javascript"
	jQuery.httpData = function( xhr, type, s ) {
		var ct = xhr.getResponseHeader("content-type") || "",
			xml = type === "xml" || !type && ct.indexOf("xml") >= 0,
			data = xml ? xhr.responseXML : xhr.responseText;

		if ( xml && data.documentElement.nodeName === "parsererror" ) {
			throw "parsererror";
		}

		// Allow a pre-filtering function to sanitize the response
		// s is checked to keep backwards compatibility
		if ( s && s.dataFilter ) {
			data = s.dataFilter( data, type );
		}

		// The filter can actually parse the response
		if ( typeof data === "string" ) {
			// Get the JavaScript object, if JSON is used.
			if ( type === "json" || !type && ct.indexOf("json") >= 0 ) {
				data = (new Function("return " + data))();
			}
		}

		return data;
	};
	
	// Ajax data is now serialized in the PHP/Rails style be default
	jQuery.ajaxSettings.traditional = true;
	
	// The internal jQuery.className structure has been removed in
	// favor of the traditional jQuery methods
	jQuery.className = {
		add: function ( elem, classNames ) {
			jQuery( elem ).addClass( classNames );
		},
		remove: function( elem, classNames ) {
			jQuery( elem ).removeClass( classNames );
		},
		has: function( elem, className ) {
			jQuery( elem ).hasClass( className );
		}
	};
	
	// jQuery.extend( true, ... ) only works on plain objects and arrays now
	jQuery.extend = jQuery.fn.extend = function() {
		// copy reference to target object
		var target = arguments[0] || {}, i = 1, length = arguments.length, deep = false, options, name, src, copy;

		// Handle a deep copy situation
		if ( typeof target === "boolean" ) {
			deep = target;
			target = arguments[1] || {};
			// skip the boolean and the target
			i = 2;
		}

		// Handle case when target is a string or something (possible in deep copy)
		if ( typeof target !== "object" && !jQuery.isFunction(target) ) {
			target = {};
		}

		// extend jQuery itself if only one argument is passed
		if ( length === i ) {
			target = this;
			--i;
		}

		for ( ; i < length; i++ ) {
			// Only deal with non-null/undefined values
			if ( (options = arguments[ i ]) != null ) {
				// Extend the base object
				for ( name in options ) {
					src = target[ name ];
					copy = options[ name ];

					// Prevent never-ending loop
					if ( target === copy ) {
						continue;
					}

					// Recurse if we're merging object literal values or arrays
					if ( deep && copy && typeof copy === "object" && !copy.nodeType ) {
						target[ name ] = jQuery.extend( deep, 
							// Never move original objects, clone them
							src || ( copy.length != null ? [ ] : { } ), copy );

					// Don't bring in undefined values
					} else if ( copy !== undefined ) {
						target[ name ] = copy;
					}
				}
			}
		}

		// Return the modified object
		return target;
	};
})(jQuery);
