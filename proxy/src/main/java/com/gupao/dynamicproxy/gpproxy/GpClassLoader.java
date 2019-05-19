package com.gupao.dynamicproxy.gpproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 代理运行过程
 *
 * 通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 * 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 */
public class GpClassLoader extends ClassLoader{

    private File classPathFile;


    public GpClassLoader(){

        String classPath = GpClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }


    protected Class<?> findClass(String name) {

        String className = GpClassLoader.class.getPackage().getName()+"."+name;

        if(classPathFile!=null){

            File classFile = new File(classPathFile,name.replaceAll("\\.","/"+".class"));

            if(classFile.exists()){

                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();

                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff))!=-1){

                        out.write(buff,0,len);
                    }

                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return null;
    }
}
