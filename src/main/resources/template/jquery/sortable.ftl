<#--
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#if parameters.sortable?default(false)>
	$("#${parameters.id?trim}").sortable({
<#if parameters.sortableZindex?if_exists != "">
		zIndex: ${parameters.sortableZindex?html},
</#if>
<#if parameters.sortableScroll?default(false)>
		scroll: true,
</#if>
<#if parameters.sortableScrollSpeed?if_exists != "">
		scrollSpeed: ${parameters.sortableScrollSpeed?html},
</#if>
<#if parameters.sortableScrollSensitivity?if_exists != "">
		scrollSensitivity: '${parameters.sortableScrollSensitivity?html}',
</#if>
<#if parameters.sortablePlaceholder?if_exists != "">
		placeholder: '${parameters.sortablePlaceholder?html}',
</#if>
<#if parameters.sortableOpacity?if_exists != "">
		opacity: ${parameters.sortableOpacity?html},
</#if>
<#if parameters.sortableItems?if_exists != "">
		items: '${parameters.sortableItems?html}',
</#if>
<#if parameters.sortableHelper?if_exists != "">
		helper: '${parameters.sortableHelper?html}',
</#if>
<#if parameters.sortableHandle?if_exists != "">
		handle: '${parameters.sortableHandle?html}',
</#if>
<#if parameters.sortableGrid?if_exists != "">
		grid: '${parameters.sortableGrid?html}',
</#if>
<#if parameters.sortableForcePlaceholderSize?default(false)>
		forcePlaceholderSize: true,
</#if>
<#if parameters.sortableForceHelperSize?default(false)>
		forceHelperSize: true,
</#if>
<#if parameters.sortableDropOnEmpty?default(false)>
		dropOnEmpty: true,
</#if>
<#if parameters.sortableCursorAt?if_exists != "">
		cursorAt: '${parameters.sortableCursorAt?html}',
</#if>
<#if parameters.sortableCursor?if_exists != "">
		cursor: '${parameters.sortableCursor?html}',
</#if>
<#if parameters.sortableContainment?if_exists != "">
		containment: '${parameters.sortableContainment?html}',
</#if>
<#if parameters.sortableConnectWith?if_exists != "">
		connectWith: '${parameters.sortableConnectWith?html}',
</#if>
<#if parameters.sortableCancel?if_exists != "">
		cancel: '${parameters.selectableCancel?html}',
</#if>
<#if parameters.sortableAxis?if_exists != "">
		axis: '${parameters.sortableAxis?html}',
</#if>
<#if parameters.sortableAppendTo?if_exists != "">
		appendTo: '${parameters.sortableAppendTo?html}',
</#if>
<#if parameters.sortableDelay?if_exists != "">
		delay : ${parameters.selectableDelay?html},
</#if>
<#if parameters.sortableTolerance?if_exists != "">
		tolerance: '${parameters.sortableTolerance?html}',
</#if>
<#if parameters.sortableDistance?if_exists != "">
		distance: '${parameters.sortableDistance?html}',
</#if>
<#if parameters.sortableStart?if_exists != "">
		start: function(event, ui) { ${parameters.sortableStart?html}(event, ui); },
</#if>
<#if parameters.sortableStop?if_exists != "">
		stop: function(event, ui) { ${parameters.sortableStop?html}(event, ui); },
</#if>
<#if parameters.sortableBeforeStop?if_exists != "">
		beforeStop: function(event, ui) { ${parameters.sortableBeforeStop?html}(event, ui); },
</#if>
<#if parameters.sortableUpdate?if_exists != "">
		update: function(event, ui) { ${parameters.sortableUpdate?html}(event, ui); },
</#if>
<#if parameters.sortableSort?if_exists != "">
		sort: function(event, ui) { ${parameters.sortableSort?html}(event, ui); },
</#if>
<#if parameters.sortableReceive?if_exists != "">
		receive: function(event, ui) { ${parameters.sortableReceive?html}(event, ui); },
</#if>
<#if parameters.sortableRemove?if_exists != "">
		remove: function(event, ui) { ${parameters.sortableRemove?html}(event, ui); },
</#if>
<#if parameters.sortableOver?if_exists != "">
		over: function(event, ui) { ${parameters.sortableOver?html}(event, ui); },
</#if>
<#if parameters.sortableOut?if_exists != "">
		out: function(event, ui) { ${parameters.sortableOut?html}(event, ui); },
</#if>
<#if parameters.sortableDeactivate?if_exists != "">
		deactivate: function(event, ui) { ${parameters.sortableDeactivate?html}(event, ui); },
</#if>
<#if parameters.sortableChange?if_exists != "">
		change: function(event, ui) { ${parameters.sortableChange?html}(event, ui); },
</#if>
<#if parameters.sortableActivate?if_exists != "">
		activate: function(event, ui) { ${parameters.sortableActivate?html}(event, ui); },
</#if>
<#if parameters.sortableRevert?default(false)>
		revert: true
<#else>
		revert: false
</#if>
	});
</#if>