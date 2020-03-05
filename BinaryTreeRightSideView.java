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
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach1: BFS
// The tree can be traversed level by level and the last element at each level can be added to the result list.
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // result list
        List<Integer> result = new ArrayList<>();
        // edge case
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(i == size-1) result.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return result;
    }
}
*/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach1: DFS
// In a DFS manner, we can explore each node by keeping track of the levels. If the result size is same as level, we need to add the current value in the result list.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // edge case
        if(root == null) return new ArrayList<>();
        return dfs(root, new ArrayList<>(), 0);
    }
    
    private List<Integer> dfs(TreeNode root, List<Integer> result, int level) {
        // base case
        if(root == null) return result;
        if(level == result.size()) result.add(root.val);
        dfs(root.right, result, level+1); // exploring right child first as we need the right side view of the tree
        dfs(root.left, result, level+1);
        return result;
    }
}

