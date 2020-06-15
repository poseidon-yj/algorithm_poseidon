package leetcode.二叉树.q94_中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* 迭代法：先不停遍历左节点，将第一层左节点压入栈，然后开始弹栈，检查右节点是否有左节点，如有，继续入栈*/
public class ImproveSolution_Iter {
    public List<Integer> inorderTraversal(TreeNode root){
        if (root == null){
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);

        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
