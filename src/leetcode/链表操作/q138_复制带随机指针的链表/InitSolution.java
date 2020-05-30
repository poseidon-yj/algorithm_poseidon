package leetcode.链表操作.q138_复制带随机指针的链表;
/*
*
* 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 

示例 1：

输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：

输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
 

提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。
*/
import java.util.HashMap;

public class InitSolution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node l1 = new Node(0);
        Node l2 = new Node(0);

        Node tmp1 = l1;
        l1.next = head;
        Node tmp2 = l2;
        l2.next = new Node(head.val);

        HashMap<Integer,Node> random_index1 = new HashMap<>();//存放 索引号：node.random
        HashMap<Integer,Node> node_index1 = new HashMap<>();//存放 索引号：l1_node
        HashMap<Integer,Node> node_index2 = new HashMap<>();//存放 索引号：l2_node

        int index = 0;
        /*
        * 第一次遍历做三件事
        * 1。生成l2的链表
        * 2。填充random_index1
        * 3。记录node_index1，node_index2*/
        while (tmp1.next != null){
            tmp1 = tmp1.next;
            random_index1.put(index,tmp1.random);
            node_index1.put(index,tmp1);

            tmp2.next = new Node(tmp1.val);
            tmp2 = tmp2.next;
            node_index2.put(index,tmp2);
            index++;
        }

        Node tmp_random1 = l1.next;
        Node tmp_random2 = l2.next;

        int tmp_index = 0;
        Node flag = new Node(0);

        /*
        * 第二次遍历
        * 1。random为null的直接置null
        * 2。找到l1正序遍历时，索引号为tmp_index的node.random节点记录为flag节点，接着去遍历node_index1，找到与flag节点对象一致的的索引号
        * 那么node_index2的对应的索引号对应的节点即是当前节点的random节点*/
        while (tmp_random1 != null){
            if (tmp_random1.random == null){
                tmp_random2.random = null;
                tmp_random1 = tmp_random1.next;
                tmp_random2 = tmp_random2.next;
                tmp_index++;
                continue;
            }
            flag = random_index1.get(tmp_index);

            for (int i = 0; i <= index ; i++) {
                if (node_index1.get(i) == flag){
                    tmp_random2.random = node_index2.get(i);
                    break;
                }
            }

            tmp_random1 = tmp_random1.next;
            tmp_random2 = tmp_random2.next;
            tmp_index++;

        }
        return l2.next;
    }
}
