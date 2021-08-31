/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //Time Complexity : O(n)
 //Space Complexity: O(n)
public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
         if (root == null)
                return new List<IList<int>>();
            List<IList<int>> result = new List<IList<int>>();
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                int size = q.Count;
                List<int> li = new List<int>();
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    li.Add(curr.val);
                    if (curr.left != null)
                        q.Enqueue(curr.left);
                    if (curr.right != null)
                        q.Enqueue(curr.right);
                }
                result.Add(li);
            }
            return result;
    }
}