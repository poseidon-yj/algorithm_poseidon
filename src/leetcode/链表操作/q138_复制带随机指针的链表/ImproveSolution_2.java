package leetcode.链表操作.q138_复制带随机指针的链表;
/*
* 回溯法：图的遍历
* 时间复杂度：O(N)O(N) ，其中 NN 是链表中节点的数目。
空间复杂度：O(N)O(N) 。如果我们仔细分析，我们需要维护一个回溯的栈，同时也需要记录已经被深拷贝过的节点，也就是维护一个已访问字典。渐进时间复杂度为 O(N)O(N) 。

* 回溯算法的第一想法是将链表想象成一张图。链表中每个节点都有 2 个指针（图中的边）。因为随机指针给图结构添加了随机性，所以我们可能会访问相同的节点多次，这样就形成了环。



上图中，我们可以看到随机指针指向了前一个节点，因此成环。我们需要考虑这种环的实现。

此方法中，我们只需要遍历整个图并拷贝它。拷贝的意思是每当遇到一个新的未访问过的节点，你都需要创造一个新的节点。
遍历按照深度优先进行。我们需要在回溯的过程中记录已经访问过的节点，否则因为随机指针的存在我们可能会产生死循环。

算法

从 头 指针开始遍历整个图。

我们将链表看做一张图。下图对应的是上面的有向链表的例子，Head 是图的出发节点。



当我们遍历到某个点时，如果我们已经有了当前节点的一个拷贝，我们不需要重复进行拷贝。
如果我们还没拷贝过当前节点，我们创造一个新的节点，并把该节点放到已访问字典中，即：
visited_dictionary[current_node] = cloned_node_for_current_node.
我们针对两种情况进行回溯调用：一个顺着 random 指针调用，另一个沿着 next 指针调用。
步骤 1 中将 random 和 next 指针分别红红色和蓝色标注。然后我们分别对两个指针进行函数递归调用：
cloned_node_for_current_node.next = copyRandomList(current_node.next);
cloned_node_for_current_node.random = copyRandomList(current_node.random);


*/

import java.util.HashMap;

public class ImproveSolution_2 {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
