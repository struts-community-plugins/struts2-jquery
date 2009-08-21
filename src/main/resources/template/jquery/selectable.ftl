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
  <#if parameters.selectable?default(false)> selectable="true"</#if>
  <#if parameters.selectableOptions?if_exists != ""> selectableoptions="${parameters.selectableOptions?html}"</#if>
  <#if parameters.selectableOnSelectedTopics?if_exists != ""> selectableonselectedtopics="${parameters.selectableOnSelectedTopics?html}"</#if>
  <#if parameters.selectableOnSelectingTopics?if_exists != ""> selectableonselectingtopics="${parameters.selectableOnSelectingTopics?html}"</#if>
  <#if parameters.selectableOnStartTopics?if_exists != ""> selectableonstarttopics="${parameters.selectableOnStartTopics?html}"</#if>
  <#if parameters.selectableOnStopTopics?if_exists != ""> selectableonstoptopics="${parameters.selectableOnStopTopics?html}"</#if>
  <#if parameters.selectableOnUnselectedTopics?if_exists != ""> selectableonunselectedtopics="${parameters.selectableOnUnselectedTopics?html}"</#if>
  <#if parameters.selectableOnUnselectingTopics?if_exists != ""> selectableonunselectingTtopics="${parameters.selectableOnUnselectingTopics?html}"</#if>
  