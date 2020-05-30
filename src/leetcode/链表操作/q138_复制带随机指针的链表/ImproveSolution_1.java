package leetcode.链表操作.q138_复制带随机指针的链表;

import java.util.HashMap;

/*
* 一次遍历
* O（N）空间存放老，新节点的映射关系*/
public class ImproveSolution_1 {
    HashMap<Node,Node> visited = new HashMap<>();

    public Node getNode(Node node){
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node l1 = new Node(0);
        Node l2 = new Node(0);

        Node oldNode = l1.next = head;
        Node newNode = l2.next = new Node(head.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null){
            newNode.random = this.getNode(oldNode.random);
            newNode.next = this.getNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return l2.next;
    }
}
