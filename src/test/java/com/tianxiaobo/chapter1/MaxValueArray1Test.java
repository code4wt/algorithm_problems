package com.tianxiaobo.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MaxValueArray1Test
 *
 * @author Tian ZhongBo
 * @date 2019-02-23 23:42:06
 */
public class MaxValueArray1Test {

    @Test
    public void getMaxValues() throws Exception {
        int[] nums = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxValues = MaxValueArray1.getMaxValues(nums, 3);

        assertArrayEquals(new int[] {5, 5, 5, 4, 6, 7}, maxValues);
    }

}