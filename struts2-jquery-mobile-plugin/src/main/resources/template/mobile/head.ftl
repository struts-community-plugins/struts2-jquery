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
<#assign jQueryVersion="1.6.4">
<#include "/${parameters.templateDir}/jquery/head.ftl" />
<#if parameters.scriptPath?if_exists != "">
  <#assign javaMobileScriptBasePath="${parameters.scriptPath?string}">
<#else>
  <#assign javaMobileScriptBasePath="${base}/struts/">
</#if>
<#if parameters.compressed?default(true)>
  <#assign jqueryMobileFile="jquery.mobile-1.0rc2.min.js">
  <#assign jqueryMobileCss="jquery.mobile-1.0rc2.min.css">
  <#assign jqueryMobileStrutsFile="jquery.mobile.struts2-3.2.0.min.js">
<#else>
  <#assign jqueryMobileFile="jquery.mobile-1.0rc2.js">
  <#assign jqueryMobileCss="jquery.mobile-1.0rc2.css">
  <#assign jqueryMobileStrutsFile="jquery.mobile.struts2-3.2.0.js">
</#if>
	<script type="text/javascript" src="${javaMobileScriptBasePath}js/plugins/${jqueryMobileFile}"></script>
	<script type="text/javascript" src="${javaMobileScriptBasePath}js/struts2/${jqueryMobileStrutsFile}"></script>
    <link id="jquery_mobile_theme_link" rel="stylesheet" href="${javaMobileScriptBasePath}js/plugins/${jqueryMobileCss}" type="text/css"/>
	