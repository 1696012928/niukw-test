package org;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * @author administered
 * 
 *         ��һ�ö������������һ���㷨�����ղ�δ�ӡ��ö�������
 *         �����������ĸ����root���뷵�ش�ӡ������������ÿһ��һ��������д��棬���������˳���ղ�����������
 *         ����ÿһ���������Ԫ�ذ��մ����������С���֤�����С�ڵ���500��
 * 
 *
 */
public class TreePrinter {
	public static int[][] printTree(TreeNode root) {

		List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();

		List<TreeNode> li = new ArrayList<TreeNode>();

		Queue<TreeNode> quere = new LinkedList<TreeNode>();
		TreeNode tmp = root;
		TreeNode last = root;
		TreeNode nlast = null;
		quere.offer(tmp);
		while (quere.size() != 0) {

			tmp = quere.poll();

			li.add(tmp);

			if (tmp.left != null) {
				quere.offer(tmp.left);
				nlast = tmp.left;
			}

			if (tmp.right != null) {
				quere.offer(tmp.right);
				nlast = tmp.right;
			}

			if (tmp.val == last.val) {
				last = nlast;
				result.add(li);

				li = new ArrayList<TreeNode>();

			}

		}

		int[][] resultarr = new int[result.size()][];

		for (int i = 0; i < result.size(); i++) {
			int[] a = new int[result.get(i).size()];
			for (int j = 0; j < result.get(i).size(); j++) {
				a[j] = result.get(i).get(j).val;
			}

			resultarr[i] = a;

		}

		return resultarr;

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

		int[][] printTree = printTree(root);

		for (int[] string : printTree) {
			System.out.println();
			for (int i : string) {
				System.out.print(i);
			}
		}

	}

}