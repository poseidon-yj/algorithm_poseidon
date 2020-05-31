package leetcode.链表操作.q206_反转链表;

public class ImproveSolution {
    /*
    * 递归法
    * 递归表达式：
    * nk.next.next = nk+1;
    * 递归退出条件：
    * nk+1 == null，也就是递归到尾节点弹栈*/

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;//这一步防止成环
        return p;//p最终就是原先的尾节点
    }
}
