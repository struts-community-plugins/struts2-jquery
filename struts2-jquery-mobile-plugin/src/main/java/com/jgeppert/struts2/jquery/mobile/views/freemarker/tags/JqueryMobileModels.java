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

package com.jgeppert.struts2.jquery.mobile.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class JqueryMobileModels {
	protected HeadModel head;
	protected CheckboxListModel checkboxList;
	protected CheckboxModel checkbox;
	protected DivModel div;
	protected ListModel list;
	protected ListItemModel listItem;
	protected AnchorModel anchor;
	protected PasswordModel password;
	protected TextareaModel textarea;
	protected TextfieldModel textfield;
	protected SearchfieldModel searchfield;
	protected SelectModel select;
    protected SliderModel slider;


	private ValueStack stack;
	private HttpServletRequest req;
	private HttpServletResponse res;

	public JqueryMobileModels(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		this.stack = stack;
		this.req = req;
		this.res = res;
	}

	public HeadModel getHead() {
		if (head == null) {
			head = new HeadModel(stack, req, res);
		}

		return head;
	}

	public DivModel getDiv() {
		if (div == null) {
			div = new DivModel(stack, req, res);
		}

		return div;
	}

	public AnchorModel getAnchor() {
		if (anchor == null) {
			anchor = new AnchorModel(stack, req, res);
		}

		return anchor;
	}

	public CheckboxListModel getCheckboxList() {
		if (checkboxList == null) {
			checkboxList = new CheckboxListModel(stack, req, res);
		}

		return checkboxList;
	}

	public CheckboxModel getCheckbox() {
		if (checkbox == null) {
			checkbox = new CheckboxModel(stack, req, res);
		}

		return checkbox;
	}

	public PasswordModel getPassword() {
		if (password == null) {
			password = new PasswordModel(stack, req, res);
		}

		return password;
	}

	public TextareaModel getTextarea() {
		if (textarea == null) {
			textarea = new TextareaModel(stack, req, res);
		}

		return textarea;
	}

	public TextfieldModel getTextfield() {
		if (textfield == null) {
			textfield = new TextfieldModel(stack, req, res);
		}

		return textfield;
	}

	public SearchfieldModel getSearchfield() {
		if (searchfield == null) {
			searchfield = new SearchfieldModel(stack, req, res);
		}

		return searchfield;
	}

	public ListModel getList() {
		if (list == null) {
			list = new ListModel(stack, req, res);
		}

		return list;
	}

	public ListItemModel getListItem() {
		if (listItem == null) {
			listItem = new ListItemModel(stack, req, res);
		}

		return listItem;
	}

	public SelectModel getSelect() {
		if (select == null) {
			select = new SelectModel(stack, req, res);
		}

		return select;
	}

    public SliderModel getSlider() {
        if (slider == null) {
            slider = new SliderModel(stack, req, res);
        }

        return slider;
    }

}
