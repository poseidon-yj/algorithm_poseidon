package leetcode.二叉树.q101_对称二叉树;
/*
* 给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

*/


import java.util.ArrayList;
import java.util.Collections;

public class InitSolution {
    private void inOrder(TreeNode node, ArrayList<Integer> res){
        if (node.left != null){
            inOrder(node.left,res);
        }else if (node.left == null && node.right != null){
            res.add(null);
        }
        res.add(node.val);
        if (node.right != null){
            inOrder(node.right,res);
        }else if(node.left != null && node.right == null){
            res.add(null);
        }
    }


    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;

        ArrayList<Integer> resLeft = new ArrayList<>();
        ArrayList<Integer> resRight = new ArrayList<>();

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left == null || right == null || left.val != right.val) return false;

        inOrder(left,resLeft);
        inOrder(right,resRight);

        Collections.reverse(resRight);
        System.out.println(resLeft);
        System.out.println(resRight);

        return resLeft.equals(resRight);
    }
}
