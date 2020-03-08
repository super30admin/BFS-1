/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(n)

// This soultion uses BFS, the tree is traversed level by level and the last element at each level is added to the result list.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        // base case
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
        	int countNodes = queue.size();
        	for(int i = 0; i < countNodes; i++) {
        		TreeNode currentNode = queue.poll();
        		// add result?
        		if(i == countNodes -1) {
        			result.add(currentNode.val);
        		}

        		if(currentNode.left != null) {
        			queue.add(currentNode.left);
        		}

        		if(currentNode.right != null) {
        			queue.add(currentNode.right);
        		}
        	}
        }

        return result;
    }
}