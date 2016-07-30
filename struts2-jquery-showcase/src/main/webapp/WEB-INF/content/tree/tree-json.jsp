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
<div id="result" class="result ui-widget-content ui-corner-all">Click on the AJAX links above.</div>



<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<sj:tab id="tab3" target="jsonaction" label="JSON Action"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;s:url var=&quot;treeDataUrl&quot; action=&quot;json-tree-data&quot; namespace=&quot;/tree&quot;/&gt;
&lt;s:url var=&quot;echo&quot; value=&quot;/echo.action&quot;/&gt;
&lt;sjt:tree
	id=&quot;jsonTree&quot;
	href=&quot;%{treeDataUrl}&quot;
	nodeHref=&quot;%{echo}&quot;
	nodeHrefParamName=&quot;echo&quot;
	nodeTargets=&quot;result&quot;
	onClickTopics=&quot;treeClicked&quot;
/&gt;
			</code>
  	  </pre>
	</div>
	<div id="javascript">
	  <pre>
            <code class="javascript">
$.subscribe('treeClicked', function(event, data) {
    var item = event.originalEvent.data.node;
    alert('Clicked item with ID: ' + item.id + ' and text: ' + item.text);
});
			</code>
	  </pre>
	</div>
	<div id="jsonaction">
	  <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.tree;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;

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
}

			</code>
	  </pre>
	</div>
</sj:tabbedpanel>
<p class="text">
    A Tree Component with a JSON Data Source and search plugin with AJAX / JSON.
</p>
<s:url var="treeSearchDataUrl" action="json-tree-search-data" namespace="/tree"/>
<s:url var="treeSearchUrl" action="json-tree-search" namespace="/tree"/>

<div>
    <input type="text" id="searchField"  />
    <sj:a onClickTopics="treeSearch" button="true" >Search</sj:a>
</div>
<sjt:tree
        id="jsonTreeSearch" searchTopic="treeSearch" searchElementId="searchField"
        href="%{treeSearchDataUrl}"
        plugins="{search:{ajax:{url:'%{treeSearchUrl}'}}}"
        
/>
<p class="text">
    More about JsTree 3 plugins (unique, sort, massload, drag and drop,...) on <a href="https://www.jstree.com/">JsTree official website</a>
</p>
<sj:tabbedpanel id="localtabs2" cssClass="list">
    <sj:tab id="tab4" target="jspsearch" label="JSP Code"/>
    <sj:tab id="tab5" target="jsonsearchaction" label="JSON Action"/>
    <div id="jspsearch">
      <pre>
            <code class="html">
&lt;s:url var=&quot;treeSearchDataUrl&quot; action=&quot;json-tree-search-data&quot; namespace=&quot;/tree&quot;/&gt;
&lt;s:url var=&quot;treeSearchUrl&quot; action=&quot;json-tree-search&quot; namespace=&quot;/tree&quot;/&gt;

&lt;div&gt;
    &lt;input type=&quot;text&quot; id=&quot;searchField&quot;  /&gt;
    &lt;sj:a onClickTopics=&quot;treeSearch&quot; button=&quot;true&quot; &gt;Search&lt;/sj:a&gt;
&lt;/div&gt;
&lt;sjt:tree
        id=&quot;jsonTreeSearch&quot; searchTopic=&quot;treeSearch&quot; searchElementId=&quot;searchField&quot;
        href=&quot;%{treeSearchDataUrl}&quot;
        plugins=&quot;{search:{ajax:{url:'%{treeSearchUrl}'}}}&quot;
        
/&gt;
            </code>
      </pre>
    </div>
    <div id="jsonsearchaction">
      <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;

public class JsonTreeSearch extends ActionSupport {

    private static final long serialVersionUID = -9222182010123442253L;
    private static final List&lt;TreeNode&gt; treeSource = new ArrayList&lt;&gt;();
    private List&lt;TreeNode&gt; nodes = new ArrayList&lt;TreeNode&gt;();
    private String id = &quot;&quot;;
    private String str;
    Set&lt;String&gt; nodeIds = new HashSet&lt;&gt;();

