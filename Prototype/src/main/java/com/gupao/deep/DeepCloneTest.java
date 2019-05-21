package com.gupao.deep;

public class DeepCloneTest {

    public static void main(String [] args){

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        QiTianDaSheng clone = qiTianDaSheng.clone();

        System.out.println("深克隆"+(qiTianDaSheng.jinGuBang == clone.jinGuBang));
    }
}
