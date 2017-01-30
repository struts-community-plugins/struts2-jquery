package com.jgeppert.jquery.actions.ajax;

import com.jgeppert.jquery.actions.tree.TreeAction;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
@Actions({
  @Action(value="/ajax/tree-data", results = {@Result(type="json", name="success", params= {"root", "treeNode"})}),
})
public class TreeDataAction extends TreeAction {
}

