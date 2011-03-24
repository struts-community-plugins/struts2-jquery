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

package com.jgeppert.struts2.jquery.tree.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class JqueryTreeModels {
  protected TreeModel        tree;
  protected TreeItemModel    treeItem;

  private ValueStack          stack;
  private HttpServletRequest  req;
  private HttpServletResponse res;

  public JqueryTreeModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    this.stack = stack;
    this.req = req;
    this.res = res;
  }

  public TreeModel getTree()
  {
    if (tree == null)
    {
      tree = new TreeModel(stack, req, res);
    }

    return tree;
  }

  public TreeItemModel getTreeItem()
  {
    if (treeItem == null)
    {
      treeItem = new TreeItemModel(stack, req, res);
    }
    return treeItem;
  }
}
