package com.jgeppert.jquery.actions.accordion;

import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class AccordionAction extends ActionSupport {
    @Getter
    private Map<String, String> accordionItems;
    
    @Override
    public String execute() {
        accordionItems = new HashMap<>();

        accordionItems.put("item 1", "Content for accordion item 1");
        accordionItems.put("item 2", "Content for accordion item 2");

        return SUCCESS;
    }
}

