package com.jgeppert.struts2.jquery.showcase;

import java.util.LinkedList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;

public class Tree extends ActionSupport{
	private static final long serialVersionUID = 6518221459701336965L;
	
	private TreeNode nodes = new TreeNode();
	
	@Action(value = "/tree", results = { @Result(location = "tree.jsp", name = "success") })
	public String execute() throws Exception {
		TreeNode nodeA = new TreeNode();
		nodeA.setId("A");
		nodeA.setTitle("Node A");
		nodeA.setState(TreeNode.NODE_STATE_OPEN);
	
		TreeNode nodeAA = new TreeNode();
		nodeAA.setId("AA");
		nodeAA.setTitle("Node AA");
		
		TreeNode nodeAB = new TreeNode();
		nodeAB.setId("AB");
		nodeAB.setTitle("Node AB");
		
		nodeA.setChildren(new LinkedList<TreeNode>());
		nodeA.getChildren().add(nodeAA);
		nodeA.getChildren().add(nodeAB);
		
		TreeNode nodeB = new TreeNode();
		nodeB.setId("B");
		nodeB.setTitle("Node B");
	
		TreeNode nodeC = new TreeNode();
		nodeC.setId("C");
		nodeC.setTitle("Node C");
	
		nodes.setId("rootNode");
		nodes.setTitle("Root Node");
		nodes.setState(TreeNode.NODE_STATE_OPEN);
		nodes.setChildren(new LinkedList<TreeNode>());
		nodes.getChildren().add(nodeA);
		nodes.getChildren().add(nodeB);
		nodes.getChildren().add(nodeC);
		return SUCCESS;
	}

	public TreeNode getNodes() {
		return nodes;
	}

}
