package edu.ncut.zzq.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/15 10:47
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
