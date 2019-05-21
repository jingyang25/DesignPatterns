package com.gupao.battercake.v2;

public class SausageDecorator extends BattercakeDecorator{

    public SausageDecorator(Battercake battercake) {

        super(battercake);
    }

    @Override
    protected void doSomething() {
    }

    protected String getMsg(){
        return super.getMsg()+"1根香肠";
    }

    public int getPrice(){
        return super.getPrice()+2;
    }
}
