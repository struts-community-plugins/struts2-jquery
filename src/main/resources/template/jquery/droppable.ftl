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
  <#if parameters.droppable?default(false)> droppable="true"</#if>
  <#if parameters.droppableOptions?if_exists != ""> droppableoptions="${parameters.droppableOptions?html}"</#if>
  <#if parameters.droppableOnActivateTopics?if_exists != ""> droppableOnActivateTopics="${parameters.droppableOnActivateTopics?html}"</#if>
  <#if parameters.droppableOnDeactivateTopics?if_exists != ""> droppableOnDeactivateTopics="${parameters.droppableOnDeactivateTopics?html}"</#if>
  <#if parameters.droppableOnDropTopics?if_exists != ""> droppableOnDropTopics="${parameters.droppableOnDropTopics?html}"</#if>
  <#if parameters.droppableOnOutTopics?if_exists != ""> droppableOnOutTopics="${parameters.droppableOnOutTopics?html}"</#if>
  <#if parameters.droppableOnOverTopics?if_exists != ""> droppableOnOverTopics="${parameters.droppableOnOverTopics?html}"</#if>
