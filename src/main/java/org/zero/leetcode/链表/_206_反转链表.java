package org.zero.leetcode.链表;

/**
 * @author 水寒
 * @date 2020/5/21
 * @see https://leetcode-cn.com/problems/reverse-linked-list/
 */
class _206_反转链表 {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}