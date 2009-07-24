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
<#if parameters.open?if_exists != "" || parameters.href?if_exists != "">
            open : function(event, ui) {
<#if parameters.open?if_exists != "">
			${parameters.open?html}(event, ui);
</#if>
<#if parameters.href?if_exists != "">
  $.ajax({
      url: "${parameters.hrefUrl}",
   <#if parameters.hrefParameter?if_exists != "">
      data : "${parameters.hrefParameter}",
   </#if>
      type: "GET",
   <#if parameters.beforeSend?if_exists != "" || parameters.indicator?if_exists != "">
          beforeSend : function(request){ <#if parameters.beforeSend?if_exists != "">${parameters.beforeSend?html}(request);</#if> <#if parameters.indicator?if_exists != "">$('#${parameters.indicator?trim}').show();</#if> },
   </#if>
   <#if parameters.error?if_exists != "">
          error : function(request, status, error){ ${parameters.error?html}(request, status, error); },
   </#if>
   <#if parameters.complete?if_exists != "">
          complete : function(request, status){ ${parameters.complete?html}(request, status); },
   </#if>
      success : function(data){ <#if parameters.indicator?if_exists != "">$('#${parameters.indicator?trim}').hide();</#if> $("#${parameters.id?trim}").html(data);  
  <#if parameters.effect?if_exists != "">
 		<#assign options="{ ${parameters.effectOptions?default('')} }">
        $("#${parameters.id?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')});
  </#if>
      	},
      	timeout:	   ${parameters.timeout?default("3000")},
  <#if parameters.dataType?if_exists != "">
      dataType:'${parameters.dataType?html}'
  <#else>
      dataType:'html' 
  </#if>
  });
</#if>
                         },
</#if>
<#if parameters.close?if_exists != "">
      close : function(event, ui) {
         ${parameters.close?html}(event, ui);<#rt/>
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
