// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
// Creating new arraylists inside an arraylist for each level and adding the values from left to right.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return; 
        //logic
        if(result.size() == level){
            result.add(new ArrayList<>()); //add an array list if size of result is same as depth, case 1 size = 0 (empty) and level = 0 so we add first arraylist;
        }
        result.get(level).add(root.val); //based on level, add to that arraylist
        dfs(root.left, level + 1);//recursion for left node
        dfs(root.right, level + 1);//recursion for right node
    }
   
}