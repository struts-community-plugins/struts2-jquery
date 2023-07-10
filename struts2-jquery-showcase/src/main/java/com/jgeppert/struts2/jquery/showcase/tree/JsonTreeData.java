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

package com.jgeppert.struts2.jquery.showcase.tree;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.action.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Actions({@Action(value = "/json-tree-data", results = {@Result(name = "success", type = "json", params = {
        "root", "nodes"})})})
public class JsonTreeData extends ActionSupport implements ServletContextAware {

    private static final long serialVersionUID = -2886756982077980790L;
    private List<TreeNode> nodes = new ArrayList<TreeNode>();
    private String id = "";
    private ServletContext servletContext;

    public String execute() {

        TreeNode nodeA = new TreeNode();
        nodeA.setId("A" + id);
        nodeA.getState().setOpened(false);
        nodeA.setHasChildren(true);
        nodeA.setText("Node A" + id);
        nodeA.setIcon(servletContext.getContextPath() + "/images/root.png");

        TreeNode nodeB = new TreeNode();
        nodeB.setId("B" + id);
        nodeB.getState().setOpened(true);
        nodeB.setIcon(servletContext.getContextPath() + "/images/folder.png");
        nodeB.setText("Node B" + id);

        TreeNode nodeB1 = new TreeNode();
        nodeB1.setId("B1" + id);
        nodeB1.setIcon(servletContext.getContextPath() + "/images/file.png");
        nodeB1.setText("Node B1" + id);
        nodeB.getChildrens().add(nodeB1);

        TreeNode nodeB2 = new TreeNode();
        nodeB2.setId("B2" + id);
        nodeB2.getState().setDisabled(true);
        nodeB2.setIcon(servletContext.getContextPath() + "/images/file.png");
        nodeB2.setText("Node B2" + id);
        nodeB.getChildrens().add(nodeB2);

        TreeNode nodeC = new TreeNode();
        nodeC.setId("C" + id);
        nodeC.setText("Node C" + id);
        nodeC.setIcon(servletContext.getContextPath() + "/images/folder.png");
        nodeC.setHasChildren(true);

        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);

        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void withServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
