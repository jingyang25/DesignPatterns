package com.gupao.abstractFactory;

import com.gupao.abstractFactory.factory.AbstractFactory;
import com.gupao.abstractFactory.factory.TruckFactory;


public class Test {

    public static  void main(String [] args){

        AbstractFactory factory = new TruckFactory();

        System.out.println(factory.body());

        System.out.println(factory.wheel());


    }
}
