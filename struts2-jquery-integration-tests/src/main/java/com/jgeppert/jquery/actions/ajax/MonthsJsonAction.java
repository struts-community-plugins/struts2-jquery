package com.jgeppert.jquery.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
@Actions({
  @Action(value="/ajax/months", results = {@Result(type="json", name="success", params= {"root", "months"})}),
  @Action(value="/ajax/monthsinobject", results = {@Result(type="json", name="success")})
})
public class MonthsJsonAction extends ActionSupport {
    @Getter
    private List<String> months;
    @Getter
    private Map<Integer, String> monthsMap;
    @Getter
    private List<MonthObject> monthObjects;
    @Setter
    private String term = "";

    @Override
    public String execute() {
        String[] tempMonths = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        months = new ArrayList<>();
        monthsMap = new HashMap<>();
        monthObjects = new ArrayList<>();

        for(int index = 0; index < tempMonths.length; index++) {
            final String month = tempMonths[index];

            if (month.toLowerCase().contains(term.toLowerCase())) {
                months.add(month);
                monthsMap.put(index + 1, month);
                monthObjects.add(new MonthObject(index + 1, month));
            }
        }

        return SUCCESS;
    }

    @AllArgsConstructor
    @Data
    public static class MonthObject {
        private int number;
        private String month;
    }
}

