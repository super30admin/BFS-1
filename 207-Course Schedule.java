//Space complexity=O(V+E)
//Time Complexity=O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N0 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree=new int[numCourses]; //We are storeing all the indegree of the node here i.e. how many incoming edges are there in each node
        HashMap<Integer, List<Integer>> map = new HashMap<>();//It creates an adjacency list to store all the node and its children
        for(int []pre:prerequisites)
        {
            //Nodes that have indegree are independent,like [2,0],[2,1] so for 2 indegree is 2
            indegree[pre[0]]++;
            //We are adding elements to adjacency list, and also creating a list if element is not there
            if(!map.containsKey(pre[1]))
            {
                map.put(pre[1],new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        
        //The queue store the element who have 0 dependency initally, so all elements who have indegree 0 are added initially
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
        //As we are storing all the children of node in hashMap, we are taking a list to store them
            List<Integer> children=map.get(curr);
        
            if(children!=null)
            {
                for(int child:children)//As we traverse the child node we are decreasing its indegree count and when the count is 0, we are adding it to the queue
                {
                    indegree[child]--;
                    if(indegree[child]==0)
                        q.add(child);
                }
            }
        }
        
        
        //At the end we are just checking whether all the indegree are calculated or not
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]>0)
                return false;
        }
        return true;
        
    }
}