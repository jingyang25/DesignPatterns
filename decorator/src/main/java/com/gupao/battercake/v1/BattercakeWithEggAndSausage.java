package com.gupao.battercake.v1;

public class BattercakeWithEggAndSausage extends BattercakeWithEgg {

    @Override
    public   String getMsg(){
        return super.getMsg()+"+1根香肠";
    }

    @Override
    public  int getPrice(){
        return super.getPrice()+2;
    }
}
