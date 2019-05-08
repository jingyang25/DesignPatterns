package com.gupao.abstractFactory.product;

public class BicycleBody implements CarBody {


    @Override
    public CarBody body() {
        System.out.println("body Bicycle ");

        return new BicycleBody();
    }

}
