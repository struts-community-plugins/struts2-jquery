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
	<${parameters.header?default('h3')}
    <#if parameters.tabindex??>
        tabindex="${parameters.tabindex?html}"<#rt/>
    </#if>
    <#if parameters.disabled?default(false)>
        disabled="disabled"<#rt/>
    </#if>
    <#if parameters.id?if_exists != "">
        id="${parameters.id?html}"<#rt/>
    </#if>
    <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
    <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
    <#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
    ><#rt/>
        <a id="${parameters.id?html}_a" href="#">
		    ${parameters.title?html}
        </a>
	</${parameters.header?default('h3')}>
	<div id="${parameters.id?html}_div"><#rt/>
<#if parameters.value?if_exists != "">
			${parameters.value?html}
</#if>			
