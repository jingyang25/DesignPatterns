package com.gupao.dynamicproxy.gproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GPProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoder,Class<?> []interfaces,GPInvocationHandler h){

        String src = generateSrc(interfaces);

        String filePath = GPProxy.class.getResource("").getPath();

        try {
            File f = new File(filePath+"$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();


            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            Class proxyClass = classLoder.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();

            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {

        StringBuffer sb = new StringBuffer();
        sb.append("package com.gupao.gproxy;"+ln);
        sb.append("import com.gupao.Peron;"+ln);
        sb.append("import java.lang.reflect.*;"+ln);
        sb.append("public class $Proxy0 implements " +interfaces[0].getName()+"{"+ln);
        sb.append("GPInvocationHandler h;"+ln);
        sb.append("public $Proxy0(GPInvocationHandler h) {"+ln);
        sb.append("this.h = h;");
        sb.append("}"+ln);
        for (Method m:interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();
            for (int i=0;i<params.length;i++){
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type+""+paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName()+".class");


                if(i>0&& i<params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");

                }
            }

            sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"("+paramNames.toString()+") {"+ln);
            sb.append("try{"+ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){"+ln);
            sb.append("throw new UndeclaredThrowableException(e);"+ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");

        }

        sb.append("}"+ln);
        return sb.toString();
    }

    private static String getCaseCode(String code, Class<?> returnType) {

        if(mapping.containsKey(returnType)){
            return "(("+mapping.get(returnType).getName()+")"+code +")."+returnType.getSimpleName()+"Value()";
        }

        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {

        return clazz!=void.class;
    }

    private static Map<Class,Class> mapping = new HashMap<>();

    static {

        mapping.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){

        if(mapping.containsKey(returnClass)){
            return "return 0; ";
        }else if(returnClass==void.class){
            return "";
        }else{
            return "return null;";
        }

    }

    private static String toLowerFirstCase(String src){

        char[] chars = src.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }


}
