package com.gupao.abstractFactory.factory;

import com.gupao.abstractFactory.product.CarBody;
import com.gupao.abstractFactory.product.CarWheel;
import com.gupao.abstractFactory.product.TruckBody;
import com.gupao.abstractFactory.product.TruckWheel;

public class TruckFactory implements AbstractFactory {



    @Override
    public CarBody body() {
        return new TruckBody();
    }

    @Override
    public CarWheel wheel() {
        return new TruckWheel();
    }
}
