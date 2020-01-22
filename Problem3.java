// Time Complexity :
//      n is the number of nodes in tree
//      rightSideView() - O(n)
//      
// Space Complexity :
//      rightSideView() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        
        if(root == null)
            return li;
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        
        int s = qu.size();
        
        while(!qu.isEmpty())
        {
            for(int i=0 ; i < s; ++i)
            {
                TreeNode node = qu.poll();
                
                if(i == 0)
                    li.add(node.val);
                
                if(node.right != null)
                    qu.offer(node.right);
                
                if(node.left != null)
                    qu.offer(node.left);
            }
            
            s = qu.size();
        }
        
        return li;
    }
}