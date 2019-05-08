package com.gupao.abstractFactory.product;

public class BicycleWheel implements CarWheel{


    @Override
    public CarWheel wheel() {
        System.out.println("wheel Bicycle ");
        return new BicycleWheel();
    }
}
