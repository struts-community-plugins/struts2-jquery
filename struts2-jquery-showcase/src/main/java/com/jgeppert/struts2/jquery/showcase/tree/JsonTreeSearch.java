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
	private static final List<TreeNode> treeSource = new ArrayList<>();
	private List<TreeNode> nodes = new ArrayList<TreeNode>();
	private String id = "";
	private String str;
	Set<String> nodeIds = new HashSet<>();

	static {
		TreeNode treeRoot = new TreeNode("1", "Struts 2", new ArrayList<TreeNode>());
		treeRoot.setHasChildren(Boolean.TRUE);
		treeSource.add(treeRoot);

		TreeNode nodeGeneral = new TreeNode("11", "General", new ArrayList<TreeNode>());
		nodeGeneral.setHasChildren(Boolean.TRUE);
		treeSource.add(nodeGeneral);

		TreeNode nodePlugins = new TreeNode("12", "Plugins", new ArrayList<TreeNode>());
		nodePlugins.setHasChildren(Boolean.TRUE);
		treeSource.add(nodePlugins);

		TreeNode nodeBlogs = new TreeNode("13", "Blogs", new ArrayList<TreeNode>());
		nodeBlogs.setHasChildren(Boolean.TRUE);
		treeSource.add(nodeBlogs);

		TreeNode nodeStruts2 = new TreeNode("111", "Struts 2");
		nodeStruts2.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2);

		TreeNode nodeStruts2FB = new TreeNode("112", "Struts 2 @ Facebook");
		nodeStruts2FB.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2FB);

		TreeNode nodeStruts2TW = new TreeNode("113", "Struts 2 @ Twitter");
		nodeStruts2TW.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2TW);

		TreeNode nodeStruts2Pins = new TreeNode("121", "Struts 2 Plugins");
		nodeStruts2Pins.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2Pins);

		TreeNode nodeStruts2JQ = new TreeNode("122", "Struts 2 JQuery Plugin");
		nodeStruts2JQ.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2JQ);

		TreeNode nodeStruts2BS = new TreeNode("123", "Struts 2 Bootstrap Plugin");
		nodeStruts2BS.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2BS);

		TreeNode nodeStruts2JQNews = new TreeNode("131", "Struts2 JQuery News");
		nodeStruts2JQNews.setHasChildren(Boolean.FALSE);
		treeSource.add(nodeStruts2JQNews);

	}

	@Action(value = "json-tree-search-data", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"nodes" }))
	public String data() {
		for (TreeNode n : treeSource) {
			if ((this.id == null || "".equals(id)) && n.getId().equals("1")) {
				this.nodes.add(n);
				break;
			} else if (this.id != null && !"".equals(id) && n.getId().startsWith(id)
					&& n.getId().length() == (this.id.length() + 1)) {
				this.nodes.add(n);
			}
		}

		return SUCCESS;
	}

	@Override
	@Action(value = "json-tree-search", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"nodeIds" }))
	public String execute() {
		if (this.str != null && !"".equals(str)) {
			for (TreeNode n : treeSource) {
				if (n.getText().toLowerCase().contains(str.toLowerCase())) {
					String nodeId = n.getId();
					do {
						this.nodeIds.add(nodeId);
						nodeId = nodeId.substring(0, nodeId.length() - 1);
					} while (nodeId.length() > 0);
				}
			}
		}

		return SUCCESS;
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Set<String> getNodeIds() {
		return this.nodeIds;
	}

}
