package com.jgeppert.struts2.jquery.tree.result;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TreeNode {

	public static final String NODE_STATE_CLOSED = "closed";
	public static final String NODE_STATE_LEAF = "leaf";
	public static final String NODE_STATE_OPEN = "open";

	private Map<String, Object> attr;
	private Collection<TreeNode> children;
	private Map<String, Object> data;
	private String icon;
	private String id;
	private String state = TreeNode.NODE_STATE_CLOSED;
	private String title;

	public TreeNode() {
		super();
	}

	public TreeNode(String title) {
		super();
		this.title = title;
	}
	
	public TreeNode(String title, Collection<TreeNode> children) {
		super();
		this.title = title;
		this.children = children;
	}

	public TreeNode(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public TreeNode(String id, String title, Collection<TreeNode> children) {
		super();
		this.id = id;
		this.title = title;
		this.children = children;
	}

	public Map<String, Object> getAttr() {
		return attr;
	}

	public Collection<TreeNode> getChildren() {
		return children;
	}

	public Map<String, Object> getData() {
	    return data;
	}

	/**
	 * Get the Tree Node Title
	 */
//	public String getDatay() {
//		return title;
//	}

	public String getIcon() {
		return icon;
	}

	public String getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getTitle() {
		return title;
	}

	public void setAttr(Map<String, Object> attr) {
		this.attr = attr;
	}

	/**
	 * Set the Tree Node Childrens
	 * 
	 * @param children
	 */
	public void setChildren(Collection<TreeNode> children) {
		this.children = children;
	}

	public void setData(Map<String, Object> data) {
	    this.data = data;
	}

	/**
	 * Set the Tree Node Icon
	 * 
	 * @param icon
	 */
	public void setIcon(String icon) {
		if (this.data == null) {
		    data = new HashMap<String, Object>();
		}

		if (this.data.containsKey("icon")) {
			this.data.remove("icon");
		}
		this.data.put("icon", icon);
		this.icon = icon;
	}

	/**
	 * Set the Tree Node Id
	 * 
	 * @param icon
	 */
	public void setId(String id) {

		this.id = id;
		if (this.attr == null) {
			attr = new HashMap<String, Object>();
		}

		if (this.attr.containsKey("id")) {
			this.attr.remove("id");
		}
		this.attr.put("id", id);
	}

	/**
	 * Set the Tree Node State open, closed or leaf
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Set the Tree Node Title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		if (this.data == null) {
		    data = new HashMap<String, Object>();
		}

		if (this.data.containsKey("title")) {
			this.data.remove("title");
		}
		this.data.put("title", title);
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeNode [id=").append(id).append(", title=").append(
				title).append(", icon=").append(icon).append(", state=")
				.append(state).append(", attr=").append(attr).append(
						", children=").append(children).append("]");
		return builder.toString();
	}
	
	
}
