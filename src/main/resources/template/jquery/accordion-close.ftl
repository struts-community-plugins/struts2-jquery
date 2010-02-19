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
<@s.iterator value="parameters.list" status="rowstatus">
        <#if parameters.listKey??>
            <#if stack.findValue(parameters.listKey)??>
              <#assign itemKey = stack.findValue(parameters.listKey)/>
              <#assign itemKeyStr = itemKey.toString()/>
            <#else>
              <#assign itemKey = ''/>
              <#assign itemKeyStr = ''/>
            </#if>
        <#else>
            <#assign itemKey = stack.findValue('top')/>
            <#assign itemKeyStr = itemKey.toString()/>
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
 		<#if parameters.paramValues?if_exists != "">
		<#assign hrefValues>
        	<#list parameters.paramValues?split(",") as tmp>${stack.findString(tmp)?default('')}<#if tmp_has_next>,</#if></#list>
		</#assign>
        </#if>
    <li id="${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />">
	<${parameters.header?default('h3')}><a id="${escapedOptionId}_a_<@s.property value="%{#rowstatus.count}" />" href="#"
<#if parameters.paramKeys?if_exists != "">
	 paramkeys="${parameters.paramKeys?trim}"
</#if>	 
<#if parameters.paramValues?if_exists != "">
	 paramvalues="${hrefValues?trim}"
</#if>	 
	 >${itemKeyStr?html}</a></${parameters.header?default('h3')}>
		<div id="${escapedOptionId}_div_<@s.property value="%{#rowstatus.count}" />">
<#if parameters.href?if_exists == "">
			${itemValue?html}
</#if>			
		</div>
	</li>
	<#lt/>
</@s.iterator>
</ul>
<script type='text/javascript'>
$(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
  <#if parameters.fillSpace?default(false)>
	options_${escapedOptionId?html}.fillspace = true;
  </#if>
  <#if parameters.collapsible?default(false)>
	options_${escapedOptionId?html}.collapsible = true;
  </#if>
  <#if parameters.clearStyle?default(false)>
	options_${escapedOptionId?html}.clearstyle = true;
  </#if>
  <#if parameters.autoHeight?default(false)>
	options_${escapedOptionId?html}.autoheight = true;
  </#if>
  <#if parameters.openOnMouseover?default(false)>
	options_${escapedOptionId?html}.event = "mouseover";
  </#if>
  <#if parameters.active?if_exists != "">
	options_${escapedOptionId?html}.active = "${parameters.active?html}";
  </#if>
  <#if parameters.href?if_exists != "">
	options_${escapedOptionId?html}.href = "${parameters.href?html}";
  </#if>
  <#if parameters.header?if_exists != "">
	options_${escapedOptionId?html}.header = "${parameters.header?html}";
  </#if>
<#if parameters.animated?if_exists != "">
<#if parameters.animated?if_exists == "false">
	options_${escapedOptionId?html}.animated = false;
<#else>
	options_${escapedOptionId?html}.animated = "${parameters.animated?html}";
</#if>
</#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />

  <#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });  
</script>