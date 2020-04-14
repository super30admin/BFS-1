// Time Complexity :O(V+E) where V is the vertices and E is the number of edges.
// Space Complexity :O(V+E) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //base case
        if(prerequisites.length==0) return true;
        int[]  indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> bfs = new LinkedList<>();
        for(int[] pre : prerequisites)
        {
            List<Integer> temp = graph.getOrDefault(pre[1],new ArrayList<Integer>());
            temp.add(pre[0]);
            indegrees[pre[0]]++;
            graph.put(pre[1],temp);
        }
        for(int i = 0 ; i <numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                bfs.add(i);
                
            }
            if(!graph.containsKey(i))
            {
                graph.put(i,new ArrayList<>());
            }
        }
        if(bfs.isEmpty()) return false;
        System.out.println(graph); 
        while(!bfs.isEmpty())
        {
            Integer node = bfs.poll();
            for(int child: graph.get(node))
            {
                indegrees[child]--;
                if(indegrees[child]==0) bfs.add(child);
            }
        }
        
        for(int i = 0 ; i <numCourses;i++)
        {
            if(indegrees[i]!=0)
            {
               return false;
            }
        }
        return true;
        
    }
}