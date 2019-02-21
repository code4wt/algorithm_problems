package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 由两个栈组成的队列
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 10:58:03
 */
public class TwoStackQueue2<T> {

    private Stack<T> stackPush = new Stack<>();

    private Stack<T> stackPop = new Stack<>();

    public void add(T ele) {
        stackPush.push(ele);
    }

    public T poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        }

        if (stackPop.empty()) {
            transfer(stackPush, stackPop);
        }

        return stackPop.pop();
    }

    public T peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        }

        if (stackPop.empty()) {
            transfer(stackPush, stackPop);
        }

        return stackPop.peek();
    }

    private void transfer(Stack<T> stack1, Stack<T> stack2) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}