package leetcode.二叉树.q144_前序遍历;
/*
* 给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
*/

import java.util.ArrayList;
import java.util.List;

public class InitSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();

        preorderTraversal(root,res);

        return res;

    }

    public List<Integer> preorderTraversal(TreeNode root, List<Integer> res){

        if (root == null){
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
        return res;
    }
}
