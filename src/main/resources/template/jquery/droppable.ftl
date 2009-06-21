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
<#if parameters.droppable?default(false)>
	$("#${parameters.id?trim}").droppable({
<#if parameters.droppableAccept?if_exists != "">
		accept: '${parameters.droppableAccept?html}',
</#if>
<#if parameters.droppableActiveClass?if_exists != "">
		activeClass: '${parameters.droppableActiveClass?html}',
</#if>
<#if parameters.droppableAddClasses?default(true)>
		addClasses: true,
<#else>
		addClasses: false,
</#if>
<#if parameters.droppableHoverClass?if_exists != "">
		hoverClass: '${parameters.droppableHoverClass?html}',
</#if>
<#if parameters.droppableScope?if_exists != "">
		scope: '${parameters.droppableScope?html}',
</#if>
<#if parameters.droppableTolerance?if_exists != "">
		tolerance: '${parameters.droppableTolerance?html}',
</#if>
<#if parameters.droppableActivate?if_exists != "">
		activate: function(event, ui) { ${parameters.droppableActivate?html}(event, ui); },
</#if>
<#if parameters.droppableDeactivate?if_exists != "">
		deactivate: function(event, ui) { ${parameters.droppableDeactivate?html}(event, ui); },
</#if>
<#if parameters.droppableDrop?if_exists != "">
		drop: function(event, ui) { ${parameters.droppableDrop?html}(event, ui); },
</#if>
<#if parameters.droppableOut?if_exists != "">
		out: function(event, ui) { ${parameters.droppableOut?html}(event, ui); },
</#if>
<#if parameters.droppableOver?if_exists != "">
		over: function(event, ui) { ${parameters.droppableOver?html}(event, ui); },
</#if>
<#if parameters.droppableGreedy?default(false)>
		greedy: true
<#else>
		greedy: false
</#if>
	});
</#if>
Fh6jtZ