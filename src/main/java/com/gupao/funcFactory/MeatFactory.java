package com.gupao.funcFactory;

public class MeatFactory implements Factory{


    @Override
    public Food create() {
        return new Meat();
    }
}
