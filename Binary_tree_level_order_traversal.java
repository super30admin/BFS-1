class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null)
            return output;
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int qsize = queue.size();
            List<Integer> level_nodes = new ArrayList<>();
            for(int i = 0; i<qsize; i++){
                TreeNode cur = queue.poll();
                level_nodes.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left); 
                if(cur.right != null)
                    queue.add(cur.right);
            }
            output.add(level_nodes);
        }
        
        return output;
    }
}


// TC- O(N)
//SC ~ O(N)
/* Since each of the nodes is visited the time complexity is O(N).
The essential step is appending the output at the end of each of each breadth traversal.
poll() used here functions the same as remove except it returns null if queue is empty. */
