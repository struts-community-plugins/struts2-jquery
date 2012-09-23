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

<#if !jQueryVersion?? >
  <#assign jQueryVersion="1.8.2">
</#if>
<#assign jQueryUIVersion="1.8.23">
<#assign struts2jQueryVersion="3.4.0-SNAPSHOT">

<#if parameters.scriptPath?if_exists != "">
  <#assign javaScriptBasePath="${parameters.scriptPath?string}">
<#else>
  <#assign javaScriptBasePath="${base}/struts/">
</#if>

<#assign googlePath="http://ajax.googleapis.com/ajax/libs/jquery/${jQueryVersion}">
<#assign googleUiPath="http://ajax.googleapis.com/ajax/libs/jqueryui/${jQueryUIVersion}">

<#if parameters.customBasepath?if_exists != "">
  <#assign basePath="${parameters.customBasepath?string}">
<#else>
  <#assign basePath="${javaScriptBasePath}themes">
</#if>
<#if parameters.compressed?default(true)>
  <#assign jqueryFile="jquery-${jQueryVersion}.min.js">
  <#assign jqueryForm="jquery.form.min.js?s2j=${struts2jQueryVersion}">
  <#assign jqueryUIFile="jquery-ui.min.js?s2j=${struts2jQueryVersion}">
  <#assign jqueryUICoreFile="jquery.ui.core.min.js?s2j=${struts2jQueryVersion}">
  <#assign jquerySubscribeFile="jquery.subscribe.min.js">
  <#assign jqueryHistoryFile="jquery.ba-bbq.min.js">
  <#assign jqueryCompat13File="jquery.compat-1.3.min.js">
  <#assign jqueryStrutsFile="jquery.struts2-3.3.3.min.js">
  <#assign jqueryUiStrutsFile="jquery.ui.struts2-3.3.3.min.js">
  <#assign jqueryGoogle="${googlePath}/jquery.min.js">
  <#assign jqueryUiGoogle="${googleUiPath}/jquery-ui.min.js">
<#else>
  <#assign jqueryFile="jquery-${jQueryVersion}.js">
  <#assign jqueryForm="jquery.form.js?s2j=${struts2jQueryVersion}">
  <#assign jqueryUIFile="jquery-ui.js?s2j=${struts2jQueryVersion}">
  <#assign jqueryUICoreFile="jquery.ui.core.js?s2j=${struts2jQueryVersion}">
  <#assign jquerySubscribeFile="jquery.subscribe.js">
  <#assign jqueryHistoryFile="jquery.ba-bbq.js">
  <#assign jqueryCompat13File="jquery.compat-1.3.js">
  <#assign jqueryStrutsFile="jquery.struts2-3.3.3.js">
  <#assign jqueryUiStrutsFile="jquery.ui.struts2-3.3.3.js">
  <#assign jqueryGoogle="${googlePath}/jquery.js">
  <#assign jqueryUiGoogle="${googleUiPath}/jquery-ui.js">
</#if>

<#if parameters.loadFromGoogle?default(false)>
	<script type="text/javascript" src="${jqueryGoogle}"></script>
	<#if parameters.jqueryui?default(true)>
	<script type="text/javascript" src="${jqueryUiGoogle}"></script>
		<#if parameters.jqueryLocale?if_exists != "" && parameters.jqueryLocale?if_exists != "en">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/${jQueryUIVersion}/i18n/jquery.ui.datepicker-${parameters.jqueryLocale?string}.min.js"></script>
		</#if>
	</#if>
<#else>
	<script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryFile}"></script>
	<#if parameters.jqueryui?default(true)>
 		<#if parameters.loadAtOnce?default(false)>
	<script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUIFile}"></script>
			<#if parameters.jqueryLocale?if_exists != "" && parameters.jqueryLocale?if_exists != "en">
	<script type="text/javascript" src="${javaScriptBasePath}i18n/jquery.ui.datepicker-${parameters.jqueryLocale?string}.min.js?s2j=${struts2jQueryVersion}"></script>
			</#if>
		<#else>
	<script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUICoreFile}"></script>
		</#if>
	</#if>
