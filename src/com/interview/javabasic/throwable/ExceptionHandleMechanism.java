package com.interview.javabasic.throwable;

public class ExceptionHandleMechanism {
    public static void doWork() {
        try {
            int i = 10 / 0;    //会抛出异常
            System.out.println("i=" + i);
        } catch (ArithmeticException e) {
            //捕获 Exception
            System.out.println("ArithmeticException: " + e);
        } finally {
            System.out.println("Finally");
        }
    }
    public static void main(String[] args) {
        doWork();
        System.out.println("Mission Complete");
    }
}
