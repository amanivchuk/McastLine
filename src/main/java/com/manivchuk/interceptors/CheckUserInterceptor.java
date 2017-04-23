package com.manivchuk.interceptors;

import com.manivchuk.objects.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lenovo on 29.03.2017.
 */
public class CheckUserInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(request.getRequestURI().contains("check-user")){

            User user = (User) modelAndView.getModel().get("user");
            if(user == null || !user.getName().equals("admin")){
                response.sendRedirect(request.getContextPath() + "/failed");
            }

//            if(user == null || !user.isAdmin()){
//                response.sendRedirect(request.getContextPath() + "/failed");
//            }
        }
    }
}
