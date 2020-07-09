package leetcode.二叉树.q101_对称二叉树;

public class ImproveSolution_Recursive {
    public boolean isSymmetric(TreeNode root){
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
