package com.jgeppert.struts2.jquery.showcase.tree;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.util.LinkedList;

@Action(value = "/tree", results = {@Result(location = "tree.jsp", name = "success")})
public class Tree extends ActionSupport {
    private static final long serialVersionUID = 6518221459701336965L;

    private TreeNode nodes = new TreeNode();

    public String execute() throws Exception {
        TreeNode nodeA = new TreeNode();
        nodeA.setId("A");
        nodeA.setText("Node A");
        nodeA.getState().setOpened(true);

        TreeNode nodeAA = new TreeNode();
        nodeAA.setId("AA");
        nodeAA.setText("Node AA");

        TreeNode nodeAB = new TreeNode();
        nodeAB.setId("AB");
        nodeAB.setText("Node AB");
        nodeAB.getState().setDisabled(true);

        nodeA.setChildren(new LinkedList<TreeNode>());
        nodeA.getChildrens().add(nodeAA);
        nodeA.getChildrens().add(nodeAB);

        TreeNode nodeB = new TreeNode();
        nodeB.setId("B");
        nodeB.setText("Node B");

        TreeNode nodeC = new TreeNode();
        nodeC.setId("C");
        nodeC.setText("Node C");

        nodes.setId("rootNode");
        nodes.setText("Root Node");
        nodes.getState().setOpened(true);
        nodes.setChildren(new LinkedList<TreeNode>());
        nodes.getChildrens().add(nodeA);
        nodes.getChildrens().add(nodeB);
        nodes.getChildrens().add(nodeC);
        return SUCCESS;
    }

    public TreeNode getNodes() {
        return nodes;
    }

}
