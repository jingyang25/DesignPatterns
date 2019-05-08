package com.gupao.abstractFactory.product;

public class TruckWheel implements CarWheel {


    @Override
    public CarWheel wheel() {

        System.out.println("wheel Truck ");

        return new TruckWheel();
    }
}
