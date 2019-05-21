package com.gupao.course;

public class test {

    public static void main(String [] args){

         NetworkCourse networkCourse = new JavaCourse();

         networkCourse.createCourse();
         System.out.println("------------------");


        NetworkCourse networkCourse2 = new BigDataCourse(true);
        networkCourse2.createCourse();
    }
}
