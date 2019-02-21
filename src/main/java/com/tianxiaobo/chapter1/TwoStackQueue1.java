package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 由两个栈组成的队列
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 10:58:03
 */
public class TwoStackQueue1<T> {

    private Stack<T> stackPush = new Stack<>();

    private Stack<T> stackPop = new Stack<>();

    public void add(T ele) {
        stackPush.push(ele);
        int size = stackPop.size();
        transfer(stackPop, stackPush, size);
        stackPop.push(ele);
        transfer(stackPush, stackPop, size);
    }

    public T poll() {
        if (stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        }
        T ele = stackPop.pop();
        int size = stackPush.size() - 1;
        transfer(stackPush, stackPop, size);
        stackPush.pop();
        transfer(stackPop, stackPush, size);
        return ele;
    }

    public T peek() {
        if (stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        }
        return stackPop.peek();
    }

    private void transfer(Stack<T> stack1, Stack<T> stack2, int size) {
        for (int i = 0; i < size && !stack1.empty(); i++) {
            stack2.push(stack1.pop());
        }
    }
}