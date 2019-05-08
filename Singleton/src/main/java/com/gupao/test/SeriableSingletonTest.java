package com.gupao.test;

import com.gupao.seriable.SeriableSingleton;

import java.io.*;

public class SeriableSingletonTest {

    public static void main(String[] args){

        SeriableSingleton s1 = SeriableSingleton.getInstance();

        SeriableSingleton s2 = SeriableSingleton.getInstance();


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

            s1= (SeriableSingleton) ois.readObject();

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
