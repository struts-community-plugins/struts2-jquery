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
  	<#if parameters.onClickTopics?exists>
	options_${escapedOptionId?html}.onclick = "${parameters.onClickTopics?html}";
  	</#if>

  <#include "/${parameters.templateDir}/jquery/base.ftl" />

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_tree.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
 });
</script>
