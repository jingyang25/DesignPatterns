package com.gupao.abstractFactory.product;

public class SportsBody implements CarBody {


    @Override
    public CarBody body() {
        System.out.println("SportsCar body");

        return new SportsBody();
    }



}


