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
</div>
<script type='text/javascript'>
$(document).ready(function () { 
	var options_${parameters.id?html} = {};
  <#if parameters.selectedTab?exists>
	options_${parameters.id?html}.selectedtab = "${parameters.selectedTab?html}";
  </#if>
  <#if parameters.openOnMouseover?default(false)>
	options_${parameters.id?html}.event = "mouseover";
  </#if>
  <#if parameters.collapsible?default(false)>
	options_${parameters.id?html}.collapsible = true;
  </#if>
  <#if parameters.useSelectedTabCookie?default(false)>
	options_${parameters.id?html}.cookie = true;
  </#if>
  <#if parameters.animate?default(false)>
	options_${parameters.id?html}.animate = true;
  </#if>
  <#if parameters.cache?default(false)>
	options_${parameters.id?html}.cache = true;
  </#if>
  <#if parameters.spinner?if_exists != "">
	options_${parameters.id?html}.spinner = "${parameters.spinner?html}";
  </#if>
  <#if parameters.disabledTabs?if_exists != "">
	options_${parameters.id?html}.disabledtabs = "${parameters.disabledTabs?html}";
  </#if>
  <#if parameters.onAddTopics?if_exists != "">
	options_${parameters.id?html}.onaddtopics = "${parameters.onAddTopics?html}";
  </#if>
  <#if parameters.onRemoveTopics?if_exists != "">
	options_${parameters.id?html}.onremovetopics = "${parameters.onRemoveTopics?html}";
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });  
</script>
