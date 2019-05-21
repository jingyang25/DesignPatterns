package com.gupao.mvc;

import com.gupao.mvc.controllers.MemberController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 相当于项目经理的角色
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<Handler>();


    public void init() {

        try {
            Class<?> memberControllerClass = MemberController.class;

            handlerMapping.add(new Handler().setController(memberControllerClass.newInstance()).setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class})).setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;

            return this;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }


    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {

        String uri = request.getRequestURI();

        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        Object object = null;

        try {
            object = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    protected void service(HttpServletRequest request,HttpServletResponse response){

        doDispatch(request,response);
    }
}
