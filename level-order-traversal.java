// Time Complexity : O(n)
// Space Complexity : O(n) as n/2 leaf nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
    
        while(!queue.isEmpty())
        {
             ArrayList<Integer> list=new ArrayList<>();
            int size=queue.size();
             for(int i=0;i<size;i++)
             {
                 TreeNode current=queue.poll();
                 list.add(current.val);
                 
                 if(current.left!=null)
                     queue.add(current.left);
                 if(current.right!=null)
                     queue.add(current.right);
             }
            result.add(list);
        }
        
        return result;
    }
}