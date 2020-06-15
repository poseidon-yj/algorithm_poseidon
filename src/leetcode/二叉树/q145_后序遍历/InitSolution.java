package leetcode.二叉树.q145_后序遍历;

import java.util.ArrayList;
import java.util.List;

public class InitSolution {
    public List<Integer> postorderTraversal(TreeNode root){
        if (root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();

        postorderTraversal(root,res);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> res){
        if (root == null){
            return res;
        }

        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
        return res;
    }
}
