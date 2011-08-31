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
        <#if parameters.listCounter??>
            <#if stack.findString(parameters.listCounter)??>
              <#assign itemCounter = stack.findString(parameters.listCounter)/>
            <#else>
              <#assign itemCounter = ''/>
            </#if>
        <#else>
            <#assign itemCounter = ''/>
        </#if>
    <li id="${parameters.id?html}_li_<@s.property value="%{#rowstatus.count}" />">
    <#if parameters.listHref?if_exists != "">
        <a<#rt/>
		     href="${parameters.listHref}?${parameters.listParam?default("id")}=${itemKey?html}"<#rt/>
    	>
    </#if>
                ${itemValue?html}
    <#if itemCounter?if_exists != "">
          <span class="ui-li-count">${itemCounter?html}</span>
    </#if>
    <#if parameters.listHref?if_exists != "">
        </a>
    </#if>
	</li>
	<#lt/>
</@s.iterator>
</ul>
