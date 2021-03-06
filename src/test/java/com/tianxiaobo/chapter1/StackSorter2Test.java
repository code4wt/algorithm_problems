package com.tianxiaobo.chapter1;

import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;

/**
 * StackSorter2Test
 *
 * @author Tian ZhongBo
 * @date 2019-02-22 23:28:39
 */
public class StackSorter2Test {

    @Test
    public void sort() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(6);
        stack.push(1);
        stack.push(1);
        stack.push(7);

        StackSorter2.sort(stack);
        assertEquals(Integer.valueOf(7), stack.pop());
        assertEquals(Integer.valueOf(6), stack.pop());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

}