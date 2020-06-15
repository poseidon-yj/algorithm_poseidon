package leetcode.二叉树.q145_后序遍历;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ImproveSolution_Iter {
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null){
            return  res;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            //注意和前序的差异
            res.addFirst(node.val);

            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }

        return res;
    }
}
