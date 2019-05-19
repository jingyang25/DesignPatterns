package com.gupao.dynamicproxy.jdk;

import com.gupao.Peron;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class jdkProxyTest {

    public static void main(String [] args) throws Exception {

        try {
            Peron obj = (Peron) new Meipo().getInstance(new Girl());
            obj.findLove();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Peron.class});

            FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
