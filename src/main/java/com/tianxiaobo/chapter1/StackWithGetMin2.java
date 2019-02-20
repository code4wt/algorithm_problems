package com.tianxiaobo.chapter1;

import java.util.Stack;

/**
 * StackWithGetMin1
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 20:43:33
 */
public class StackWithGetMin2<T extends Comparable<T>> {

    private Stack<T> stackData = new Stack<>();

    private Stack<T> stackMin = new Stack<>();

    public void push(T ele) {
        T min = getMin();
        if (min == null || ele.compareTo(min) <= 0) {
            stackMin.push(ele);
        }
        stackData.push(ele);
    }

    public T pop() {
        if (stackData.empty()) {
            return null;
        }

        T data = stackData.pop();
        T min = getMin();

        if (data.compareTo(min) == 0) {
            stackMin.pop();
        }
        return data;
    }

    public T getMin() {
        if (stackData.empty()) {
            return null;
        }

        return stackMin.peek();
    }
}

