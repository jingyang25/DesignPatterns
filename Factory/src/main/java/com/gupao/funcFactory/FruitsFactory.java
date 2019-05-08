package com.gupao.funcFactory;

public class FruitsFactory implements Factory {

    @Override
    public Food create() {
        return  new Fruits();
    }
}
