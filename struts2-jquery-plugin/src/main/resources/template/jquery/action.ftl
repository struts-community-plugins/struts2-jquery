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
  <#if parameters.targets! != "">
	options_${escapedOptionId}.targets = "${parameters.targets}";
  </#if>
  <#if parameters.hrefUrl! != "">
	options_${escapedOptionId}.href = "${parameters.hrefUrl}";
  <#else>
	options_${escapedOptionId}.href = "#";
  </#if>
  <#if parameters.hrefParameter! != "">
	options_${escapedOptionId}.hrefparameter = "<#outputformat "JavaScript">${parameters.hrefParameter}</#outputformat>";
  </#if>
  <#if parameters.formIds??>
	options_${escapedOptionId}.formids = "${parameters.formIds}";
  </#if>
  <#if parameters.onClickTopics??>
	options_${escapedOptionId}.onclick = "${parameters.onClickTopics}";
  </#if>
  <#if parameters.indicator??>
	options_${escapedOptionId}.indicatorid = "${parameters.indicator}";
  </#if>
  <#if parameters.loadingText??>
	options_${escapedOptionId}.loadingtext = "${parameters.loadingText}";
  </#if>
  <#if parameters.errorText??>
	options_${escapedOptionId}.errortext = "${parameters.errorText}";
  </#if>
  <#if parameters.errorElementId??>
	options_${escapedOptionId}.errorelementid = "${parameters.errorElementId}";
  </#if>
  <#if parameters.dataType??>
	options_${escapedOptionId}.datatype = "${parameters.dataType}";
  </#if>
  <#if parameters.requestType??>
	options_${escapedOptionId}.requesttype = "${parameters.requestType}";
  </#if>
  <#if parameters.effect??>
	options_${escapedOptionId}.effect = "${parameters.effect}";
	<#if parameters.effectDuration??>
	options_${escapedOptionId}.effectduration = ${parameters.effectDuration};
	</#if>
	<#if parameters.effectMode??>
	options_${escapedOptionId}.effectmode = "${parameters.effectMode}";
	</#if>
	<#if parameters.effectOptions??>
	options_${escapedOptionId}.effectoptions = <#outputformat "JavaScript">${parameters.effectOptions}</#outputformat>;
	<#else>
	options_${escapedOptionId}.effectoptions = {};
	</#if>
  </#if>
  <#if parameters.timeout??>
	options_${escapedOptionId}.timeout = ${parameters.timeout};
  </#if>
  <#if parameters.listenTopics??>
	options_${escapedOptionId}.listentopics = "${parameters.listenTopics}";
  </#if>
  <#if parameters.onEffectCompleteTopics??>
	options_${escapedOptionId}.oneffect = "${parameters.onEffectCompleteTopics}";
  </#if>
   <#if parameters.clearForm!false>
	options_${escapedOptionId}.clearform = true;
    </#if>
   <#if parameters.resetForm!false>
	options_${escapedOptionId}.resetform = true;
    </#if>
   <#if parameters.iframe!false>
	options_${escapedOptionId}.iframe = true;
    </#if>
   <#if parameters.replaceTarget!false>
	options_${escapedOptionId}.replaceTarget = true;
    </#if>
