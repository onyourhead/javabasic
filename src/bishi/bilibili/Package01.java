package bishi.bilibili;

import java.util.Scanner;

/**
 * @ClassName: Package01
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/20 20:18
 * @Version: 1.0
 */
public class Package01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int m = Integer.parseInt(scanner.nextLine().trim());
        String[] wInput = scanner.nextLine().split(" ");
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(wInput[i-1]);
        }
        String[] vInput = scanner.nextLine().split(" ");
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(vInput[i-1]);
        }
        int[][] table = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w[i] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(table[n][m]);
    }
}
