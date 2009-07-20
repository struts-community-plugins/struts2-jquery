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
<#if parameters.parentTheme?default('') == 'xhtml'>
  <tr>
      <td colspan="2"><div <#rt/>
  <#if parameters.align?exists>
      align="${parameters.align?html}"<#t/>
  </#if>
  ><#t/>
<#elseif parameters.parentTheme?default('') == 'css_xhtml'>
  <#if parameters.labelposition?default("top") == 'top'>
    <div <#rt/>
  <#else>
    <span <#rt/>
  </#if>
  <#if parameters.align?exists>
    align="${parameters.align?html}"<#t/>
  </#if>
  <#if parameters.id?exists>
    id="wwctrl_${parameters.id}"<#rt/>
  </#if>
  ><#t/>
</#if>

<#if parameters.type?exists && parameters.type=="button">
  <input type="button"<#rt/>
    <#if parameters.id?if_exists != "">
     id="${parameters.id?html}"<#rt/>
    </#if>
	<#if parameters.cssClass?if_exists != "">
	  class="${parameters.cssClass?html}"<#rt/>
	</#if>
	<#if parameters.cssStyle?if_exists != "">
	  style="${parameters.cssStyle?html}"<#rt/>
	</#if>
  <#include "/${parameters.templateDir}/simple/scripting-events.ftl"/>
  <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
  <#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
  <#if parameters.label?if_exists != "">
     value="${parameters.label?html}"<#rt/>
  </#if>
 />
<#else>
  <#if parameters.type?exists && parameters.type=="image">
    <input type="image"<#rt/>
    <#if parameters.label?if_exists != "">
     alt="${parameters.label?html}"<#rt/>
    </#if>
    <#if parameters.src?if_exists != "">
     src="${parameters.src?html}"<#rt/>
    </#if>
  <#else>
    <input type="submit"<#rt/>
  </#if>
    <#if parameters.id?if_exists != "">
     id="${parameters.id?html}"<#rt/>
    </#if>
	<#if parameters.cssClass?if_exists != "">
	  class="${parameters.cssClass?html}"<#rt/>
	</#if>
	<#if parameters.cssStyle?if_exists != "">
	  style="${parameters.cssStyle?html}"<#rt/>
	</#if>
    <#if parameters.nameValue?if_exists != "">
     value="${parameters.nameValue?html}"<#rt/>
    </#if>
    <#if parameters.value?if_exists != "">
     value="${parameters.value?html}"<#rt/>
    </#if>
    <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
    <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
	<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
  />
</#if>
<#if parameters.parentTheme?default('') == 'xhtml'>
  </div><#t/>
  <#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
<#elseif parameters.parentTheme?default('') == 'css_xhtml'>
  <#if parameters.labelposition?default("top") == 'top'>
    </div> <#t/>
  <#else>
    </span> <#t/>
  </#if>  
</#if>
