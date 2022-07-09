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
class Solution {
    
    /*
     *
     *  Using BFS: From root. 
     *
     *  1. Add root to the queue.
     *  2. Till the queue is not empty poll the queue.
     *  3. For each element polled, add its left and right to the queue.
     *  4. Add that level's elements to the list 
     *  5. When the elements for a given level are done, add the level element to the result
     *
     *  Time complexity: O(no.of nodes in the tree) => O(n)
     *. Space complexity: O(breadth of the tree) => O(n/2)
                Queue is the extra data structure we maintain, 
                in the worst case the max no.of elements that can reside in a queue is at last level (leaf nodes)
                at max we can have n/2 nodes in the leaf nodes level for a tree with n nodes.
     *   
     */
    
    // Global result
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return result;
        
        //Queue to maintain the order 
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            
            // We have to maintain a size variable as we need to keep track of the level
            // To create multiple lists and add elements to corresponding levels
            int size = q.size();
            
            
            // Created for every iteration of while loop, ie.. for each level.
            // This is not considered while calculating the space com
            List<Integer> li = new ArrayList<>();
            
            
            // Since we are running loop from 0.  i < size. ie.. for 1 element in a level we've to run only once.
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                    li.add(curr.val);
                // Add left & right children to the queue
                    if(curr.left != null)
                        q.add(curr.left);
                    if(curr.right != null)
                        q.add(curr.right);
                }
            
                // By this time we've processed all the elements in the given level
                // and have put it in the above list. this is the reason why we need the size variable.
                // To distinguish between levels.
                result.add(li);
            
            }
        
        return result;
    }
}
