import java.util.ArrayList;
import java.util.List;

/**
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
 
Time Complexity :   O (N) 
Space Complexity :  O(h) 
Did this code successfully run on Leetcode :    Yes (102. Binary Tree Level Order Traversal)
Any problem you faced while coding this :       No
 */

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

public class LevelOrderTraversal_DFS {
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        // base case
        if(root == null)
            return;
        
        //logic
        if(depth == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
