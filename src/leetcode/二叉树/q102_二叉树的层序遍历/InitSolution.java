package leetcode.二叉树.q102_二叉树的层序遍历;
/*
* */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InitSolution {
    public List<List<Integer>> levelOrder(TreeNode root){

        Deque<TreeNode> deque = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        //TreeNode node = root;
        deque.add(root);

        while (!deque.isEmpty()){
            int level_size = deque.size();
            List<Integer> res_level = new ArrayList<>();
            for (int i = 0; i < level_size ; i++) {
                TreeNode node = deque.pollFirst();
                res_level.add(node.val);
                if (node.left != null){
                    deque.add(node.left);
                }
                if (node.right != null){
                    deque.add(node.right);
                }
            }
            res.add(res_level);

        }
        return res;
    }
}