</#if>
<#if parameters.compatibility?if_exists == "1.3">
	<script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryCompat13File}"></script>
</#if>
<#if parameters.loadAtOnce?default(false) ||  parameters.loadFromGoogle?default(false)>
	<script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryForm}"></script>
</#if>
  <script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jquerySubscribeFile}"></script>
<#if parameters.ajaxhistory?default(false)>
  <script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryHistoryFile}"></script>
</#if>

  <script type="text/javascript" src="${javaScriptBasePath}js/struts2/${jqueryStrutsFile}"></script>

<script type="text/javascript">
$(function() {
	jQuery.struts2_jquery.version="${struts2jQueryVersion}";
<#if parameters.debug?default(false)>
	jQuery.struts2_jquery.debug = true;
</#if>
<#if parameters.loadAtOnce?default(false) || parameters.loadFromGoogle?default(false)>
	jQuery.struts2_jquery.loadAtOnce = true;
</#if>
<#if parameters.scriptPath?if_exists != "">
  	jQuery.scriptPath = "${parameters.scriptPath?string}";
<#else>
  	jQuery.scriptPath = "${javaScriptBasePath}";
</#if>
<#if !parameters.compressed?default(true)>
	jQuery.struts2_jquery.minSuffix = "";
</#if>
<#if parameters.jqueryLocale?if_exists != "" && parameters.jqueryLocale?if_exists != "en">
  jQuery.struts2_jquery.local = "${parameters.jqueryLocale?string}";
</#if>
<#if parameters.gridLocale??>
  jQuery.struts2_jquery.gridLocal = "${parameters.gridLocale?default('en')}";
</#if>
<#if parameters.timeLocale??>
  jQuery.struts2_jquery.timeLocal = "${parameters.timeLocale?default('en')}";
</#if>
<#if parameters.ajaxhistory?default(false)>
	jQuery.struts2_jquery.ajaxhistory = true;
</#if>
	<#if parameters.defaultIndicator?if_exists != "">
	jQuery.struts2_jquery.defaults.indicator="${parameters.defaultIndicator?string}";
	</#if>
	<#if parameters.defaultLoadingText?if_exists != "">
	jQuery.struts2_jquery.defaults.loadingText="${parameters.defaultLoadingText?string}";
	</#if>
	<#if parameters.defaultErrorText?if_exists != "">
	jQuery.struts2_jquery.defaults.errorText="${parameters.defaultErrorText?string}";
	</#if>
	jQuery.ajaxSettings.traditional = true;

	jQuery.ajaxSetup ({
	<#if parameters.ajaxcache?default(false)>
		cache: true
	<#else>
		cache: false
	</#if>
	});
	
<#if parameters.jqueryui?default(true)>
	jQuery.struts2_jquery.require("js/struts2/${jqueryUiStrutsFile}");
</#if>
	
<#if parameters.ajaxhistory?default(false)>
	jQuery(window).trigger('hashchange');
</#if>
});
</script>

<#if parameters.jqueryui?default(true)>
    <#if parameters.jquerytheme?if_exists != "">
		<#if parameters.loadFromGoogle?default(false) && basePath == "${base}/struts/themes">
        	<link id="jquery_theme_link" rel="stylesheet" href="${googleUiPath}/themes/${parameters.jquerytheme?string}/jquery-ui.css" type="text/css"/>
		<#else>
        	<link id="jquery_theme_link" rel="stylesheet" href="${basePath}/${parameters.jquerytheme?string}/jquery-ui.css?s2j=${struts2jQueryVersion}" type="text/css"/>
		</#if>
    <#else>
        <link id="jquery_theme_link" rel="stylesheet" href="${basePath}/smoothness/jquery-ui.css?s2j=${struts2jQueryVersion}" type="text/css"/>
    </#if>
</#if>
