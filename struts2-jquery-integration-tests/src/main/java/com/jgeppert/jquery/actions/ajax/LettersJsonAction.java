package com.jgeppert.jquery.actions.ajax;

import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
@Actions({
  @Action(value="/ajax/letters", results = {@Result(type="json", name="success", params= {"root", "letters"})}),
  @Action(value="/ajax/lettersinobject", results = {@Result(type="json", name="success")})
})
public class LettersJsonAction extends ActionSupport {
    private static final char[] LETTERS;
    private static final Map<Integer, String> LETTERS_MAP;
    
    static {
        LETTERS = new char[26];
        LETTERS_MAP = new HashMap(26);
	for (int i = 0; i < 26; i++) {
            char letter = (char)('a' + (char)i);
            LETTERS[i] = letter;
            LETTERS_MAP.put((int) letter, String.valueOf(letter));
	}
    }

    public char[] getLetters() {
        return LETTERS;
    }

    public Map<Integer, String> getLettersMap() {
        return LETTERS_MAP;
    }
}

