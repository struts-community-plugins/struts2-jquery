<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<sj:tabbedpanel id="myTabbedPanel">
  <sj:tab id="tab1" target="tabcontent1" label="tab 1"/>
  <sj:tab id="tab2" target="tabcontent2" label="tab 2"/>
  <div id="tabcontent1">Tab Content 1</div>
  <div id="tabcontent2">Tab Content 2</div>
</sj:tabbedpanel>
