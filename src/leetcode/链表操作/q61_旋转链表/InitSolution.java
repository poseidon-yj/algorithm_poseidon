package leetcode.链表操作.q61_旋转链表;

public class InitSolution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tail = dummyHead;

        int length = 0;
        //第一次遍历，改成循环链表首尾连接
        while (tail.next != null){
            tail = tail.next;
            length++;
        }

        tail.next = head;

        //k取余length减少重复操作，length-k将原本逆向移动k改成正向移动j
        k %= length;
        int j = length - k;

        //定位j最终指向的节点，并将虚头节点的next指向它
        ListNode temp = dummyHead;
        while (j >= 0){
            j--;
            temp = temp.next;
        }
        dummyHead.next = temp;

        //断开循环链表
        ListNode beforeTail = dummyHead;
        while (length > 1){
            length--;
            temp = temp.next;
        }
        temp.next = null;

        return dummyHead.next;

    }
}
