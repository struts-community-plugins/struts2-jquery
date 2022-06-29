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
var CKEDITOR_BASEPATH = "${base}/static/js/ckeditor/";
jQuery(document).ready(function () { 
	jQuery.struts2_jquery.require("js/struts2/jquery.richtext.struts2"+jQuery.struts2_jquery.minSuffix+".js");
	
	var options_${escapedOptionId} = {};
	options_${escapedOptionId}.type = 'text';

	options_${escapedOptionId}.path = "${base}/static/js/ckeditor/";
	
	<#if parameters.customConfig?if_exists != ""> 
	options_${escapedOptionId}.customConfig = "${parameters.customConfig}";
	</#if>
	<#if parameters.skin?if_exists != ""> 
	options_${escapedOptionId}.skin = "${parameters.skin}";
	<#else>
    options_${escapedOptionId}.skin = "moono";
	</#if>
	<#if parameters.toolbar?if_exists != "">
	options_${escapedOptionId}.toolbar = "${parameters.toolbar}";
	</#if>
	<#if parameters.width??> 
	options_${escapedOptionId}.width = ${parameters.width};
	</#if>
	<#if parameters.height??> 
	options_${escapedOptionId}.height = ${parameters.height};
	</#if>
	<#if parameters.editorLocal?if_exists != ""> 
	options_${escapedOptionId}.editorLocal = "${parameters.editorLocal}";
	</#if>
	<#if parameters.uploads?default(false)>
		<#if parameters.uploadHref?if_exists != ""> 
	options_${escapedOptionId}.filebrowserUploadUrl = "${parameters.uploadHref}";
		<#else>
	<@s.url var="ckeditorUploadUrl" action="upload" namespace="/ckeditor"/>
	options_${escapedOptionId}.filebrowserUploadUrl = "<@s.property value="ckeditorUploadUrl" />";
		</#if>
	</#if>
  	<#if parameters.editorResizable?default(false)>
	options_${escapedOptionId}.editorResizable = true;
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
