package com.gupao.dynamicproxy.gpproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来生成源代码的工具类
 *
 */
public class GPProxy {

    public static final String ln = "\r\n";


    public static Object newProxyInstance(GpClassLoader classLoder, Class<?>[] interfaces, GPinvocationHandler h){

        //1、动态生成源代码.java 文件
        try {
            String src = generateSrc(interfaces);

            //2、Java 文件输出磁盘
            String filePath = GPProxy.class.getResource("").getPath();

            File f  = new File(filePath+"$Proxy0.java");

            FileWriter fw = new FileWriter(f);

            fw.write(src);
            fw.flush();
            fw.close();

            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = javaCompiler.getTask(null,manager,null,null,null,iterable);

            task.call();

            manager.close();

            Class proxyClass = classLoder.findClass("$Proxy0");

            Constructor c = proxyClass.getConstructor(GPinvocationHandler.class);

            f.delete();

            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private static String generateSrc(Class<?> [] interfaces){

        StringBuffer sb = new StringBuffer();
        sb.append("package com.gupao.dynamicproxy.gpproxy;");
        sb.append("import com.gupao.Peron;"+ln);
        sb.append("import java.lang.reflect.*;"+ln);
        sb.append("public class $Proxy0 implements"+interfaces[0].getName()+"{"+ln);

        sb.append("GPinvocationHandler h;"+ln);
        sb.append("public $Proxy0(GPinvocationHandler h) {"+ln);
        sb.append("this.h=h;");
        sb.append("}"+ln);

        for (Method m: interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();

            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstClase(clazz.getSimpleName());
                paramNames.append(type + "" + paramName);
                paramValues.append(paramName);
                paramValues.append(clazz.getName());

                if (i > 0 && i < params.length - 1) {

                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");

                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");

        sb.append("}"+ln);
        
        return sb.toString();

        }


        return null;
    }

    private static Map<Class,Class> mappings = new HashMap<>();



        static{
            mappings.put(int.class,Integer.class);
        }

    private static boolean hasReturnValue(Class<?> clazz) {
       return clazz != void.class;

    }

    private static String getReturnEmptyCode(Class<?> returnClass) {

        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        }else if (returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }

    }

    private static String toLowerFirstClase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }
}
