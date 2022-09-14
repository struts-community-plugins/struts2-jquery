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
	jQuery.struts2_jquery.require("js/struts2/jquery.richtext.struts2"+jQuery.struts2_jquery.minSuffix+".js");

	var options_${escapedOptionId} = {};
	options_${escapedOptionId}.type = 'text';

	options_${escapedOptionId}.path = "${base}/static/js/tinymce/";

	<#if parameters.editorSkin! != "">
	options_${escapedOptionId}.skin = "${parameters.editorSkin}";
	</#if>
	<#if parameters.editorSkinVariant! != "">
	options_${escapedOptionId}.skin_variant = "${parameters.editorSkinVariant}";
	</#if>
	options_${escapedOptionId}.theme = "${parameters.editorTheme!"modern"}";
	<#if parameters.width??>
	options_${escapedOptionId}.width = ${parameters.width};
	</#if>
	<#if parameters.height??>
	options_${escapedOptionId}.height = ${parameters.height};
	</#if>
	<#if parameters.editorLocal! != "">
	options_${escapedOptionId}.editorLocal = "${parameters.editorLocal}";
	</#if>
	<#if parameters.toolbarLocation! != "">
	options_${escapedOptionId}.theme_advanced_toolbar_location = "${parameters.toolbarLocation}";
	</#if>
	<#if parameters.toolbarAlign! != "">
	options_${escapedOptionId}.theme_advanced_toolbar_align = "${parameters.toolbarAlign}";
	</#if>
	<#if parameters.statusbarLocation! != "">
	options_${escapedOptionId}.theme_advanced_statusbar_location = "${parameters.statusbarLocation}";
	</#if>
  	<#if parameters.pasteplain!false>
	options_${escapedOptionId}.pasteplain = true;
  	</#if>
  	<#if parameters.editorResizable!false>
	options_${escapedOptionId}.editorResizable = true;
  	</#if>
	<#if parameters.plugins! != "">
	options_${escapedOptionId}.plugins = "${parameters.plugins}";
	</#if>
	<#if parameters.toolbarButtonsRow1! != "">
	options_${escapedOptionId}.theme_advanced_buttons1 = "${parameters.toolbarButtonsRow1?replace(" ", "")}";
	</#if>
	<#if parameters.toolbarButtonsRow2! != "">
	options_${escapedOptionId}.theme_advanced_buttons2 = "${parameters.toolbarButtonsRow2?replace(" ", "")}";
	</#if>
	<#if parameters.toolbarButtonsRow3! != "">
	options_${escapedOptionId}.theme_advanced_buttons3 = "${parameters.toolbarButtonsRow3?replace(" ", "")}";
	</#if>
	<#if parameters.toolbarButtonsRow4! != "">
	options_${escapedOptionId}.theme_advanced_buttons4 = "${parameters.toolbarButtonsRow4?replace(" ", "")}";
	</#if>
	<#if parameters.entityEncoding! != "">
	options_${escapedOptionId}.entity_encoding = "${parameters.entityEncoding}";
	</#if>
	<#if parameters.contentCss! != "">
	options_${escapedOptionId}.content_css = "${parameters.contentCss?string}";
	</#if>
	<#if parameters.removeLinebreaks??>
	options_${escapedOptionId}.remove_linebreaks = ${parameters.removeLinebreaks?string};
	</#if>
	<#if parameters.removeRedundantBrs??>
	options_${escapedOptionId}.remove_redundant_brs = ${parameters.removeRedundantBrs?string};
	</#if>
	<#if parameters.onSaveTopics! != "">
	options_${escapedOptionId}.onsavetopics = "${parameters.onSaveTopics}";
	</#if>
	<#if parameters.onEventTopics! != "">
	options_${escapedOptionId}.oneventtopics = "${parameters.onEventTopics}";
	</#if>

  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />
  <#include "/${parameters.templateDir}/jquery/draggable.ftl" />
  <#include "/${parameters.templateDir}/jquery/droppable.ftl" />
  <#include "/${parameters.templateDir}/jquery/resizable.ftl" />
  <#include "/${parameters.templateDir}/jquery/selectable.ftl" />
  <#include "/${parameters.templateDir}/jquery/sortable.ftl" />

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_richtext.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
 });
</script>
