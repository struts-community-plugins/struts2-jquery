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
var CKEDITOR_BASEPATH = "${base}/struts/js/ckeditor/";
$(document).ready(function () { 
	$.require("js/struts2/jquery.richtext.struts2"+$.struts2_jquery.minSuffix+".js");
	
	var options_${escapedOptionId?html} = {};
	options_${escapedOptionId?html}.type = 'text';

	options_${escapedOptionId?html}.path = "${base}/struts/js/ckeditor/";
	
	<#if parameters.customConfig?if_exists != ""> 
	options_${escapedOptionId?html}.config = { }
	options_${escapedOptionId?html}.config.customConfig = "${parameters.customConfig?html}";
	</#if>
	<#if parameters.skin?if_exists != ""> 
	options_${escapedOptionId?html}.skin = "${parameters.skin?html}";
	</#if>
	<#if parameters.toolbar?if_exists != ""> 
	options_${escapedOptionId?html}.toolbar = "${parameters.toolbar?html}";
	</#if>
	<#if parameters.width??> 
	options_${escapedOptionId?html}.width = ${parameters.width?html};
	</#if>
	<#if parameters.height??> 
	options_${escapedOptionId?html}.height = ${parameters.height?html};
	</#if>
	options_${escapedOptionId?html}.language = "${parameters.editorLocal?default("en")}";

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
	$.struts2_jquery_richtext.bind($('#${escapedId?html}'),options_${escapedOptionId?html});
 });  
</script>
