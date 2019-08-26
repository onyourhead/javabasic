package edu.ncut.zzq.basic;

/**
 * @ClassName: BitOperation
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/22 19:49
 * @Version: 1.0
 */
public class BitOperation {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(-2));
//        System.out.println(Integer.toBinaryString(-5));
//        System.out.println(Integer.toBinaryString(1073741822));
//        System.out.println(-5 >>> 2);
        System.out.println(bitAnd(-7));
    }

    public static int bitAnd(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >>> 1;
        }
        return count;
    }
}
