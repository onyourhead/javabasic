package zuoyebang;

import java.util.Scanner;

/**
 * @ClassName: ReverseString
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/14 19:24
 * @Version: 1.0
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = new String(scanner.nextLine());
        System.out.println(reverse(s));
    }
    public static String reverse(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        int middle = length / 2;
        String left = s.substring(0, middle);
        String right = s.substring(middle);
        return reverse(right) + reverse(left);
    }
}
