package com.tianxiaobo.chapter1;

import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;

/**
 * ReverseStackTest
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 13:51:11
 */
public class ReverseStackTest {

    @Test
    public void reverse() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        ReverseStack.reverse(stack);

        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(4), stack.pop());
        assertEquals(Integer.valueOf(5), stack.pop());
    }

}