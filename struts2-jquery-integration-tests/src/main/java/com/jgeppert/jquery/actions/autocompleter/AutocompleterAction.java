package com.jgeppert.jquery.actions.autocompleter;

import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
public class AutocompleterAction extends ActionSupport {
    @Getter
    private List<String> monthsList;

    @Setter
    private boolean addError;

    @Getter
    @Setter
    private boolean selectBox;

    @Override
    public String execute() {
        monthsList = Arrays.asList(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
        if (this.addError){
            this.addFieldError("month","Some error message");
        }
        return SUCCESS;
    }
}

