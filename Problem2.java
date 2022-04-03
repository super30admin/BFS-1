// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] prereq : prerequisites) {
            
            int dependent = prereq[0];
            int source = prereq[1];
            
            if(!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            
            adjList.get(source).add(dependent);
            
            ++indegree[dependent];
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int completedCourses = 0;
        
        while (!q.isEmpty()) {
            
            int course = q.remove();
            ++completedCourses;
            
            List<Integer> dependents = adjList.get(course);
            
            if (dependents != null) {
                for (int depend : dependents) {
                    indegree[depend]--;
                    
                    if (indegree[depend] == 0) {
                        q.add(depend);
                    }
                }
            }
        }
        
        return completedCourses == numCourses;
    }
}