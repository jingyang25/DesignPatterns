package com.gupao.funcFactory;

public class FuncFactory {

    public Food create(String name){

        if("vegetables".equals(name)){


           return new VegetablesFactroy();

        }else if("fruits".equals(name)){

            return new FruitsFactory();
        }else if("meat".equals(name)){

            return new MeatFactory();
        }else{

            return null;
        }
    }
}
