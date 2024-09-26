//Time Complexity: O(n) where n is the maximum diameter in the tree
//Space Complexity: hasNext: O(1) 

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalBT {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //res is the result that we need and 0 is the levels
        helper(root,res,0);
        return res;
    }
    
    TreeNode temp = null;
    public void helper(TreeNode root, List<List<Integer>> result, int level){
        if(root==null) 
            return;
        //level == size of the result then return empty Arraylist
        if(result.size()==level)
           result.add(new ArrayList<Integer>());
        //if arraylist is present then add value to it
        result.get(level).add(root.val);
        //traverse left and increment the level
        helper(root.left,result,level+1);
        //traverse right and increment the level
        helper(root.right,result,level+1);
    }
    public static class TreeNode {
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
}