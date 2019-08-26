package bishi.bilibili;

import java.util.Scanner;

import java.util.Scanner;

/**
 * @ClassName: MinNum
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/20 19:38
 * @Version: 1.0
 */
public class MinNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = input.length - 1; j > i; j--) {
                compareAndSwap(input, j -1,j);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            stringBuilder.append(input [i]);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void compareAndSwap(String[] input, int i1, int i2) {
        if (Long.parseLong(input[i1] + input [i2]) > Long.parseLong(input [i2] + input[i1])) {
            String temp = input[i1];
            input[i1] = input [i2];
            input [i2] = temp;
        }
    }
}
