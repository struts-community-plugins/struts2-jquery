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
  <#if parameters.name??> name="${parameters.name?html}"</#if>
  <#if parameters.cssClass??> class="${parameters.cssClass?html}"</#if>
  <#if parameters.cssStyle??> style="${parameters.cssStyle?html}"</#if>
  <#if parameters.title??> title="${parameters.title?html}"<#rt/></#if>
  <#if parameters.reloadTopics?exists> reloadTopics="${parameters.reloadTopics?html}"<#rt/></#if>
  <#if parameters.draggable?default(false)> draggable="true"</#if>
  <#if parameters.draggableOptions?if_exists != ""> draggableoptions="${parameters.draggableOptions?html}"</#if>
  <#if parameters.droppable?default(false)> droppable="true"</#if>
  <#if parameters.droppableOptions?if_exists != ""> droppableoptions="${parameters.droppableOptions?html}"</#if>
  <#if parameters.resizable?default(false)> resizable="true"</#if>
  <#if parameters.resizableOptions?if_exists != ""> resizableoptions="${parameters.resizableOptions?html}"</#if>
  <#if parameters.selectable?default(false)> selectable="true"</#if>
  <#if parameters.selectableOptions?if_exists != ""> selectableoptions="${parameters.selectableOptions?html}"</#if>
  <#if parameters.sortable?default(false)> sortable="true"</#if>
  <#if parameters.sortableOptions?if_exists != ""> sortableoptions="${parameters.sortableOptions?html}"</#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />
  <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
>
