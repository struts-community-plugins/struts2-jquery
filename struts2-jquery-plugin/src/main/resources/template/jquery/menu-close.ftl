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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<#if parameters.list?? >
<@s.iterator value="parameters.list" status="rowstatus">
	<#if parameters.listKey??>
		<#if stack.findValue(parameters.listKey)??>
			<#assign itemKey = stack.findValue(parameters.listKey)/>
			<#assign itemKeyStr = stack.findString(parameters.listKey)/>
		<#else>
			<#assign itemKey = ''/>
			<#assign itemKeyStr = ''/>
		</#if>
	<#else>
		<#assign itemKey = stack.findValue('top')/>
		<#assign itemKeyStr = stack.findString('top')>
	</#if>
	<#if parameters.listValue??>
		<#if stack.findString(parameters.listValue)??>
			<#assign itemValue = stack.findString(parameters.listValue)/>
		<#else>
			<#assign itemValue = ''/>
		</#if>
	<#else>
		<#assign itemValue = stack.findString('top')/>
	</#if>
	<#if itemValue?if_exists == "">
		<#assign itemValue = itemKeyStr/>
	</#if>
	<#if parameters.paramValues?if_exists != "">
		<#assign hrefValues>
        	<#list parameters.paramValues?split(",") as tmp>${stack.findString(tmp)?default('')}<#if tmp_has_next>,</#if></#list>
		</#assign>
        </#if>
    <li id="${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />">
	    <#if parameters.href?exists>
		    <#if parameters.targets?if_exists != "">
				<a id="${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />_anchor" href="javascript:void(0)">
			    ${itemValue?html}
			    </a>
			    <#assign escapedOptionLinkId="${escapedOptionId}_li_anchor">
			    <script type='text/javascript'>
				    jQuery(document).ready(function () {
					    var options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" /> = {};
					    options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />.jqueryaction = "menuItem";
			            options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />.id = "${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />_anchor";
			    <#if parameters.targets?if_exists != "">
				        options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />.targets = "${parameters.targets?html}";
			    </#if>
			    <#if parameters.href?if_exists != "">
				        options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />.href = "${parameters.href?html}";
			    </#if>
			            options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />.hrefparameter = "${parameters.paramName?default('id')}=${itemKeyStr}";
			            jQuery.struts2_jquery_ui.bind(jQuery('#${escapedOptionId?string?replace('.', '\\\\\\\\.')}_li_<@s.property value="%{#rowstatus.count}" />_anchor'),options_${escapedOptionLinkId?html}_<@s.property value="%{#rowstatus.count}" />);
			         });
			    </script>
		    <#else>
			    <a href="${parameters.href}?${parameters.paramName?default('id')}=${itemKeyStr}">
			    ${itemValue?html}
			    </a>
		    </#if>
	    <#else>
		    <a href="javascript:void(0)">
		    ${itemValue?html}
		    </a>
	    </#if>
	</li>
</@s.iterator>
</#if>
</ul>
<#if !parameters.subMenu?default(false)>
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
  <#if parameters.disabled?default(false)>
	options_${escapedOptionId?html}.disabled = true;
  </#if>
  <#if parameters.targets?if_exists != "">
	options_${escapedOptionId?html}.targets = "${parameters.targets?html}";
  </#if>
  <#if parameters.href?if_exists != "">
		options_${escapedOptionId?html}.href = "${parameters.href?html}";
  </#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />

  <#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });  
</script>
</#if>