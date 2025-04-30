package com.jgeppert.jquery.actions.accordion;

import lombok.Data;
import lombok.Getter;
import org.apache.struts2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccordionAction extends ActionSupport {
    @Getter
    private Map<String, String> accordionItems;
    @Getter
    private List<Object> accordionItemObjects;

    @Override
    public String execute() {
        accordionItems = new HashMap<>();
        accordionItemObjects = new ArrayList<>();

        accordionItems.put("item 1", "Content for accordion item 1");
        accordionItems.put("item 2", "Content for accordion item 2");
        accordionItemObjects.add(new AccordionItem("item 1", "Content for accordion item 1"));
        accordionItemObjects.add(new AccordionItem("item 2", "Content for accordion item 2"));

        return SUCCESS;
    }

    @Data
    private static class AccordionItem {

        public AccordionItem(String title, String content) {
            this.title = title;
            this.content = content;
        }

        private String title;
        private String content;
    }
}

