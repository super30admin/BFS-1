//****LEVEL ORDER TRAVERSAL USING BFS****
//Time complexity:0(n);
//Space complexity:n/2;
//Leetcode runnable: Y;
//Any doubts: no;

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
        
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        //The show must go till queue becomes empty
        while(!q.isEmpty())
        {
            int size=q.size();
            //For each level a seperate list
            List<Integer> li =new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                //Once the particular node is popped off
                //Add it to its corresponding list
                li.add(curr.val);
                //the node which got added into the list, add its children to the queue(
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            //The list which we made for particular node add that to the result;
            result.add(li);
        }
     return result;  
    }
}


//*****LEVEL ORDER TRAVERSAL - USING DFS****
//Time compelxity:o(n);
//Space complexity:o(1);
//Leetcode runnable: Y;
//Any doubts: N;

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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return result;
        
    }
    
    private void dfs(TreeNode root, int level)
    {
        //Base case
        if(root==null) return;
        
        //logic
        if(result.size()==level)
        {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}

//****COURSE SCHEDULE****
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //null case
        if(prerequisites.length==0 ||prerequisites==null) return true;
        
        //make an indegree array of dependent elements
        int[] indegree = new int[numCourses];
        //Make a hashmap of independent to the dependent elements
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        //Traversing through the prerequisites and adding them to indegree and         //hashmap
        for(int[] edge: prerequisites)
        {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        //For bfs declaring a queue
        Queue<Integer> q=new LinkedList<>();
        //count variable for returning result
        int count=0;
        
        //Adding first of all the independent node to the queue;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                count++;
                
            }
        }
    
        //Now traversing the queue 
        while(!q.isEmpty())
        {
            int curr=q.poll();
            //Now getting all the nodes that were dependent on the current
            List<Integer> li=map.get(curr);
            if(li!=null)
            {
                for(int i:li)
                {
                    indegree[i]--;
                    if(indegree[i]==0)
                    {
                        q.add(i);
                        count++;
                        if(count==numCourses) return true;
                    }
                }
            }
            
        }
        return false;
        
        
        
    }
}
