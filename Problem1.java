// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Process the node at the level and create an arraylist if the list doesn't exist for the array. 
If level exists, retreive list and add node to it. 
Traverse and process left child and right child. 
 * 
 */

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int level;
     public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return result;
     }
     private void helper(TreeNode root, int level){
        if (root == null )
            return;
        if (result.size() == level){
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
        }
     }
}
