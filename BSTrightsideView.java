/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC  O(n)
//SC O(h)
class Solution {
    int max = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list, 0);
        return list;
    }
    
    void dfs(TreeNode root, List<Integer> list, int height) {
        
        if(root == null) return;
        
        if (height == list.size()) {
            list.add(root.val);
        }
        
        dfs(root.right, list, height+1);
        dfs(root.left, list, height+1);
    }
}

