// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.*;

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

class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer> > result = new ArrayList<>();
        if (root == null) 
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List currLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currLevel.add(curr.val);
                
                if (curr.left != null)
                    q.add(curr.left);
                
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(currLevel);
        }
      return result;     
    }
}