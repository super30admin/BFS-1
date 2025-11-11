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
public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        if(root == null) return [];
        Queue<TreeNode> levelQueue = new Queue<TreeNode>();
        levelQueue.Enqueue(root);
        List<IList<int>> result = new List<IList<int>>();
        while(levelQueue.Count>0)
        {
            List<int> temp = new List<int>();
            int size = levelQueue.Count;
            int count=0;
            while(count<size)
            {
                TreeNode node = levelQueue.Dequeue();
                count++;
                temp.Add(node.val);
                if(node.left!=null)
                {
                levelQueue.Enqueue(node.left);
                }
                if(node.right!=null)
                {
                levelQueue.Enqueue(node.right);
                }
            }
            result.Add(temp);      

        }
        return result;
        
    }
}