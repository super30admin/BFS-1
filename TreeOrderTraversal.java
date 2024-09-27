
// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// Go thorough recursion logic much more	

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
     private Map<Integer, List<Integer>> map;
    
    public Solution()
    {
        this.map = new HashMap<>();
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderRec(root, 0);
        List<List<Integer>> result = new ArrayList<>();
        
        int index = 0;
        while (map.containsKey(index))
        {
            result.add(map.get(index));
            index++;
        }
        
        return result;
    }
    
    private void levelOrderRec(TreeNode node, int height)
    {
        if (node == null) return;
        
        if (this.map.containsKey(height))
        {
            this.map.get(height).add(node.val);
        } else
        {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(node.val);
            this.map.put(height, newLevel);
        }
        
        levelOrderRec(node.left, height + 1);
        levelOrderRec(node.right, height + 1);
    }
}