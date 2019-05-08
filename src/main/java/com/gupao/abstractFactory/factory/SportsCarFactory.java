package com.gupao.abstractFactory.factory;

import com.gupao.abstractFactory.product.CarBody;
import com.gupao.abstractFactory.product.CarWheel;
import com.gupao.abstractFactory.product.SportsBody;
import com.gupao.abstractFactory.product.SportsWheel;

public class SportsCarFactory implements AbstractFactory {

    @Override
    public CarBody body() {
        return new SportsBody();
    }

    @Override
    public CarWheel wheel() {
        return new SportsWheel();
    }
}
