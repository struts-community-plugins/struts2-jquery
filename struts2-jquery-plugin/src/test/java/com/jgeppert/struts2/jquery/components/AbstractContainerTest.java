package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.opensymphony.xwork2.util.ValueStack;

class AbstractContainerTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            AbstractContainer abstractContainer = new AbstractContainerImpl(valueStack);

            abstractContainer.evaluateParams();

            Map<String, Object> parameters = abstractContainer.getParameters();

            assertThat(parameters)
                    .doesNotContainKeys("reloadTopics", "bindOn", "events", "deferredLoading", "resizable",
                            "resizableOptions", "resizableOnResizeTopics", "resizableOnStartTopics",
                            "resizableOnStopTopics", "droppable", "droppableOptions", "droppableOnActivateTopics",
                            "droppableOnDeactivateTopics", "droppableOnOverTopics", "droppableOnOutTopics",
                            "droppableOnDropTopics", "draggable", "draggableOptions", "draggableOnDragTopics",
                            "draggableOnStartTopics", "draggableOnStopTopics", "selectable", "selectableOptions",
                            "selectableOnSelectedTopics", "selectableOnSelectingTopics", "selectableOnStartTopics",
                            "selectableOnStopTopics", "selectableOnUnselectedTopics", "selectableOnUnselectingTopics",
                            "sortable", "sortableOptions", "sortableOnActivateTopics", "sortableOnUpdateTopics",
                            "sortableOnStopTopics", "sortableOnStartTopics", "sortableOnSortTopics",
                            "sortableOnRemoveTopics", "sortableOnReceiveTopics", "sortableOnOverTopics",
                            "sortableOnOutTopics", "sortableOnDeactivateTopics", "sortableOnChangeTopics",
                            "sortableOnBeforeStopTopics");
        }

        @Test
        void allSet() {
            AbstractContainer abstractContainer = new AbstractContainerImpl(valueStack);
            abstractContainer.setReloadTopics("theReloadTopic");
            abstractContainer.setBindOn("theBindOn");
            abstractContainer.setEvents("theEvent");
            abstractContainer.setDeferredLoading("false");
            // start resizable
            abstractContainer.setResizable("true");
            abstractContainer.setResizableAnimate("false");
            abstractContainer.setResizableAspectRatio("16 / 9");
            abstractContainer.setResizableAutoHide("true");
            abstractContainer.setResizableGhost("true");
            abstractContainer.setResizableAnimateDuration("fast");
            abstractContainer.setResizableMaxHeight("300");
            abstractContainer.setResizableMaxWidth("350");
            abstractContainer.setResizableMinHeight("150");
            abstractContainer.setResizableMinWidth("200");
            abstractContainer.setResizableAnimateEasing("easeOutBounce");
            abstractContainer.setResizableHelper("resizable-helper");
            abstractContainer.setResizableHandles("n, e, s, w");
            abstractContainer.setResizableContainment("parent");
            abstractContainer.setResizableOnResizeTopics("theResizableResizeTopic");
            abstractContainer.setResizableOnStartTopics("theResizableStartTopic");
            abstractContainer.setResizableOnStopTopics("theResizableStopTopic");
            // end resizable
            // start droppable
            abstractContainer.setDroppable("true");
            abstractContainer.setDroppableAccept(".special");
            abstractContainer.setDroppableAddClasses("false");
            abstractContainer.setDroppableClasses("{'ui-droppable-active': 'ui-state-highlight', 'ui-droppable-hover', 'drop-hover'}");
            abstractContainer.setDroppableGreedy("true");
            abstractContainer.setDroppableTolerance("fit");
            abstractContainer.setDroppableScope("tasks");
            abstractContainer.setDroppableOnActivateTopics("theDroppableOnActivateTopic");
            abstractContainer.setDroppableOnDeactivateTopics("theDroppableOnDeactivateTopic");
            abstractContainer.setDroppableOnOverTopics("theDroppableOnOverTopic");
            abstractContainer.setDroppableOnOutTopics("theDroppableOnOutTopic");
            abstractContainer.setDroppableOnDropTopics("theDroppableOnDropTopic");
            // end droppable
            // start draggable
            abstractContainer.setDraggable("true");
            abstractContainer.setDraggableAddClasses("false");
            abstractContainer.setDraggableAppendTo("body");
            abstractContainer.setDraggableAxis("x");
            abstractContainer.setDraggableCancel(".title");
            abstractContainer.setDraggableCursor("crosshair");
            abstractContainer.setDraggableHandle("h2");
            abstractContainer.setDraggableHelper("clone");
            abstractContainer.setDraggableIframeFix("true");
            abstractContainer.setDraggableOpacity("0.35");
            abstractContainer.setDraggableRefreshPositions("true");
            abstractContainer.setDraggableRevertDuration("200");
            abstractContainer.setDraggableScope("tasks");
            abstractContainer.setDraggableScroll("true");
            abstractContainer.setDraggableScrollSensitivity("100");
            abstractContainer.setDraggableScrollSpeed("100");
            abstractContainer.setDraggableSnap("true");
            abstractContainer.setDraggableSnapMode("inner");
            abstractContainer.setDraggableSnapTolerance("30");
            abstractContainer.setDraggableZindex("100");
            abstractContainer.setDraggableRevert("invalid");
            abstractContainer.setDraggableContainment("parent");
            abstractContainer.setDraggableOnDragTopics("theDraggableOnDragTopic");
            abstractContainer.setDraggableOnStartTopics("theDraggableOnStartTopic");
            abstractContainer.setDraggableOnStopTopics("theDraggableOnStopTopic");
            // end draggable
            // start selectable
            abstractContainer.setSelectable("true");
            abstractContainer.setSelectableFilter("li");
            abstractContainer.setSelectableCancel("a,.cancel");
            abstractContainer.setSelectableTolerance("fit");
            abstractContainer.setSelectableOnSelectedTopics("theSelectableOnSelectTopic");
            abstractContainer.setSelectableOnSelectingTopics("theSelectableOnSelectingTopic");
            abstractContainer.setSelectableOnStartTopics("theSelectableOnStartTopic");
            abstractContainer.setSelectableOnStopTopics("theSelectableOnStopTopic");
            abstractContainer.setSelectableOnUnselectedTopics("theSelectableOnUnselectTopic");
            abstractContainer.setSelectableOnUnselectingTopics("theSelectableOnUnselectingTopic");
            // end selectable
            // start sortable
            abstractContainer.setSortable("true");
            abstractContainer.setSortableDropOnEmpty("false");
            abstractContainer.setSortableForceHelperSize("true");
            abstractContainer.setSortableForcePlaceholderSize("true");
            abstractContainer.setSortableRevert("true");
            abstractContainer.setSortableScroll("true");
            abstractContainer.setSortableZindex("9999");
            abstractContainer.setSortableScrollSensitivity("10");
            abstractContainer.setSortableScrollSpeed("40");
            abstractContainer.setSortableTolerance("pointer");
            abstractContainer.setSortablePlaceholder("sortable-placeholder");
            abstractContainer.setSortableOpacity("0.5");
            abstractContainer.setSortableItems("> li");
            abstractContainer.setSortableHandle(".handle");
            abstractContainer.setSortableGrid("[ 20, 10 ]");
            abstractContainer.setSortableCursorAt("{ left: 5 }");
            abstractContainer.setSortableCursor("move");
            abstractContainer.setSortableConnectWith("#shopping-cart");
            abstractContainer.setSortableAxis("x");
            abstractContainer.setSortableAppendTo("parent");
            abstractContainer.setSortableCancel("a,button");
            abstractContainer.setSortableContainment("document");
            abstractContainer.setSortableOnActivateTopics("theSortableOnActivateTopic");
            abstractContainer.setSortableOnUpdateTopics("theSortableOnUpdateTopic");
            abstractContainer.setSortableOnStopTopics("theSortableOnStopTopic");
            abstractContainer.setSortableOnStartTopics("theSortableOnStartTopic");
            abstractContainer.setSortableOnSortTopics("theSortableOnSortTopic");
            abstractContainer.setSortableOnRemoveTopics("theSortableOnRemoveTopic");
            abstractContainer.setSortableOnReceiveTopics("theSortableOnReceiveTopic");
            abstractContainer.setSortableOnOverTopics("theSortableOnOverTopic");
            abstractContainer.setSortableOnOutTopics("theSortableOnOutTopic");
            abstractContainer.setSortableOnDeactivateTopics("theSortableOnDeactivateTopic");
            abstractContainer.setSortableOnChangeTopics("theSortableOnChangeTopic");
            abstractContainer.setSortableOnBeforeStopTopics("theSortableOnBeforeStopTopic");
            // end sortable

            abstractContainer.evaluateParams();

            Map<String, Object> parameters = abstractContainer.getParameters();

            assertThat(parameters)
                    .containsEntry("reloadTopics", "theReloadTopic")
                    .containsEntry("bindOn", "theBindOn")
                    .containsEntry("events", "theEvent")
                    .containsEntry("deferredLoading", false)
                    .containsEntry("resizable", true)
                    .containsEntry("resizableOptions",
                            "{ animate: false, aspectRatio: 16 / 9, autoHide: true, ghost: true, animateDuration: fast, maxHeight: 300, maxWidth: 350, minHeight: 150, minWidth: 200, animateEasing: 'easeOutBounce' , helper: 'resizable-helper' , handles: 'n, e, s, w' , containment: 'parent'}")
                    .containsEntry("resizableOnResizeTopics", "theResizableResizeTopic")
                    .containsEntry("resizableOnStartTopics", "theResizableStartTopic")
                    .containsEntry("resizableOnStopTopics", "theResizableStopTopic")
                    .containsEntry("droppable", true)
                    .containsEntry("droppableOptions",
                            "{ accept: '.special' , addClasses: false, classes: {'ui-droppable-active': 'ui-state-highlight', 'ui-droppable-hover', 'drop-hover'}, greedy: true, tolerance: 'fit' , scope: 'tasks'  }")
                    .containsEntry("droppableOnActivateTopics", "theDroppableOnActivateTopic")
                    .containsEntry("droppableOnDeactivateTopics", "theDroppableOnDeactivateTopic")
                    .containsEntry("droppableOnOverTopics", "theDroppableOnOverTopic")
                    .containsEntry("droppableOnOutTopics", "theDroppableOnOutTopic")
                    .containsEntry("droppableOnDropTopics", "theDroppableOnDropTopic")
                    .containsEntry("draggable", true)
                    .containsEntry("draggableOptions",
                            "{ addClasses: false, appendTo: 'body' , axis: 'x' , cancel: '.title' , cursor: 'crosshair' , handle: 'h2' , helper: 'clone' , iframeFix: true, opacity: '0.35' , refreshPositions: true, revertDuration: 200, scope: 'tasks' , scroll: true, sensitivity: 100, scrollSpeed: true100, snap: true, snapMode: 'inner' , snapTolerance: 30, zIndex: 100, revert: 'invalid', containment: 'parent' }")
                    .containsEntry("draggableOnDragTopics", "theDraggableOnDragTopic")
                    .containsEntry("draggableOnStartTopics", "theDraggableOnStartTopic")
                    .containsEntry("draggableOnStopTopics", "theDraggableOnStopTopic")
                    .containsEntry("selectable", true)
                    .containsEntry("selectableOptions",
                            "{ filter: 'li' , cancel: 'a,.cancel' , tolerance: 'fit'  }")
                    .containsEntry("selectableOnSelectedTopics", "theSelectableOnSelectTopic")
                    .containsEntry("selectableOnSelectingTopics", "theSelectableOnSelectingTopic")
                    .containsEntry("selectableOnStopTopics", "theSelectableOnStopTopic")
                    .containsEntry("selectableOnUnselectedTopics", "theSelectableOnUnselectTopic")
                    .containsEntry("selectableOnUnselectingTopics", "theSelectableOnUnselectingTopic")
                    .containsEntry("sortable", true)
                    .containsEntry("sortableOptions",
                            "{ dropOnEmpty: false, forceHelperSize: true, forcePlaceholderSize: true, revert: true, scroll: true, zIndex: 9999, scrollSensitivity: 10, scrollSpeed: 40, tolerance: 'pointer' , placeholder: 'sortable-placeholder' , opacity: '0.5' , items: '> li' , handle: '.handle' , grid: '[ 20, 10 ]' , cursorAt: '{ left: 5 }' , cursor: 'move' , connectWith: '#shopping-cart' , axis: 'x' , appendTo: 'parent' , cancel: 'a,button' , containment: 'document' }")
                    .containsEntry("sortableOnActivateTopics", "theSortableOnActivateTopic")
                    .containsEntry("sortableOnUpdateTopics", "theSortableOnUpdateTopic")
                    .containsEntry("sortableOnStopTopics", "theSortableOnStopTopic")
                    .containsEntry("sortableOnStartTopics", "theSortableOnStartTopic")
                    .containsEntry("sortableOnSortTopics", "theSortableOnSortTopic")
                    .containsEntry("sortableOnRemoveTopics", "theSortableOnRemoveTopic")
                    .containsEntry("sortableOnReceiveTopics", "theSortableOnReceiveTopic")
                    .containsEntry("sortableOnOverTopics", "theSortableOnOverTopic")
                    .containsEntry("sortableOnOutTopics", "theSortableOnOutTopic")
                    .containsEntry("sortableOnDeactivateTopics", "theSortableOnDeactivateTopic")
                    .containsEntry("sortableOnChangeTopics", "theSortableOnChangeTopic")
                    .containsEntry("sortableOnBeforeStopTopics", "theSortableOnBeforeStopTopic");
        }
    }

    private static class AbstractContainerImpl extends AbstractContainer {
        public AbstractContainerImpl(final ValueStack valueStack) {
            super(valueStack, null, null);
        }

        @Override
        public String getDefaultOpenTemplate() {
            return null;
        }

        @Override
        protected String getDefaultTemplate() {
            return null;
        }
    }
}
