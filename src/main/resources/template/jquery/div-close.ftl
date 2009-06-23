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
</div>
<script type="text/javascript">
$(document).ready(function () {
	$("#${parameters.id?trim}").load(
        "${parameters.href}", 
        {
  <#if parameters.beforeSend?if_exists != "">
            beforeSend : function() {
                            ${parameters.beforeSend?html};<#rt/>
                         },
  </#if>
  <#if parameters.complete?if_exists != "">
            complete : function() {
                            ${parameters.complete?html};<#rt/>
                         },
  </#if>
  <#if parameters.error?if_exists != "">
            error : function() {
                            ${parameters.error?html};<#rt/>
                         },
  </#if>
  <#if parameters.dataType?if_exists != "">
            ajaxOptions:{ dataType:'${parameters.dataType?html}'<#rt/>
  <#else>
             ajaxOptions:{ dataType:'html' }
  </#if>
        },
        function() {
  <#if parameters.effect?if_exists != "">
 		<#assign options="{ ${parameters.effectOptions?default('')} }">
        $("#${parameters.id?trim}").effect("${parameters.effect?html}",${options?html},${parameters.effectDuration?default('2000')});
  </#if>
<#include "resizeable.ftl" />
<#include "draggable.ftl" />
<#include "droppable.ftl" />
        }
	);
});
</script>
