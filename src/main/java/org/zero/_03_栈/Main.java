package org.zero._03_栈;

import org.zero._01_数组.ZeroArrayList;

/**
 * @author 水寒
 * @date 2020/5/19
 */
public class Main {

    public static void main(String[] args) {
        ZeroStack<Integer> stack = new ZeroStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack);
    }
}
