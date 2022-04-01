//Time complexity = O(n)
//Space complexity = O(n) worst case

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

        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        if(root == null)
            return result;

        q.add(root);

        while(!q.isEmpty())
        {
            int len = q.size();
            List<Integer> level = new ArrayList();

            for(int i=0; i<len; i++)
            {
                TreeNode current = q.remove();

                level.add(current.val);

                if(current.left != null)
                    q.add(current.left);

                if(current.right != null)
                    q.add(current.right);
            }

            result.add(level);
        }

        return result;

    }
}
