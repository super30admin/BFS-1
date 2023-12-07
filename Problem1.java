// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//By DFS. Have a helper function with a level variable and at each node 
//based on the level add each root value to new list and add to result.
//if exists then get and add that the array list in result,

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem1 {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    // Driver method for testing
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        
        Problem1 solution = new Problem1();

        
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
