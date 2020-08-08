// Time Complexity : O(V + E)
//      V: Number of vertices 
//      E: Number of edges
// Space Complexity :O(V + E)
//      V: Number of vertices 
//      E: Number of edges
//    Adjacency List 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Using Topological sort
// 1. Find the indegrees i.e number of parents
// 2. Create a Adjacency List
// 3. Add nodes whose indegrees is 0.
// 4. Process the nodes from the queue by decreasing the indegree count
// 5. Also add the nodes whose indegree count equals to 0 to the queue.
// 6. If all nodes indgree count is zero return true else false.
class Problme2 {

    /** returns true if all the courses can be finished */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // edge case
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;
        
        // create indegrees and adjacency list
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> myMap = new HashMap<>();
        for(int[] edge:prerequisites){
            
            // increase indegrees
            indegrees[edge[0]]++;
            
            // add to map
            if(!myMap.containsKey(edge[1]))
                myMap.put(edge[1], new ArrayList<Integer>());
            myMap.get(edge[1]).add(edge[0]);
        }
        
        // add to queue
        Queue<Integer> myQueue = new LinkedList<>();
        for(int i=0; i< numCourses; i++)
            if(indegrees[i]==0)
                myQueue.add(i);
        
        // using BFS traversal
        while(!myQueue.isEmpty()){

            // process current
            int current = myQueue.poll();

            // if children present
            if(myMap.get(current) != null)
            for(int temp: myMap.get(current)){
                // decrease 
                indegrees[temp]--;
                // add to queue
                if(indegrees[temp] == 0)
                    myQueue.add(temp);
            }
        }
        // check if all nodes are processed
        for(int i=0; i< numCourses; i++)
            if(indegrees[i] != 0)
                return false;
        return true;
    }
}