// Time complexity: O(N), where N is the number of nodes in tree.
// Space complexity: O(N) for queue.

import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>(); 
        if(root == null) return output; 
        
        // initializing queue
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); 
        
        while (!q.isEmpty()) {
            // initializing new queue to store next level tree nodes
            Queue<TreeNode> nextq = new LinkedList<>(); 
            int index = output.size(); 
            output.add(new ArrayList<Integer>());
            // while current queue is not null
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                output.get(index).add(node.val);
                if (node.left != null)
                    nextq.offer(node.left);
                if (node.right != null)
                    nextq.offer(node.right);
            }
            // updating the current queue.
            q = nextq; 
        }
        
        return output;
    }
}