// Time Complexity : O (n) 
// Space Complexity : O (H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : while swap, the swap without temp variable failed
// in cases where the indices were same

// can be dine by bfs also

import java.util.*;
public class prob1 {
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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
        
    }

    public void dfs(TreeNode root, int level){
        if(root == null) return;
      
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    
}
