package com.gupao.lazy;

public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazy = null;


    public static   LazyDoubleCheckSingleton  getInstance(){

        if(lazy==null){

            synchronized(LazyDoubleCheckSingleton.class) {

                if (lazy==null)
                lazy = new LazyDoubleCheckSingleton();
            }

        }

        return lazy;
    }
}
