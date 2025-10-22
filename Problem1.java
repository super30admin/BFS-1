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
 /*
102. Binary Tree Level Order Traversal
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
At each level process the node and add the node to the list and add all of its children in the queue, do the same till we have processed aall the nodes
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return result;
    }

    private void bfs(TreeNode root){
        if(root == null) return; // if root node is null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){ // check if queue is empty
            int size = queue.size();
            List<Integer> sameLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sameLevel.add(node.val); // add the node to the list
                if(node.left != null){ // add left child if left child is not empty
                    queue.offer(node.left);
                }
                if(node.right != null){ // add right child if right child is not empty
                    queue.offer(node.right);
                }
            }
            result.add(sameLevel);
        }
    }
}