// Time Complexity :O(n) n is the nodes of the tree
// Space Complexity :O(h) h is the height of the recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {    
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode node,int level){
        if(node == null) return;
        
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left,level+1);
        dfs(node.right,level+1);
    }
}