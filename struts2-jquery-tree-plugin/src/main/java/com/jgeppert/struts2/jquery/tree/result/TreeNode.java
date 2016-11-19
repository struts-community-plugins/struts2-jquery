package com.jgeppert.struts2.jquery.tree.result;

import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

public class TreeNode implements Comparable<TreeNode> {

    private Map<String, Object> li_attr;
    private Map<String, Object> a_attr;
    private Collection<TreeNode> childrens = new TreeSet<>();
    private String icon;
    private String id;
    private TreeNodeState state = new TreeNodeState();
    private String text;
    private String type;
    private Boolean hasChildren = false;

    public TreeNode() {
        super();
    }

    public TreeNode(String text) {
        super();
        this.text = text;
    }

    public TreeNode(String text, Collection<TreeNode> children) {
        super();
        setText(text);
        setChildren(children);
    }

    public TreeNode(String id, String text) {
        super();
        setId(id);
        setText(text);
    }

    public TreeNode(String id, String text, Collection<TreeNode> children) {
        super();
        setId(id);
        setText(text);
        setChildren(children);
    }

    public Map<String, Object> getA_attr() {
        return a_attr;
    }

    public Map<String, Object> getLi_attr() {
        return li_attr;
    }

    public Object getChildren() {
        if (childrens == null || childrens.isEmpty()) {
            return hasChildren;
        }
        return childrens;
    }

    public Collection<TreeNode> getChildrens() {
        return childrens;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public TreeNodeState getState() {
        return state;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setLi_attr(Map<String, Object> attr) {
        this.li_attr = attr;
    }

    public void setA_attr(Map<String, Object> attr) {
        this.a_attr = attr;
    }

    /**
     * @param childrens the Tree Node childrens
     */
    public void setChildren(Collection<TreeNode> childrens) {
        this.childrens = childrens;
    }

    /**
     * @param icon the Tree Node Icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @param id the Tree Node Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param state the Tree Node State opened, disabled or selected
     */
    public void setState(TreeNodeState state) {
        this.state = state;
    }

    /**
     * @param text the Tree Node Title
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param type the Tree Node Type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TreeNode [id=").append(id).append(", text=").append(
                text).append(", icon=").append(icon).append(", state=")
                .append(state).append(", li_attr=").append(li_attr).append(", a_attr=").append(a_attr).append(
                ", childrens=").append(childrens).append("]");
        return builder.toString();
    }


    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public int compareTo(TreeNode other) {
        return text.compareTo(other.getText());
    }
}
