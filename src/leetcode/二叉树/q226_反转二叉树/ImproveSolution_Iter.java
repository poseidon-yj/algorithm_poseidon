package leetcode.二叉树.q226_反转二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class ImproveSolution_Iter {
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return root;
    }
}
