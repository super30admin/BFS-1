// Time Complexity : O(n), n is number of nodes
// Space Complexity : O(h), h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//DFS (Recursive)
class Solution {
    //declare result globally to access in dfs method
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        //initialize locally, (so that others cannot overwrite your data)
        result = new ArrayList<>();
        //if tree empty, return empty list
        if(root == null) return result;
        //call dfs methos
        dfs(root,0); //root, level of root (void method, we just add values to result in the method)
        //return result 
        return result; 
              
    }
    
    private void dfs(TreeNode root, int level) {
        //base case
        if(root == null) return; 
            
        //logic       
        //if level of node = size of result 
        //then it is the right most node of that level, as that levels nodes have still not
        //been added to the result.
        //so add that root.val to result
        if(level == result.size()) {
            result.add(root.val);
        }
        //calling root.right first (to add right most node to the result)
        //to add left view, call root.left before root.right
        dfs(root.right, level+1);
        dfs(root.left, level+1);            
    }
}



////////////////////////////


//BFS (Iterative)
class Solution {    
    public List<Integer> rightSideView(TreeNode root) {
        //declare and inititalize result 
        List<Integer> result = new ArrayList<>();
        //if tree is empty return empty result
        if(root == null) return result;
        //create queue to perform bfs
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);
        
        //perform loop till queue empty (if queue empty, then all nodes have been processed)
        while(!q.isEmpty()) {
            //maintain size to know which node belongs to a particular level
            //we need to add right most node of each level
            int size = q.size();
            //a last variable to keep the val of curr right most node, 
            //when polling nodes from queue of each level
            int last = -1;
            
            //for loop for each level (0 to size)
            for(int i = 0; i < size; i++) {
                //remove front of queue
                TreeNode curr = q.poll();
                //if it has left/right child, add to queue
                //add left before right child
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);  
                //get value of last node processed of each level
                //when for loop ends, last will have right most node value
                last = curr.val;
            }
            //add it to result
            result.add(last);         
        }
        //return result
        return result;        
    }
}

