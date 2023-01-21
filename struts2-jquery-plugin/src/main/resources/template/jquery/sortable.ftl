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
<#assign escapedOptionId="${parameters.escapedId}">
  <#if parameters.sortable!false>
	options_${escapedOptionId}.sortable = true;<#rt/>
   </#if>
  <#if parameters.sortableOptions! != "">
 	options_${escapedOptionId}.sortableoptions = "<#outputformat "JavaScript">${parameters.sortableOptions}</#outputformat>";<#rt/>
   </#if>
  <#if parameters.sortableOnBeforeStopTopics! != "">
 	options_${escapedOptionId}.sortableonbeforestoptopics = "${parameters.sortableOnBeforeStopTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnStopTopics! != "">
 	options_${escapedOptionId}.sortableonstoptopics = "${parameters.sortableOnStopTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnStartTopics! != "">
 	options_${escapedOptionId}.sortableonstarttopics = "${parameters.sortableOnStartTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnSortTopics! != "">
 	options_${escapedOptionId}.sortableonsorttopics = "${parameters.sortableOnSortTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnActivateTopics! != "">
 	options_${escapedOptionId}.sortableonactivatetopics = "${parameters.sortableOnActivateTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnDeactivateTopics! != "">
 	options_${escapedOptionId}.sortableondeactivatetopics = "${parameters.sortableOnDeactivateTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnOverTopics! != "">
 	options_${escapedOptionId}.sortableonovertopics = "${parameters.sortableOnOverTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnOutTopics! != "">
 	options_${escapedOptionId}.sortableonouttopics = "${parameters.sortableOnOutTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnRemoveTopics! != "">
 	options_${escapedOptionId}.sortableonremovetopics = "${parameters.sortableOnRemoveTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnReceiveTopics! != "">
 	options_${escapedOptionId}.sortableonreceivetopics = "${parameters.sortableOnReceiveTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnChangeTopics! != "">
 	options_${escapedOptionId}.sortableonchangetopics = "${parameters.sortableOnChangeTopics}";<#rt/>
   </#if>
  <#if parameters.sortableOnUpdateTopics! != "">
 	options_${escapedOptionId}.sortableonupdatetopics = "${parameters.sortableOnUpdateTopics}";<#rt/>
   </#if>
