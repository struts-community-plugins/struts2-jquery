/**
 *
 */
package com.jgeppert.struts2.jquery.datatables.model;

import java.io.Serializable;

/**
 *
 */
public class DatatablesOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1774157331741146926L;

    public static final String COLUMN = "column";
    public static final String DIR = "dir";

    private int column;
    private String dir;

    /**
     *
     */
    public DatatablesOrder() {

    }

    /**
     * @param column
     * @param dir
     */
    public DatatablesOrder(int column, String dir) {
        super();
        this.column = column;
        this.dir = dir;
    }

    public int getColumn() {
        return this.column;
    }

    public String getDir() {
        return this.dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
