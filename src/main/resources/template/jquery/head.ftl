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
  <#assign jqueryFile="jquery-1.4.1.min.js">
  <#assign jqueryForm="jquery.form.min.js">
  <#assign jqueryCookieFile="jquery.cookie.min.js">
  <#assign jqueryUIFile="jquery-ui-1.8.min.js">
  <#assign jqueryBGIFile="jquery.bgiframe.min.js">
  <#assign jquerySubscribeFile="jquery.subscribe.1.2.min.js">
  <#assign jqueryHistoryFile="jquery.ba-bbq.min.js">
  <#assign jqueryStrutsFile="jquery.struts2.min.js">
  <#assign jqueryGoogle="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js">
  <#assign jqueryUiGoogle="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js">
<#else>
  <#assign jqueryFile="jquery-1.4.1.js">
  <#assign jqueryForm="jquery.form.js">
  <#assign jqueryCookieFile="jquery.cookie.js">
  <#assign jqueryUIFile="jquery-ui-1.8.js">
  <#assign jqueryBGIFile="jquery.bgiframe.js">
  <#assign jquerySubscribeFile="jquery.subscribe.1.2.js">
  <#assign jqueryHistoryFile="jquery.ba-bbq.js">
  <#assign jqueryStrutsFile="jquery.struts2.js">
  <#assign jqueryGoogle="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.js">
  <#assign jqueryUiGoogle="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.js">
</#if>

<#if parameters.loadFromGoogle?default(false)>
<script type="text/javascript" src="${jqueryGoogle}"></script>
<script type="text/javascript" src="${jqueryUiGoogle}"></script>
<#else>
  <script type="text/javascript" src="${base}/struts/js/base/${jqueryFile}"></script>
	<#if parameters.jqueryui?default(false)>
    <script type="text/javascript" src="${base}/struts/js/base/${jqueryUIFile}"></script>
	</#if>
</#if>

  <script type="text/javascript" src="${base}/struts/js/plugins/${jqueryForm}"></script>
  <script type="text/javascript" src="${base}/struts/js/plugins/${jquerySubscribeFile}"></script>
<#if parameters.ajaxhistory?default(false)>
  <script type="text/javascript" src="${base}/struts/js/plugins/${jqueryHistoryFile}"></script>
</#if>
<#if parameters.jqueryui?default(false)>
  <script type="text/javascript" src="${base}/struts/js/base/${jqueryCookieFile}"></script>
  <script type="text/javascript" src="${base}/struts/js/base/${jqueryBGIFile}"></script>
    <#if parameters.jquerytheme?if_exists != "">
		<#if parameters.loadFromGoogle?default(false) && basePath == "struts/themes">
        	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/${parameters.jquerytheme?string}/jquery-ui.css" type="text/css"/>
		<#else>
        	<link rel="stylesheet" href="${base}/${basePath}/${parameters.jquerytheme?string}/jquery-ui.css" type="text/css"/>
		</#if>
    <#else>
        <link rel="stylesheet" href="${base}/${basePath}/smoothness/jquery-ui.css" type="text/css"/>
    </#if>
    <#if parameters.locale?if_exists != "">
        <#if parameters.locale?if_exists != "en">
            <script type="text/javascript" src="${base}/struts/i18n/jquery.ui.datepicker-${parameters.locale?string}.min.js"></script>
        </#if>
    </#if>
<#if parameters.useJqGridPlugin?default(false)>
  <script type="text/javascript" src="${base}/struts/i18n/grid.locale-${parameters.locale?default('en')}.js"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
  <script type="text/javascript" src="${base}/struts/js/plugins/jquery.jqGrid.js"></script>
  <link rel="stylesheet" href="${base}/struts/themes/ui.jqgrid.css" type="text/css"/>
</#if>
</#if>
  <script type="text/javascript" src="${base}/struts/js/struts2/${jqueryStrutsFile}"></script>
<script type="text/javascript">
<#if parameters.ajaxhistory?default(false)>
	$.struts2_jquery.ajaxhistory = true;
</#if>
$(document).ready(function () {
	<#if parameters.defaultIndicator?if_exists != "">
	$.struts2_jquery.defaultIndicator="${parameters.defaultIndicator?string}";
	</#if>
	$.ajaxSettings.traditional = true;

	$.ajaxSetup ({
	<#if parameters.ajaxcache?default(false)>
		cache: true
	<#else>
		cache: false
	</#if>
	});
<#if parameters.ajaxhistory?default(false)>
	$(window).trigger('hashchange');
</#if>
});
</script>

  