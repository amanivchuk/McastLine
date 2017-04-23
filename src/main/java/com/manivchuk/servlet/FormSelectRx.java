package com.manivchuk.servlet;

import com.manivchuk.aop.UsesApplicationContext;
import com.manivchuk.beans.LineConfig;
import com.manivchuk.db.MySqlDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lenovo on 16.03.2017.
 */
public class FormSelectRx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("You entered:");
        String hostname = req.getParameter("hostname");
        String ipsocket = req.getParameter("ipsocket");
        int portsocket = Integer.parseInt(req.getParameter("portsocket"));
        String ipmcast = req.getParameter("ipmcast");
        int portmcast = Integer.parseInt(req.getParameter("portmcast"));

        LineConfig lineConfig = new LineConfig(hostname,ipsocket,portsocket,ipmcast,portmcast);
        UsesApplicationContext.getApplicationContext().createLineConfig(lineConfig);

    }
}
