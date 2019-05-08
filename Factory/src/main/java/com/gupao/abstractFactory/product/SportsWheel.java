package com.gupao.abstractFactory.product;

public class SportsWheel implements CarWheel {


    @Override
    public CarWheel wheel() {

        System.out.println("wheel SportsCar ");

        return new SportsWheel();
    }
}
