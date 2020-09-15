//Time Complexity: O(n) where n is the maximum diameter in the tree
//Space Complexity: O(1)
import java.util.*;

public class RightSideViewofBT {
    List<Integer> l = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        levelOrder(root);
        return l;
    }
    
    public void levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //res is the result that we need and 0 is the levels
        helper(root,res,0);

        //taking the right most elements from each level to get right view
        for(List<Integer> x : res){
            if(x!=null)
                l.add(x.get(x.size()-1));
        }
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