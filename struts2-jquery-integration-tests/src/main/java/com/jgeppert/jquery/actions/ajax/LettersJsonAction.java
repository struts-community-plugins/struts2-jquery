package com.jgeppert.jquery.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
@Action(value="/ajax/letters", results = {@Result(type="json", name="success", params= {"root", "letters"})})
public class LettersJsonAction extends ActionSupport {
    private static final char[] LETTERS;
    
    static {
        LETTERS = new char[26];
	for (int i = 0; i < 26; i++) {
            LETTERS[i] = (char)('a' + (char)i);
	}
    }

    public char[] getLetters() {
        return LETTERS;
    }
}

