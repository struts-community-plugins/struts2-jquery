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
<div
  <#if parameters.selectedTab?exists>
    selectedTab="${parameters.selectedTab?html}"<#rt/>
  </#if>
  <#if parameters.openOnMouseover?default(false)>
    event="mouseover"<#rt/>
  </#if>
  <#if parameters.collapsible?default(false)>
    collapsible="true"<#rt/>
  </#if>
  <#if parameters.useSelectedTabCookie?default(false)>
    cookie="true"<#rt/>
  </#if>
  <#if parameters.animate?default(false)>
    animate="true"<#rt/>
  </#if>
  <#if parameters.cache?default(false)>
    cache="true"<#rt/>
  </#if>
  <#if parameters.spinner?if_exists != "">
    spinner="${parameters.spinner?html}"<#rt/>
  </#if>
  <#if parameters.disabled?if_exists != "">
    disabled="${parameters.disabled?html}"<#rt/>
  </#if>
  <#if parameters.onAddTopics?if_exists != "">
    onaddtopics="${parameters.onAddTopics?html}"<#rt/>
  </#if>
  <#if parameters.onRemoveTopics?if_exists != "">
    onremovetopics="${parameters.onRemoveTopics?html}"<#rt/>
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
<ul>