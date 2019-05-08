package com.gupao.funcFactory;

public class VegetablesFactroy implements Factory {

    @Override
    public Food create() {
        return  new Vegetables();
    }
}
