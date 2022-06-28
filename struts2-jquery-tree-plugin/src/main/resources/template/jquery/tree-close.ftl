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
</div>
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId} = {};
	<#if parameters.jstreetheme?if_exists != ""> 
	options_${escapedOptionId}.treetheme = "${parameters.jstreetheme}";
	</#if>
	<#if parameters.jstreethemeVariant?if_exists != ""> 
	options_${escapedOptionId}.treethemeVariant = "${parameters.jstreethemeVariant}";
	</#if>
	<#if parameters.jstreethemeResponsive??>
	options_${escapedOptionId}.treethemeResponsive = ${parameters.jstreethemeResponsive?string};
  	</#if>
  	<#if parameters.animation??>
	options_${escapedOptionId}.animation = ${parameters.animation?c};
  	</#if>
  	<#if parameters.initiallyOpen??>
	options_${escapedOptionId}.initially_open = ${parameters.initiallyOpen?string};
  	</#if>
	<#if parameters.htmlTitles??>
	options_${escapedOptionId}.html_titles = ${parameters.htmlTitles?string};
	</#if>
	<#if parameters.rtl??>
	options_${escapedOptionId}.rtl = ${parameters.rtl?string};
	</#if>
	<#if parameters.href?if_exists != ""> 
	options_${escapedOptionId}.url = "${parameters.href?string}";
	</#if>
  	<#if parameters.nodeTargets?exists>
	options_${escapedOptionId}.nodeTargets = "${parameters.nodeTargets}";
  	</#if>
  	<#if parameters.nodeHref?exists>
	options_${escapedOptionId}.nodeHref = "${parameters.nodeHref}";
  	</#if>
  	<#if parameters.nodeHref?exists>
	options_${escapedOptionId}.nodeHrefParamName = "${parameters.nodeHrefParamName?default('id')}";
  	</#if>
  	<#if parameters.onClickTopics?exists>
	options_${escapedOptionId}.onclick = "${parameters.onClickTopics}";
  	</#if>
	<#if parameters.openAllOnLoad??>
	options_${escapedOptionId}.openload = ${parameters.openAllOnLoad?string};
	</#if>
	<#if parameters.openAllOnRefresh??>
	options_${escapedOptionId}.openrefresh = ${parameters.openAllOnRefresh?string};
	</#if>
    <#if parameters.showThemeDots??>
        options_${escapedOptionId}.dots = ${parameters.showThemeDots?string};
    </#if>
    <#if parameters.showThemeIcons??>
        options_${escapedOptionId}.icons = ${parameters.showThemeIcons?string};
    </#if>
	<#if parameters.contextmenu?if_exists != "">
	options_${escapedOptionId}.contextmenu = ${parameters.contextmenu?string};
	</#if>
	<#if parameters.plugins?if_exists != "">
	options_${escapedOptionId}.pluginsconf = ${parameters.plugins?string};
	</#if>
	<#if parameters.types?if_exists != ""> 
	options_${escapedOptionId}.types = ${parameters.types?string};
	</#if>
	<#if parameters.checkbox??>
	options_${escapedOptionId}.checkbox = ${parameters.checkbox?string};
	</#if>
	<#if parameters.checkboxTwoState??>
	options_${escapedOptionId}.two_state = ${parameters.checkboxTwoState?string};
	</#if>
	<#if parameters.checkboxToogleAllTopics?if_exists != "">
	options_${escapedOptionId}.toogleAllTopics = "${parameters.checkboxToogleAllTopics?string}";
	</#if>
	<#if parameters.checkboxHideTopics?if_exists != "">
	options_${escapedOptionId}.checkHideTopics = "${parameters.checkboxHideTopics?string}";
	</#if>
	<#if parameters.checkboxShowTopics?if_exists != ""> 
	options_${escapedOptionId}.checkShowTopics = "${parameters.checkboxShowTopics?string}";
	</#if>
    <#if parameters.checkboxCheckAllTopics?if_exists != "">
    options_${escapedOptionId}.checkAllTopics = "${parameters.checkboxCheckAllTopics?string}";
    </#if>
    <#if parameters.checkboxUncheckAllTopics?if_exists != "">
    options_${escapedOptionId}.uncheckAllTopics = "${parameters.checkboxUncheckAllTopics?string}";
    </#if>
    <#if parameters.searchTopic?if_exists != "">
    options_${escapedOptionId}.searchTopic = "${parameters.searchTopic?string}";
    </#if>
    <#if parameters.searchClearTopic?if_exists != "">
    options_${escapedOptionId}.searchClearTopic = "${parameters.searchClearTopic?string}";
    </#if>
    <#if parameters.searchElementId?if_exists != "">
    options_${escapedOptionId}.searchElementId = "${parameters.searchElementId?string}";
    </#if>
    <#if parameters.onSearchCompleteTopics?if_exists != "">
    options_${escapedOptionId}.onSearchCompleteTopics = "${parameters.onSearchCompleteTopics?string}";
    </#if>
    <#if parameters.onSearchClearTopics?if_exists != "">
    options_${escapedOptionId}.onSearchClearTopics = "${parameters.onSearchClearTopics?string}";
    </#if>

  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/base.ftl" />

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
 });
</script>
