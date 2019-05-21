package com.gupao.battercake.v1;

public class BattercakeWithEgg  extends Battercake{

    @Override
    public String getMsg(){

        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    public int getPrice(){

        return super.getPrice()+1;
    }

}
