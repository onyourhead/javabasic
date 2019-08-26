package bishi.yitu;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

/**
 * @ClassName: ShaZi
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/23 19:13
 * @Version: 1.0
 */
public class ShaZi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] nums = new int[n][6];
        for (int i = 0; i < n; i++) {
            String[] numInline = scanner.nextLine().trim().split(" ");
            int[] innerNums = new int[6];
            for (int j = 0; j < 6; j++) {
                innerNums[j] = Integer.parseInt(numInline[j]);
            }
            Arrays.sort(innerNums);
            nums[i] = innerNums;
        }
        System.out.println(numOfSumEqualK(nums, 0, k));
    }

    public static int numOfSumEqualK(int[][] nums, int i, int k) {
        if (i == nums.length) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int total = 0;
        for (int j = 0; j < 6; j++) {
            if (k <= nums[i][j]) {
                continue;
            }
            total += numOfSumEqualK(nums, i + 1, k - nums[i][j]);
        }
        return total;
    }
}
