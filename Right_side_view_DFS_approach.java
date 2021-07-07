/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
                        // dfs solution     
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helper(root,0,list);
        return list;
    }
    private void helper(TreeNode root,int depth,List<Integer> list){
        if(root == null) return ;   
        
        if(depth == list.size())  list.add(root.val);
        helper(root.right,depth+1,list);
        helper(root.left,depth+1,list);
        
    }
}
