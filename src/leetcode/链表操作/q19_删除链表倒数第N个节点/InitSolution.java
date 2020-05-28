package leetcode.链表操作.q19_删除链表倒数第N个节点;
/*
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

*/

public class InitSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }

        ListNode temp = head;
        int count = 0;

        while (temp != null){
            temp = temp.next;
            count++;
        }

        /*      以下方式做二次遍历时间复杂度过高
        int m = count - n;
        System.out.println(m);

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int num = 0;
        ListNode tmp = dummyHead;

        while (tmp != null){
            if (num == m){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
            num++;
        }

        */

        count -= n;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (count > 0){
            count--;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return dummyHead.next;
    }
}
