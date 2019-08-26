package bishi.youzan;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: MergeLink
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/20 15:22
 * @Version: 1.0
 */
public class MergeLink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\|");
        String[] list1 = input[0].trim().split(",");
        String[] list2 = input[1].trim().split(",");
        if (list1.length == 0) {
            System.out.println(Arrays.toString(list2));
        }
        if (list2.length == 0) {
            System.out.println(Arrays.toString(list1));
        }
        int[] nums1 = new int[list1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(list1[i].trim());
        }
        int[] nums2 = new int[list2.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.parseInt(list2[i].trim());
        }
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
            } else if (nums1[index1] == nums2[index2]) {
                index1++;
            } else {
                result.add(nums2[index2]);
                index2++;
            }
        }
        if (index1 < nums1.length) {
            for (int j = index1; j < nums1.length; j++) {
                result.add(nums1[j]);
            }
        }
        if (index2 < nums2.length) {
            for (int j = index2; j < nums2.length; j++) {
                result.add(nums2[j]);
            }
        }
        System.out.println(result);


    }
}
