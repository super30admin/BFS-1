/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Add root node to the queue. Calculate the size of queue. Iterate over the queue size times. Add it to the result. Add left and right child
 * to the queue until it's empty.
 */

/**
 * DFS
 */
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {

        result = new ArrayList<>();
        helper(root, 0);

        return result;
    }

    private void helper(TreeNode root, int depth) {

        if(root == null) return;

        if(result.size() == depth)
            result.add(new ArrayList<>());
        result.get(depth).add(root.val);

        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}


/**
 * BFS
 */
/*
//TC: O(n)
//SC: O(n/2) -> O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<size; i++) {

                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            result.add(list);
        }

        return result;
    }
}*/
