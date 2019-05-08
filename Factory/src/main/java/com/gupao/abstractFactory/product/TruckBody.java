package com.gupao.abstractFactory.product;

public class TruckBody implements CarBody {



    public CarBody body() {
        System.out.println("Truck body");
        return new TruckBody();
    }

}
