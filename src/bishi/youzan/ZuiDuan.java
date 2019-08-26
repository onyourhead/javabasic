package bishi.youzan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: ZuiDuan
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/20 15:51
 * @Version: 1.0
 */
public class ZuiDuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] input = scanner.nextLine().trim().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int[] gap = new int[nums.length - 1];
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            gap[i - 1] = Math.abs(nums[i] - nums[i - 1]);
            total += gap[i - 1];
        }
        int maxGap = 0;
        for (int i = 1; i < gap.length; i++) {
            if (gap[i - 1] + gap[i] > maxGap) {
                maxGap = gap[i - 1] + gap[i];
            }
        }
        System.out.println(total - maxGap);

    }
}
