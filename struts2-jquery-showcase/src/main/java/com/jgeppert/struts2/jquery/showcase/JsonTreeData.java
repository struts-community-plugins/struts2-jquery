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

package com.jgeppert.struts2.jquery.showcase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "showcase")
public class JsonTreeData extends ActionSupport {

	private static final long serialVersionUID = -2886756982077980790L;
	private List<TreeNode> nodes = new ArrayList<TreeNode>();
	private String id = "";

	@Actions( { @Action(value = "/json-tree-data", results = { @Result(name = "success", type = "json", params = {
			"root", "nodes" }) }) })
	public String execute() {

		TreeNode nodeA = new TreeNode();
		nodeA.setId("A" + id);
		nodeA.setTitle("Node A" + id);
		nodeA.setState(TreeNode.NODE_STATE_CLOSED);

		TreeNode nodeB = new TreeNode();
		nodeB.setId("B" + id);
		nodeB.setState(TreeNode.NODE_STATE_OPEN);
		nodeB.setIcon("ui-icon-suitcase");
		nodeB.setTitle("Node B" + id);
		nodeB.setChildren(new LinkedList<TreeNode>());
		
		TreeNode nodeB1 = new TreeNode();
		nodeB1.setId("B1" + id);
		nodeB1.setState(TreeNode.NODE_STATE_LEAF);
		nodeB1.setIcon("ui-icon-document");
		nodeB1.setTitle("Node B1" + id);
		nodeB.getChildren().add(nodeB1);
		
		TreeNode nodeB2 = new TreeNode();
		nodeB2.setId("B2" + id);
		nodeB2.setState(TreeNode.NODE_STATE_LEAF);
		nodeB2.setIcon("ui-icon-image");
		nodeB2.setTitle("Node B2" + id);
		nodeB.getChildren().add(nodeB2);

		TreeNode nodeC = new TreeNode();
		nodeC.setId("C" + id);
		nodeC.setState(TreeNode.NODE_STATE_CLOSED);
		nodeC.setTitle("Node C" + id);

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
}
