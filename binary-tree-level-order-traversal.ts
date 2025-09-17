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
// Space complexity - O(n)
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

function levelOrder(root: TreeNode | null): number[][] {
	let result = [];
	if (root === null) return result;
	let q = [root];

	while (q.length > 0) {
		// get the current number of nodes in thw queue, it represents number of nodes at current level
		let size = q.length;
		// initialize an array to store val of nodes at current level
		let level: number[] = [];

		// traverse through all nodes at current level
		for (let i = 0; i < size; i++) {
			// dequeue the first element from the queue and add it to level
			let curr = q.shift();
			level.push(curr.val);

			// traverse through left or right of node exists
			if (curr.left !== null) q.push(curr.left);
			if (curr.right !== null) q.push(curr.right);
		}
		// all nodes at current levels are traversed, add the level array to result
		result.push(level);
	}
	return result;
}
