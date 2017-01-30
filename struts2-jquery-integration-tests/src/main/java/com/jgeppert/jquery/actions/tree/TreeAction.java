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
        nodeA.getChildrens().add(nodeAA);
        nodeA.getChildrens().add(nodeAB);
        TreeNode nodeB = new TreeNode("B", "node B");
        TreeNode nodeBA = new TreeNode("BA", "node BA");
        TreeNode nodeBB = new TreeNode("BB", "node BB");
        nodeB.getChildrens().add(nodeBA);
        nodeB.getChildrens().add(nodeBB);
        treeNode.getChildrens().add(nodeA);
        treeNode.getChildrens().add(nodeB);

        return SUCCESS;
    }
}

