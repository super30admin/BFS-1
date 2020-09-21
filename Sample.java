//Level order traversal of a tree
// Time Complexity :0(n) no of nodes
// Space Complexity :0(n) max diameter
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


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
        List<List<Integer>> output= new ArrayList<>();
        if(root==null)
        {
            return output;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode front= queue.poll();
                //temp.add(front.val);
                if(front.left!=null)
                {
                    queue.add(front.left);
                }
                if(front.right!=null)
                {
                    queue.add(front.right);
                }
            }
            output.add(temp);
        }
        return output;
    }
}
//Course schedule
// Time Complexity :0(n*m)
// Space Complexity :0(v+E)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges= new int[numCourses];
        HashMap<Integer, List<Integer>> hp= new HashMap<>();
        for(int[] edge: prerequisites)
        {
            int first=edge[0]; 
            int second=edge[1];
            
            incomingEdges[first]+=1;
            if(!hp.containsKey(second))
            {
               hp.put(second, new ArrayList<>());
                
            }
            hp.get(second).add(first);
        }
        
         Queue<Integer> queue= new LinkedList<>();
        for(int x=0;x<incomingEdges.length;x++)
        {
            if(incomingEdges[x]==0)
            {
                queue.add(x);
            }
        }
        if(queue.isEmpty())
            return false;
        while(!queue.isEmpty())
        {
            int front= queue.poll();
            if(hp.containsKey(front))
            {
                for(int x:hp.get(front)){
                    incomingEdges[x]-=1;
                    if(incomingEdges[x]==0)
                    {
                        queue.add(x);
                    }
                }
                    
            }
        }
        
        
        for(int x:incomingEdges){
            if(x!=0){
                return false;
            }
        }
        return true;
    }
}

//Right side view of a tree
// Time Complexity :0(n) no. of nodes
// Space Complexity :0(n) diameter
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no
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
        List<Integer> output= new ArrayList<>();
        if(root==null)
            return output;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size= queue.size();
            for(int x=0;x<size;x++)
            {
                 TreeNode front=queue.poll();
                 //temp.add(root.val);
                if(x==size-1)
                {
                    output.add(front.val);
                }
                 if(front.left!=null)
                 {
                     queue.add(front.left);
                 }
                if(front.right!=null)
                {
                    queue.add(front.right);
                }
                
            }
        }
        
    return output;
    }
}
