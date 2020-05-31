package leetcode.链表操作.q206_反转链表;
/*
* 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
* */

public class InitSolution {
    public ListNode reverseList(ListNode head) {
        ListNode tmp = head;

        /*
        * 保存前驱节点和后置节点
        * 此为迭代法*/
        ListNode prev = null;
        ListNode next = new ListNode(0);

        while (tmp != null){
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;

        }
        return head;
    }
}
