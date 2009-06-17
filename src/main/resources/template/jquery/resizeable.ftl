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
<#if parameters.resizable?default(false)>
	$("#${parameters.id?trim}").resizable({
<#if parameters.resizableAspectRatio?default(false)>
		aspectRatio: true,
</#if>
<#if parameters.resizableAutoHide?default(false)>
		autoHide: true,
</#if>
<#if parameters.resizableContainment?if_exists != "">
	<#if parameters.resizableContainment?trim == "parent">
		containment: 'parent',
	<#elseif parameters.resizableContainment?trim == "document">
		containment: 'document',
	<#else>
		containment: '#${parameters.resizableContainment?html}',
	</#if>
</#if>
<#if parameters.resizableDelay?if_exists != "">
		delay: ${parameters.resizableDelay?html},
</#if>
<#if parameters.resizableDistance?if_exists != "">
		distance: ${parameters.resizableDistance?html},
</#if>
<#if parameters.resizableGhost?default(false)>
		ghost: true,
</#if>
<#if parameters.resizableHandles?if_exists != "">
		handles: '${parameters.resizableHandles?html}',
</#if>
<#if parameters.resizableHelper?if_exists != "">
		helper: '${parameters.resizableHelper?html}',
</#if>
<#if parameters.resizableMaxHeight?if_exists != "">
		maxHeight: ${parameters.resizableMaxHeight?html},
</#if>
<#if parameters.resizableMaxWidth?if_exists != "">
		maxWidth: ${parameters.resizableMaxWidth?html},
</#if>
<#if parameters.resizableMinHeight?if_exists != "">
		minHeight: ${parameters.resizableMinHeight?html},
</#if>
<#if parameters.resizableMinWidth?if_exists != "">
		minWidth: ${parameters.resizableMinWidth?html},
</#if>
<#if parameters.resizableStart?if_exists != "">
		start: function(event, ui) { ${parameters.resizableStart?html}(event, ui); },
</#if>
<#if parameters.resizableResize?if_exists != "">
		resize: function(event, ui) { ${parameters.resizableResize?html}(event, ui); },
</#if>
<#if parameters.resizableStop?if_exists != "">
		stop: function(event, ui) { ${parameters.resizableStop?html}(event, ui); },
</#if>
<#if parameters.resizableAnimateDuration?if_exists != "">
		animateDuration: ${parameters.resizableAnimateDuration?html},
</#if>
<#if parameters.resizableAnimateEasing?if_exists != "">
		animateEasing: ${parameters.resizableAnimateEasing?html},
</#if>
<#if parameters.resizableAnimate?default(false)>
		animate: true
<#else>
		animate: false
</#if>
	});
</#if>
