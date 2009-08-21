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
  <#if parameters.sortable?default(false)> sortable="true"</#if>
  <#if parameters.sortableOptions?if_exists != ""> sortableoptions="${parameters.sortableOptions?html}"</#if>
  <#if parameters.sortableOnBeforeStopTopics?if_exists != ""> sortableonbeforestoptopics="${parameters.sortableOnBeforeStopTopics?html}"</#if>
  <#if parameters.sortableOnStopTopics?if_exists != ""> sortableonstoptopics="${parameters.sortableOnStopTopics?html}"</#if>
  <#if parameters.sortableOnStartTopics?if_exists != ""> sortableonstarttopics="${parameters.sortableOnStartTopics?html}"</#if>
  <#if parameters.sortableOnSortTopics?if_exists != ""> sortableonsorttopics="${parameters.sortableOnSortTopics?html}"</#if>
  <#if parameters.sortableOnActivateTopics?if_exists != ""> sortableonactivatetopics="${parameters.sortableOnActivateTopics?html}"</#if>
  <#if parameters.sortableOnDeactivateTopics?if_exists != ""> sortableondeactivatetopics="${parameters.sortableOnDeactivateTopics?html}"</#if>
  <#if parameters.sortableOnOverTopics?if_exists != ""> sortableonovertopics="${parameters.sortableOnOverTopics?html}"</#if>
  <#if parameters.sortableOnOutTopics?if_exists != ""> sortableonouttopics="${parameters.sortableOnOutTopics?html}"</#if>
  <#if parameters.sortableOnRemoveTopics?if_exists != ""> sortableonremovetopics="${parameters.sortableOnRemoveTopics?html}"</#if>
  <#if parameters.sortableOnReceiveTopics?if_exists != ""> sortableonreceivetopics="${parameters.sortableOnReceiveTopics?html}"</#if>
  <#if parameters.sortableOnChangeTopics?if_exists != ""> sortableonchangetopics="${parameters.sortableOnChangeTopics?html}"</#if>
  <#if parameters.sortableOnUpdateTopics?if_exists != ""> sortableonupdatetopics="${parameters.sortableOnUpdateTopics?html}"</#if>
  