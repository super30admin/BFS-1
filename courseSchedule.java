// Time Complexity : O(V + E) 
// Space Complexity : O(V + E) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependency = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            dependency[i] = 0;
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            dependency[prerequisites[i][0]]++;
        }
        
        List<List<Integer> > adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (dependency[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            List<Integer> dependentCourses = adjacencyList.get(curr);
            
            for (int i = 0; i < dependentCourses.size(); i++) {
                dependency[dependentCourses.get(i)]--;
                
                if (dependency[dependentCourses.get(i)] == 0) {
                    q.add(dependentCourses.get(i));
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (dependency[i] != 0) {
                return false;
            }
        }
        return true;
    }
}