package com.manivchuk.model;

import com.manivchuk.MSender;
import com.manivchuk.initLines.InitLines;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lenovo on 11.03.2017.
 */
public class McastServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //-------MSSR osn------------
//        LineConfig mssr_osn = new LineConfig("MSSR osn","10.64.236.113",22, "239.192.0.118",4004);
//        Thread mssrOsn = new Thread(new CheckSocketEnable(mssr_osn));
//        mssrOsn.start();

        Thread MSSROsn = new Thread(new MSender("224.1.1.22",8855, "MSSR osn send..."));
        MSSROsn.start();

        //-------MSSR rez----------
//        LineConfig mssr_rez = new LineConfig("MSSR rez","216.58.209.206",80, "224.1.1.25",8888);
//        Thread mssrRez = new Thread(new CheckSocketEnable(mssr_rez));
//        mssrRez.start();

        Thread MSSRRez = new Thread(new MSender("224.1.1.25",8888, "MSSR rezerv send..."));
        MSSRRez.start();

        InitLines.initLines();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

}
