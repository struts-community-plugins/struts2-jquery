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
<#assign escapedOptionId="${parameters.escapedId}">
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
        <#if itemValue! == "">
            <#assign itemValue = itemKeyStr/>
        </#if>
        <#if parameters.paramValues! != "">
            <#assign hrefValues>
                <#list parameters.paramValues?split(",") as tmp>${stack.findString(tmp)!''}<#if tmp_has_next>,</#if></#list>
            </#assign>
        </#if>
        <li id="${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />">
            <div>
                <#if parameters.href??>
                    <#if parameters.targets! != "">
                        <a id="${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />_anchor" href="javascript:void(0)">
                            ${itemValue}
                        </a>
                        <#assign escapedOptionLinkId="${escapedOptionId}_li">
                        <#assign optionsLiVariableName>options_${escapedOptionLinkId}_<@s.property value="%{#rowstatus.count}" /></#assign>
                        <@s.script type='text/javascript'>
                            jQuery(document).ready(function () {
                                var ${optionsLiVariableName} = {};
                                ${optionsLiVariableName}.jqueryaction = "menuItem";
                                ${optionsLiVariableName}.id = "${escapedOptionId}_li_<@s.property value="%{#rowstatus.count}" />";
                            <#if parameters.targets! != "">
                                ${optionsLiVariableName}.targets = "${parameters.targets}";
                            </#if>
                            <#if parameters.href! != "">
                                ${optionsLiVariableName}.href = "${parameters.href}";
                            </#if>
                                ${optionsLiVariableName}.hrefparameter = "${parameters.paramName!'id'}=${itemKeyStr}";
                                jQuery.struts2_jquery_ui.bind(jQuery('#${escapedOptionId?string?replace('.', '\\\\\\\\.')}_li_<@s.property value="%{#rowstatus.count}" />'), ${optionsLiVariableName});
                            });
                        </@s.script>
                    <#else>
                        <a href="${parameters.href}?${parameters.paramName!'id'}=${itemKeyStr}">
                            ${itemValue}
                        </a>
                    </#if>
                <#else>
                    <a href="javascript:void(0)">
                        ${itemValue}
                    </a>
                </#if>
            </div>
        </li>
    </@s.iterator>
</#if>
</ul>
<#if !parameters.subMenu!false>
    <@s.script type='text/javascript'>
        jQuery(document).ready(function () {
            var options_${escapedOptionId} = {};
        <#if parameters.disabled!false>
            options_${escapedOptionId}.disabled = true;
        </#if>
        <#if parameters.targets! != "">
            options_${escapedOptionId}.targets = "${parameters.targets}";
        </#if>
        <#if parameters.href! != "">
            options_${escapedOptionId}.href = "${parameters.href}";
        </#if>
            <#include "/${parameters.templateDir}/jquery/base.ftl" />
            <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
            <#include "/${parameters.templateDir}/jquery/topics.ftl" />

            <#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
        });
    </@s.script>
</#if>
