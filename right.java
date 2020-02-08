/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//timr:O(n)
  // space: O(n)  
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode node=null;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int n=queue.size();
            // level order and adding last one
            for(int i=0;i<n;i++)
            {
                node=queue.poll();
                if(i==0) list.add(node.val);
               
                if(node.right!=null) queue.add(node.right);
                 if(node.left!=null) queue.add(node.left);
            }
            //list.add(node.val);
            //System.out.print(queue);
        }
        return list;
    }
}