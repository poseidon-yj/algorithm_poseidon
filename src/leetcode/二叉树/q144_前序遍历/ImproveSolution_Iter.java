package leetcode.二叉树.q144_前序遍历;
/*
* 迭代法*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImproveSolution_Iter {
    public List<Integer> preorderTraversal(TreeNode root){

        if (root == null){
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        //先压节点本身
        stack.push(root);

        /*
        * 先右节点压栈，再左节点压栈，这样下一次循环就是先弹出左节点*/
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}
