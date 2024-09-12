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

// This solution uses BFS, a queue is used where each level will be tracked by the size of the queue at that point
// then, a new list with all of the elements at each processed level will be added to the result list.


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        // base case
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
        	int countNodes = queue.size();
        	List<Integer> currentLevel = new LinkedList<>();
        	for(int i = 0; i < countNodes; i++) { // process current level
        		TreeNode current = queue.poll();
        		currentLevel.add(current.val);

        		if(current.left != null) {
        			queue.add(current.left);
        		}

        		if(current.right != null) {
        			queue.add(current.right);
        		}
        	}
        	result.add(currentLevel);
        }
        return result;
    }
}