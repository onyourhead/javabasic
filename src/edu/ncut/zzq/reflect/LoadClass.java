package edu.ncut.zzq.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * title: LoadClass
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/13
 * time： 19:55
 */
public class LoadClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c=Class.forName("edu.ncut.zzq.reflect.Basic");
        System.out.println(c.getName());
        Basic ex= (Basic) c.newInstance();
        Method setA=c.getDeclaredMethod("setA", int.class);
        Object o=setA.invoke(ex,1);
        Method getA=c.getDeclaredMethod("getA");
        Object a=getA.invoke(ex);
        System.out.println(a);
    }
}
