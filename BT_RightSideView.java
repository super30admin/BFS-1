// Time Complexity :O(n) n - number of tree nodes
// Space Complexity :O(2^h) h - height of the tree
// Did this code successfully run on Leetcode :yes 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(i==size-1)
                    list.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        

        return list;
        
    }
}