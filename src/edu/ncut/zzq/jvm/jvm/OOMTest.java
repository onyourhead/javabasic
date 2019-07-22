package edu.ncut.zzq.jvm.jvm;

/**
 * title: OOMTest
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/29
 * time： 15:59
 */
public class OOMTest{
    public void stackOverFlowMethod(){
        stackOverFlowMethod();
    }
    public static void main(String... args){
        OOMTest oom = new OOMTest();
        oom.stackOverFlowMethod();
    }
}