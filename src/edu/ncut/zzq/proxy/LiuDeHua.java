package edu.ncut.zzq.proxy;

/**
 * title: LiuDeHua
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/6/3
 * time： 9:49
 */
public class LiuDeHua implements Person {

    public String sing(String name){
        System.out.println("刘德华唱"+name+"歌！！");
        return "歌唱完了，谢谢大家！";
    }

    public String dance(String name){
        System.out.println("刘德华跳"+name+"舞！！");
        return "舞跳完了，多谢各位观众！";
    }
}