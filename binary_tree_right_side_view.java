class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> output = new ArrayList<Integer>();
        
        if(root == null) return output;
        
        queue.add(root);
        TreeNode cur=null;
        while(!queue.isEmpty())
        {
            int qsize = queue.size();
            for(int i=0; i< qsize; i++)
            {
                cur = queue.poll();
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            output.add(cur.val);
        }
        return output;
    }
}

// TC- O(N)
//SC- O(N)
/* The approach is same as binary tree traversal except that all nodes values at every traversal don't need to be stored. Only the last node's value will be stored. */
