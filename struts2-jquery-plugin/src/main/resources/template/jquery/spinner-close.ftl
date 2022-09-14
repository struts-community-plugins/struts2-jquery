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
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
	options_${escapedOptionId}.type = 'text';
  <#if parameters.max??>
	options_${escapedOptionId}.max = ${parameters.max?c};
  </#if>
  <#if parameters.min??>
	options_${escapedOptionId}.min = ${parameters.min?c};
  </#if>
  <#if parameters.step??>
	options_${escapedOptionId}.step = ${parameters.step?c};
  </#if>
  <#if parameters.culture! != "">
	options_${escapedOptionId}.culture = "${parameters.culture}";
  </#if>
  <#if parameters.numberFormat! != "">
	options_${escapedOptionId}.numberFormat = "${parameters.numberFormat}";
  </#if>
  <#if parameters.page??>
	options_${escapedOptionId}.page = ${parameters.page?c};
  </#if>
  <#if parameters.mouseWheel??>
	options_${escapedOptionId}.mouseWheel = ${parameters.mouseWheel?string};
  </#if>
  <#if parameters.incremental??>
	options_${escapedOptionId}.incremental = ${parameters.incremental?string};
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

  <#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</script>
