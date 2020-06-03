package org.zero.leetcode.二叉树;

/**
 * @author 水寒
 * @date 2020/6/2
 * @see https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
    	if(root == null){
    	    return null;
    	}
        TreeNode tmp = root.left;
	    root.left = root.right;
	    root.right = tmp;
	    invertTree(root.left);
	    invertTree(root.right);
        return root;
    }
}
