package com.gupao.simpleFactory;

public class Test {


    public static void main(String [] args){
        SimpleFactory factory = new SimpleFactory();

        Clothes clothes = factory.getClothesByName("T_shirt");


    }
}
