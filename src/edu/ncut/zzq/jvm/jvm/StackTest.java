package edu.ncut.zzq.jvm.jvm;

/**
 * title: StackTest
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/29
 * time： 16:28
 */
public class StackTest {
    public static void main(String[] args) {
        StackTest test=new StackTest();
        test.a();
    }
    public void a() {
        int a=1;
        System.out.println("iam method a");
        b();
    }
    public void b() {
        int b=2;
        System.out.println("iam method b");
        c();
    }
    public void c() {
        int c=3;
        System.out.println("iam method c");
    }
}
