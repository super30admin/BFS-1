//TC: O(V+E)
//SC: O(n)
//Sucessfully ran on leetcode
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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> output=new ArrayList<>();

        if(root==null)
            return output;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int count=q.size();
            List<Integer> levelTrack=new ArrayList<>();

            for(int i=0;i<count;i++)
            {
                TreeNode node=q.poll();
                levelTrack.add(node.val);

                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }

            output.add(levelTrack);
        }
        return output;
    }
}
