package com.gupao.battercake.v2;

public class EggDecorator extends BattercakeDecorator {

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {
        System.out.println("添加鸡蛋");
    }


    @Override
    protected String getMsg(){
        return super.getMsg()+"1个鸡蛋";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+1;
    }
}
