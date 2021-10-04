class LevelOrderTraversal {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(n)
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Edge Case Checking
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            // Adding the elements level-wise to the queue
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }
            // Adding each level to the output list
            result.add(temp);
        }
        return result;
    }
}