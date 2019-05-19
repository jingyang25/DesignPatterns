package com.gupao.dynamicproxy.jdk;

import com.gupao.Peron;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//必须要实现invocationHandler接口
public class Meipo implements InvocationHandler {

    //持有对象的引用
    private Peron target;

    public Object getInstance(Peron peron) throws Exception{

        this.target = peron;

        Class<?> clazz = target.getClass();

        System.out.println(Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this));

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return  method.invoke(this.target,args);

    }
}
