// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
            result = new ArrayList<>();
//         List<List<Integer>> nodes = new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         if(root == null){
//             return nodes;
//         }
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();

//             List<Integer> levels = new ArrayList<>();
//             for(int i = 0; i < size; i++){
//                 TreeNode out = queue.poll();
//                 levels.add(out.val);
//                 if(out.left != null){
//                     queue.add(out.left);
//                 }
//                 if(out.right != null){
//                     queue.add(out.right);
//                 }
                
//             }
//             nodes.add(levels);
//         }
//         return nodes;
        helper(root, 1);
        return result;
        
    }
    private void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level > result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}