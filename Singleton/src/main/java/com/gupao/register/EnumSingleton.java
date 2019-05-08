package com.gupao.register;

//为什么枚举不需要resolve 方法
public enum  EnumSingleton {
    INSTANCE;


    private  Object  data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
