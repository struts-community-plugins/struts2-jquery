<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags" %>
<h2>Tree (JSON Data)</h2>

<p class="text">
	A Tree Component with a JSON Data Source.
</p>
<s:url var="treeDataUrl" action="json-tree-data" namespace="/tree"/>
<sjt:tree
		id="jsonTree"
		href="%{treeDataUrl}"
		onClickTopics="treeClicked"
		/>

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
		  var item = event.originalEvent.data.rslt.obj;
		  alert('Clicked ID : ' + item.attr(&quot;id&quot;) + ' - Text ' + item.text());
	});
	  </pre>
	</div>
	<div id="jsonaction">
	  <pre>
@ParentPackage(value = &quot;showcase&quot;)
public class JsonTreeData extends ActionSupport {

	private static final long serialVersionUID = -2886756982077980790L;
	private List&lt;TreeNode&gt; nodes = new ArrayList&lt;TreeNode&gt;();
	private String id = &quot;&quot;;

	@Actions( { @Action(value = &quot;/json-tree-data&quot;, results = { 
		@Result(name = &quot;success&quot;, type = &quot;json&quot;, params = {
			&quot;root&quot;, &quot;nodes&quot; 
		}) 
	}) })
	public String execute() {

		TreeNode nodeA = new TreeNode();
		nodeA.setId(&quot;A&quot; + id);
		nodeA.setTitle(&quot;Node A&quot; + id);
		nodeA.setState(TreeNode.NODE_STATE_CLOSED);

		TreeNode nodeB = new TreeNode();
		nodeB.setId(&quot;B&quot; + id);
		nodeB.setState(TreeNode.NODE_STATE_OPEN);
		nodeB.setIcon(&quot;ui-icon-suitcase&quot;);
		nodeB.setTitle(&quot;Node B&quot; + id);
		nodeB.setChildren(new LinkedList&lt;TreeNode&gt;());
		
		TreeNode nodeB1 = new TreeNode();
		nodeB1.setId(&quot;B1&quot; + id);
		nodeB1.setState(TreeNode.NODE_STATE_LEAF);
		nodeB1.setIcon(&quot;ui-icon-document&quot;);
		nodeB1.setTitle(&quot;Node B1&quot; + id);
		nodeB.getChildren().add(nodeB1);
		
		TreeNode nodeB2 = new TreeNode();
		nodeB2.setId(&quot;B2&quot; + id);
		nodeB2.setState(TreeNode.NODE_STATE_LEAF);
		nodeB2.setIcon(&quot;ui-icon-image&quot;);
		nodeB2.setTitle(&quot;Node B2&quot; + id);
		nodeB.getChildren().add(nodeB2);

		TreeNode nodeC = new TreeNode();
		nodeC.setId(&quot;C&quot; + id);
		nodeC.setState(TreeNode.NODE_STATE_CLOSED);
		nodeC.setTitle(&quot;Node C&quot; + id);

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
	}	  </pre>
	</div>
</sj:tabbedpanel>
