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
</div>
<script type="text/javascript">
$(document).ready(function () {
	$.ui.dialog.defaults.bgiframe = true;
	$("#${parameters.id?trim}").dialog({
<#if parameters.height?if_exists != "">
			height: ${parameters.height?html},
</#if>
<#if parameters.width?if_exists != "">
			width: ${parameters.width?html},
</#if>
<#if parameters.zindex?if_exists != "">
			zIndex: ${parameters.zindex?html},
</#if>
<#if parameters.title?if_exists != "">
			title: '${parameters.title?html}',
</#if>
<#if parameters.position?if_exists != "">
			position: '${parameters.position?html}',
</#if>
<#if parameters.buttons?if_exists != "">
			buttons: {${parameters.buttons?html}},
</#if>
<#if parameters.showEffect?if_exists != "">
			show: '${parameters.showEffect?html}',
</#if>
<#if parameters.hideEffect?if_exists != "">
			hide: '${parameters.hideEffect?html}',
</#if>
<#if parameters.draggable?default(true)>
			draggable: true,
<#else>
			draggable: false,
</#if>
<#if parameters.resizable?default(true)>
			resizable: true,
<#else>
			resizable: false,
</#if>
<#if parameters.autoOpen?default(true)>
			autoOpen: true,
<#else>
			autoOpen: false,
</#if>
<#if parameters.beforeSend?if_exists != "" || parameters.href?if_exists != "">
            open : function() {
<#if parameters.beforeSend?if_exists != "">
                            ${parameters.beforeSend?html};<#rt/>
</#if>
<#if parameters.href?if_exists != "">
                            $("#${parameters.id?trim}").load("${parameters.href}");<#rt/>
</#if>
                         },
</#if>
<#if parameters.complete?if_exists != "">
            close : function() {
                            ${parameters.complete?html};<#rt/>
                         },
</#if>
<#if parameters.modal?default(false)>
 <#if parameters.overlayColor?if_exists != "" || parameters.overlayOpacity?if_exists != "">
 	overlay: {
	<#if parameters.overlayColor?if_exists != "">
				backgroundColor: '${parameters.overlayColor?html}',
	</#if>
	<#if parameters.overlayOpacity?if_exists != "">
				opacity: ${parameters.overlayOpacity?html}
	<#else>
				opacity: 0.5
	</#if>
	},
  </#if>
			modal: true
<#else>
			modal: false
</#if>
		});
});
</script>
