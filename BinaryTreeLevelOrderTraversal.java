// Time Complexity : O(N)
// Space Complexity : O(N/2) or O(N)- Elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
//BFS Approach using Queue
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> li = new ArrayList<>();

            for(int i=0;i< size;i++) {
                TreeNode temp = queue.poll();
                li.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(li);
        }

        return result;

    }


}

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
// T= O(N)
// S = O(H)
// DFS approach using recurssion
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int height ) {

        if(root == null) return;

        if(height == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(root.val);
        helper(root.left, height+1);
        helper(root.right, height+1);
    }

}