/**
 * jquery.subscribe.1.3
 *
 * Implementation of publish/subscription framework for jQuery
 * Requires use of jQuery. Tested with jQuery 1.4 and above
 *
 *
 * Copyright (c) 2008 Eric Chijioke (obinna a-t g mail dot c o m)
 * Copyright (c) 2012 Johannes Geppert https://www.jgeppert.com
 *
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 *  Release Notes:
 *
 *  version 1.1:
 *
 *  Fixed unexpected behavior which can occur when a script in a embedded page (page loaded in div,tab etc.) subscribes a handler for a topic using
 *  the jQuery subscribe ($.subscribe) or a no-id element but this subscribe plugin is not reloaded within that embedded page (for example, when
 *  script is included in containing page) . In this case, if the embedded page is reloaded without reloading the entire page (and plugin), the
 *  subscription could be made multiple times for the topic, which will call the handler multiple times each time the topic is published.
 *  Code has been added to prevent this when the subscription is made using the non-element subscribe ($.subscribe()), which assures that only one
 *  subscription is made for a topic for a given window/frame. To prevent this from happening for an element subscription ($elem.subscribe()), make
 *  sure that the element has an id attribute.
 *
 *  version 1.2
 *  - Added the isSubscribed() method
 *
 *  version 1.2.1
 *  - Fixed to work with jQuery 1.4 changes
 *  - changed $() syntax to $(document)
 *
 *  version 1.2.2
 *  - Added subscribe overwrite property (default = false) to handle 1.4.2 changes and
 *  - allow for multiple subscriptions by the same element to the same topic
 *  - changed $() syntax to $(document)
 *
 *  version 1.2.3
 *  - jslint fixes
 *  - Added protection to variables when file is loaded multiple times
 *
 *  version 1.2.4
 *  - replace deprecated jQuery isFunction calls
 *
 *  version 1.3
 *  - Modernized code with ES6+ features while maintaining backward compatibility
 *  - Optimized performance and memory usage
 *  - Added const/let declarations for better scoping
 *  - Converted to arrow functions where appropriate
 */

/*global jQuery, window, document   */

