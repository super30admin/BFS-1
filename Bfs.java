// Time Complexity : O(n)  n=no of elements in tree.
// Space Complexity :O(n)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
       List<List<Integer>> result=new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        { 
            List<Integer> res=new ArrayList<>();
            int size=queue.size();
            for(int i=1;i<=size;i++)
            {
            TreeNode temp=queue.poll();
                res.add(temp.val);
            if(temp.left!=null)
            {
                queue.add(temp.left);
            }
            if(temp.right!=null)
            {
                queue.add(temp.right);
            }
            }
            result.add(res);
        }
        return result;
    }
}