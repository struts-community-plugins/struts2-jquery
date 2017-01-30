<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags" %>
<input type="text" id="searchField" placeholder="Search"/> 
<sj:a onClickTopics="treeSearch" button="true" id="searchButton">Search</sj:a>
<sjt:tree id="myTree" searchElementId="searchField" searchTopic="treeSearch">
  <sjt:treeItem title="A" id="A">
    <sjt:treeItem title="AA" id="AA"/>
    <sjt:treeItem title="AB" id="AB"/>
  </sjt:treeItem>
  <sjt:treeItem title="B" id="B">
    <sjt:treeItem title="BA" id="BA"/>
    <sjt:treeItem title="BB" id="BB"/>
  </sjt:treeItem>
</sjt:tree>
