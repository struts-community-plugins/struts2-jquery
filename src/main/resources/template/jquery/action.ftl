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

  <#if parameters.targets?if_exists != "">
	options_${parameters.id?html}.targets = "${parameters.targets?html}";
  </#if>
  <#if parameters.hrefUrl?if_exists != "">
	options_${parameters.id?html}.href = "${parameters.hrefUrl?html}";
  <#else>
	options_${parameters.id?html}.href = "#";
  </#if>
  <#if parameters.hrefParameter?if_exists != ""> 
	options_${parameters.id?html}.hrefparameter = "${parameters.hrefParameter?html}";
  </#if>
  <#if parameters.formIds?exists>
	options_${parameters.id?html}.formids = "${parameters.formIds?html}";
  </#if>
  <#if parameters.validate?exists>
	options_${parameters.id?html}.validate = "${parameters.validate?html}";
  </#if>
  <#if parameters.onClickTopics?exists>
	options_${parameters.id?html}.onclicktopics = "${parameters.onClickTopics?html}";
  </#if>
  <#if parameters.indicator?exists>
	options_${parameters.id?html}.indicatorid = "${parameters.indicator?html}";
  </#if>
  <#if parameters.loadingText?exists>
	options_${parameters.id?html}.loadingtext = "${parameters.loadingText?html}";
  </#if>
  <#if parameters.errorText?exists>
	options_${parameters.id?html}.errortext = "${parameters.errorText?html}";
  </#if>
  <#if parameters.errorElementId?exists>
	options_${parameters.id?html}.errorelementid = "${parameters.errorElementId?html}";
  </#if>
  <#if parameters.dataType?exists>
	options_${parameters.id?html}.datatype = "${parameters.dataType?html}";
  </#if>
   <#if parameters.effect?exists>
	options_${parameters.id?html}.effect = "${parameters.effect?html}";
  </#if>  
  <#if parameters.effectDuration?exists>
	options_${parameters.id?html}.effectduration = "${parameters.effectDuration?html}";
  </#if>  
  <#if parameters.effectOptions?exists>
	options_${parameters.id?html}.effectoptions = "${parameters.effectOptions?html}";
  </#if>  
  <#if parameters.timeout?exists>
	options_${parameters.id?html}.timeout = ${parameters.timeout?html};
  </#if>
  