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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
  <#if parameters.sortable?default(false)>
	options_${escapedOptionId}.sortable = true;<#rt/>
   </#if>
  <#if parameters.sortableOptions?if_exists != "">
 	options_${escapedOptionId}.sortableoptions = "${parameters.sortableOptions}";<#rt/>
   </#if>
  <#if parameters.sortableOnBeforeStopTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonbeforestoptopics = "${parameters.sortableOnBeforeStopTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnStopTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonstoptopics = "${parameters.sortableOnStopTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnStartTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonstarttopics = "${parameters.sortableOnStartTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnSortTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonsorttopics = "${parameters.sortableOnSortTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnActivateTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonactivatetopics = "${parameters.sortableOnActivateTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnDeactivateTopics?if_exists != "">
 	options_${escapedOptionId}.sortableondeactivatetopics = "${parameters.sortableOnDeactivateTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnOverTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonovertopics = "${parameters.sortableOnOverTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnOutTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonouttopics = "${parameters.sortableOnOutTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnRemoveTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonremovetopics = "${parameters.sortableOnRemoveTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnReceiveTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonreceivetopics = "${parameters.sortableOnReceiveTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnChangeTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonchangetopics = "${parameters.sortableOnChangeTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnUpdateTopics?if_exists != "">
 	options_${escapedOptionId}.sortableonupdatetopics = "${parameters.sortableOnUpdateTopics}";<#rt/>
   </#if>
  