<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags" %>
<s:form id="treeForm" action="echo" namespace="/">
  <sjt:tree id="myTree" checkbox="true" name="echo">
    <sjt:treeItem title="A" id="A">
      <sjt:treeItem title="AA" id="AA"/>
      <sjt:treeItem title="AB" id="AB"/>
    </sjt:treeItem>
    <sjt:treeItem title="B" id="B">
      <sjt:treeItem title="BA" id="BA"/>
      <sjt:treeItem title="BB" id="BB"/>
    </sjt:treeItem>
  </sjt:tree>
  <sj:submit id="mySubmit" targets="resultDiv"/>
</s:form>
<div id="resultDiv"/>
