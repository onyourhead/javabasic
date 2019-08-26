package bishi.bilibili;
import	java.util.Arrays;
import	java.util.Scanner;

/**
 * @ClassName: ReverseWord
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/20 19:19
 * @Version: 1.0
 */
public class ReverseWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String reversed = reverse(input);
        String[] strings = input.trim().split(" ");
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings [i];
            strings[i] = strings [strings.length - 1-i];
            strings [strings.length - 1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings [i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
    public static String reverse(String input) {
        char [] chars = input.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars [i];
            chars [i] = chars [chars.length - 1 - i];
            chars [chars.length - 1-i] = temp;
        }
        return new String(chars);
    }
}
