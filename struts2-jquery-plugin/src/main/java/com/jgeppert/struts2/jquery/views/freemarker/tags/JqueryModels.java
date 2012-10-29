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

package com.jgeppert.struts2.jquery.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
public class JqueryModels {
	protected DatePickerModel datePicker;
	protected TabbedPanelModel tabbedPanel;
	protected DivModel div;
	protected DialogModel dialog;
	protected AccordionModel accordion;
	protected AccordionItemModel accordionItem;
	protected TabModel tab;
	protected AnchorModel a;
	protected SubmitModel submit;
	protected HeadModel head;
	protected ProgressbarModel progessbar;
	protected SliderModel slider;
	protected SpinnerModel spinner;
	protected TextareaModel textarea;
	protected TextfieldModel textfield;
	protected SelectModel select;
	protected AutocompleterModel autocompleter;
	protected RadioModel radio;
	protected CheckboxListModel checkboxlist;
	protected MenuModel menu;
	protected MenuItemModel menuItem;

	private ValueStack stack;
	private HttpServletRequest req;
	private HttpServletResponse res;

	public JqueryModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		this.stack = stack;
		this.req = req;
		this.res = res;
	}

	public MenuModel getMenu() {
		if (menu == null) {
			menu = new MenuModel(stack, req, res);
		}

		return menu;
	}

	public MenuItemModel getMenuItem() {
		if (menuItem == null) {
			menuItem = new MenuItemModel(stack, req, res);
		}

		return menuItem;
	}

	public AccordionItemModel getAccordionItem() {
		if (accordionItem == null) {
			accordionItem = new AccordionItemModel(stack, req, res);
		}

		return accordionItem;
	}

	public AutocompleterModel getAutocompleter() {
		if (autocompleter == null) {
			autocompleter = new AutocompleterModel(stack, req, res);
		}

		return autocompleter;
	}

	public HeadModel getHead() {
		if (head == null) {
			head = new HeadModel(stack, req, res);
		}

		return head;
	}

	public DatePickerModel getDatepicker() {
		if (datePicker == null) {
			datePicker = new DatePickerModel(stack, req, res);
		}

		return datePicker;
	}

	public TabbedPanelModel getTabbedpanel() {
		if (tabbedPanel == null) {
			tabbedPanel = new TabbedPanelModel(stack, req, res);
		}

		return tabbedPanel;
	}

	public TabModel getTab() {
		if (tab == null) {
			tab = new TabModel(stack, req, res);
		}

		return tab;
	}

	public DivModel getDiv() {
		if (div == null) {
			div = new DivModel(stack, req, res);
		}

		return div;
	}

	public AnchorModel getA() {
		if (a == null) {
			a = new AnchorModel(stack, req, res);
		}

		return a;
	}

	public SubmitModel getSubmit() {
		if (submit == null) {
			submit = new SubmitModel(stack, req, res);
		}

		return submit;
	}

	public DialogModel getDialog() {
		if (dialog == null) {
			dialog = new DialogModel(stack, req, res);
		}

		return dialog;
	}

	public AccordionModel getAccordion() {
		if (accordion == null) {
			accordion = new AccordionModel(stack, req, res);
		}

		return accordion;
	}

	public ProgressbarModel getProgressbar() {
		if (progessbar == null) {
			progessbar = new ProgressbarModel(stack, req, res);
		}

		return progessbar;
	}

	public SliderModel getSlider() {
		if (slider == null) {
			slider = new SliderModel(stack, req, res);
		}

		return slider;
	}

	public SpinnerModel getSpinner() {
		if (spinner == null) {
			spinner = new SpinnerModel(stack, req, res);
		}

		return spinner;
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

	public SelectModel getSelect() {
		if (select == null) {
			select = new SelectModel(stack, req, res);
		}

		return select;
	}

	public RadioModel getRadio() {
		if (radio == null) {
			radio = new RadioModel(stack, req, res);
		}

		return radio;
	}

	public CheckboxListModel getCheckboxlist() {
		if (checkboxlist == null) {
			checkboxlist = new CheckboxListModel(stack, req, res);
		}

		return checkboxlist;
	}
}
