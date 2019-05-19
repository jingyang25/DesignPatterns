package com.gupao.hungry;

public class HungryStaticSingleton {

    private  static final HungryStaticSingleton  hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }



}
