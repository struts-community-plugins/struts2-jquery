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

package com.jgeppert.struts2.jquery.tree.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.tree.components.Tree;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractContainerTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

public class TreeTag extends AbstractContainerTag {

	private static final long serialVersionUID = -6297851020849153739L;

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
	protected String nodeTypeProperty;
	protected String nodeIdProperty;
	protected String nodeHref;
	protected String nodeHrefParamName;
	protected String nodeTargets;
	protected String openAllOnLoad;
	protected String openAllOnRefresh;
	protected String contextmenu;
	protected String types;

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Tree(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Tree tree = (Tree) component;
		tree.setJstreetheme(jstreetheme);
		tree.setAnimation(animation);
		tree.setHtmlTitles(htmlTitles);
		tree.setInitiallyOpen(initiallyOpen);
		tree.setRtl(rtl);
		tree.setHref(href);
		tree.setOnClickTopics(onClickTopics);
		tree.setRootNode(rootNode);
		tree.setChildCollectionProperty(childCollectionProperty);
		tree.setNodeIdProperty(nodeIdProperty);
		tree.setNodeTitleProperty(nodeTitleProperty);
		tree.setNodeTypeProperty(nodeTypeProperty);
		tree.setNodeHref(nodeHref);
		tree.setNodeHrefParamName(nodeHrefParamName);
		tree.setNodeTargets(nodeTargets);
		tree.setOpenAllOnLoad(openAllOnLoad);
		tree.setOpenAllOnRefresh(openAllOnRefresh);
		tree.setContextmenu(contextmenu);
		tree.setTypes(types);
	}

	public void setJstreetheme(String jstreetheme) {
		this.jstreetheme = jstreetheme;
	}

	public void setHtmlTitles(String htmlTitles) {
		this.htmlTitles = htmlTitles;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
	}

	public void setInitiallyOpen(String initiallyOpen) {
		this.initiallyOpen = initiallyOpen;
	}

	public void setRtl(String rtl) {
		this.rtl = rtl;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setOnClickTopics(String onClickTopics) {
		this.onClickTopics = onClickTopics;
	}

	public void setRootNode(String rootNode) {
		this.rootNode = rootNode;
	}

	public void setChildCollectionProperty(String childCollectionProperty) {
		this.childCollectionProperty = childCollectionProperty;
	}

	public void setNodeTitleProperty(String nodeTitleProperty) {
		this.nodeTitleProperty = nodeTitleProperty;
	}

	public void setNodeIdProperty(String nodeIdProperty) {
		this.nodeIdProperty = nodeIdProperty;
	}

	public void setNodeHref(String nodeHref) {
		this.nodeHref = nodeHref;
	}

	public void setNodeHrefParamName(String nodeHrefParamName) {
		this.nodeHrefParamName = nodeHrefParamName;
	}

	public void setNodeTargets(String nodeTargets) {
		this.nodeTargets = nodeTargets;
	}

	public void setOpenAllOnLoad(String openAllOnLoad) {
	    this.openAllOnLoad = openAllOnLoad;
	}

	public void setOpenAllOnRefresh(String openAllOnRefresh) {
	    this.openAllOnRefresh = openAllOnRefresh;
	}

	public void setContextmenu(String contextmenu) {
	    this.contextmenu = contextmenu;
	}

	public void setTypes(String types) {
	    this.types = types;
	}

	public void setNodeTypeProperty(String nodeTypeProperty) {
	    this.nodeTypeProperty = nodeTypeProperty;
	}

}
