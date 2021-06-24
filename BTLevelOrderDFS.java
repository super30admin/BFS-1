//Time Complexity - O(n) 
//Space Complexity - O(n) 


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
//DFS solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
      result = new ArrayList<>();
      if(root == null) return result;
      
      dfs(root,0);
      return result;
    }
  private void dfs(TreeNode root, int level) {
     //base 
     if(root == null) return;
    //logic
    if(level == result.size()) {
      //check the resultant arr size if its equal there is no list in that level
      //create new list
      result.add(new ArrayList<>());
    }
    //add the elements in list then result list
    result.get(level).add(root.val);
    dfs(root.left, level+1);
    dfs(root.right, level+1);
        
   }
}