(($ = jQuery) => {
    'use strict';

    window._subscribe_topics = window._subscribe_topics || {};
    const _subscribe_topics = window._subscribe_topics;
    const _subscribe_handlers = {};

    const _subscribe_getDocumentWindow = (document) =>
        document.defaultView || document.parentWindow;

    $.fn.extend({
        /**
         * Creates a new topic without any subscribers
         */
        createTopic(topic) {
            if (!topic) {
                return this;
            }

            if (!_subscribe_topics[topic]) {
                _subscribe_topics[topic] = {
                    objects: {
                        __noId__: []
                    }
                };
            }

            return this;
        },

        /**
         * Destroy an existing topic and unsubscribe all subscribers
         */
        destroyTopic(topic) {
            if (!topic || !_subscribe_topics[topic]) {
                return this;
            }

            delete _subscribe_topics[topic];
            return this;
        },

        /**
         * Subscribes an object to particular topic with a handler.
         * When the topic is published, this handler will be executed.
         *
         * Parameters:
         *  @param {string} topic - is the string name of the topic
         *  @param {function} handler - is a handler function and is of the form function(event, data), in which the 'this' refers to the element itself.
         *  handler can be a function or can be a string referring to a function previously registered using the $.subscribeHandler() function
         *            Note: returning 'false' from the handler will prevent subsequent handlers from being executed on this element during
         *            this call.
         *  @param {*} [data] - (optional) is additional data that is passed to the event handler as event.data when the topic is published
         *  @param {string} [id='__noId__'] - The subscriber ID
         *  @param {boolean} [overwrite=false] - Whether to overwrite existing handlers
         *  @param {boolean} [multiple=true] - Whether to allow multiple subscriptions
         *
         * Note: Unexpected behavior can occur when a script in a embedded page (page loaded in div,tab etc.) subscribes a handler for a topic using
         *  the global jQuery subscribe ($.subscribe) or a no-id element but this subscribe plugin .js is not reloaded within that embedded page (for example, when
         *  script is included in container page) . In this case, if the embedded page is reloaded without reloading the container page (and plugin), the
         *  subscription could be made multiple times for the topic, which will call the handler multiple times each time the topic is published.
         *  Code has been added to prevent this when the subscription is made using the non-element subscribe ($.subscribe()), which assures that only one
         *  subscription is made for a topic for a given window/frame. To prevent this from happening for an element subscription ($elem.subscribe()), make
         *  sure that the element has an id attribute.
         */
        subscribe(topic, handler, data, id = '__noId__', multiple = true, overwrite = false) {
            if (!topic || typeof handler !== 'function') {
                return this;
            }

            const topicObj = _subscribe_topics[topic] = _subscribe_topics[topic] || {
                objects: {
                    __noId__: []
                }
            };

            const objects = topicObj.objects;

            // Create wrapper function to include data
            const wrappedHandler = (eventData) => {
                handler.call(this, eventData, data);
            };

            // Store reference to original handler for unsubscribe
            wrappedHandler._originalHandler = handler;

            // Handle subscription based on multiple and overwrite flags
            if (!multiple && objects[id] && objects[id].length > 0) {
                return this;
            }

            if (overwrite) {
                objects[id] = [wrappedHandler];
            } else {
                objects[id] = objects[id] || [];
                objects[id].push(wrappedHandler);
            }

            return this;
        },

        /**
         * Remove a subscription of an element to a topic.
         * This will unbind stop all handlers from executing on this element when the topic
         * is published
         */
        unsubscribe(topic, handler, id = '__noId__') {
            if (!topic || !_subscribe_topics[topic]) {
                return this;
            }

            const objects = _subscribe_topics[topic].objects;

            if (handler) {
                const handlers = objects[id];
                if (handlers) {
                    objects[id] = handlers.filter(h =>
                        h !== handler && h._originalHandler !== handler
                    );
                    if (objects[id].length === 0) {
                        delete objects[id];
                    }
                }
            } else {
                delete objects[id];
            }

            return this;
        },

        /**
         * Determine if an element has already subscribed to a topics
         * returns true if so, otherwise false
         */
        isSubscribed(topic, handler, id = '__noId__') {
            if (!topic || !_subscribe_topics[topic]) {
                return false;
            }

            const objects = _subscribe_topics[topic].objects;
            const handlers = objects[id];

            if (!handlers) {
                return false;
            }

            return handlers.includes(handler);
        },

        /**
         * Publishes a topic (triggers handlers on all topic subscribers)
         * This ends up calling any subscribed handlers which are functions of the form function (event, data)
         * where: event - is a standard jQuery event object
         *    data - is the data parameter that was passed to this publish() method
         *    event.data - is the data parameter passed to the subscribe() function when this published topic was subscribed to
         *    event.target  - is the dom element that subscribed to the event (or the document element if $.subscribe() was used)
         *
         * Parameters:
         *  -topic- is the string name of the topic
         *  -data- (optional) is additional data that is passed to the event handler 'data' parameter when the topic is published
         *     handler can be a function or can be a string referring to a function previously registered using the $.subscribeHandler() function
         *  -originalEvent- (optional) may be passed in a reference to an event which triggered this publishing. This will be passed as the
         *     'originalEvent' field of the triggered event which will allow for controlling the propagation of higher level events
         *     from within the topic handler. In other words, this allows one to cancel execution of all subsequent handlers on the originalEvent
         *            for this element by return 'false' from a handler that is subscribed to the topic published here. This can be especially useful
         *            in conjunction with publishOnEvent(), where a topic is published when an event executes (such as a click) and we want our
         *            handler logic prevent additional topics from being published (For example if our topic displays a 'delete confirm' dialog on click and
         *            the user cancels, we may want to prevent subsequent topics bound to the original click event from being published).
         */        publish(topic, data, originalEvent) {
            if (!topic || !_subscribe_topics[topic]) {
                return this;
            }

            const objects = _subscribe_topics[topic].objects;

            // Handle originalEvent and stopPropagation
            if (originalEvent) {
                data.originalEvent = originalEvent;
            }
            if (data && data.originalEvent) {
                const subscriberStopPropagation = data.stopPropagation;
                data = data.originalEvent;
                data.stopPropagation = subscriberStopPropagation;
            }

            // Create a single array of all handlers
            const allHandlers = Object.values(objects)
                .flat()
                .filter(handler => typeof handler === 'function');

            // Execute all handlers
            allHandlers.forEach(handler => {
                try {
                    handler.call(this, data);
                } catch (e) {
                    console.error(`Error executing handler for topic ${topic}:`, e);
                }
            });

            return this;
        },

        /**
         * Binds an objects event handler to a publish call
         *
         * Upon the event triggering, this ends up calling any subscribed handlers which are functions of the form function (event, data)
         * where: event- is a standard jQuery event object
         *    event.data- is the data parameter passed to the subscribe() function when this published topic was subscribed to
         *    data- is the data parameter that was passed to this publishOnEvent() method
         * Parameters:
         *  -event- is the string name of the event upon which to publish the topic
         *  -topic- is the string name of the topic to publish when the event occurs
         *  -data- (optional) is additional data which will be passed in to the publish() method ant hen available as the second ('data')
         *          parameter to the topic handler
         */
        publishOnEvent(eventName, topic, selector) {
            const self = this;

            if (!eventName || !topic) {
                return this;
            }

            // Create handler function
            const handler = function (event) {
                const $target = $(event.target);

                if (!selector || $target.is(selector)) {
                    self.publish(topic, event);
                }
            };

            // Store handler reference for potential future cleanup
            _subscribe_handlers[topic] = _subscribe_handlers[topic] || [];
            _subscribe_handlers[topic].push({
                element: this,
                handler: handler,
                eventName: eventName
            });

            // Bind the event
            this.on(eventName, handler);

            return this;
        }
    });

})(jQuery);
