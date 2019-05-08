package com.gupao.abstractFactory.factory;

import com.gupao.abstractFactory.product.CarBody;
import com.gupao.abstractFactory.product.CarWheel;

public interface AbstractFactory {

    CarBody body();

    CarWheel wheel();


}
