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
<#if parameters.href?default('false') == 'false'>
</script>
</#if>
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
	<#if parameters.href?if_exists != ""> 
	options_${escapedOptionId?html}.url = "${parameters.href?html}";
	</#if>
	<#if parameters.templateName?if_exists != ""> 
	options_${escapedOptionId?html}.name = "${parameters.templateName?html}";
	</#if>
	<#if parameters.type?if_exists != ""> 
	options_${escapedOptionId?html}.type = "${parameters.type?html}";
	</#if>
	<#if parameters.targets??>
	options_${escapedOptionId?html}.targets = "${parameters.targets?string}";
  	</#if>
  	<#if parameters.listenTopics??>
	options_${escapedOptionId?html}.listenTopics = "${parameters.listenTopics?string}";
  	</#if>
  	
	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	 options_${escapedOptionId?html}.id= "${escapedId?html}"; 
	<#--options_${escapedOptionId?html}.id= "${parameters.id?string}"; -->
	jQuery.struts2_jquery_handlebars.handlebars(options_${escapedOptionId?html});
 });
</script>
