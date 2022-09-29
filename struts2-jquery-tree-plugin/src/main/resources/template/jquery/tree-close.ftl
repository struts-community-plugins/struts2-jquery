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
<#assign escapedOptionId="${parameters.escapedId}">
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
	<#if parameters.jstreetheme! != "">
	options_${escapedOptionId}.treetheme = "${parameters.jstreetheme}";
	</#if>
	<#if parameters.jstreethemeVariant! != "">
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
	<#if parameters.href! != "">
	options_${escapedOptionId}.url = "<#outputformat "JavaScript">${parameters.href}</#outputformat>";
	</#if>
  	<#if parameters.nodeTargets??>
	options_${escapedOptionId}.nodeTargets = "${parameters.nodeTargets}";
  	</#if>
  	<#if parameters.nodeHref??>
	options_${escapedOptionId}.nodeHref = "${parameters.nodeHref}";
  	</#if>
  	<#if parameters.nodeHref??>
	options_${escapedOptionId}.nodeHrefParamName = "${parameters.nodeHrefParamName!'id'}";
  	</#if>
  	<#if parameters.onClickTopics??>
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
	<#if parameters.contextmenu! != "">
	options_${escapedOptionId}.contextmenu = <#outputformat "JavaScript">${parameters.contextmenu?string}</#outputformat>;
	</#if>
	<#if parameters.plugins! != "">
	options_${escapedOptionId}.pluginsconf = <#outputformat "JavaScript">${parameters.plugins?string}</#outputformat>;
	</#if>
	<#if parameters.types! != "">
	options_${escapedOptionId}.types = <#outputformat "JavaScript">${parameters.types?string}</#outputformat>;
	</#if>
	<#if parameters.checkbox??>
	options_${escapedOptionId}.checkbox = <#outputformat "JavaScript">${parameters.checkbox?string}</#outputformat>;
	</#if>
	<#if parameters.checkboxTwoState??>
	options_${escapedOptionId}.two_state = ${parameters.checkboxTwoState?string};
	</#if>
	<#if parameters.checkboxToogleAllTopics! != "">
	options_${escapedOptionId}.toogleAllTopics = "${parameters.checkboxToogleAllTopics?string}";
	</#if>
	<#if parameters.checkboxHideTopics! != "">
	options_${escapedOptionId}.checkHideTopics = "${parameters.checkboxHideTopics?string}";
	</#if>
	<#if parameters.checkboxShowTopics! != "">
	options_${escapedOptionId}.checkShowTopics = "${parameters.checkboxShowTopics?string}";
	</#if>
    <#if parameters.checkboxCheckAllTopics! != "">
    options_${escapedOptionId}.checkAllTopics = "${parameters.checkboxCheckAllTopics?string}";
    </#if>
    <#if parameters.checkboxUncheckAllTopics! != "">
    options_${escapedOptionId}.uncheckAllTopics = "${parameters.checkboxUncheckAllTopics?string}";
    </#if>
    <#if parameters.searchTopic! != "">
    options_${escapedOptionId}.searchTopic = "${parameters.searchTopic?string}";
    </#if>
    <#if parameters.searchClearTopic! != "">
    options_${escapedOptionId}.searchClearTopic = "${parameters.searchClearTopic?string}";
    </#if>
    <#if parameters.searchElementId! != "">
    options_${escapedOptionId}.searchElementId = "${parameters.searchElementId?string}";
    </#if>
    <#if parameters.onSearchCompleteTopics! != "">
    options_${escapedOptionId}.onSearchCompleteTopics = "${parameters.onSearchCompleteTopics?string}";
    </#if>
    <#if parameters.onSearchClearTopics! != "">
    options_${escapedOptionId}.onSearchClearTopics = "${parameters.onSearchClearTopics?string}";
    </#if>

  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/base.ftl" />

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
 });
</script>
