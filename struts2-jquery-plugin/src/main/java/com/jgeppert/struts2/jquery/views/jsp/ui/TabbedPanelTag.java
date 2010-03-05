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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.components.TabbedPanel;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see TabbedPanel
 */
public class TabbedPanelTag extends AbstractTopicTag {

  private static final long serialVersionUID = -4719930205515386252L;

  protected String          selectedTab;
  protected String          useSelectedTabCookie;
  protected String          openOnMouseover;
  protected String          collapsible;
  protected String          animate;
  protected String          spinner;
  protected String          cache;
  protected String          disabledTabs;
  protected String          onAddTopics;
  protected String          onRemoveTopics;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new TabbedPanel(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();
    TabbedPanel tabbedPanel = (TabbedPanel) component;
    tabbedPanel.setSelectedTab(selectedTab);
    tabbedPanel.setUseSelectedTabCookie(useSelectedTabCookie);
    tabbedPanel.setAnimate(animate);
    tabbedPanel.setCollapsible(collapsible);
    tabbedPanel.setOpenOnMouseover(openOnMouseover);
    tabbedPanel.setSpinner(spinner);
    tabbedPanel.setCache(cache);
    tabbedPanel.setDisabledTabs(disabledTabs);
    tabbedPanel.setOnAddTopics(onAddTopics);
    tabbedPanel.setOnRemoveTopics(onRemoveTopics);
  }

  public void setSelectedTab(String selectedTab)
  {
    this.selectedTab = selectedTab;
  }

  public void setUseSelectedTabCookie(String useSelectedTabCookie)
  {
    this.useSelectedTabCookie = useSelectedTabCookie;
  }

  public void setOpenOnMouseover(String openOnMouseover)
  {
    this.openOnMouseover = openOnMouseover;
  }

  public void setCollapsible(String collapsible)
  {
    this.collapsible = collapsible;
  }

  public void setAnimate(String animate)
  {
    this.animate = animate;
  }

  public void setSpinner(String spinner)
  {
    this.spinner = spinner;
  }

  public void setCache(String cache)
  {
    this.cache = cache;
  }

  public void setDisabledTabs(String disabledTabs)
  {
    this.disabledTabs = disabledTabs;
  }

  public void setOnAddTopics(String onAddTopics)
  {
    this.onAddTopics = onAddTopics;
  }

  public void setOnRemoveTopics(String onRemoveTopics)
  {
    this.onRemoveTopics = onRemoveTopics;
  }
}
