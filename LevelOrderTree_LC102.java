class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        
        //add root to the queue
        queue.add(root);
        //set the level of the traversal
        int level =0;
        //traverse untill the queue is empty
        while(!queue.isEmpty())
        {
            //create a new list inside the result list for every new level
            res.add(new ArrayList<Integer>());
            //find the length of the queue
            int len = queue.size();
            //traverse the loop to pop the queue elements 
            for(int i=0; i<len;i++){
                //store the poped element in a node and add it to the result list
                TreeNode node = queue.remove(); 
               res.get(level).add(node.val);
                //check if the popped node has right or left child
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            //increment the level by 1
            level++;
        }
        
       return res; 
        
    }
}
