// Time Complexity : O(n)
// Space Complexity: O(n)
// Did it run on LeetCode : Yes, 0ms
// Did you face any problems while attemmpting? : No

// Approach: Basic Idea is to put the nodes in the queue, and explore its left and right child, till all the nodes are traversed.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> outerList = new ArrayList<>();
        
        if(root == null){
            return outerList;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            List<Integer> innerList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode temp = queue.poll();
                
                innerList.add(temp.val);
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
                
            }
            
            outerList.add(innerList);
            
        }
        
        return outerList;
        
    }
}