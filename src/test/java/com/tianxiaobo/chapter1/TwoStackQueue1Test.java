package com.tianxiaobo.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * TwoStackQueue1Test
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 11:52:11
 */
public class TwoStackQueue1Test {

    @Test
    public void test() {
        TwoStackQueue1<Integer> queue = new TwoStackQueue1<>();
        queue.add(1);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(2);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(3);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(4);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(5);
        assertEquals(Integer.valueOf(1), queue.peek());

        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.peek());
        assertEquals(Integer.valueOf(2), queue.poll());
        assertEquals(Integer.valueOf(3), queue.peek());
        assertEquals(Integer.valueOf(3), queue.poll());
        assertEquals(Integer.valueOf(4), queue.peek());
        assertEquals(Integer.valueOf(4), queue.poll());
        assertEquals(Integer.valueOf(5), queue.peek());
        assertEquals(Integer.valueOf(5), queue.poll());
    }
}