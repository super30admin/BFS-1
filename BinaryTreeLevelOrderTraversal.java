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
//Time Complexity-O(n) where n is the number of nodes
//Space complexity-O(n) 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>output=new ArrayList();
        if(root==null)
        {
            return output;
        }
        Queue<TreeNode>queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer>temp=new ArrayList();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();  
                temp.add(node.val);
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            output.add(temp);
        }
        return output;
        
    }
    
}