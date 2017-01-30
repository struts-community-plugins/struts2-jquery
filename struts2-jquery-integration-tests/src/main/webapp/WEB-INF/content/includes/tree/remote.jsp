<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags" %>

<s:url var="treeDataUrl" action="tree-data" namespace="/ajax"/>
<sjt:tree id="myTree" href="%{treeDataUrl}"/>
