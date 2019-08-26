package bishi.yitu;
import java.util.ArrayList;
import java.util.List;
import	java.util.Scanner;

/**
 * @ClassName: DiTie
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/23 19:44
 * @Version: 1.0
 */
public class DiTie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int total = 0;
        if (n >= 3) {
            total = 2 * (n - 3) + 1;
        }
        System.out.println(total * 2 * getM(jump(n + 1)));
    }
    public static int jump(int n) {
        int f_3 = 1;
        int f_2 = 1;
        int f_1 = 1;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = f_2 + f_3;
            f_3 = f_2;
            f_2 = f_1;
            f_1 = fn;
        }
        return fn;
    }
    public static int getM(int n) {
        List<Integer> inv = new ArrayList<>();
        int mod = 1000000007;
        inv.add(0);
        inv.add(1);
        for (int i = 2; i <= n; i++) {
            inv.add(inv.get(mod % i) * (mod - mod / i) % mod);
        }
        return inv.get(n);
    }
}
