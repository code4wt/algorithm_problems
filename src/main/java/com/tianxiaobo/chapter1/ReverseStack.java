package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 如何仅用递归函数和栈操作逆序一个栈
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 13:38:31
 */
public class ReverseStack {

    public static <T> void reverse(Stack<T> stack) {
        if (stack.empty()) {
            return;
        }

        T last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    private static <T> T getAndRemoveLastElement(Stack<T> stack) {
        T ele = stack.pop();
        if (stack.empty()) {
            return ele;
        }

        T last = getAndRemoveLastElement(stack);
        stack.push(ele);
        return last;
    }
}
