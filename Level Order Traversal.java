/////////////////////////////////////////BFS///////////////////////////////////////////////////////////

// Time Complexity : O(n)
// Space Complexity : O(n) but it would be 2*n plus more but it gets reduced to n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    //create a master list to hold the level orders
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        //createe a queue 
        Queue<TreeNode> que = new LinkedList<>();
        //intialize the res 
        res = new ArrayList<>();
        if(root == null) return res;
        //add the root into the queue
        que.add(root);
        //now iterate until the queue is not empty as per BFS
        while(!que.isEmpty()){
            //maintain a size variable after adding to the queue to see how many nodes you need to process for that given level
            int size = que.size();
            List<Integer> hold = new ArrayList<>();
            //now have a for loop that iterates through that size and pops from the que because thats how many nodes are in that level
            for(int i = 0; i<size; i++){
                //pull node out of the queue per the for loop that is how many nodes are in that level
                TreeNode t = que.poll(); 
                //put these nodes into the temp array as an array itself for its own level 
                hold.add(t.val);
                //now check if this node has a left or right child to add to the queue and explore
                if(t.left != null) que.add(t.left);
                if(t.right != null) que.add(t.right);
                
            }
            //add the temp array with current level
            res.add(hold);
        }
        return res;
    }
}




/////////////////////////////////////////DFS///////////////////////////////////////////////////////////

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


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
    //create a master list to hold the level orders
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        //intialize the result array;
        res = new ArrayList<>();
        if(root == null) return res;
        //now call dfs on the root and level we are starting at which would be 0
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int lvl){
        //base
        if(root == null) return;
        //logic
        //if the root you are at and it's level is equal to the size that means we have to add a new level 
        if(lvl == res.size()){
            //add a new array list
            res.add(new ArrayList<>());
        }
        //now now put the node corresponding to its level as an index in the result array
        res.get(lvl).add(root.val);
        //now call dfs on the left child and increase the level
        dfs(root.left, lvl+1);
        //a stack pop will happen here after the base case has been hit then you want to check if there is a right child
        dfs(root.right, lvl+1);
    }
}