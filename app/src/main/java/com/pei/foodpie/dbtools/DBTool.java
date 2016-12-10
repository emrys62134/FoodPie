package com.pei.foodpie.dbtools;

/**
 * Created by dllo on 16/12/10.
 */
public class DBTool {

    private static DBTool ourInstance = new DBTool();


    public static DBTool getInstance() {
        return ourInstance;
    }

    private DBTool() {
    }
}
