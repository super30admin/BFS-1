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
//This Java solution utilizes a breadth-first search (BFS) approach to perform level order traversal of a binary tree, storing values at each level in a list of lists (result). 
//It uses a queue (q) to manage the traversal, enqueuing nodes, processing each level, and appending the corresponding values to the result. 
//The final result represents the binary tree's level order traversal.
/**
 * Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once.
Space Complexity: O(W) - where W is the maximum width (number of nodes at any level) of the binary tree in the queue at any point during traversal. 
In the worst case, the width could be at most N/2, and hence, the space complexity is O(N).
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode curr = q.poll();
               li.add(curr.val);
               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);

            }
            result.add(li);
        }
        return result;

    }
}