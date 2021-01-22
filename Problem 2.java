//Time Complexity: O(V+E) where V is numCourses and E is the prerequisites
//Space Complexity: O(V+E) due to HashMap space

//Successfully runs on leetcode: 5 ms

//Approach: This is a concept of Topological sort. The problem converts into a graph problem and we keep a track of all indegrees
//in a graph node using Hashmap and indegrees count. Then we start BFS traversal from the independent nodes and repeat
//the process for the other nodes whose indegree becomes 0. Then we check if the last count is equal to number of courses
// i.e. if all the courses can be taken together.


import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pre: prerequisites)
        {
            indegree[pre[0]]++;
            if(!hmap.containsKey(pre[1]))
            {
                hmap.put(pre[1], new ArrayList<>());
            }
            hmap.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }
        
        if(queue.isEmpty()) return false;
        
        while(!queue.isEmpty())
        {
            int q = queue.poll();
            List<Integer> edges = hmap.get(q);
            if(edges != null)
            {
                for(int edge: edges)
                {
                    indegree[edge]--;
                    if(indegree[edge] == 0)
                    {
                        queue.add(edge);
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                count++;
            }
        }
        
        if(count == numCourses) return true;
        else return false;
    }
}