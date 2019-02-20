package com.tianxiaobo.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * StackWithGetMin2Test
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 22:31:08
 */
public class StackWithGetMin2Test {

    @Test
    public void getMin() throws Exception {
        StackWithGetMin2<Integer> stack = new StackWithGetMin2<>();
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