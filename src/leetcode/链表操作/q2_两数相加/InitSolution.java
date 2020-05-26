package leetcode.链表操作.q2_两数相加;
/*
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

* */

public class InitSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode rs = new ListNode(l1.val + l2.val);

        l1 = l1.next;
        l2 = l2.next;

        ListNode temp = rs;
        /*
        * 第一次遍历：将两个链表节点的值相加，若节点为空则值用0填充*/
        while (l1 != null || l2 != null){
            int a = 0;
            int b = 0;

            if (l1 != null){
                a = l1.val;
            }

            if (l2 != null){
                b = l2.val;
            }

            int t = a + b;

            temp.next = new ListNode(t);
            temp = temp.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        /*
        * 第二次遍历：链表rs的节点值大于10，则向后进一位*/
        temp = rs;

        while (temp != null){
            if (temp.val >= 10){
                temp.val = temp.val - 10;

                if (temp.next == null){
                    temp.next = new ListNode(0);
                }

                temp.next.val = temp.next.val + 1;

            }
            temp = temp.next;
        }
        return rs;

    }


}
