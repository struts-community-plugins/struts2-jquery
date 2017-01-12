package com.jgeppert.jquery.actions.autocompleter;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.text.DateFormatSymbols;

import lombok.Getter;
public class AutocompleterAction extends ActionSupport {
    @Getter
    private List<String> monthsList;
    
    @Override
    public String execute() {
        monthsList = Arrays.asList((new DateFormatSymbols(Locale.ENGLISH)).getMonths());
        
        return SUCCESS;
    }
}

