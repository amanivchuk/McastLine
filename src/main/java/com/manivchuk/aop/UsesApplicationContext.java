package com.manivchuk.aop;

import com.manivchuk.db.MySqlDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lenovo on 27.03.2017.
 */
public class UsesApplicationContext {

    public static MySqlDAO getApplicationContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MySqlDAO sqlDAO = (MySqlDAO) context.getBean("mySqlDAO");

        return sqlDAO;
    }
}
