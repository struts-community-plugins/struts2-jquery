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
<#if !parameters.subGrid?default(false)>
<table id="${parameters.id?html}" class="scroll" cellpadding="0" cellspacing="0"
<#if parameters.cssStyle?if_exists != "">
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.cssClass?if_exists != "">
 class="${parameters.cssClass?html} scroll"<#rt/>
<#else>
 class="scroll"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
></table>
<#if parameters.pager?default(false) || parameters.navigator?default(false)>
<div id="${parameters.id?html}_pager"></div>
</#if>
</#if>

<#if parameters.subGrid?default(false)>
	<#assign escapedParentOptionId="${parameters.parentGrid?string?replace('.', '_')}">
	options_${escapedParentOptionId?html}.subgrid = true;
	<#if parameters.subGridWidth?if_exists != "">
	options_${escapedParentOptionId?html}.subGridWidth = "${parameters.subGridWidth?html}";
	</#if>
<#else>
<script type='text/javascript'>
jQuery(document).ready(function () { 
	jQuery.struts2_jquery.require("js/struts2/jquery.grid.struts2"+jQuery.struts2_jquery.minSuffix+".js");
</#if>
	var options_${escapedOptionId?html} = {};
	var options_${escapedOptionId?html}_colmodels = new Array();
	var options_${escapedOptionId?html}_colnames = new Array();
