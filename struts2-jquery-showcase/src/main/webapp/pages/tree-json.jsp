<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlslider" action="slider"/><sj:a id="slidersimplelink" href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url id="urlsliderform" action="slider-form"/><sj:a id="sliderformlink"  href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url id="urlsliderrange" action="slider-range"/><sj:a id="sliderrangelink"  href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
      <li><s:url id="urlspinner" action="spinner"/><sj:a id="spinnerlink" href="%{urlspinner}" targets="main">Spinner</sj:a></li>
      <li><s:url id="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url id="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url id="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url id="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
      <li><s:url id="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
      <li><s:url id="urltree" action="tree"/><sj:a id="treelink" href="%{urltree}" targets="main">Tree</sj:a></li>
      <li><s:url id="urltreejson" action="tree-json"/><sj:a id="treejsonlink" href="%{urltreejson}" targets="main">Tree (JSON Data)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Tree (JSON Data)</h2>
    <p class="text">
        A Tree Component with a JSON Data Source.
    </p>
    	<s:url id="treeDataUrl" action="json-tree-data"/>
    	<sjt:tree 
    		id="jsonTree" 
    		href="%{treeDataUrl}"
    		onClickTopics="treeClicked" 
    	/>

  </div>
  
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
		nodeB.setState(TreeNode.NODE_STATE_CLOSED);
		nodeB.setTitle(&quot;Node B&quot; + id);

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
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
