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
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_tab_${escapedOptionId} = {};
  <#if parameters.id! != "">
	options_tab_${escapedOptionId}.id = "${parameters.id}";
  </#if>
  <#if parameters.cssStyle! != "">
	options_tab_${escapedOptionId}.cssstyle = "${parameters.cssStyle}";
  </#if>
  <#if parameters.cssClass! != "">
	options_tab_${escapedOptionId}.cssclass = "${parameters.cssClass}";
  </#if>
  <#if parameters.formIds! != "">
	options_tab_${escapedOptionId}.formIds = "${parameters.formIds}";
  </#if>
  <#if parameters.href! != "">
	options_tab_${escapedOptionId}.href = "${parameters.href}";
  <#elseif parameters.target! != "" >
	options_tab_${escapedOptionId}.href = "#${parameters.target}";
  <#else>
	options_tab_${escapedOptionId}.href = "#";
  </#if>
  <#if parameters.label! != "">
	options_tab_${escapedOptionId}.label = "${parameters.label}";
  </#if>
  <#if parameters.closable??>
	options_tab_${escapedOptionId}.closable = ${parameters.closable?string};
  </#if>
  <#if parameters.parentTabbedPanel! != "">
  	<#assign escapedParentOptionId="${parameters.parentTabbedPanel?string?replace('.', '_')}">
  	var tabs = jQuery('#${parameters.parentTabbedPanel?string?replace('.', '\\\\\\\\.')}').data('taboptions');
  	if(!tabs) {
  		tabs = [];
  	}
  	tabs.push(options_tab_${escapedOptionId});
  	jQuery('#${parameters.parentTabbedPanel?string?replace('.', '\\\\\\\\.')}').data('taboptions', tabs);
  </#if>
 });
</script>
