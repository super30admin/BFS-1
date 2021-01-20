// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a recursive function with a local variable as height of the tree, and goto the leftmost sub tree, while incrementing the height and then goto the right subtree. For each new height encountered, create a List and add to that list if nodes of same height are found.

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        helper(root, 1);
        return result;
    }    
    
    private void helper(TreeNode root, int height){
        
        if(root == null) return;
        
        if(height > result.size()){
            result.add(new ArrayList<Integer>(Arrays.asList(root.val)) );

        } else{
            result.get(height-1).add(root.val);
        }
                
        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }
}
