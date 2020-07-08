package leetcode.二叉树.q450_删除二叉搜索树的节点;
/*
* 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。*/

public class InitSolution {
    public TreeNode deleteNode(TreeNode root, int key) {

        /*
        * 删除节点一共三种情况
        * 1。节点为叶子节点
        * 2。节点仅有一个子树
        * 3。节点有两个子树，此时需要找到右子树的最小节点的值替换要删除的节点的值*/
        TreeNode PP = null;
        TreeNode p = root;

        while (p != null && p.val != key){
            PP = p;
            if (p.val > key){
                p = p.left;
            }else p = p.right;
        }

        if (p == null) { return root; }


        if (p.left != null && p.right != null){
            //找到p点右子树上的最小节点
            TreeNode MinPP = p;
            TreeNode Minp = p.right;
            while (Minp.left != null){
                MinPP = Minp;
                Minp = Minp.left;
            }

            p.val = Minp.val;//交换数据
            p = Minp;//把p引用改到最小节点，把要删除的三种情况合并为后续一种代码
            PP = MinPP;
        }

        TreeNode child;
        //此时已不存在两个子树都不为null的情况了
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (PP == null) root = child; //删除根节点
        else if (PP.left == p) PP.left = child;
        else PP.right = child;

        return  root;



    }
}
