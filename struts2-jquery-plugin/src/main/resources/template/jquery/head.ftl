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
    <#assign jQueryVersion="3.7.1">
</#if>
<#assign jQueryUIVersion="1.13.2">
<#-- issue89: temporary fix because of i18n files not being available for current jQuery UI version -->
<#assign jQueryUIVersionI18n="1.11.1">
<#assign struts2jQueryVersion="${version}">

<#if attributes.scriptPath?has_content>
    <#assign javaScriptBasePath="${attributes.scriptPath?string}">
<#else>
    <#assign javaScriptBasePath="${base}/static/">
</#if>

<#assign cdnUiPath="https://code.jquery.com/ui/${jQueryUIVersion}">

<#if attributes.customBasepath?has_content>
    <#assign basePath="${attributes.customBasepath?string}">
<#else>
    <#assign basePath="${javaScriptBasePath}themes">
</#if>
<#if attributes.compressed!true>
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

<#if attributes.loadFromCdn!false>
    <#if attributes.jquery!true>
    <@s.script type="text/javascript" src="${jqueryCdn}"></@s.script>
    </#if>
    <#if attributes.jqueryui!true>
    <@s.script type="text/javascript" src="${jqueryUiCdn}"></@s.script>
        <#if attributes.jqueryLocale?has_content && attributes.jqueryLocale != "en">
        <@s.script type="text/javascript"
                src="//ajax.googleapis.com/ajax/libs/jqueryui/${jQueryUIVersionI18n}/i18n/datepicker-${attributes.jqueryLocale?string}.min.js"/>
        </#if>
    </#if>
<#else>
    <#if attributes.jquery!true>
        <@s.script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryFile}"/>
    </#if>
    <#if attributes.jqueryui!true>
        <#if attributes.loadAtOnce!false>
        <@s.script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUIFile}"/>
            <#if attributes.jqueryLocale?has_content && attributes.jqueryLocale != "en">
            <@s.script type="text/javascript"
                    src="${javaScriptBasePath}i18n/datepicker-${attributes.jqueryLocale?string}.min.js?s2j=${struts2jQueryVersion}"/>
            </#if>
        <#else>
        <!-- script type="text/javascript" src="${javaScriptBasePath}js/base/${jqueryUICoreFile}"></script -->
        <@s.script type="text/javascript"src="${javaScriptBasePath}js/base/${jqueryUiVersionFile}"/>
        </#if>
    </#if>
</#if>
<#if attributes.loadAtOnce!false ||  attributes.loadFromCdn!false>
<@s.script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryForm}"/>
</#if>
<@s.script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jquerySubscribeFile}"/>
<#if attributes.ajaxhistory!false>
<@s.script type="text/javascript" src="${javaScriptBasePath}js/plugins/${jqueryHistoryFile}"/>
</#if>

<@s.script type="text/javascript" src="${javaScriptBasePath}js/struts2/${jqueryStrutsFile}"/>

<@s.script type="text/javascript">
    $(function () {
        jQuery.struts2_jquery.version = "${struts2jQueryVersion}";
    <#if attributes.debug!false>
        jQuery.struts2_jquery.debug = true;
    </#if>
    <#if attributes.loadAtOnce!false || attributes.loadFromCdn!false>
        jQuery.struts2_jquery.loadAtOnce = true;
    </#if>
    <#if attributes.scriptPath?has_content>
        jQuery.scriptPath = "${attributes.scriptPath?string}";
    <#else>
        jQuery.scriptPath = "${javaScriptBasePath}";
    </#if>
    <#if !attributes.compressed!true>
        jQuery.struts2_jquery.minSuffix = "";
    </#if>
    <#if attributes.jqueryLocale?has_content && attributes.jqueryLocale! != "en">
        jQuery.struts2_jquery.local = "${attributes.jqueryLocale?string}";
    </#if>
    <#if attributes.gridLocale??>
        jQuery.struts2_jquery.gridLocal = "${attributes.gridLocale!'en'}";
    </#if>
    <#if attributes.timeLocale??>
        jQuery.struts2_jquery.timeLocal = "${attributes.timeLocale!'en'}";
    </#if>
    <#if attributes.datatablesLocale??>
        jQuery.struts2_jquery.datatablesLocal = "${attributes.datatablesLocale!'en'}";
    </#if>
    <#if attributes.ajaxhistory!false>
        jQuery.struts2_jquery.ajaxhistory = true;
    </#if>
    <#if attributes.defaultIndicator?has_content>
        jQuery.struts2_jquery.defaults.indicator = "${attributes.defaultIndicator?string}";
    </#if>
    <#if attributes.defaultLoadingText?has_content>
        jQuery.struts2_jquery.defaults.loadingText = "${attributes.defaultLoadingText?string}";
    </#if>
    <#if attributes.defaultErrorText?has_content>
        jQuery.struts2_jquery.defaults.errorText = "${attributes.defaultErrorText?string}";
    </#if>
        jQuery.ajaxSettings.traditional = true;

        jQuery.ajaxSetup({
        <#if attributes.ajaxcache!false>
            cache: true
        <#else>
            cache: false
        </#if>
        });

    <#if attributes.jqueryui!true>
        jQuery.struts2_jquery.require("js/struts2/${jqueryUiStrutsFile}");
    </#if>

    <#if attributes.ajaxhistory!false>
        jQuery(window).trigger('hashchange');
    </#if>
    });
</@s.script>

<#if attributes.jqueryui!true>
    <#if attributes.jquerytheme?has_content>
        <#if attributes.loadFromCdn!false && basePath == "${base}/static/themes">
            <link
                    id="jquery_theme_link"
                    rel="stylesheet"
                    href="${cdnUiPath}/themes/${attributes.jquerytheme?string}/jquery-ui.css"
                    type="text/css"
                    <#include "/${attributes.templateDir}/simple/nonce.ftl" />/>
        <#else>
            <link
                    id="jquery_theme_link"
                    rel="stylesheet"
                    href="${basePath}/${attributes.jquerytheme?string}/jquery-ui.css?s2j=${struts2jQueryVersion}"
                    type="text/css"
                    <#include "/${attributes.templateDir}/simple/nonce.ftl" />/>
        </#if>
    <#else>
    <@s.link id="jquery_theme_link" rel="stylesheet"
          href="${basePath}/smoothness/jquery-ui.css?s2j=${struts2jQueryVersion}" type="text/css"/>
    </#if>
</#if>
