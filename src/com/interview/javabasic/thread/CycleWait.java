package com.interview.javabasic.thread;

import java.util.Date;

public class CycleWait implements Runnable{
//    private String value;
    private Person person;
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        value = "we have data now";
        person=new Person("q",24);
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
//        while (cw.value == null){
        while (cw.person == null){
            Thread.currentThread().sleep(100);
        }
//        t.join();
//        System.out.println("value : " + cw.value);
        System.out.println(cw.person.getName());
    }


    private class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
