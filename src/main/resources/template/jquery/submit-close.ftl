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
<script type="text/javascript">
$(document).ready(function () {
<#assign target>
    <#list parameters.targets?split(",") as tmp>#${tmp?trim}<#if tmp_has_next>,</#if></#list>
</#assign>
 <#if parameters.formId?if_exists != "">
    $('#${parameters.id?html}').click(function(e) {
        $('#${parameters.formId?html}').ajaxSubmit({
<#else>
   $('#${parameters.id?html}').closest("form").submit(function(e) {
        $(this).ajaxSubmit({
</#if>
   <#if parameters.href?if_exists != "">
        url:       	   '${parameters.href?html}',
   </#if>
	<#if parameters.beforeSend?if_exists != "" || parameters.indicator?if_exists != "">
        beforeSubmit:  function() {
		  <#if parameters.indicator?if_exists != "">
		    $('#${parameters.indicator?trim}').show();
		  </#if>
		  <#if parameters.beforeSend?if_exists != "">
		    ${parameters.beforeSend?html}(formData, jqForm, options);
		  </#if>
        },
   </#if>
	<#if parameters.complete?if_exists != "" || parameters.effect?if_exists != "" || parameters.indicator?if_exists != "">
        success:       function() {
	      <#if parameters.indicator?if_exists != "">
	        $('#${parameters.indicator?trim}').hide();
	      </#if>
	      <#if parameters.effect?if_exists != "">
			<#assign options="{ ${parameters.effectOptions?default('')} }">
	        $("${target?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')});
	      </#if>
	      <#if parameters.complete?if_exists != "">
	        ${parameters.complete?html}(responseText, statusText);
	      </#if>
        },
   </#if>
   <#if parameters.dataType?if_exists != "">
        dataType:       '${parameters.dataType?html}',
   </#if>
   <#if parameters.clearForm?default(false)>
        clearForm:       true,
   </#if>
   <#if parameters.resetForm?default(false)>
        resetForm:       true,
   </#if>
   <#if parameters.iframe?default(false)>
        iframe:       true,
   </#if>
   		timeout:	   ${parameters.timeout?default("3000")},
        target:        '${target?trim}'

		});
    	return false; 
    }); 
});    
</script>