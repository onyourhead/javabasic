package edu.ncut.zzq.jvm;

/**
 * title: StringIntern
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/15
 * time： 17:38
 */
public class StringIntern {
    public static void main(String[] args) {
//        String a=new StringBuilder("计算机").append("软件").toString();

//        String b="a";
//        String e=new String("计算机软件");
//        System.out.println(e.intern().hashCode());
//        System.out.println(e.hashCode());
//        System.out.println(e==e.intern());
//
//
//        String c=new String("a");
//        String d=new String("a");
//        String a4 = new String("AA") + new String("BB"); //在堆上创建对象AA、BB和AABB，在常量池上创建常量AA和BB
////        a4.intern();
//        String a5 = "AA" + "BB";
//
//        System.out.println(a4 == a5); //true
        String a="a";
        String b=a.intern();

        String c=new String("a");
        String d=new String("a");
        System.out.println(a==b);
        System.out.println(c==d);
    }
}
