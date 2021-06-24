// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/**
 * DFS Solution
 * We are doing a Depth first search (Preorder traversal) and assign level to each of the nodes starting from 0.
 * We add the node's value to the respective arraylist in result list.
 **/


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        preorder(root, 0);
        
        return result;
    }
    
    public void preorder(TreeNode root, int level) {
        //base
        if(root == null) return;
        
        if(level == result.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        } else {
            result.get(level).add(root.val);
        }
        
        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }
}
