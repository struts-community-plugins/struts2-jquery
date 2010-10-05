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
	options_${escapedOptionId?html}.value = ${parameters.value?default('0')};
  <#if parameters.widgetid?if_exists != "">
	options_${escapedOptionId?html}.hiddenid = "${parameters.widgetid?html}";
  </#if>
  <#if parameters.animate?default(false)>
	options_${escapedOptionId?html}.animate = true;
  </#if>
  <#if parameters.range?if_exists != "">
	options_${escapedOptionId?html}.range = "${parameters.range?html}";
  </#if>
  <#if parameters.max??>
	options_${escapedOptionId?html}.max = ${parameters.max?c};
  </#if>
  <#if parameters.min??>
	options_${escapedOptionId?html}.min = ${parameters.min?c};
  </#if>
  <#if parameters.orientation?if_exists != "">
	options_${escapedOptionId?html}.orientation = "${parameters.orientation?html}";
  </#if>
  <#if parameters.step??>
	options_${escapedOptionId?html}.step = ${parameters.step?c};
  </#if>
  <#if parameters.displayValueElement?if_exists != "">
	options_${escapedOptionId?html}.displayvalueelement = "${parameters.displayValueElement?html}";
  </#if>
  <#if parameters.onSlideTopics?exists>
	options_${escapedOptionId?html}.onslidetopics = "${parameters.onSlideTopics?html}";
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });
</script>
