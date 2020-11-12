package Nov11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
/*
  Time Complexity: O(V+E) where V is vertex(courses) and E is edges(dependencies/size of prerequisites array).
 
  Space Complexity: O(V+E)
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
            
*/ 
        
        // edge
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        // create indegree array for all the courses
        // create map to hold every parent course with its list of dependent child courses
        int[] indegree = new int[numCourses];    // O(V) space
        Map<Integer, List<Integer>> hm = new HashMap<>();  // O(V) space
        
        for (int[] pair: prerequisites) {
            indegree[pair[0]]++;
            if (!hm.containsKey(pair[1])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(pair[0]);
                hm.put(pair[1], temp);
            } else {
                List<Integer> temp = hm.get(pair[1]);
                temp.add(pair[0]);
               // hm.put(pair[1], temp);
            }
            
        }
        
        // iterate thru indegree array to find courses whose indegree = 0 => independent courses
        // add these independent courses to the queue
        Queue<Integer> queue = new LinkedList<>();   // O(E) space
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // perform BFS on the queue to reduce indegree of all dependent(child) nodes of the current node being processed
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> children = hm.get(cur);
            if (children != null){
                for (int child: children) {
                    indegree[child]--;
                    if (indegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }
         
        // iterate through indegree array to check if there is any course with indegree > 0 still. If yes, return false => cycle in the graph. If no, return true.
         for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) {
                return false;
            }
         }
        
        return true;

    }
}