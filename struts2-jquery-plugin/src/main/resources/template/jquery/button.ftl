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
	<#if parameters.disabled?default(false)>
	options_${escapedOptionId}.disabled = true;
	</#if>
	<#if parameters.button?default(false)>
	options_${escapedOptionId}.button = true;
	</#if>
	<#if parameters.buttonIcon?if_exists != ""> 
	options_${escapedOptionId}.bicon = "${parameters.buttonIcon}";
	</#if>
	<#if parameters.buttonIconSecondary?if_exists != ""> 
	options_${escapedOptionId}.bicon2 = "${parameters.buttonIconSecondary}";
	</#if>
	<#if parameters.buttonText??>
	options_${escapedOptionId}.btext = ${parameters.buttonText?string};
	</#if>
	