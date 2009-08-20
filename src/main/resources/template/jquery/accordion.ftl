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

<ul
  <#if parameters.fillSpace?default(false)>
    fillSpace="true"<#rt/>
  </#if>
  <#if parameters.collapsible?default(false)>
    collapsible="true"<#rt/>
  </#if>
  <#if parameters.clearStyle?default(false)>
    clearStyle="true"<#rt/>
  </#if>
  <#if parameters.autoHeight?default(false)>
    autoHeight="true"<#rt/>
  </#if>
  <#if parameters.openOnMouseover?default(false)>
    event="mouseover"<#rt/>
  </#if>
  <#if parameters.active?if_exists != "">
    active="${parameters.active?html}"<#rt/>
  </#if>
  <#if parameters.href?if_exists != "">
    href="${parameters.href?html}"<#rt/>
  </#if>
  <#if parameters.header?if_exists != "">
    header="${parameters.header?html}"<#rt/>
  </#if>
<#if parameters.animated?if_exists != "">
<#if parameters.animated?if_exists == "false">
    animated="false"<#rt/>
<#else>
    animated="${parameters.animated?html}"<#rt/>
</#if>
</#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
<@s.iterator value="parameters.list">
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
    <li>
	<${parameters.header?default('h3')}><a href="#"
<#if parameters.paramKeys?if_exists != "">
	 paramkeys="${parameters.paramKeys?trim}"
</#if>	 
<#if parameters.paramValues?if_exists != "">
	 paramvalues="${hrefValues?trim}"
</#if>	 
	 >${itemKeyStr?html}</a></${parameters.header?default('h3')}>
		<div>
			<p>
<#if parameters.href?if_exists == "">
			${itemValue?html}
</#if>			
			</p>
		</div>
	</li>
	<#lt/>
</@s.iterator>
</ul>
<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
