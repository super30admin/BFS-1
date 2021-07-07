// Time Complexity is O(N) as we visiting all the nodes.
// Space complexity is O(h), i.e the height of the tree if we are considering the recursion stack
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN58RightSideViewUsingRecursion {
	class Solution {
	    List<Integer> result = new ArrayList<>();
	    public List<Integer> rightSideView(TreeNode root) {
	        helper(root,0);
	        return result;
	    }
	    private void helper(TreeNode root, int depth){
	        // base case:
	        if(root == null)
	            return;
	        // logic:
	        if(depth == result.size())
	            result.add(root.val);
	        helper(root.right, depth+1);
	        helper(root.left,depth+1);
	    }
	}
}