package com.gupao.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

public interface GPinvocationHandler {

    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable;


}
