// Time Complexity : O(n), n is number of nodes in tree
// Space Complexity : O(h), h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//BFS
//for having the result as list of list
//we need to have a varible that indicates which level we are in 
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        //result ds 
        List<List<Integer>> result = new ArrayList<>();  
        //if tree empty, return result
        if(root == null) return result;  
        //intitialize a queue 
        //Can't instantiate Queue directly, so use LL
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);
        
        //do till q is not empty
        while(!q.isEmpty()) {
            
            //get size of queue
            int size = q.size();
            //create temp list to add nodes of each level
            List<Integer> temp = new ArrayList<>();
            
            //till size is not 0, add that nodes children in queue 
            //to maintain level order
            while(size > 0) {
                //get the front of queue add it to temp to add to queue
                TreeNode curr = q.poll();
                temp.add(curr.val);
                
                //add the children to queue (size is not changed)
                //size is reset when loop ends
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right); 
                
                //reduce the size
                size--;
                
                //do this for all nodes in queue (all nodes in a levels, children is added)
            }
            
            //if loop terminates, add the temp list to result as a new list
            //so each level nodes is a separate list
            result.add(new ArrayList<>(temp));
        }
        //return the list
        return result;
    }
}



////////////////////////////



//DFS
//keep track of level
//compare size of result and level 
//intitially both are 0, so when size = level, create a arraylist and add teh root
class Solution {
    //global variables to use in both methods
    List<List<Integer>> result;
    Queue<TreeNode> q = new LinkedList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //create new arraylist to return incase if tree is null
        result = new ArrayList<>();
        
        //return empty result
        if(root == null) return result;
        
        //call dfs with root and level = 0
        dfs(root,0);
        
        //return the result (method is void)
        return result;
        
    }
    
    
    private void dfs (TreeNode root, int level) {
        
        //if null, return 
        if(root == null) return;
        
        //if size = level, we know list for that level does not exists to 
        //create new list and add the root (after the if condition)
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        
        //after creatind list in result add the root.val
        //if list already created, get the level values list from result 
        //and add node value
        result.get(level).add(root.val);
        
        //recursive calls to left and right child
        dfs(root.left, level+1);
        dfs(root.right, level +1); 
        
        //size increases by 1 till tree height
        //after which it remains same, so we dont create new arraylist in result
        //we call the level number arraylist from result and add node value
        //level depends on recursive call
        //so call level (list) and add the node value
    }
}


