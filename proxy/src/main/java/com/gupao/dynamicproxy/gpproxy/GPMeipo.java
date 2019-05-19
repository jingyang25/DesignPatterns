package com.gupao.dynamicproxy.gpproxy;


import java.lang.reflect.Method;

public class GPMeipo implements GPinvocationHandler{

        private Object target;

        public Object getInstance(Object target) throws Exception{

            this.target = target;
            Class<?> clazz = target.getClass();

            System.out.println(GPProxy.newProxyInstance(new GpClassLoader(),clazz.getInterfaces(),this));

            return (Object) GPProxy.newProxyInstance(new GpClassLoader(),clazz.getInterfaces(),this);


        }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            before();


       Object obj = method.invoke(this.target,args);

       after();

        return obj;
    }

    public void before(){

            System.out.println("我是媒婆，我要给你找对象");
    }

    public void after(){
            System.out.println("OK的话，准备办事");

    }
}
