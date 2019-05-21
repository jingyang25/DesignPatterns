package com.gupao.battercake.v2;

public class BattercakeTest {

    public static void main(String [] args){

        Battercake battercake;

        battercake = new BaseBattercake();
        System.out.println(battercake.getMsg()+"___________"+battercake.getPrice());

        battercake = new EggDecorator(battercake);

        System.out.println(battercake.getMsg()+"___________"+battercake.getPrice());

        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMsg()+"___________"+battercake.getPrice());
    }
}
