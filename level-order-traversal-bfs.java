import java.util.*;

class Solution {
    // BSF Solution
    // Time complexity is O(n)
    // Space complexity is O(n) i.e n/2 elements in queue but we neglect /2 and it is O(n)
    // This solution is submitted on leetcode with no errors
    public class TreeNode {
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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        // edge case
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); // level 1 initially
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            result.add(level);
        }
        return result;
    }
}