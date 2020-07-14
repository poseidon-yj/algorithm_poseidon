package leetcode.排序.q148_排序链表;
/*
* 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
*/

public class InitSolution {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode left, ListNode right){
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null){
            if (left.val <= right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //左右区间可能存在长短不一的情况，把未比完的直接拼接到h.next
        h.next = left == null ? right:left;
        return res.next;
    }
}
