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
		<li id="${stack.findValue(parameters.nodeIdProperty)}"
		<#if parameters.nodeTypeProperty?if_exists != ""> 
			<#if stack.findValue(parameters.nodeTypeProperty)??> 
			rel="${stack.findValue(parameters.nodeTypeProperty)}"
			</#if>
		</#if>
		>
    <#if parameters.nodeHref?exists>
		<#if parameters.nodeTargets?if_exists != ""> 
			<a id="${stack.findValue(parameters.nodeIdProperty)}_anchor" href="javascript:void(0)">
    				${stack.findValue(parameters.nodeTitleProperty)}
			</a>
			<#assign escapedOptionId="${stack.findValue(parameters.nodeIdProperty)?string?replace('.', '_')}_anchor">
			<#assign escapedId="${stack.findValue(parameters.nodeIdProperty)?string?replace('.', '\\\\\\\\.')}_anchor">
			<script type='text/javascript'>
				jQuery(document).ready(function () { 
					var options_${escapedOptionId?html} = {};
					options_${escapedOptionId?html}.jqueryaction = "treeitem";
					options_${escapedOptionId?html}.id = "${stack.findValue(parameters.nodeIdProperty)}_anchor";
				  <#if parameters.nodeTargets?if_exists != "">
					options_${escapedOptionId?html}.targets = "${parameters.nodeTargets?html}";
				  </#if>
				  <#if parameters.nodeHref?if_exists != "">
					options_${escapedOptionId?html}.href = "${parameters.nodeHref?html}";
				  </#if>
					options_${escapedOptionId?html}.hrefparameter = "${parameters.nodeHrefParamName?default('id')}=${stack.findValue(parameters.nodeIdProperty)}";
					jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
		 		});  
			</script>
	    <#else>
			<a href="${parameters.nodeHref}?${parameters.nodeHrefParamName?default('id')}=${stack.findValue(parameters.nodeIdProperty)}">
    				${stack.findValue(parameters.nodeTitleProperty)}
			</a>
		</#if>
    <#else>
			<a href="javascript:void(0)">
    				${stack.findValue(parameters.nodeTitleProperty)}
			</a>
    </#if>
			<ul>
<#list stack.findValue(parameters.childCollectionProperty.toString())! as child>
    ${stack.push(child)}
    <#include "/${parameters.templateDir}/jquery/treenode-include.ftl" />
    <#assign oldNode = stack.pop() /> <#-- pop the node off of the stack, but don't show it -->
</#list>
			</ul>
		</li>
