package zuoyebang;

import java.util.Scanner;

/**
 * @ClassName: SumOfTwoNum
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/14 19:03
 * @Version: 1.0
 */
public class SumOfTwoNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine().trim());
        String[] strings = input.split(",");
        int[] nums = new int [strings.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings [i].trim();
            if (i == 0) {
                nums[i]= Integer.parseInt(strings [i].substring(1));
            } else if (i == nums.length - 1){
                nums [i] = Integer.parseInt(strings [i].substring(0, strings[i].length() - 1));
            } else {
                nums [i] = Integer.parseInt(strings [i]);
            }
        }
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums [left] + nums [right] < k) {
                left++;
            } else if (nums [left] + nums [right] > k) {
                right--;
            } else {
                System.out.println(nums [left] + "," + nums [right]);
                left++;
                right--;
            }
        }
    }
}
