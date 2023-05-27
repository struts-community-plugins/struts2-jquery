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

import com.jgeppert.struts2.jquery.tree.components.Tree;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractContainerTag;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */

public class TreeTag extends AbstractContainerTag {

    private static final long serialVersionUID = -6297851020849153739L;

    protected String jstreetheme;
    protected String jstreethemeVariant;
    protected String jstreethemeResponsive;
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
    protected String plugins;
    protected String types;
    protected String showThemeDots;
    protected String showThemeIcons;
    protected String checkbox;
    protected String checkboxTwoState;
    protected String checkboxToogleAllTopics;
    protected String checkboxHideTopics;
    protected String checkboxShowTopics;
    protected String checkboxCheckAllTopics;
    protected String checkboxUncheckAllTopics;
    protected String searchTopic;
    protected String searchClearTopic;
    protected String searchElementId;
    protected String onSearchCompleteTopics;
    protected String onSearchClearTopics;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Tree(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Tree tree = (Tree) component;
        tree.setJstreetheme(jstreetheme);
        tree.setJstreethemeVariant(jstreethemeVariant);
        tree.setJstreethemeResponsive(jstreethemeResponsive);
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
        tree.setPlugins(plugins);
        tree.setTypes(types);
        tree.setShowThemeDots(showThemeDots);
        tree.setShowThemeIcons(showThemeIcons);
        tree.setCheckbox(checkbox);
        tree.setCheckboxTwoState(checkboxTwoState);
        tree.setCheckboxToogleAllTopics(checkboxToogleAllTopics);
        tree.setCheckboxShowTopics(checkboxShowTopics);
        tree.setCheckboxHideTopics(checkboxHideTopics);
        tree.setCheckboxCheckAllTopics(checkboxCheckAllTopics);
        tree.setCheckboxUncheckAllTopics(checkboxUncheckAllTopics);
        tree.setSearchElementId(searchElementId);
        tree.setSearchTopic(searchTopic);
        tree.setOnSearchCompleteTopics(onSearchCompleteTopics);
        tree.setSearchClearTopic(searchClearTopic);
        tree.setOnSearchClearTopics(onSearchClearTopics);
    }

    public void setJstreetheme(String jstreetheme) {
        this.jstreetheme = jstreetheme;
    }

    public void setJstreethemeVariant(String jstreethemeVariant) {
        this.jstreethemeVariant = jstreethemeVariant;
    }

    public void setJstreethemeResponsive(String jstreethemeResponsive) {
        this.jstreethemeResponsive = jstreethemeResponsive;
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

    @Override
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

    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setShowThemeIcons(String showThemeIcons) {
        this.showThemeIcons = showThemeIcons;
    }

    public void setShowThemeDots(String showThemeDots) {
        this.showThemeDots = showThemeDots;
    }

    public void setNodeTypeProperty(String nodeTypeProperty) {
        this.nodeTypeProperty = nodeTypeProperty;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public void setCheckboxTwoState(String checkboxTwoState) {
        this.checkboxTwoState = checkboxTwoState;
    }

    public void setCheckboxToogleAllTopics(String checkboxToogleAllTopics) {
        this.checkboxToogleAllTopics = checkboxToogleAllTopics;
    }

    public void setCheckboxHideTopics(String checkboxHideTopics) {
        this.checkboxHideTopics = checkboxHideTopics;
    }

    public void setCheckboxShowTopics(String checkboxShowTopics) {
        this.checkboxShowTopics = checkboxShowTopics;
    }

    public void setCheckboxUncheckAllTopics(String checkboxUncheckAllTopics) {
        this.checkboxUncheckAllTopics = checkboxUncheckAllTopics;
    }

    public void setCheckboxCheckAllTopics(String checkboxCheckAllTopics) {
        this.checkboxCheckAllTopics = checkboxCheckAllTopics;
    }

    public void setSearchTopic(String searchTopic) {
        this.searchTopic = searchTopic;
    }

    public void setSearchElementId(String searchElementId) {
        this.searchElementId = searchElementId;
    }

    public void setOnSearchCompleteTopics(String onSearchCompleteTopics) {
        this.onSearchCompleteTopics = onSearchCompleteTopics;
    }

    public void setSearchClearTopic(String searchClearTopic) {
        this.searchClearTopic = searchClearTopic;
    }

    public void setOnSearchClearTopics(String onSearchClearTopics) {
        this.onSearchClearTopics = onSearchClearTopics;
    }
}
