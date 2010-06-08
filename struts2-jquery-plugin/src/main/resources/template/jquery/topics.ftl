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
  <#if parameters.onCompleteTopics?exists>
	options_${escapedOptionId?html}.oncompletetopics = "${parameters.onCompleteTopics?html}";
  </#if>
  <#if parameters.onSuccessTopics?exists>
	options_${escapedOptionId?html}.onsuccesstopics = "${parameters.onSuccessTopics?html}";
  </#if>
  <#if parameters.onErrorTopics?exists>
	options_${escapedOptionId?html}.onerrortopics = "${parameters.onErrorTopics?html}";
  </#if>
  <#if parameters.onBeforeTopics?exists>
	options_${escapedOptionId?html}.onbeforetopics = "${parameters.onBeforeTopics?html}";
  </#if>
  <#if parameters.onAlwaysTopics?exists>
	options_${escapedOptionId?html}.onalwaystopics = "${parameters.onAlwaysTopics?html}";
  </#if>
  <#if parameters.onChangeTopics?exists>
	options_${escapedOptionId?html}.onchangetopics = "${parameters.onChangeTopics?html}";
  </#if>
  <#if parameters.onHideTopics?exists>
	options_${escapedOptionId?html}.onhidetopics = "${parameters.onHideTopics?string?html}";
  </#if>
  <#if parameters.onShowTopics?exists>
	options_${escapedOptionId?html}.onshowtopics = "${parameters.onShowTopics?string?html}";
  </#if>
  <#if parameters.onRemoveTopics?exists>
	options_${escapedOptionId?html}.onremovetopics = "${parameters.onRemoveTopics?string?html}";
  </#if>
  <#if parameters.onFocusTopics?exists>
	options_${escapedOptionId?html}.onfocustopics = "${parameters.onFocusTopics?string?html}";
  </#if>
  <#if parameters.onBlurTopics?exists>
	options_${escapedOptionId?html}.onblurtopics = "${parameters.onBlurTopics?string?html}";
  </#if>
  