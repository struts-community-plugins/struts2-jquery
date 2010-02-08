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
  <#if parameters.targets?if_exists != "">
	options_${escapedOptionId?html}.targets = "${parameters.targets?html}";
  </#if>
  <#if parameters.hrefUrl?if_exists != "">
	options_${escapedOptionId?html}.href = "${parameters.hrefUrl?html}";
  <#else>
	options_${escapedOptionId?html}.href = "#";
  </#if>
  <#if parameters.hrefParameter?if_exists != ""> 
	options_${escapedOptionId?html}.hrefparameter = "${parameters.hrefParameter?string}";
  </#if>
  <#if parameters.formIds?exists>
	options_${escapedOptionId?html}.formids = "${parameters.formIds?html}";
  </#if>
  <#if parameters.validate?exists>
	options_${escapedOptionId?html}.validate = "${parameters.validate?html}";
  </#if>
  <#if parameters.onClickTopics?exists>
	options_${escapedOptionId?html}.onclicktopics = "${parameters.onClickTopics?html}";
  </#if>
  <#if parameters.indicator?exists>
	options_${escapedOptionId?html}.indicatorid = "${parameters.indicator?html}";
  </#if>
  <#if parameters.loadingText?exists>
	options_${escapedOptionId?html}.loadingtext = "${parameters.loadingText?html}";
  </#if>
  <#if parameters.errorText?exists>
	options_${escapedOptionId?html}.errortext = "${parameters.errorText?html}";
  </#if>
  <#if parameters.errorElementId?exists>
	options_${escapedOptionId?html}.errorelementid = "${parameters.errorElementId?html}";
  </#if>
  <#if parameters.dataType?exists>
	options_${escapedOptionId?html}.datatype = "${parameters.dataType?html}";
  </#if>
   <#if parameters.effect?exists>
	options_${escapedOptionId?html}.effect = "${parameters.effect?html}";
  </#if>  
  <#if parameters.effectDuration?exists>
	options_${escapedOptionId?html}.effectduration = ${parameters.effectDuration?html};
  </#if>  
  <#if parameters.effectOptions?exists>
	options_${escapedOptionId?html}.effectoptions = ${parameters.effectOptions?html};
  </#if>  
  <#if parameters.timeout?exists>
	options_${escapedOptionId?html}.timeout = ${parameters.timeout?html};
  </#if>
  <#if parameters.listenTopics?exists>
	options_${escapedOptionId?html}.listentopics = "${parameters.listenTopics?html}";
  </#if>
  