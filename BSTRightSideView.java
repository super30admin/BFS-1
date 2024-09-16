

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

// Time Complexity : o(n)
// Space Complexity : o(H) height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 199
//Approach : DFS left side first

class Solution {
    
      //variables to store the x and y parents and levels
      TreeNode x_parent, y_parent;   
      int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
      //Edge  
      if(root == null) return false;

      dfs(root, null , x, y, 0); 
              
      return (x_parent != y_parent && x_level == y_level);  
    }
          
      private void dfs(TreeNode root, TreeNode parent , int x , int y, int level){
          
          //base
          if(root == null) return;
          //logic 
         if(root.val == x){
            x_parent = parent;
            x_level = level;
          } 
          if(root.val == y ){
             y_parent = parent;
             y_level = level;
          } 
          dfs(root.left, root, x,y, level+1);
          dfs(root.right, root, x,y, level+1);                 
    }
}

// Time Complexity : o(n)
// Space Complexity : o(H) height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 199
//Approach : DFS right side first

class Solution {
    List<Integer> result ;
    public List<Integer> rightSideView(TreeNode root) {
        result =  new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        dfs(root,0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        
        //base
        if(root == null) return ;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}

// Time Complexity : o(n)
// Space Complexity : o(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 199
//Approach : BFS Left side first



class Solution {
     List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
            return result;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int last=-1;
            for(int i = 0 ; i < size; i++){
               
                TreeNode curr = q.poll();
                if(i == size-1){
                    last = curr.val;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(last);
        }
        return result;
    }
}
