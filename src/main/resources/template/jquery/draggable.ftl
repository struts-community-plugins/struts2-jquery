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
<#if parameters.draggable?default(false)>
	$("#${parameters.id?trim}").draggable({
<#if parameters.draggableAppendTo?if_exists != "">
		appendTo: '${parameters.draggableAppendTo?html}',
</#if>
<#if parameters.draggableAxis?if_exists != "">
		axis: '${parameters.draggableAxis?html}',
</#if>
<#if parameters.draggableCancel?if_exists != "">
		cancel: '${parameters.draggableCancel?html}',
</#if>
<#if parameters.draggableDelay?if_exists != "">
		delay: ${parameters.draggableDelay?html},
</#if>
<#if parameters.draggableDistance?if_exists != "">
		distance: ${parameters.draggableDistance?html},
</#if>
<#if parameters.draggableHandle?if_exists != "">
		handle: '${parameters.draggableHandle?html}',
</#if>
<#if parameters.draggableHelper?if_exists != "">
		helper: '${parameters.draggableHelper?html}',
</#if>
<#if parameters.draggableIframeFix?default(false)>
		iframeFix: true,
</#if>
<#if parameters.draggableOpacity?if_exists != "">
		opacity: '${parameters.draggableOpacity?html}',
</#if>
<#if parameters.draggableRefreshPositions?default(false)>
		refreshPositions: true,
</#if>
<#if parameters.draggableRevert?if_exists != "">
	<#if parameters.draggableRevert?if_exists == "true">
		revert: true,
	<#elseif parameters.draggableRevert?if_exists == "false">
		revert: false,
	<#else>
		revert: '${parameters.draggableRevert?html}',
	</#if>
</#if>
<#if parameters.draggableRevertDuration?if_exists != "">
		revertDuration: ${parameters.draggableRevertDuration?html},
</#if>
<#if parameters.draggableScope?if_exists != "">
		draggableScope: '${parameters.draggableScope?html}',
</#if>
<#if parameters.draggableScroll?default(false)>
		scroll: true,
</#if>
<#if parameters.draggableScrollSensitivity?if_exists != "">
		scrollSensitivity: ${parameters.draggableScrollSensitivity?html},
</#if>
<#if parameters.draggableScrollSpeed?if_exists != "">
		scrollSpeed: ${parameters.draggableScrollSpeed?html},
</#if>
<#if parameters.draggableSnap?default(false)>
		snap: true,
</#if>
<#if parameters.draggableSnapMode?if_exists != "">
		snapMode: '${parameters.draggableSnapMode?html}',
</#if>
<#if parameters.draggableSnapTolerance?if_exists != "">
		snapTolerance: ${parameters.draggableSnapTolerance?html},
</#if>
<#if parameters.draggableZindex?if_exists != "">
		zIndex: ${parameters.draggableZindex?html},
</#if>
<#if parameters.draggableSnapMode?if_exists != "">
		snapMode: '${parameters.draggableSnapMode?html}',
</#if>
<#if parameters.draggableContainment?if_exists != "">
	<#if parameters.draggableContainment?trim == "parent">
		containment: 'parent',
	<#elseif parameters.draggableContainment?trim == "document">
		containment: 'document',
	<#elseif parameters.draggableContainment?trim == "window">
		containment: 'window',
	<#else>
		containment: ${parameters.draggableContainment?html},
	</#if>
</#if>
<#if parameters.draggableDrag?if_exists != "">
		drag: function(event, ui) { ${parameters.draggableDrag?html}(event, ui); },
</#if>
<#if parameters.draggableStart?if_exists != "">
		start: function(event, ui) { ${parameters.draggableStart?html}(event, ui); },
</#if>
<#if parameters.draggableStop?if_exists != "">
		stop: function(event, ui) { ${parameters.draggableStop?html}(event, ui); },
</#if>
<#if parameters.draggableAddClasses?default(true)>
		addClasses: true
<#else>
		addClasses: false
</#if>
	});
</#if>
