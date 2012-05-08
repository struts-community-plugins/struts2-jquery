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

package com.jgeppert.struts2.jquery.richtext.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.richtext.components.Tinymce;
import com.jgeppert.struts2.jquery.views.jsp.ui.TextareaTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class TinymceTag extends TextareaTag {

	private static final long serialVersionUID = 4218017555155820282L;
	protected String cols;
	protected String readonly;
	protected String rows;
	protected String wrap;
	protected String width;
	protected String height;
	protected String editorLocal;
	protected String editorTheme;
	protected String editorSkin;
	protected String editorSkinVariant;
	protected String toolbarLocation;
	protected String toolbarAlign;
	protected String statusbarLocation;
	protected String plugins;
	protected String toolbarButtonsRow1;
	protected String toolbarButtonsRow2;
	protected String toolbarButtonsRow3;
	protected String toolbarButtonsRow4;
	protected String entityEncoding;
	protected String contentCss;
	protected String pastePlainText;
	protected String removeLinebreaks;
	protected String removeRedundantBrs;
	protected String onSaveTopics;
	protected String onEventTopics;

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Tinymce(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Tinymce editor = (Tinymce) component;
		editor.setCols(cols);
		editor.setRows(rows);
		editor.setReadonly(readonly);
		editor.setWrap(wrap);
		editor.setWidth(width);
		editor.setHeight(height);
		editor.setEditorLocal(editorLocal);
		editor.setEditorSkin(editorSkin);
		editor.setEditorSkinVariant(editorSkinVariant);
		editor.setEditorTheme(editorTheme);
		editor.setToolbarAlign(toolbarAlign);
		editor.setToolbarLocation(toolbarLocation);
		editor.setStatusbarLocation(statusbarLocation);
		editor.setPlugins(plugins);
		editor.setToolbarButtonsRow1(toolbarButtonsRow1);
		editor.setToolbarButtonsRow2(toolbarButtonsRow2);
		editor.setToolbarButtonsRow3(toolbarButtonsRow3);
		editor.setToolbarButtonsRow4(toolbarButtonsRow4);
		editor.setEntityEncoding(entityEncoding);
		editor.setContentCss(contentCss);
		editor.setPastePlainText(pastePlainText);
		editor.setRemoveLinebreaks(removeLinebreaks);
		editor.setRemoveRedundantBrs(removeRedundantBrs);
		editor.setOnSaveTopics(onSaveTopics);
		editor.setOnEventTopics(onEventTopics);
	}

	public void setCols(String cols) {
		this.cols = cols;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setWrap(String wrap) {
		this.wrap = wrap;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setEditorLocal(String editorLocal) {
		this.editorLocal = editorLocal;
	}

	public void setEditorTheme(String editorTheme) {
		this.editorTheme = editorTheme;
	}

	public void setEditorSkin(String editorSkin) {
		this.editorSkin = editorSkin;
	}

	public void setEditorSkinVariant(String editorSkinVariant) {
		this.editorSkinVariant = editorSkinVariant;
	}

	public void setToolbarLocation(String toolbarLocation) {
		this.toolbarLocation = toolbarLocation;
	}

	public void setToolbarAlign(String toolbarAlign) {
		this.toolbarAlign = toolbarAlign;
	}

	public void setStatusbarLocation(String statusbarLocation) {
		this.statusbarLocation = statusbarLocation;
	}

	public void setPlugins(String plugins) {
		this.plugins = plugins;
	}

	public void setToolbarButtonsRow1(String toolbarButtonsRow1) {
		this.toolbarButtonsRow1 = toolbarButtonsRow1;
	}

	public void setToolbarButtonsRow2(String toolbarButtonsRow2) {
		this.toolbarButtonsRow2 = toolbarButtonsRow2;
	}

	public void setToolbarButtonsRow3(String toolbarButtonsRow3) {
		this.toolbarButtonsRow3 = toolbarButtonsRow3;
	}

	public void setToolbarButtonsRow4(String toolbarButtonsRow4) {
		this.toolbarButtonsRow4 = toolbarButtonsRow4;
	}

	public void setEntityEncoding(String entityEncoding) {
		this.entityEncoding = entityEncoding;
	}

	public void setContentCss(String contentCss) {
		this.contentCss = contentCss;
	}

	public void setPastePlainText(String pastePlainText) {
		this.pastePlainText = pastePlainText;
	}

	public void setRemoveLinebreaks(String removeLinebreaks) {
		this.removeLinebreaks = removeLinebreaks;
	}

	public void setRemoveRedundantBrs(String removeRedundantBrs) {
		this.removeRedundantBrs = removeRedundantBrs;
	}

	public void setOnSaveTopics(String onSaveTopics) {
		this.onSaveTopics = onSaveTopics;
	}

	public void setOnEventTopics(String onEventTopics) {
		this.onEventTopics = onEventTopics;
	}

}
