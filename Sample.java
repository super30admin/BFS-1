// Time Complexity : O(n)
// Space Complexity : O(n) as max number of elements possible in queue are leaf nodes i.e n/2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) // no root
            return result;
            
        Queue<TreeNode> queue = new LinkedList<>(); // to process nodes in FIFO manner
        queue.add(root); // adding root to queue
         
        while(!queue.isEmpty()) // till queue is not empty
        {
            List<Integer> list = new ArrayList<>(); // create a list at each level
            int size = queue.size(); // calculating the size of the queue at that level
            for(int i = 0; i<size; i++) // processing the elements only of current level
            {
                TreeNode curr = queue.poll(); // polling front node out of queue
                list.add(curr.val); // adding value to temp list
                if(curr.left!=null) // checking if it has a left child
                    queue.add(curr.left); // adding it to queue
                if(curr.right!=null) // checking if it has a right child
                    queue.add(curr.right); // adding it to queue
            }
            result.add(list); // adding the resultant list to the final result list
        }
        
        return result; // returning result
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) recursion stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    List<List<Integer>> result; // global list result
   public List<List<Integer>> levelOrder(TreeNode root) {
      result = new ArrayList<>(); // initializing result
       
       if(root == null) // if no root
           return result;
       
       dfs(root, 0); // calling dfs function on root for level 0
   return result;
   }
   
   private void dfs(TreeNode root, int level)
   {
       //base
       if(root == null)
           return;
       //logic
       if(result.size() == level) // if there is no list in result for current level
           result.add(new ArrayList<>()); // add an empty list
       result.get(level).add(root.val); // add current root value to result at that level
       
       dfs(root.left,level+1); // calling dfs for left child
       dfs(root.right,level+1);// calling dfs for right child
   }
}

// Time Complexity : O(V+E) since for one vertex , all edges are not processed so v+e
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int indegree[] = new int[numCourses]; /// to keep track of the no of dependencies a course(represented by index) has
        
        Map<Integer, List<Integer>> map = new HashMap<>(); // to store how many course depend on one course
        
        for(int edge[]: prerequisites) //traversing through prerequisites
        {
            indegree[edge[0]]++; // for first index increment its indegree as it is dependent
            if(!map.containsKey(edge[1])) // put the subject it is dependent on as key
              map.put(edge[1], new ArrayList<>());
             map.get(edge[1]).add(edge[0]); // add the subject that is dependent in the array list so that we can use it while processing the courses in queue
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length;i++)
        {
            if(indegree[i] == 0) // finding all the courses that are independent
                q.add(i);
        }
        
        while(!q.isEmpty()) // till queue is not empty
        {
            int curr = q.poll();   // remove from queue 
            List<Integer> child = map.get(curr);    // get the courses dependent on curr 
            if(child!=null) // traverse through list of dependents
            {
                  for(int i:child)
                  {
                        indegree[i]--; // reduce there indegree as the course they are dependent on has been completed
                        if(indegree[i] == 0) // if the value becomes zero i.e it is independent
                            q.add(i);  // add to queue
                  }        
            }
        }
        
        for(int i: indegree) // check if at any course, the indegree is greater than 0
        {
            if(i>0)
                return false;
        }
        
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) recursion stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    List<Integer> result; // global result list
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>(); // initializing result
        
        if(root == null) // if no root
            return result;
        
        dfs(root,0);  // calling dfs function on root for level 0
        return result;
    }
    
    private void dfs(TreeNode root, int level)
    {
        //base
        if(root == null)
            return;
        //logic
        if(result.size() == level) // if there is no list in result for current level i.e the curr element is the first element for the level 
            result.add(root.val); // add root value to list
        
        dfs(root.right, level+1); // calling dfs for right child first
        dfs(root.left, level+1); // calling dfs for left child
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) recursion stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    List<Integer> result;  // global result list
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>(); // initializing result
        
        if(root == null) // if no root
            return result;
        
        dfs(root,0); // calling dfs function on root for level 0
        return result;
    }
    
    private void dfs(TreeNode root, int level)
    {
        //base
        if(root == null)
            return;
        //logic
        if(result.size() == level) // if there is no list in result for current level 
            result.add(root.val); // add to result
        else
            result.set(level, root.val); // replace the existing value
        
        dfs(root.left, level+1); // calling dfs for left child first
        dfs(root.right, level+1); // calling dfs for right child 
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) as max n/2 leaf nodes in queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // result list
        if(root == null) // if root is null
            return result;
        
      Queue<TreeNode> queue = new LinkedList<>(); // queue to process all nodes with processing all children at one go
        queue.add(root); // add root to queue
        
        while(!queue.isEmpty()) // till queue is empty
        {
            int size = queue.size(); // size of the number of items in queue currently (at the level)
            int last = -1; // to find last element at each level
            for(int i=0; i<size; i++) 
            {
                TreeNode curr = queue.poll(); // removing front element from queue
                last = curr.val; // updating the last value till loop finishes
                if(curr.left!=null) // if left child exists
                    queue.add(curr.left); // add to queue
                  if(curr.right!=null) // if right child exists
                    queue.add(curr.right); // add to queue
            }
            result.add(last); // add last element to result
        }
        return result;
    }
}