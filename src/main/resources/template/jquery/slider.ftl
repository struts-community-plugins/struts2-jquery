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
<input type="hidden"
  <#if parameters.id?if_exists != "">
    id="${parameters.id?html}"<#rt/>
  </#if>
    value="${parameters.value?default('0')}"<#rt/>
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
<div id="${parameters.id?html}_widget"
  <#if parameters.cssClass?if_exists != "">
    class="${parameters.cssClass?html}"<#rt/>
  </#if>
  <#if parameters.cssStyle?if_exists != "">
    style="${parameters.cssStyle?html}"<#rt/>
  </#if>
></div>
<#if parameters.label?if_exists != "">
	<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
</#if>
<script type="text/javascript">
$(document).ready(function () {
    $('#${parameters.id?html}_widget').slider({
  <#if parameters.animate?default(false)>
            animate: true,
  </#if>
            value: ${parameters.value?default('0')},
  <#if parameters.max?if_exists != "">
            max: ${parameters.max?html},
  </#if>
  <#if parameters.min?if_exists != "">
            min: ${parameters.min?html},
  </#if>
  <#if parameters.orientation?if_exists != "">
            orientation: '${parameters.orientation?html}',
  </#if>
  <#if parameters.range?if_exists != "">
	  <#if parameters.range?html == "true">
	        range: true,<#rt/>
  	  <#else>
            range: '${parameters.range?html}',
	  </#if>
  </#if>
  <#if parameters.step?if_exists != "">
            step: ${parameters.step?html},
  </#if>
<#if parameters.start?if_exists != "">
			start: function(event, ui) { ${parameters.start?html}(event, ui); },
</#if>
<#if parameters.change?if_exists != "">
			change: function(event, ui) { ${parameters.change?html}(event, ui); },
</#if>
<#if parameters.stop?if_exists != "">
			stop: function(event, ui) { ${parameters.stop?html}(event, ui); },
</#if>
			slide: function(event, ui) {
			 $('#${parameters.id?html}').val(ui.value);
<#if parameters.displayValueElement?if_exists != "">
			 $('#${parameters.displayValueElement?html}').html(ui.value);
</#if>
<#if parameters.slide?if_exists != "">
			 ${parameters.slide?html}(event, ui); 
</#if>
			}
    });
});
</script>