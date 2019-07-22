package com.interview.javabasic.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhengqi
 * @date 2019/7/12
 * @time 10:54
 */
public class ListStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ad");
        list.add("be");
        list.add("cs");
        list.add("");
        list.add(" d");
//        list.stream().filter(
//                (String::isEmpty)
//        ).collect();
        list.stream().map(
                String::toCharArray
        ).forEach(
                System.out::println
        );
//        System.out.println(list);
    }
}
