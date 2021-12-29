// Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n/2) maximum number of elements in a queue at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
     // Definition for a binary tree node.
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
    //BFS
    List<List<Integer>>result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result= new ArrayList<>();
        if (root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            // size variable for maintining distinction between lists
            int size=q.size();
            List<Integer> temp= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                temp.add(node.val);
                
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            // after covering all elements in a level , add the temp list to resultant list
            result.add(temp);
        }
      return result;  
    }
    // DFS
    //Used level variable to maintain the levels
    // Adding elements to desired level list in the final list
    List<List<Integer>>result1;
    public List<List<Integer>> levelOrder1(TreeNode root) {
        result= new ArrayList<>();
        if (root==null)
            return result1;
       
    dfs(root,0);
      return result1;  
    }
    private void dfs(TreeNode root,int level)
    {
        // base 
        if(root==null)
            return;
        
        // logic
        if(level==result1.size())
            result1.add (new ArrayList<>());
        
        result1.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}