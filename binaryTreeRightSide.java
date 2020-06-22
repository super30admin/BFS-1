// Time Complexity : O(n)
// Space Complexity : O(1) , do we add queue space used?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues, followed level order way

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<Integer>();
        
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            TreeNode curr=null;
            for(int i=0;i<size;i++)
            {
                curr=queue.poll();
                
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            
            result.add(curr.val);
        }
        
        return result;
    }
}