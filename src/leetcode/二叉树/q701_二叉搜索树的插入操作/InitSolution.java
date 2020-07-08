package leetcode.二叉树.q701_二叉搜索树的插入操作;
/*
* 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

*/

public class InitSolution {
    public TreeNode insertIntoBST(TreeNode root, int key){
        if (root == null) return root = new TreeNode(key);

        if (key >= root.val) root.right = insertIntoBST(root.right, key);
        else root.left = insertIntoBST(root.left, key);

        return root;
    }
}
