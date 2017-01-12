package com.jgeppert.jquery.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
@Actions({
  @Action(value="/ajax/months", results = {@Result(type="json", name="success", params= {"root", "months"})}),
})
public class MonthsJsonAction extends ActionSupport {
    @Getter
    private List<String> months;
    @Setter
    private String term = "";

    @Override
    public String execute() {
        String[] tempMonths = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        months = new ArrayList<>();

        for(final String month : tempMonths) {
            if (month.toLowerCase().contains(term.toLowerCase())) {
                months.add(month);
            }
        }

        return SUCCESS;
    }
}

