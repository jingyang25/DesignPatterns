package com.gupao.simpleFactory;

public class SimpleFactory {


    public Clothes getClothesByName(String name) {

        if("T_shirt".equals(name)){
            System.out.println("T_shirt");

            return new T_shirt();

        }else if("Skirt".equals(name)){
            System.out.println("Skirt");
            return new Skirt();
        }else if("Sweater".equals(name)) {
            System.out.println("Sweater");
            return new Skirt();
        }else{
            return null;
        }

    }
}
