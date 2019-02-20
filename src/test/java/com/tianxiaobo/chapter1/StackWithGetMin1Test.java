package com.tianxiaobo.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * StackWithGetMin1Test
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 22:31:25
 */
public class StackWithGetMin1Test {

    @Test
    public void getMin() throws Exception {
        StackWithGetMin1<Integer> stack = new StackWithGetMin1<>();
        stack.push(3);
        stack.push(9);
        stack.push(6);
        stack.push(2);
        stack.push(0);
        stack.push(1);

        assertEquals(Integer.valueOf(0), stack.getMin());
        stack.pop();
        assertEquals(Integer.valueOf(0), stack.getMin());
        stack.pop();
        assertEquals(Integer.valueOf(2), stack.getMin());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMin());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMin());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMin());
    }

}