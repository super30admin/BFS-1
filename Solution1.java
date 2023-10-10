// Leetcode Problem : https://leetcode.com/problems/binary-search-tree-iterator/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I create a Queue and add root to it. If root is null, I simply return ans. Else I iterate till q is not empty, I initialize size = q.size(). I create a temporary array tempArray at the start of each iteration. Now while i = 0 to size-1, I remove temp from queue and
 * add left child and right child of temp (if present) to the queue. I add temp.val to tempArray list. After the for loop, I add tempArray to ans.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
        {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> tempArray = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                tempArray.add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            ans.add(tempArray);
        }
        return ans;
    }
}