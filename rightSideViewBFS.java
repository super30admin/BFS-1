/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(i==0) result.add(temp.val);
                if(temp.right!=null) q.add(temp.right);
                if(temp.left!=null) q.add(temp.left);
            }
            
        }
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)