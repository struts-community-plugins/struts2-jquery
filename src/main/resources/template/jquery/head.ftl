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

<#if parameters.customBasepath?if_exists == "">
  <#assign basePath="struts/themes">
<#else>
  <#assign basePath="${parameters.customBasepath?string}">
</#if>
<#if parameters.compressed?default(true)>
  <#assign jqueryFile="jquery-1.3.2.min.js">
  <#assign jqueryForm="jquery.form.min.js">
  <#assign jqueryCookieFile="jquery.cookie.min.js">
  <#assign jqueryUIFile="jquery-ui-1.7.2.min.js">
  <#assign jqueryBGIFile="jquery.bgiframe.min.js">
  <#assign jquerySubscribeFile="jquery.subscribe.1.1.min.js">
  <#assign jqueryStrutsFile="jquery.struts2.min.js">
<#else>
  <#assign jqueryFile="jquery-1.3.2.js">
  <#assign jqueryForm="jquery.form.js">
  <#assign jqueryCookieFile="jquery.cookie.js">
  <#assign jqueryUIFile="jquery-ui-1.7.2.js">
  <#assign jqueryBGIFile="jquery.bgiframe.js">
  <#assign jquerySubscribeFile="jquery.subscribe.1.1.js">
  <#assign jqueryStrutsFile="jquery.struts2.js">
</#if>

<#if parameters.loadFromGoogle?default(false)>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript">
  google.load("jquery", "1.3.2");
	<#if parameters.jqueryui?default(false)>
  google.load("jqueryui", "1.7.2");
	</#if>
</script>
<#else>
  <script type="text/javascript" src="${base}/struts/js/${jqueryFile}"></script>
	<#if parameters.jqueryui?default(false)>
    <script type="text/javascript" src="${base}/struts/js/${jqueryUIFile}"></script>
	</#if>
</#if>

  <script type="text/javascript" src="${base}/struts/js/${jqueryForm}"></script>
  <script type="text/javascript" src="${base}/struts/js/${jquerySubscribeFile}"></script>
  <script type="text/javascript" src="${base}/struts/js/${jqueryStrutsFile}"></script>
<#if parameters.jqueryui?default(false)>
    <#if parameters.jquerytheme?if_exists != "">
        <link rel="stylesheet" href="${base}/${basePath}/${parameters.jquerytheme?string}/ui.theme.css" type="text/css"/>
    <#else>
        <link rel="stylesheet" href="${base}/${basePath}/smoothness/ui.theme.css" type="text/css"/>
    </#if>
    <#if parameters.locale?if_exists != "">
        <#if parameters.locale?if_exists != "en">
            <script type="text/javascript" src="${base}/struts/i18n/ui.datepicker-${parameters.locale?string}.min.js"></script>
        </#if>
    </#if>
</#if>

  