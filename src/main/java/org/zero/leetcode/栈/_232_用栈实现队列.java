package org.zero.leetcode.栈;

import java.util.Stack;

/**
 * @author 水寒
 * @date 2020/6/8
 * @see https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列 {

	private Stack<Integer> inStack;
	private Stack<Integer> outStack;

	/**
	 * Initialize your data structure here.
	 */
	public _232_用栈实现队列() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		inStack.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if(outStack.isEmpty()){
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if(outStack.isEmpty()){
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
}
