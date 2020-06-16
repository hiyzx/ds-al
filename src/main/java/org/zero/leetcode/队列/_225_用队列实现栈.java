package org.zero.leetcode.队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 水寒
 * @date 2020/6/13
 */
public class _225_用队列实现栈 {

    private Queue<Integer> inQueue;

    private Queue<Integer> outQueue;

    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.offer(x);
        while (!outQueue.isEmpty()){
            inQueue.offer(outQueue.poll());
        }

        Queue<Integer> tmp = inQueue;
        inQueue = outQueue;
        outQueue = tmp;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return outQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return outQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }

    public static void main(String[] args) {
        _225_用队列实现栈 mystack = new _225_用队列实现栈();
        mystack.push(1);
        mystack.push(2);

        System.out.println(mystack.top());

        System.out.println(mystack.pop());

        System.out.println(mystack.empty());
    }
}
