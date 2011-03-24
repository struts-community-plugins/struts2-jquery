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
import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Item for the Tree Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "treeItem", tldTagClass = "com.jgeppert.struts2.jquery.tree.views.jsp.ui.TreeItemTag", description = "Item for the Tree Element", allowDynamicAttributes = true)
public class TreeItem extends AbstractRemoteBean {

	public static final String TEMPLATE = "tree-item";
	public static final String TEMPLATE_CLOSE = "tree-item-close";
	public static final String COMPONENT_NAME = TreeItem.class.getName();
	protected final static Logger LOG = LoggerFactory.getLogger(TreeItem.class);
	private final static transient Random RANDOM = new Random();
	public static final String           JQUERYACTION   = "treeitem";

	protected String title;

	public TreeItem(ValueStack stack, HttpServletRequest request,
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

		if (title != null)
			addParameter("title", findString(title));

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "treeitem" + String.valueOf(nextInt);
			addParameter("id", this.id);
		}

		Tree tree = (Tree) findAncestor(Tree.class);
		if (tree != null) {
			addParameter("tree", tree.getId());
		}

		TreeItem parentTreeItem = (TreeItem) findAncestor(TreeItem.class);
		if (parentTreeItem != null) {
			addParameter("parentTreeItem", parentTreeItem.getId());
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

	@StrutsTagAttribute(description = "Title for the Tree Item", required = true)
	public void setTitle(String title) {
		this.title = title;
	}
}
