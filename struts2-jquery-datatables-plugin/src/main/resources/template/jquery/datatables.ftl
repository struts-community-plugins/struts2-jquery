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
<@s.script type='text/javascript'>
jQuery(document).ready(function () {
    jQuery.struts2_jquery.require(["js/struts2/jquery.datatables.struts2"+jQuery.struts2_jquery.minSuffix+".js","js/plugins/jquery.dataTables"+jQuery.struts2_jquery.minSuffix+".js"]);
 });
</@s.script>
<table id="${parameters.id}"
<#if parameters.cssClass??>
 class="${parameters.cssClass}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
