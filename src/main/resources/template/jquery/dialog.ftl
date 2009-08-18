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
<!-- Dialog ${parameters.id?html}  <#if parameters.autoOpen?if_exists != "">autoopen="${parameters.autoOpen?html}"</#if>
 -->
<div
  <#if parameters.height?if_exists != "">
    height="${parameters.height?html}"<#rt/>
  </#if>
  <#if parameters.width?if_exists != "">
    width="${parameters.width?html}"<#rt/>
  </#if>
  <#if parameters.zindex?if_exists != "">
    zindex="${parameters.zindex?html}"<#rt/>
  </#if>
  <#if parameters.title?if_exists != "">
    title="${parameters.title?html}"<#rt/>
  </#if>
  <#if parameters.showEffect?if_exists != "">
    show="${parameters.showEffect?html}"<#rt/>
  </#if>
  <#if parameters.position?if_exists != "">
    position="${parameters.position?html}"<#rt/>
  </#if>
  <#if parameters.buttons?if_exists != "">
    buttons="${parameters.buttons?html}"<#rt/>
  </#if>
  <#if parameters.hideEffect?if_exists != "">
    hide="${parameters.hideEffect?html}"<#rt/>
  </#if>
  <#if parameters.draggable?if_exists != "">
    draggable="${parameters.draggable?html}"<#rt/>
  <#else>
	draggable="true"<#rt/>
  </#if>
  <#if parameters.resizable?if_exists != "">
    resizable="${parameters.resizable?html}"<#rt/>
  </#if>
  <#if parameters.autoOpen?if_exists == "false">
    autoOpen="false"<#rt/>
  <#else>
	autoOpen="true"<#rt/>
  </#if>
  <#if parameters.hideEffect?if_exists != "">
    hide="${parameters.hideEffect?html}"<#rt/>
  </#if>
<#if parameters.modal?if_exists == "true" >
 <#if parameters.overlayColor?if_exists != "" || parameters.overlayOpacity?if_exists != "">
	<#if parameters.overlayColor?if_exists != "">
	backgroundColor="${parameters.overlayColor?html}"<#rt/>
	</#if>
	<#if parameters.overlayOpacity?if_exists != "">
	opacity="${parameters.overlayOpacity?html}"<#rt/>
	<#else>
	opacity="0.7"<#rt/>
	</#if>
  </#if>
	modal="true"<#rt/>
</#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />
<#include "/${parameters.templateDir}/jquery/action.ftl" />
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