    static {
        TreeNode treeRoot = new TreeNode(&quot;1&quot;, &quot;Struts 2&quot;, new ArrayList&lt;TreeNode&gt;());
        treeRoot.setHasChildren(Boolean.TRUE);
        treeSource.add(treeRoot);

        TreeNode nodeGeneral = new TreeNode(&quot;11&quot;, &quot;General&quot;, new ArrayList&lt;TreeNode&gt;());
        nodeGeneral.setHasChildren(Boolean.TRUE);
        treeSource.add(nodeGeneral);

        TreeNode nodePlugins = new TreeNode(&quot;12&quot;, &quot;Plugins&quot;, new ArrayList&lt;TreeNode&gt;());
        nodePlugins.setHasChildren(Boolean.TRUE);
        treeSource.add(nodePlugins);

        TreeNode nodeBlogs = new TreeNode(&quot;13&quot;, &quot;Blogs&quot;, new ArrayList&lt;TreeNode&gt;());
        nodeBlogs.setHasChildren(Boolean.TRUE);
        treeSource.add(nodeBlogs);

        TreeNode nodeStruts2 = new TreeNode(&quot;111&quot;, &quot;Struts 2&quot;);
        nodeStruts2.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2);

        TreeNode nodeStruts2FB = new TreeNode(&quot;112&quot;, &quot;Struts 2 @ Facebook&quot;);
        nodeStruts2FB.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2FB);

        TreeNode nodeStruts2TW = new TreeNode(&quot;113&quot;, &quot;Struts 2 @ Twitter&quot;);
        nodeStruts2TW.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2TW);

        TreeNode nodeStruts2Pins = new TreeNode(&quot;121&quot;, &quot;Struts 2 Plugins&quot;);
        nodeStruts2Pins.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2Pins);

        TreeNode nodeStruts2JQ = new TreeNode(&quot;122&quot;, &quot;Struts 2 JQuery Plugin&quot;);
        nodeStruts2JQ.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2JQ);

        TreeNode nodeStruts2BS = new TreeNode(&quot;123&quot;, &quot;Struts 2 Bootstrap Plugin&quot;);
        nodeStruts2BS.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2BS);

        TreeNode nodeStruts2JQNews = new TreeNode(&quot;131&quot;, &quot;Struts2 JQuery News&quot;);
        nodeStruts2JQNews.setHasChildren(Boolean.FALSE);
        treeSource.add(nodeStruts2JQNews);

    }

    @Action(value = &quot;json-tree-search-data&quot;, results = @Result(name = SUCCESS, type = &quot;json&quot;, params = { &quot;root&quot;,
            &quot;nodes&quot; }))
    public String data() {
        for (TreeNode n : treeSource) {
            if ((this.id == null || &quot;&quot;.equals(id)) && n.getId().equals(&quot;1&quot;)) {
                this.nodes.add(n);
                break;
            } else if (this.id != null && !&quot;&quot;.equals(id) && n.getId().startsWith(id)
                    && n.getId().length() == (this.id.length() + 1)) {
                this.nodes.add(n);
            }
        }

        return SUCCESS;
    }

    @Override
    @Action(value = &quot;json-tree-search&quot;, results = @Result(name = SUCCESS, type = &quot;json&quot;, params = { &quot;root&quot;,
            &quot;nodeIds&quot; }))
    public String execute() {
        if (this.str != null && !&quot;&quot;.equals(str)) {
            for (TreeNode n : treeSource) {
                if (n.getText().toLowerCase().contains(str.toLowerCase())) {
                    String nodeId = n.getId();
                    do {
                        this.nodeIds.add(nodeId);
                        nodeId = nodeId.substring(0, nodeId.length() - 1);
                    } while (nodeId.length() &gt; 0);
                }
            }
        }

        return SUCCESS;
    }

    public List&lt;TreeNode&gt; getNodes() {
        return nodes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Set&lt;String&gt; getNodeIds() {
        return this.nodeIds;
    }

}

            </code>
      </pre>
    </div>
</sj:tabbedpanel>
