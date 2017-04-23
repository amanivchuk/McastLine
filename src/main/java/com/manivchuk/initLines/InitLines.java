package com.manivchuk.initLines;

import com.manivchuk.CheckSocketEnable;
import com.manivchuk.aop.UsesApplicationContext;
import com.manivchuk.beans.LineConfig;

import java.util.List;

/**
 * Created by Lenovo on 14.03.2017.
 */
public class InitLines {

    public static void initLines(){

        List<LineConfig> lineConfigsList = UsesApplicationContext.getApplicationContext().getAllLineConfig();
        System.out.println(lineConfigsList.size());

        for(int i = 0; i < lineConfigsList.size(); i++){
            LineConfig lineConfig = lineConfigsList.get(i);
            Thread mssrOsn = new Thread(new CheckSocketEnable(lineConfig));
            mssrOsn.start();

        }
    }

    public static void main(String[] args) {
        InitLines.initLines();
    }
}
