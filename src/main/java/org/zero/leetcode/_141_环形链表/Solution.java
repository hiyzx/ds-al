package org.zero.leetcode._141_环形链表;

/**
 * @author 水寒
 * @date 2020/4/22
 * @see https://leetcode-cn.com/problems/linked-list-cycle
 */
public class Solution {

	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null){
			if(slow.val == fast.val){
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args){
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		// listNode.next.next.next = listNode;
		System.out.println(hasCycle(listNode));
	}
}