<#--
/*
 * $Id: div-close.ftl 590812 2007-10-31 20:32:54Z apetrelli $
 *
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
</div>
<script type="text/javascript">
$(document).ready(function () {
<#if parameters.effect?if_exists != "">
<#assign options="{ ${parameters.effectOptions?default('')} }">
<#if parameters.bindOn?if_exists != "">
	$('#${parameters.bindOn?html}').bind(
<#else>
	$('#${parameters.id?html}').bind(
</#if>
	'${parameters.events?default('click')}', 
	function(e){
      <#if parameters.befor?if_exists != "">
    	${parameters.befor?html};
	  </#if>
       $("#${parameters.id?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')}
      <#if parameters.after?if_exists != "">
    	, ${parameters.after?html}
	  </#if>
	  );
	});
</#if>
<#include "resizeable.ftl" />
<#include "draggable.ftl" />
<#include "droppable.ftl" />
});
</script>