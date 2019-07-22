package edu.ncut.zzq.concurrent.test;

import java.util.Random;

/**
 * @ClassName: RondomTest
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/22 16:12
 * @Version: 1.0
 */
public class RondomTest {
    public static void main(String[] args) {
//        随机数设了种子后，就不随机了，下面的代码每次都会输出同样的值
        Random random = new Random(10);
        System.out.println(random.nextInt(100));
    }
}
