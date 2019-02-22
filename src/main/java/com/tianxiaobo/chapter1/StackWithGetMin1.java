package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * Q: 带有 getMin 功能的栈
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 20:43:33
 */
public class StackWithGetMin1<T extends Comparable<T>> {

    private Stack<T> stackData = new Stack<>();

    private Stack<T> stackMin = new Stack<>();

    public void push(T ele) {
        T min = getMin();
        if (min == null || min.compareTo(ele) > 0) {
            min = ele;
        }
        stackMin.push(min);
        stackData.push(ele);
    }

    public T pop() {
        if (stackData.empty()) {
            return null;
        }
        stackMin.pop();
        return stackData.pop();
    }

    public T getMin() {
        if (stackData.empty()) {
            return null;
        }

        return stackMin.peek();
    }
}

