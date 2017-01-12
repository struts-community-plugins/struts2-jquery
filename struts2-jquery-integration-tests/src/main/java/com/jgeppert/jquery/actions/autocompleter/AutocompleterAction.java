package com.jgeppert.jquery.actions.autocompleter;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
public class AutocompleterAction extends ActionSupport {
    @Getter
    private List<String> monthsList;
    
    @Override
    public String execute() {
        monthsList = Arrays.asList(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
        
        return SUCCESS;
    }
}

