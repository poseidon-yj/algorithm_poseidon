package leetcode.二叉树.q94_中序遍历;

import java.util.ArrayList;
import java.util.List;

/*
* */
public class InitSolution {
    public List<Integer> inorderTraversal(TreeNode root){
        if (root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();

        inorderTraversal(root,res);

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root,List<Integer> res){
        if (root == null){
            return res;
        }

        inorderTraversal(root.left,res);
        res.add(root.val);
        inorderTraversal(root.right,res);
        return res;
    }
}
