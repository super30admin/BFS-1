/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LevelOrderBinTree {
    // Time Complexity:     O(n) - traversing n nodes
    // Space Complexity:    O(max(number of elements at each level))
    
//  ITERATIVE APPROACH

    //output
    List<List<Integer>> levels = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) 
            return levels;
        
        // 1. add nodes to the queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);    
        
        // 2. Size to keep track of number of nodes at each level
        int size = 0;
        
        while(!q.isEmpty()){
            size = q.size();
            
            // 3. add a new empty list (LEVEL) to add to the output.
            List<Integer> level = new ArrayList<>();
            
             // 4. now add elements to the added list (LEVEL) of the result ListOfList --> elemnts in level
            for(int i = 0; i < size; i++){
                TreeNode front = q.poll();
                level.add(front.val);
                
                // Add left and right nodes of elements to the queue
                // Check for null - avoids adding null to queue which is of no use here
                if(front.left != null)
                    q.add(front.left);
                if(front.right != null)
                    q.add(front.right);
            }
            levels.add(level);
        }
        return levels;
    }
    
    
//     ### RECURSIVE

//     1. **HELPER ()** 
//              --->  checks the node element and its level 
//              --->  add node to that level present in the result list
//                 parameters --> (node, level )
//                 returns void
//     2.  **size of LEVELS == level ** ---> add a new list to the result List (levels)
//           else **NO**
//     3.  Recursive left and right 
//                 helper(node.left, level+1)
//                 helper(node.right, level+1)
    
    
//     List<List<Integer>> levels = new ArrayList<>();
    
//     public void helper(TreeNode root, int level ){
//         if(levels.size() == level)  
//             levels.add(new ArrayList<Integer>());
        
//         levels.get(level).add(root.val);
    
//         if(root.left != null)
//             helper(root.left, level+1);
//         if(root.right != null)
//             helper(root.right, level+1);
//     }
    
    
//     public List<List<Integer>> levelOrder(TreeNode root) {
        
//         if(root == null) return levels;
//         helper(root,0);
//         return levels;
//     }
}