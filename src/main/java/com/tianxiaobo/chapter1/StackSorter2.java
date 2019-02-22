package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 用一个栈实现另一个栈排序
 *
 * 最优解
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 23:16:55
 */
public class StackSorter2 {

    public static void sort(Stack<Integer> stack) {
        if (stack == null) {
            return;
        }

        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        while (!help.empty()) {
            stack.push(help.pop());
        }
    }
}