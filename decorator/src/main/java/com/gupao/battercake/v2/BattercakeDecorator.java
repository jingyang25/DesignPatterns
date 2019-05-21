package com.gupao.battercake.v2;


public  abstract  class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg(){
        return this.battercake.getMsg();
    }

    @Override
    public int getPrice(){

        return this.battercake.getPrice();
    }


}
