package org;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSys {

	/**
	 * 遍历二叉树
	 * 
	 * @param root
	 */

	public static void printTree(TreeNode root) {

		Queue<TreeNode> quere = new LinkedList<TreeNode>();
		TreeNode tmp = root;
		quere.offer(tmp);
		while (quere.size() != 0) {

			tmp = quere.poll();
			System.out.println(tmp.val);

			if (tmp.left != null) {
				quere.offer(tmp.left);
			}

			if (tmp.right != null) {
				quere.offer(tmp.right);
			}

		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		TreeNode left2 = root.left;
		TreeNode right2 = root.right;

		left2.left = new TreeNode(4);
		right2.left = new TreeNode(5);
		right2.right = new TreeNode(6);

		TreeNode left3 = right2.left;
		left3.left = new TreeNode(7);
		left3.right = new TreeNode(8);

		printTree(root);

	}

}
