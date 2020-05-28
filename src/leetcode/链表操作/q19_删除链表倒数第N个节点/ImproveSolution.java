package leetcode.链表操作.q19_删除链表倒数第N个节点;
/*
* 双指针一次遍历，F指针和S指针
* F指针先移动n+1，此时S指针与F指针之间隔了N个节点，然后F，S指针同时移动，当F指针指向Null节点时，S指针正好是倒数第N个节点
* */
public class ImproveSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode F = dummyHead;
        ListNode S = dummyHead;

        for (int i = 0; i <= n; i++) {
            F = F.next;
        }

        while (F != null){
            F = F.next;
            S = S.next;
        }

        S.next = S.next.next;

        return dummyHead.next;
    }
}
