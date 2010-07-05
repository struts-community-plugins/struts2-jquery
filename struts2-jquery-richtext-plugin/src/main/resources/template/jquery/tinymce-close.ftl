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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<script type='text/javascript'>
jQuery(document).ready(function () { 
	jQuery.struts2_jquery.require("js/struts2/jquery.richtext.struts2"+jQuery.struts2_jquery.minSuffix+".js");
	
	var options_${escapedOptionId?html} = {};
	options_${escapedOptionId?html}.type = 'text';

	options_${escapedOptionId?html}.path = "${base}/struts/js/tinymce/";
	
	<#if parameters.editorSkin?if_exists != ""> 
	options_${escapedOptionId?html}.skin = "${parameters.editorSkin?html}";
	</#if>
	<#if parameters.editorTheme?if_exists != ""> 
	options_${escapedOptionId?html}.theme = "${parameters.editorTheme?html}";
	</#if>
	<#if parameters.width??> 
	options_${escapedOptionId?html}.width = ${parameters.width?html};
	</#if>
	<#if parameters.height??> 
	options_${escapedOptionId?html}.height = ${parameters.height?html};
	</#if>
	<#if parameters.editorLocal?if_exists != ""> 
	options_${escapedOptionId?html}.editorLocal = "${parameters.editorLocal?html}";
	</#if>
	<#if parameters.toolbarLocation?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_toolbar_location = "${parameters.toolbarLocation?html}";
	</#if>
	<#if parameters.toolbarAlign?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_toolbar_align = "${parameters.toolbarAlign?html}";
	</#if>
	<#if parameters.statusbarLocation?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_statusbar_location = "${parameters.statusbarLocation?html}";
	</#if>
	<#if parameters.editorResizable?if_exists != ""> 
	options_${escapedOptionId?html}.editorResizable = "${parameters.editorResizable?html}";
	</#if>
	<#if parameters.plugins?if_exists != ""> 
	options_${escapedOptionId?html}.plugins = "${parameters.plugins?html}";
	</#if>
	<#if parameters.toolbarButtonsRow1?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_buttons1 = "${parameters.toolbarButtonsRow1?replace(" ", "")?html}";
	</#if>
	<#if parameters.toolbarButtonsRow2?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_buttons2 = "${parameters.toolbarButtonsRow2?replace(" ", "")?html}";
	</#if>
	<#if parameters.toolbarButtonsRow3?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_buttons3 = "${parameters.toolbarButtonsRow3?replace(" ", "")?html}";
	</#if>
	<#if parameters.toolbarButtonsRow4?if_exists != ""> 
	options_${escapedOptionId?html}.theme_advanced_buttons4 = "${parameters.toolbarButtonsRow4?replace(" ", "")?html}";
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
	jQuery.struts2_jquery_richtext.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
 });  
</script>
