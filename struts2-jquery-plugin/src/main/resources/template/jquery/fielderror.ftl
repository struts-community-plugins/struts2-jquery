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
<#if fieldErrors??><#t/>
    <#assign eKeys = fieldErrors.keySet()><#t/>
    <#assign eKeysSize = eKeys.size()><#t/>
    <#assign doneStartUlTag=false><#t/>
    <#assign doneEndUlTag=false><#t/>
    <#assign haveMatchedErrorField=false><#t/>
    <#if (fieldErrorFieldNames?size > 0) ><#t/>
        <#list fieldErrorFieldNames as fieldErrorFieldName><#t/>
            <#list eKeys as eKey><#t/>
                <#if (eKey = fieldErrorFieldName)><#t/>
                    <#assign haveMatchedErrorField=true><#t/>
                    <#assign eValue = fieldErrors[fieldErrorFieldName]><#t/>
                    <#if (haveMatchedErrorField && (!doneStartUlTag))><#t/>
                        <#assign doneStartUlTag=true><#t/>
                    </#if><#t/>
					<div 
					<#if parameters.id?if_exists != "">
					 id="${parameters.id?html}"<#rt/>
					</#if>
					<#if parameters.cssClass??>
					 class="ui-widget ${parameters.cssClass?html}"<#rt/>
					<#else>
					 class="ui-widget actionError"<#rt/>
					</#if>
					<#if parameters.cssStyle??>
					 style="margin${parameters.cssStyle?html}"<#rt/>
					</#if>
					>
					<div class="ui-state-error ui-corner-all" style="padding: 0.3em 0.7em; margin-top: 20px;"> 
		                    <#list eValue as eEachValue><#t/>
					            <#if eEachValue?if_exists != "">
							<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: 0.3em;"></span>
							<span><#if parameters.escape>${eEachValue!?html}<#else>${eEachValue!}</#if></span></p>
					            </#if>
							</#list>
					</div>
        			</div>
                </#if><#t/>
            </#list><#t/>
        </#list><#t/>
        <#if (haveMatchedErrorField && (!doneEndUlTag))><#t/>
            <#assign doneEndUlTag=true><#t/>
        </#if><#t/>
        <#else><#t/>
        <#if (eKeysSize > 0)><#t/>
					<div 
					<#if parameters.id?if_exists != "">
					 id="${parameters.id?html}"<#rt/>
					</#if>
					<#if parameters.cssClass??>
					 class="ui-widget ${parameters.cssClass?html}"<#rt/>
					<#else>
					 class="ui-widget actionError"<#rt/>
					</#if>
					<#if parameters.cssStyle??>
					 style="margin${parameters.cssStyle?html}"<#rt/>
					</#if>
					>
					<div class="ui-state-error ui-corner-all" style="padding: 0.3em 0.7em; margin-top: 20px;"> 
            <#list eKeys as eKey><#t/>
                <#assign eValue = fieldErrors[eKey]><#t/>
		                    <#list eValue as eEachValue><#t/>
					            <#if eEachValue?if_exists != "">
							<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: 0.3em;"></span>
							<span><#if parameters.escape>${eEachValue!?html}<#else>${eEachValue!}</#if></span></p>
					            </#if>
							</#list>
            </#list><#t/>
					</div>
        			</div>
        </#if><#t/>
    </#if><#t/>
</#if><#t/>
