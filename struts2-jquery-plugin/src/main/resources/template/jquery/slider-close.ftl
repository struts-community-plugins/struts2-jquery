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
  <#if parameters.value! != "">
	options_${escapedOptionId}.value = ${parameters.value!'0'};
  </#if>
  <#if parameters.arrayValue! != "">
	options_${escapedOptionId}.values = ${parameters.arrayValue?string};
  </#if>
  <#if parameters.widgetid! != "">
	options_${escapedOptionId}.hiddenid = "${parameters.widgetid}";
  </#if>
  <#if parameters.animate!false>
	options_${escapedOptionId}.animate = true;
  </#if>
  <#if parameters.range! != "">
	options_${escapedOptionId}.range = "${parameters.range}";
  </#if>
  <#if parameters.max??>
	options_${escapedOptionId}.max = ${parameters.max?c};
  </#if>
  <#if parameters.min??>
	options_${escapedOptionId}.min = ${parameters.min?c};
  </#if>
  <#if parameters.orientation! != "">
	options_${escapedOptionId}.orientation = "${parameters.orientation}";
  </#if>
  <#if parameters.step??>
	options_${escapedOptionId}.step = ${parameters.step?c};
  </#if>
  <#if parameters.displayValueElement! != "">
	options_${escapedOptionId}.displayvalueelement = "${parameters.displayValueElement}";
  </#if>
  <#if parameters.onSlideTopics??>
	options_${escapedOptionId}.onslidetopics = "${parameters.onSlideTopics}";
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</script>
