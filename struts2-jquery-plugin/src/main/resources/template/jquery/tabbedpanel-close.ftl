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
</div>
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
  <#if parameters.selectedTab??>
	options_${escapedOptionId}.selectedtab = ${parameters.selectedTab?c};
  </#if>
  <#if parameters.openOnMouseover!false>
	options_${escapedOptionId}.event = "mouseover";
  </#if>
  <#if parameters.collapsible!false>
	options_${escapedOptionId}.collapsible = true;
  </#if>
  <#if parameters.useSelectedTabCookie!false>
	options_${escapedOptionId}.cookie = true;
  </#if>
  <#if parameters.show! != "">
	options_${escapedOptionId}.show = ${parameters.show};
  </#if>
  <#if parameters.hide! != "">
	options_${escapedOptionId}.hide = ${parameters.hide};
  </#if>
  <#if parameters.cache!false>
	options_${escapedOptionId}.cache = true;
  </#if>
  <#if parameters.disabledTabs! != "">
	options_${escapedOptionId}.disabledtabs = "${parameters.disabledTabs}";
  </#if>
  <#if parameters.sortable!false>
	options_${escapedOptionId}.sortable = true;
  </#if>
  <#if parameters.heightStyle! != "">
	options_${escapedOptionId}.heightStyle = "${parameters.heightStyle}";
  </#if>
  <#if parameters.onLoadTopics! != "">
	options_${escapedOptionId}.onloadtopics = "${parameters.onLoadTopics}";
  </#if>
  <#if parameters.onActivateTopics! != "">
	options_${escapedOptionId}.onactivatetopics = "${parameters.onActivateTopics}";
  </#if>
<#if parameters.onBeforeActivateTopics! != "">
	options_${escapedOptionId}.onbefacttopics = "${parameters.onBeforeActivateTopics}";
</#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</script>
