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
</a>
<script type="text/javascript">
$(document).ready(function () {
<#if parameters.formId?if_exists != "">
$('#${parameters.id?html}').click(function() {
<#if parameters.openDialog?if_exists != "">
    $('#${parameters.openDialog?trim}').dialog('open');
</#if>
<#if parameters.targets?if_exists != "">
    <#assign target>
    <#list parameters.targets?split(",") as tmp>#${tmp?trim}<#if tmp_has_next>,</#if></#list>
</#assign>
        $('#${parameters.formId?html}').ajaxSubmit({
	<#if parameters.beforeSend?if_exists != "" || parameters.indicator?if_exists != "">
        beforeSubmit:  function(data, form, options) {
		  <#if parameters.indicator?if_exists != "">
		    $('#${parameters.indicator?trim}').show();
		  </#if>
		  <#if parameters.beforeSend?if_exists != "">
		    ${parameters.beforeSend?html}(data, form, options);
		  </#if>
        },
   </#if>
	<#if parameters.complete?if_exists != "" || parameters.effect?if_exists != "" || parameters.indicator?if_exists != "">
        success:       function(response, status) {
	      <#if parameters.indicator?if_exists != "">
	        $('#${parameters.indicator?trim}').hide();
	      </#if>
	      <#if parameters.effect?if_exists != "">
			<#assign options="{ ${parameters.effectOptions?default('')} }">
	        $("${target?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')});
	      </#if>
	      <#if parameters.complete?if_exists != "">
	        ${parameters.complete?html}(response, status);
	      </#if>
        },
   </#if>
	<#if parameters.error?if_exists != "">
        error:       function(status, request) {
	      <#if parameters.indicator?if_exists != "">
	        $('#${parameters.indicator?trim}').hide();
	      </#if>
	      <#if parameters.error?if_exists != "">
	        ${parameters.error?html}(status, request);
	      </#if>
        },
   </#if>
   <#if parameters.dataType?if_exists != "">
        dataType:       '${parameters.dataType?html}',
   </#if>
   		timeout:	   ${parameters.timeout?default("3000")},
        target:        '${target?trim}'
      });
      return false;
</#if>
});
<#else>
$('#${parameters.id?html}').click(function() {
  <#if parameters.openDialog?if_exists != "">
    $('#${parameters.openDialog?trim}').dialog('open');;
  </#if>
<#if parameters.targets?if_exists != "">
  <#if parameters.indicator?if_exists != "">
    $('#${parameters.indicator?trim}').show();
  </#if>
<#list parameters.targets?split(",") as target>
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
          error : function(request, status, error){ <#if parameters.indicator?if_exists != "">$('#${parameters.indicator?trim}').hide();</#if> ${parameters.error?html}(request, status, error); },
   </#if>
   <#if parameters.complete?if_exists != "">
          complete : function(request, status){ ${parameters.complete?html}(request, status); },
   </#if>
      success : function(data){ <#if parameters.indicator?if_exists != "">$('#${parameters.indicator?trim}').hide();</#if> $("#${target?trim}").html(data);  
  <#if parameters.effect?if_exists != "">
 		<#assign options="{ ${parameters.effectOptions?default('')} }">
        $("#${target?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')});
  </#if>
      	},
      	timeout:	   ${parameters.timeout?default("3000")},
  <#if parameters.dataType?if_exists != "">
      dataType:'${parameters.dataType?html}'
  <#else>
      dataType:'html' 
  </#if>
  });
</#list>
  </#if>
      return false;
  });
</#if>
});
</script>
