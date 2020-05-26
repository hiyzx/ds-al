package org.zero.leetcode.链表;

import org.zero.leetcode.链表.ListNode;

/**
 * @author 水寒
 * @date 2020/4/22
 * @see https://leetcode-cn.com/problems/linked-list-cycle
 */
public class _141_环形链表 {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow.val == fast.val) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}