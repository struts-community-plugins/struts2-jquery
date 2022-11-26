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
		<#assign itemId = stack.findValue(parameters.nodeIdProperty)/>
		<li id="${itemId}"
		<#if parameters.nodeTypeProperty?if_exists != "">
			<#if stack.findValue(parameters.nodeTypeProperty)??>
                    data-jstree='{"type" : "${stack.findValue(parameters.nodeTypeProperty)}"}'
			</#if>
		</#if>
		<#if parameters.checkbox?default(false)>
	    <#if tag.contains(parameters.nameValue, itemId) == true>
			data-checked="true"<#rt/>
		<#else>
			data-checked="false"<#rt/>
		</#if>
		</#if>
		>
    <#if parameters.nodeHref?if_exists != "">
		<#if parameters.nodeTargets?if_exists != "">
			<a id="${itemId}_anchor" href="javascript:void(0)" data-targets="${parameters.nodeTargets}">
    				${stack.findValue(parameters.nodeTitleProperty)}
			</a>
	    <#else>
			<a href="${parameters.nodeHref}?${parameters.nodeHrefParamName?default('id')}=${itemId}">
    				${stack.findValue(parameters.nodeTitleProperty?default('text'))}
			</a>
		</#if>
    <#else>
			<a href="javascript:void(0)">
    				${stack.findValue(parameters.nodeTitleProperty?default('text'))}
			</a>
    </#if>
			<ul>
<#if stack.findValue(parameters.childCollectionProperty.toString())?is_enumerable>
    <#list stack.findValue(parameters.childCollectionProperty.toString())! as child>
        ${stack.push(child)}
        <#include "/${parameters.templateDir}/jquery/treenode-include.ftl" />
        <#assign oldNode = stack.pop() /> <#-- pop the node off of the stack, but don't show it -->
    </#list>
</#if>
			</ul>
		</li>
        <#if parameters.nodeHref?if_exists != "" && parameters.nodeTargets?if_exists != "">
            <#assign escapedOptionId="${itemId?string?replace('.', '_')}_anchor">
            <#assign escapedId="${itemId?string?replace('.', '\\\\\\\\.')}_anchor">
        <@s.script type='text/javascript'>
            jQuery(document).ready(function () {
                var options_${escapedOptionId} = {};
                options_${escapedOptionId}.jqueryaction = "treeitem";
                options_${escapedOptionId}.id = "${itemId}_anchor";
                options_${escapedOptionId}.href = "${parameters.nodeHref}";
                options_${escapedOptionId}.targets = "${parameters.nodeTargets}";
                options_${escapedOptionId}.hrefparameter = "${parameters.nodeHrefParamName?default('id')}=${itemId}";
                jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
            });
        </@s.script>
        </#if>
