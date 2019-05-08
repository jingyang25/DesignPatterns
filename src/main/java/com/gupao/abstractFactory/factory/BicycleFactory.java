package com.gupao.abstractFactory.factory;

import com.gupao.abstractFactory.product.BicycleBody;
import com.gupao.abstractFactory.product.BicycleWheel;
import com.gupao.abstractFactory.product.CarBody;
import com.gupao.abstractFactory.product.CarWheel;

public class BicycleFactory implements AbstractFactory{


    @Override
    public CarBody body() {
        return  new BicycleBody();
    }

    @Override
    public CarWheel wheel() {
        return new BicycleWheel();
    }
}
