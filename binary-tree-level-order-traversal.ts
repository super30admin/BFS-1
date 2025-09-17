/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - O(n), n = number of nodes in the tree
// Space complexity - O(h), height of the Tree
function levelOrder(root: TreeNode | null): number[][] {
	let result = [];

	helper(root, 0, result);

	return result;

	function helper(root: TreeNode, level: number, result: number[][]) {
		if (root === null) return;

		if (result.length === level) {
			result[level] = [];
		}

		result[level].push(root.val);

		helper(root.left, level + 1, result);
		helper(root.right, level + 1, result);
	}
}
