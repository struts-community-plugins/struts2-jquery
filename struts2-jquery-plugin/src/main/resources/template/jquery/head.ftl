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
    <#assign jQueryVersion="3.6.0">
</#if>
<#assign jQueryUIVersion="1.13.2">
<#-- issue89: temporary fix because of i18n files not being available for current jQuery UI version -->
<#assign jQueryUIVersionI18n="1.11.1">
<#assign struts2jQueryVersion="${version}">

<#if parameters.scriptPath?if_exists != "">
    <#assign javaScriptBasePath="${parameters.scriptPath?string}">
<#else>
    <#assign javaScriptBasePath="${base}/static/">
</#if>

<#assign cdnUiPath="https://code.jquery.com/ui/${jQueryUIVersion}">

<#if parameters.customBasepath?if_exists != "">
    <#assign basePath="${parameters.customBasepath?string}">
<#else>
    <#assign basePath="${javaScriptBasePath}themes">
</#if>
<#if parameters.compressed?default(true)>
    <#assign jqueryFile="jquery-${jQueryVersion}.min.js">
    <#assign jqueryForm="jquery.form.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUIFile="jquery-ui.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUICoreFile="core.min.js?s2j=${struts2jQueryVersion}">
    <#assign jquerySubscribeFile="jquery.subscribe.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryHistoryFile="jquery.ba-bbq.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryStrutsFile="jquery.struts2.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUiStrutsFile="jquery.ui.struts2.min.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUiCdn="https://code.jquery.com/ui/${jQueryUIVersion}/jquery-ui.min.js">
    <#assign jqueryUiVersionFile="version.min.js">
<#else>
    <#assign jqueryFile="jquery-${jQueryVersion}.js">
    <#assign jqueryForm="jquery.form.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUIFile="jquery-ui.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUICoreFile="core.js?s2j=${struts2jQueryVersion}">
    <#assign jquerySubscribeFile="jquery.subscribe.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryHistoryFile="jquery.ba-bbq.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryStrutsFile="jquery.struts2.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUiStrutsFile="jquery.ui.struts2.js?s2j=${struts2jQueryVersion}">
    <#assign jqueryUiCdn="https://code.jquery.com/ui/${jQueryUIVersion}/jquery-ui.js">
    <#assign jqueryUiVersionFile="version.js">
</#if>
<#assign jqueryCdn="https://code.jquery.com/${jqueryFile}">

<#if parameters.loadFromCdn?default(false)>
    <#if parameters.jquery?default(true)>
    <script type="text/javascript" src="${jqueryCdn}"></script>
    </#if>
    <#if parameters.jqueryui?default(true)>
    <script type="text/javascript" src="${jqueryUiCdn}"></script>
        <#if parameters.jqueryLocale?if_exists != "" && parameters.jqueryLocale?if_exists != "en">
        <script type="text/javascript"
                src="//ajax.googleapis.com/ajax/libs/jqueryui/${jQueryUIVersionI18n}/i18n/datepicker-${parameters.jqueryLocale?string}.min.js"></script>
        </#if>
    </#if>
<#else>
    <#if parameters.jquery?default(true)>
        <script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryFile}"></script>
    </#if>
    <#if parameters.jqueryui?default(true)>
        <#if parameters.loadAtOnce?default(false)>
        <script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUIFile}"></script>
            <#if parameters.jqueryLocale?if_exists != "" && parameters.jqueryLocale?if_exists != "en">
            <script type="text/javascript"
                    src="${javaScriptBasePath}i18n/datepicker-${parameters.jqueryLocale?string}.min.js?s2j=${struts2jQueryVersion}"></script>
            </#if>
        <#else>
        <!-- script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUICoreFile}"></script -->
        <script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUiVersionFile}"></script>
        </#if>
    </#if>
</#if>
<#if parameters.loadAtOnce?default(false) ||  parameters.loadFromCdn?default(false)>
<script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryForm}"></script>
</#if>
<script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jquerySubscribeFile}"></script>
<#if parameters.ajaxhistory?default(false)>
<script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryHistoryFile}"></script>
</#if>

<script type="text/javascript" src="${javaScriptBasePath}js/struts2/${jqueryStrutsFile}"></script>

<script type="text/javascript">
    $(function () {
        jQuery.struts2_jquery.version = "${struts2jQueryVersion}";
    <#if parameters.debug?default(false)>
        jQuery.struts2_jquery.debug = true;
    </#if>
    <#if parameters.loadAtOnce?default(false) || parameters.loadFromCdn?default(false)>
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
    <#if parameters.datatablesLocale??>
        jQuery.struts2_jquery.datatablesLocal = "${parameters.datatablesLocale?default('en')}";
    </#if>
    <#if parameters.ajaxhistory?default(false)>
        jQuery.struts2_jquery.ajaxhistory = true;
    </#if>
    <#if parameters.defaultIndicator?if_exists != "">
        jQuery.struts2_jquery.defaults.indicator = "${parameters.defaultIndicator?string}";
    </#if>
    <#if parameters.defaultLoadingText?if_exists != "">
        jQuery.struts2_jquery.defaults.loadingText = "${parameters.defaultLoadingText?string}";
    </#if>
    <#if parameters.defaultErrorText?if_exists != "">
        jQuery.struts2_jquery.defaults.errorText = "${parameters.defaultErrorText?string}";
    </#if>
        jQuery.ajaxSettings.traditional = true;

        jQuery.ajaxSetup({
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
        <#if parameters.loadFromCdn?default(false) && basePath == "${base}/static/themes">
        <link id="jquery_theme_link" rel="stylesheet"
              href="${cdnUiPath}/themes/${parameters.jquerytheme?string}/jquery-ui.css" type="text/css"/>
        <#else>
        <link id="jquery_theme_link" rel="stylesheet"
              href="${basePath}/${parameters.jquerytheme?string}/jquery-ui.css?s2j=${struts2jQueryVersion}"
              type="text/css"/>
        </#if>
    <#else>
    <link id="jquery_theme_link" rel="stylesheet"
          href="${basePath}/smoothness/jquery-ui.css?s2j=${struts2jQueryVersion}" type="text/css"/>
    </#if>
</#if>
