package com.gupao.seriable;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {

    private final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){

    }


    public static  SeriableSingleton getInstance(){

        return INSTANCE;

    }


    // 为什么要加上这个方法
    //覆盖了反序列化的对象


    private Object readResolve(){

        return INSTANCE;
    }
}
