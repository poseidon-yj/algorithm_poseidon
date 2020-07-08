package leetcode.二叉树.q450_删除二叉搜索树的节点;
/*
* 递归解法*/

public class ImproveSolution_Recursive {

    //找后继节点
    public TreeNode successor(TreeNode root){
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    //找前驱节点
    public TreeNode predecessor(TreeNode root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;

        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null){
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            }else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

}
