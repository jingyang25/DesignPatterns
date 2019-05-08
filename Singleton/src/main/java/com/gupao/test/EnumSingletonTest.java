package com.gupao.test;

import com.gupao.register.EnumSingleton;

import java.io.*;

public class EnumSingletonTest {

    public static void main(String [] args){

       EnumSingleton  s1 = EnumSingleton.getInstance();

       EnumSingleton s2 = EnumSingleton.getInstance();


        try {
            FileOutputStream fos = null;

            fos = new FileOutputStream("SeriableSingleton.obj");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s2);

            oos.flush();

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fis = null;

            fis = new FileInputStream("SeriableSingleton.obj");

            ObjectInputStream ois = new ObjectInputStream(fis);

            s1= (EnumSingleton) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);




    }
}
