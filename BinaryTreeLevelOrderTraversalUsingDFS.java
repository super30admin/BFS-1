// Time Complexity : O(h) height of the tree
// Space Complexity : O(n) number of nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
1. recursive approach (increase level at every new call)
2. maintain a hashmap to store the list of nodes where each level will be a new key

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
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    HashMap<Integer,List<Integer>> set = new HashMap<>();
     List<Integer> nodes = null;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        helper(root , 0);
        
        levels.addAll(set.values());
        return levels;
    }
    
    public void helper(TreeNode root , int level)
    {
       
        if(root == null)
            return;
     
      //  System.out.println(root.val + " " + level);
        if(set.containsKey(level))
        {
            nodes = set.get(level);
            nodes.add(root.val);
            set.put(level,nodes);
        }
        else
        {
            nodes = new ArrayList<>();
             nodes.add(root.val);
            set.put(level,nodes);
        }
        helper(root.left,level+1);
         helper(root.right,level+1);
        
      
    }
}