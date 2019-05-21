package com.gupao.battercake.v1;

public class BattercakeTest {

    public static void main(String [] args){

        Battercake cake = new BattercakeWithEggAndSausage();

        System.out.print(cake.getMsg()+cake.getPrice());
    }
}
