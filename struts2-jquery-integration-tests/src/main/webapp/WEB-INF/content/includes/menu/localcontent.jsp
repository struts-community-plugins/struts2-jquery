<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>
<sj:menu id="myMenu" cssStyle="width:50%">
  <sj:menuItem title="menuItem 1" id="menuItem1" />
  <sj:menuItem title="menuItem 2" id="menuItem2">
    <sj:menu id="mySubmenu" cssStyle="width:50%">
      <sj:menuItem title="submenuItem 1" id="submenuItem1"/>
      <sj:menuItem title="submenuItem 2" id="submenuItem2" href="%{simpleTextAjaxUrl}" targets="resultDiv"/>
    </sj:menu>
  </sj:menuItem>
</sj:menu>
<div id="resultDiv">
  This is the result div.
</div>
