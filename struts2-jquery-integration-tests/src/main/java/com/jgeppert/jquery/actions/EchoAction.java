package com.jgeppert.jquery.actions;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EchoAction extends ActionSupport {
    private String echo;
    private boolean escape = true;
}
