package com.interview.javabasic.reflect;

public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("C:\\Users\\15480\\Downloads\\", "myClassLoader");
        Class c = m.loadClass("Wali");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
