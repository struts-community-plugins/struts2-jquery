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
  <#if parameters.onCompleteTopics??>
	options_${escapedOptionId}.oncom = "${parameters.onCompleteTopics}";
  </#if>
  <#if parameters.onSuccessTopics??>
	options_${escapedOptionId}.onsuc = "${parameters.onSuccessTopics}";
  </#if>
  <#if parameters.onErrorTopics??>
	options_${escapedOptionId}.onerr = "${parameters.onErrorTopics}";
  </#if>
  <#if parameters.onBeforeTopics??>
	options_${escapedOptionId}.onbef = "${parameters.onBeforeTopics}";
  </#if>
  <#if parameters.onAfterValidationTopics??>
    options_${escapedOptionId}.onaftervalidation = "${parameters.onAfterValidationTopics}";
  </#if>
  <#if parameters.onAlwaysTopics??>
	options_${escapedOptionId}.onalw = "${parameters.onAlwaysTopics}";
  </#if>
  <#if parameters.onChangeTopics??>
	options_${escapedOptionId}.oncha = "${parameters.onChangeTopics}";
  </#if>
  <#if parameters.onHideTopics??>
	options_${escapedOptionId}.onhidetopics = "${parameters.onHideTopics?string}";
  </#if>
  <#if parameters.onShowTopics??>
	options_${escapedOptionId}.onshowtopics = "${parameters.onShowTopics?string}";
  </#if>
  <#if parameters.onRemoveTopics??>
	options_${escapedOptionId}.onremovetopics = "${parameters.onRemoveTopics?string}";
  </#if>
  <#if parameters.onFocusTopics??>
	options_${escapedOptionId}.onfocustopics = "${parameters.onFocusTopics?string}";
  </#if>
  <#if parameters.onBlurTopics??>
	options_${escapedOptionId}.onblurtopics = "${parameters.onBlurTopics?string}";
  </#if>
