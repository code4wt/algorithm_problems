package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 用一个栈实现另一个栈排序
 *
 * 不好的实现
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 23:16:55
 */
public class StackSorter1 {

    public static void sort(Stack<Integer> stack) {
        if (stack == null) {
            return;
        }

        Stack<Integer> helpStack = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                findMinAndTransfer(stack, helpStack, size - i);
            } else {
                findMinAndTransfer(helpStack, stack, size - i);
            }
        }

        int i = 0;
        size = helpStack.size();
        while (size-- > 0) {
            Integer ele = helpStack.pop();
            while (stack.peek() > ele) {
                helpStack.push(stack.pop());
                i++;
            }

            stack.push(ele);
            while(i > 0) {
                stack.push(helpStack.pop());
                i--;
            }
        }
    }

    private static void findMinAndTransfer(Stack<Integer> source, Stack<Integer> target, int size) {
        int min = source.pop();
        for (int i = 0; i < size - 1; i++) {
            Integer ele = source.pop();
            if (ele < min) {
                target.push(min);
                min = ele;
            } else {
                target.push(ele);
            }
        }

        source.push(min);
    }
}