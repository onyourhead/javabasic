package edu.ncut.zzq.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/1 14:41
 * @Version: 1.0
 */
public class HeapSort {
    @Test
    public void main() {
        int[] nums = {2, 7, 1, 3, 9, 6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums) {
        //先将无序的堆调整为大顶堆
        buildBigHeap(nums);
        //大顶堆的元素往下交换，并重新调整为大顶堆
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0]= nums[i];
            nums[i]= temp;
            adjustBigHeap(nums,0,i);
        }
    }
    public void buildBigHeap(int[] nums) {
        for (int i = (nums.length - 1 )/2; i >= 0; i--) {
            adjustBigHeap(nums, i, nums.length);
        }

    }
    public void adjustBigHeap(int[] nums, int i, int limit) {
        int temp = nums[i];
        while (2 * (i + 1) - 1 < limit) {
            int k = 2 * (i + 1) - 1;
            if (k + 1 < limit && nums[k + 1] > nums[k]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                return;
            }
        }
        nums[i] = temp;
    }
}
