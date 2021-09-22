// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // intialize the array to be returned
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return empty list is tree is empty
        if(root == null) return result;
        // call the recursive function
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        // return if leaf node
        if(root == null) return;
        // logic
        // if sub-list corresponding to level does not exist
        // then add a sub-list
        if(result.size() == level){
            List<Integer> li = new ArrayList<>();
            result.add(li);
        }
        // add the node's value to the list corresponding to its level
        result.get(level).add(root.val);
        // call the recursive function on the left child
        dfs(root.left, level + 1);
        // call the recursive function on the right child
        dfs(root.right, level + 1);
    }
}