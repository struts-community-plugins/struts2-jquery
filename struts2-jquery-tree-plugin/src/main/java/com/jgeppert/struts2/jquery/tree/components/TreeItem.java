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

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Item for the Tree Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "treeItem", tldTagClass = "com.jgeppert.struts2.jquery.tree.views.jsp.ui.TreeItemTag", description = "Item for the Tree Element", allowDynamicAttributes = true)
public class TreeItem extends AbstractRemoteBean {

    public static final String TEMPLATE = "tree-item";
    public static final String TEMPLATE_CLOSE = "tree-item-close";
    public static final String COMPONENT_NAME = TreeItem.class.getName();
    public static final String JQUERYACTION = "treeitem";

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_TREE = "tree";
    private static final String PARAM_PARENT_TREE_ITEM = "parentTreeItem";

    private static final String ID_PREFIX_TREEITEM = "treeitem_";

    protected String title;
    protected String type;

    public TreeItem(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_TITLE, this.title);
        addParameterIfPresent(PARAM_TYPE, this.type);

        addGeneratedIdParam(ID_PREFIX_TREEITEM);

        Component tree = findAncestor(Tree.class);
        if (tree != null) {
            addParameter(PARAM_TREE, ((Tree) tree).getId());
        }

        Component parentTreeItem = findAncestor(TreeItem.class);
        if (parentTreeItem != null) {
            addParameter(PARAM_PARENT_TREE_ITEM, ((TreeItem) parentTreeItem).getId());
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

    @StrutsTagAttribute(description = "The type property for node. This requires a valid types definition in the tree tag.")
    public void setType(String type) {
        this.type = type;
    }
}
