/**
T: o(n) - each node is visited once
S: breadth of queue - O(n/2) -> O(n)
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        //null input check
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        //iterate until q is empty
        while(!q.isEmpty()){
            //for level order
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode front = q.poll();
                level.add(front.val);
                
                //add the node's left and rigth only if they are not null
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            //add the respective level list to result
            result.add(level);
        }
        return result;
    }
}