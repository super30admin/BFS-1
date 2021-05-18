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
    //Time O(N)
    //Space O(N/2)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty())
        {
            int size = Q.size();
            List<Integer> lis = new ArrayList<>();
            for(int i=0 ; i<size ; i++)
            {
                TreeNode temp = Q.poll();
                lis.add(temp.val);
                if(temp.left != null) Q.add(temp.left);
                if(temp.right != null) Q.add(temp.right);
            }
            result.add(lis);
        }
        return result;
    }
}