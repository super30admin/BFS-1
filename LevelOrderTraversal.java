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

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();

        if(root==null)
            return output;

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode current = queue.poll();

                if(current.left!=null)
                    queue.add(current.left);

                if(current.right!=null)
                    queue.add(current.right);

                level.add(current.val);
            }

            output.add(level);
        }


        return output;
    }
}