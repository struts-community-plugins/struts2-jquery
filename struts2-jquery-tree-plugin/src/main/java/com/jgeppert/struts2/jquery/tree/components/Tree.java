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

package com.jgeppert.struts2.jquery.tree.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Tree Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "tree", tldTagClass = "com.jgeppert.struts2.jquery.tree.views.jsp.ui.TreeTag", description = "A Tree Element", allowDynamicAttributes = true)
public class Tree extends AbstractContainer {

	public static final String TEMPLATE = "tree";
	public static final String TEMPLATE_CLOSE = "tree-close";
	public static final String COMPONENT_NAME = Tree.class.getName();
	final private static transient Random RANDOM = new Random();
	public static final String JQUERYACTION = "tree";

	protected String jstreetheme;
	protected String htmlTitles;
	protected String animation;
	protected String initiallyOpen;
	protected String rtl;
	protected String href;
	protected String onClickTopics;
	protected String rootNode;
	protected String childCollectionProperty;
	protected String nodeTitleProperty;
	protected String nodeIdProperty;
	protected String nodeHref;
	protected String nodeHrefParamName;
	protected String nodeTargets;

	public Tree(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		addParameter("jqueryaction", JQUERYACTION);

		if (this.jstreetheme != null)
			addParameter("jstreetheme", findString(this.jstreetheme));
		if (this.animation != null)
			addParameter("animation", findValue(animation, Number.class));
		if (this.htmlTitles != null)
			addParameter("htmlTitles",
					findValue(this.htmlTitles, Boolean.class));
		if (this.initiallyOpen != null)
			addParameter("initiallyOpen", findString(this.initiallyOpen));
		if (this.rtl != null)
			addParameter("rtl", findValue(this.rtl, Boolean.class));
		if (href != null)
			addParameter("href", findString(href));
		if (onClickTopics != null)
			addParameter("onClickTopics", findString(onClickTopics));
		if (rootNode != null)
			addParameter("rootNode", findValue(rootNode));
		if (childCollectionProperty != null)
			addParameter("childCollectionProperty",
					findString(childCollectionProperty));
		if (nodeTitleProperty != null)
			addParameter("nodeTitleProperty", findString(nodeTitleProperty));
		if (nodeIdProperty != null)
			addParameter("nodeIdProperty", findString(nodeIdProperty));
		if (nodeHref != null)
			addParameter("nodeHref", findString(nodeHref));
		if (nodeHrefParamName != null)
			addParameter("nodeHrefParamName", findString(nodeHrefParamName));
		if (nodeTargets != null)
			addParameter("nodeTargets", findString(nodeTargets));

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "tree" + String.valueOf(nextInt);
			addParameter("id", this.id);
		}
	}

	@Override
	@StrutsTagSkipInheritance
	public void setTheme(String theme) {
		super.setTheme(theme);
	}

	@Override
	public String getTheme() {
		return "jquery";
	}

	@StrutsTagAttribute(description = "jstree theme. default, default-rtl, classic or apple", defaultValue = "theme from jquery ui")
	public void setJstreetheme(String jstreetheme) {
		this.jstreetheme = jstreetheme;
	}

	@StrutsTagAttribute(description = "Defines whether titles can contain HTML code.", type = "Boolean", defaultValue = "false")
	public void setHtmlTitles(String htmlTitles) {
		this.htmlTitles = htmlTitles;
	}

	@StrutsTagAttribute(description = "Defines the duration of open/close animations. 0 means no animation.", type = "Number", defaultValue = "500")
	public void setAnimation(String animation) {
		this.animation = animation;
	}

	@StrutsTagAttribute(description = "Defines which nodes are to be automatically opened when the tree finishes loading - a list of IDs is expected. eg.: ['id1', 'id2']", defaultValue = "[]")
	public void setInitiallyOpen(String initiallyOpen) {
		this.initiallyOpen = initiallyOpen;
	}

	@StrutsTagAttribute(description = "Defines whether the tree is in right-to-left mode (also make sure you are using a RTL theme - for example the included default-rtl).", type = "Boolean", defaultValue = "false")
	public void setRtl(String rtl) {
		this.rtl = rtl;
	}

	@StrutsTagAttribute(description = "Url used to load the list of children nodes for an specific node, whose id will be passed as a parameter named 'nodeId' (empty for root)")
	public void setHref(String href) {
		this.href = href;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published when the tree item is clicked", type = "String")
	public void setOnClickTopics(String onClickTopics) {
		this.onClickTopics = onClickTopics;
	}
	
    @StrutsTagAttribute(description="The rootNode property.")
    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }
    
    public String getRootNode() {
        return rootNode;
    }

    @StrutsTagAttribute(description="The childCollectionProperty property.")
    public void setChildCollectionProperty(String childCollectionProperty) {
        this.childCollectionProperty = childCollectionProperty;
    }

    public String getChildCollectionProperty() {
        return childCollectionProperty;
    }

    @StrutsTagAttribute(description="The nodeTitleProperty property.")
    public void setNodeTitleProperty(String nodeTitleProperty) {
        this.nodeTitleProperty = nodeTitleProperty;
    }

    public String getNodeTitleProperty() {
        return nodeTitleProperty;
    }

    @StrutsTagAttribute(description="The nodeIdProperty property.")
    public void setNodeIdProperty(String nodeIdProperty) {
        this.nodeIdProperty = nodeIdProperty;
    }

    public String getNodeIdProperty() {
        return nodeIdProperty;
    }

    @StrutsTagAttribute(description="The href property for node.")
	public void setNodeHref(String nodeHref) {
		this.nodeHref = nodeHref;
	}

    @StrutsTagAttribute(description="The href parameter name for node link.", defaultValue="id")
	public void setNodeHrefParamName(String nodeHrefParamName) {
		this.nodeHrefParamName = nodeHrefParamName;
	}

    @StrutsTagAttribute(description="AJAX targets for node items.")
	public void setNodeTargets(String nodeTargets) {
		this.nodeTargets = nodeTargets;
	}
}
