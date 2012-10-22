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
</div>
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
  <#if parameters.selectedTab?exists>
	options_${escapedOptionId?html}.selectedtab = ${parameters.selectedTab?c};
  </#if>
  <#if parameters.openOnMouseover?default(false)>
	options_${escapedOptionId?html}.event = "mouseover";
  </#if>
  <#if parameters.collapsible?default(false)>
	options_${escapedOptionId?html}.collapsible = true;
  </#if>
  <#if parameters.useSelectedTabCookie?default(false)>
	options_${escapedOptionId?html}.cookie = true;
  </#if>
  <#if parameters.show?if_exists != "">
	options_${escapedOptionId?html}.show = ${parameters.show?html};
  </#if>
  <#if parameters.hide?if_exists != "">
	options_${escapedOptionId?html}.hide = ${parameters.hide?html};
  </#if>
  <#if parameters.cache?default(false)>
	options_${escapedOptionId?html}.cache = true;
  </#if>
  <#if parameters.disabledTabs?if_exists != "">
	options_${escapedOptionId?html}.disabledtabs = "${parameters.disabledTabs?html}";
  </#if>
  <#if parameters.sortable?default(false)>
	options_${escapedOptionId?html}.sortable = true;
  </#if>
  <#if parameters.heightStyle?if_exists != "">
	options_${escapedOptionId?html}.heightStyle = "${parameters.heightStyle?html}";
  </#if>
  <#if parameters.onLoadTopics?if_exists != "">
	options_${escapedOptionId?html}.onloadtopics = "${parameters.onLoadTopics?html}";
  </#if>
  <#if parameters.onActivateTopics?if_exists != "">
	options_${escapedOptionId?html}.onactivatetopics = "${parameters.onActivateTopics?html}";
  </#if>
<#if parameters.onBeforeActivateTopics?if_exists != "">
	options_${escapedOptionId?html}.onbefacttopics = "${parameters.onBeforeActivateTopics?html}";
</#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });  
</script>
