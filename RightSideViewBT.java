class RightSideViewBT {
    
    // Time Complexity:     O(N) ----> All nodes are visited and for only once.
    
    // Space Complexity:    O(diameter) -> queue
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if(root == null)
            return output;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        
        int size = -1;
        while(!queue.isEmpty()){
            size = queue.size();            
            for(int i = 0; i < size; i++){
                TreeNode front = queue.poll();
                if(i == size -1)
                    output.add(front.val);
                
                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            }
        }
        return output;
    }
}