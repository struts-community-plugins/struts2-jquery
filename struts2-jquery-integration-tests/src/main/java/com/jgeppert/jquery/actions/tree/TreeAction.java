package com.jgeppert.jquery.actions.tree;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
public class TreeAction extends ActionSupport {
    @Getter
    private TreeNode treeNode;
    
    @Override
    public String execute() {
        treeNode = new TreeNode("ROOT", "rootNode");
        TreeNode nodeA = new TreeNode("A", "node A");
        TreeNode nodeAA = new TreeNode("AA", "node AA");
        TreeNode nodeAB = new TreeNode("AB", "node AB");
        nodeA.addChild(nodeAA);
        nodeA.addChild(nodeAB);
        TreeNode nodeB = new TreeNode("B", "node B");
        TreeNode nodeBA = new TreeNode("BA", "node BA");
        TreeNode nodeBB = new TreeNode("BB", "node BB");
        nodeB.addChild(nodeBA);
        nodeB.addChild(nodeBB);
        treeNode.addChild(nodeA);
        treeNode.addChild(nodeB);

        return SUCCESS;
    }
}

