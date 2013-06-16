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
	</ul>
<#include "/${parameters.templateDir}/simple/div-close.ftl" />
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
	<#if parameters.jstreetheme?if_exists != ""> 
	options_${escapedOptionId?html}.treetheme = "${parameters.jstreetheme?html}";
	</#if>
  	<#if parameters.animation??>
	options_${escapedOptionId?html}.animation = ${parameters.animation?c};
  	</#if>
  	<#if parameters.initiallyOpen??>
	options_${escapedOptionId?html}.initially_open = ${parameters.initiallyOpen?string};
  	</#if>
	<#if parameters.htmlTitles??>
	options_${escapedOptionId?html}.html_titles = ${parameters.htmlTitles?string};
	</#if>
	<#if parameters.rtl??>
	options_${escapedOptionId?html}.rtl = ${parameters.rtl?string};
	</#if>
	<#if parameters.href?if_exists != ""> 
	options_${escapedOptionId?html}.url = "${parameters.href?string}";
	</#if>
  	<#if parameters.nodeTargets?exists>
	options_${escapedOptionId?html}.nodeTargets = "${parameters.nodeTargets?html}";
  	</#if>
  	<#if parameters.nodeHref?exists>
	options_${escapedOptionId?html}.nodeHref = "${parameters.nodeHref?html}";
  	</#if>
  	<#if parameters.nodeHref?exists>
	options_${escapedOptionId?html}.nodeHrefParamName = "${parameters.nodeHrefParamName?default('id')}";
  	</#if>
  	<#if parameters.onClickTopics?exists>
	options_${escapedOptionId?html}.onclick = "${parameters.onClickTopics?html}";
  	</#if>
	<#if parameters.openAllOnLoad??>
	options_${escapedOptionId?html}.openload = ${parameters.openAllOnLoad?string};
	</#if>
	<#if parameters.openAllOnRefresh??>
	options_${escapedOptionId?html}.openrefresh = ${parameters.openAllOnRefresh?string};
	</#if>
    <#if parameters.showThemeDots??>
        options_${escapedOptionId?html}.dots = ${parameters.showThemeDots?string};
    </#if>
    <#if parameters.showThemeIcons??>
        options_${escapedOptionId?html}.icons = ${parameters.showThemeIcons?string};
    </#if>
	<#if parameters.contextmenu?if_exists != "">
	options_${escapedOptionId?html}.contextmenu = ${parameters.contextmenu?string};
	</#if>
	<#if parameters.types?if_exists != ""> 
	options_${escapedOptionId?html}.types = ${parameters.types?string};
	</#if>
	<#if parameters.checkbox??>
	options_${escapedOptionId?html}.checkbox = ${parameters.checkbox?string};
	</#if>
	<#if parameters.checkboxTwoState??>
	options_${escapedOptionId?html}.two_state = ${parameters.checkboxTwoState?string};
	</#if>
	<#if parameters.checkboxCheckAllTopics?if_exists != ""> 
	options_${escapedOptionId?html}.checkAllTopics = "${parameters.checkboxCheckAllTopics?string}";
	</#if>
	<#if parameters.checkboxUncheckAllTopics?if_exists != ""> 
	options_${escapedOptionId?html}.uncheckAllTopics = "${parameters.checkboxUncheckAllTopics?string}";
	</#if>
	<#if parameters.checkboxHideTopics?if_exists != ""> 
	options_${escapedOptionId?html}.checkHideTopics = "${parameters.checkboxHideTopics?string}";
	</#if>
	<#if parameters.checkboxShowTopics?if_exists != ""> 
	options_${escapedOptionId?html}.checkShowTopics = "${parameters.checkboxShowTopics?string}";
	</#if>

  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/base.ftl" />

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
 });
</script>
