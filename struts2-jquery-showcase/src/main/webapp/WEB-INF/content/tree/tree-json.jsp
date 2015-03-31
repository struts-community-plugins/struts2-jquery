<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags" %>
<h2>Tree (JSON Data)</h2>

<p class="text">
	A Tree Component with a JSON Data Source.
</p>
<s:url var="treeDataUrl" action="json-tree-data" namespace="/tree"/>
<s:url var="echo" value="/echo.action"/>
<sjt:tree
		id="jsonTree"
		href="%{treeDataUrl}"
        nodeHref="%{echo}"
        nodeHrefParamName="echo"
        nodeTargets="result"
		onClickTopics="treeClicked"
/>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the AJAX Links above.</div>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<sj:tab id="tab3" target="jsonaction" label="JSON Action"/>
	<div id="jsp">
	  <pre>
    	&lt;s:url id=&quot;treeDataUrl&quot; action=&quot;json-tree-data&quot;/&gt;
    	&lt;sjt:tree 
    		id=&quot;jsonTree&quot; 
    		href=&quot;%{treeDataUrl}&quot;
    		onClickTopics=&quot;treeClicked&quot; 
    	/&gt;
   	  </pre>
	</div>
	<div id="javascript">
	  <pre>
	$.subscribe('treeClicked', function(event, data) {
		  var item = event.originalEvent.data.node;
		  alert('Clicked item with ID: ' + item.id + ' and text: ' + item.text);
	});
	  </pre>
	</div>
	<div id="jsonaction">
	  <pre>
@Actions({ @Action(value = &quot;/json-tree-data&quot;, results = { @Result(name = &quot;success&quot;, type = &quot;json&quot;, params = {
	&quot;root&quot;, &quot;nodes&quot; }) }) })
public class JsonTreeData extends ActionSupport implements ServletContextAware {

    private static final long serialVersionUID = -2886756982077980790L;
    private List&lt;TreeNode&gt; nodes = new ArrayList&lt;TreeNode&gt;();
    private String id = &quot;&quot;;
    private ServletContext servletContext;

    public String execute() {

	TreeNode nodeA = new TreeNode();
	nodeA.setId(&quot;A&quot; + id);
    nodeA.getState().setOpened(false);
    nodeA.setHasChildren(true);
	nodeA.setText(&quot;Node A&quot; + id);
    nodeA.setIcon(servletContext.getContextPath() + &quot;/images/root.png&quot;);

	TreeNode nodeB = new TreeNode();
	nodeB.setId(&quot;B&quot; + id);
    nodeB.getState().setOpened(true);
    nodeB.setIcon(servletContext.getContextPath() + &quot;/images/folder.png&quot;);
	nodeB.setText(&quot;Node B&quot; + id);

	TreeNode nodeB1 = new TreeNode();
	nodeB1.setId(&quot;B1&quot; + id);
    nodeB1.setIcon(servletContext.getContextPath() + &quot;/images/file.png&quot;);
	nodeB1.setText(&quot;Node B1&quot; + id);
	nodeB.getChildrens().add(nodeB1);

	TreeNode nodeB2 = new TreeNode();
	nodeB2.setId(&quot;B2&quot; + id);
    nodeB2.getState().setDisabled(true);
    nodeB2.setIcon(servletContext.getContextPath() + &quot;/images/file.png&quot;);
	nodeB2.setText(&quot;Node B2&quot; + id);
	nodeB.getChildrens().add(nodeB2);

	TreeNode nodeC = new TreeNode();
	nodeC.setId(&quot;C&quot; + id);
	nodeC.setText(&quot;Node C&quot; + id);
    nodeC.setIcon(servletContext.getContextPath() + &quot;/images/folder.png&quot;);
    nodeC.setHasChildren(true);

	nodes.add(nodeA);
	nodes.add(nodeB);
	nodes.add(nodeC);

	return SUCCESS;
    }

    public String getJSON() {
	return execute();
    }

    public List&lt;TreeNode&gt; getNodes() {
	return nodes;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setServletContext(ServletContext servletContext) {
          this.servletContext = servletContext;
    }
}       </pre>
	</div>
</sj:tabbedpanel>
