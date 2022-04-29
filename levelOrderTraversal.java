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
//TC : O(N) SC :O(N)
class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<> ();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode current = q.poll();
                l.add(current.val);
                if(current.left!=null)
                    q.add(current.left);
                if(current.right!=null)
                    q.add(current.right);
            }
            finalList.add(l);
        }
        return finalList;
    }
}