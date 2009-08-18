<#--
/*
 * $Id: a.ftl,v 1.1 2009/02/09 08:34:16 echijioke Exp $
 *
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

  <#if parameters.targets?if_exists != ""> targets="${parameters.targets?html}"<#rt/></#if>
  <#if parameters.hrefUrl??> href="${parameters.hrefUrl?html}"<#rt/></#if>
  <#if parameters.hrefParameter??> hrefParameter="${parameters.hrefParameter?html}"<#rt/></#if>
  <#if parameters.formIds?exists>
    formIds="${parameters.formIds?html}"<#rt/>
  </#if>
  <#if parameters.validate?exists>
    validate="${parameters.validate?string?html}"<#rt/>
  </#if>
  <#if parameters.onClickTopics?exists>
    onClickTopics="${parameters.onClickTopics?html}"<#rt/>
  </#if>
  <#if parameters.indicator?exists>
    indicatorId="${parameters.indicator?html}"<#rt/>
  </#if>
  <#if parameters.loadingText?exists>
    loadingText="${parameters.loadingText?html}"<#rt/>
  </#if>
  <#if parameters.errorText?exists>
    errorText="${parameters.errorText?string?html}"<#rt/>
  </#if>
  <#if parameters.errorElementId?exists>
    errorElementId="${parameters.errorElementId?string?html}"<#rt/>
  </#if>
  <#if parameters.onCompleteTopics?exists>
    onCompleteTopics="${parameters.onCompleteTopics?html}"<#rt/>
  </#if>
  <#if parameters.onSuccessTopics?exists>
    onSuccessTopics="${parameters.onSuccessTopics?html}"<#rt/>
  </#if>
  <#if parameters.onErrorTopics?exists>
    onErrorTopics="${parameters.onErrorTopics?html}"<#rt/>
  </#if>
  <#if parameters.elementIds?exists>
    elementIds="${parameters.elementIds?html}"<#rt/>
  </#if>
  <#if parameters.dataType?exists>
    dataType="${parameters.dataType?html}"<#rt/>
  </#if>
   <#if parameters.effect?exists>
    effect="${parameters.effect?html}"<#rt/>
  </#if>  
  <#if parameters.effectDuration?exists>
    effectDuration="${parameters.effectDuration?html}"<#rt/>
  </#if>  
  <#if parameters.effectOptions?exists>
    effectOptions="${parameters.effectOptions?html}"<#rt/>
  </#if>  
  <#if parameters.timeout?exists>
    timeout="${parameters.timeout?html}"<#rt/>
  </#if>
  