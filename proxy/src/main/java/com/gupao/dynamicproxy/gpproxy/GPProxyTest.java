package com.gupao.dynamicproxy.gpproxy;

import com.gupao.Peron;
import com.gupao.dynamicproxy.jdk.Girl;

public class GPProxyTest {

    public static void main(String[] args){

        try {
            Peron obj = (Peron) new GPMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());

            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
