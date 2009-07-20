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
<#if parameters.label?if_exists != "">
	<#include "/${parameters.templateDir}/xhtml/controlheader.ftl" />
</#if>
<#if parameters.form?exists && parameters.form.validate?default(false) == true>
	<#-- can't mutate the data model in freemarker -->
    <#if parameters.onblur?exists>
        ${tag.addParameter('onblur', "validate(this);${parameters.onblur}")}
    <#else>
        ${tag.addParameter('onblur', "validate(this);")}
    </#if>
</#if>
<input type="text"
  <#if parameters.id?if_exists != "">
    id="${parameters.id?html}"<#rt/>
  </#if>
  <#if parameters.value?if_exists != "">
    value="${parameters.value?html}"<#rt/>
  </#if>
  <#if parameters.name?if_exists != "">
    name="${parameters.name?html}"<#rt/>
  </#if>
  <#if parameters.tabindex?if_exists != "">
    tabindex="${parameters.tabindex?html}"<#rt/>
  </#if>
  <#if parameters.cssClass?if_exists != "">
    class="${parameters.cssClass?html}"<#rt/>
  </#if>
  <#if parameters.cssStyle?if_exists != "">
    style="${parameters.cssStyle?html}"<#rt/>
  </#if>
  <#if parameters.disabled?default(false)>
    disabled="disabled"<#rt/>
  </#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>
<#if parameters.label?if_exists != "">
	<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
</#if>
<script type="text/javascript">
$(document).ready(function () {
    $('#${parameters.id?html}').datepicker({
  <#if parameters.buttonImage?if_exists != "">
            showOn: 'both', buttonImage: '${parameters.buttonImage?html}',
  <#else>
            showOn: 'both', buttonImage: '${base}/struts/js/calendar.gif',
  </#if>
  <#if parameters.showButtonPanel?default(false)>
            showButtonPanel: true,
  </#if>
  <#if parameters.changeMonth?default(false)>
            changeMonth: true,
  </#if>
  <#if parameters.changeYear?default(false)>
            changeYear: true,
  </#if>
  <#if parameters.displayFormat?if_exists != "">
            dateFormat: '${parameters.displayFormat?html}'<#rt/>
  <#else>
            dateFormat: 'yy-mm-dd'<#rt/>
  </#if>
    });
});
</script>