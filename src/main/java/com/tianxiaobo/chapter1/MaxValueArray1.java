package com.tianxiaobo.chapter1;

/**
 * MaxValueArray1
 *
 * @author Tian ZhongBo
 * @date 2019-02-23 23:14:52
 */
public class MaxValueArray1 {

    public static int[] getMaxValues(int[] nums, int n) {
        if (n < 2 || nums == null || nums.length < 2) {
            return nums;
        }

        n = n > nums.length ? nums.length : n;
        int[] maxValues = new int[nums.length - n + 1];

        int end = n - 1;
        int index = -1, max = 0;
        for (int i = 0; i < maxValues.length; i++, end++) {
            if (i == 0 || index < i) {
                index = i;
                max = nums[i];
                for (int j = i + 1; j <= end; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        index = j;
                    }
                }
                maxValues[i] = max;
            } else {
                if (nums[end] > max) {
                    index = end;
                    max = nums[end];
                }
                maxValues[i] = max;
            }
        }

        return maxValues;
    }
}
