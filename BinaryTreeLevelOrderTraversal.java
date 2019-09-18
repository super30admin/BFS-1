class BinaryTreeLevelOrderTraversal {
    // approach 1 - using recursion
    // Time complexity O(n)
    // Space complexity O(1)
    // Tested in Leetcode
    
    // Driver function of approach 1.
    public List<List<Integer>> levelOrder(TreeNode root) {    
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        helper(result, root, 1);
        return result;
    }
    // Helper function for approac 1. this function is a recursion function for traversing nodes 
    // and recording node value into result array.
    public void helper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null)
            return;
        // Every element of this array is a arraylist which is having nodes value of a particular level. 
        // This condition checks for a level if there is no allocated array, then allocate it.
        if(result.size() < level){
            result.add(new ArrayList<>());
        }
        
        // stores the node value based on the value into the subarray of result array.
        result.get(level-1).add(root.val);
        
        // call left and right child recursively
        helper(result, root.left,level+1); 
        helper(result, root.right,level+1);
    }
    
     // approach 2 - Iterative approach
    // Time complexity O(n)
    // Space complexity O(n)
    // Tested in Leetcode
    
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        // stores node during iteration
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // loop will terminate all nodes has been traversed.
        // record the size of the queue and run the sub loop upto count of size.
        while(!queue.isEmpty()){
             
            // during one iteration 
            // maximum size of the queue is maximum width of the tree
            int size = queue.size();
            List<Integer> temp= new ArrayList<>();
            while(size-- >0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                
                // insert childs of the next level
                 if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
               
            }
           result.add(temp);
        }
        return result;
    }
}