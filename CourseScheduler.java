// Time Complexity : O(N + V + E) where N is the courses and V = Vertices and E = edges
        //in the hashmap. As we go through all the vertices and its edges.
// Space Complexity : O(N + V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really

import java.util.*;

public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        Map<Integer, List<Integer>> topMap = new HashMap<>();
        
        for(int[] edge : prerequisites) {
            int first = edge[0];
            int second = edge[1];
            
            incomingEdges[first] += 1;

            if(topMap.containsKey(second)) {
                List<Integer> temp = topMap.get(second);
                temp.add(first);
                topMap.put(second, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(first);
                topMap.put(second, temp);
            }
        }
        
        Queue<Integer> topSortQueue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(incomingEdges[i] == 0) {
                topSortQueue.add(i);
            }
        }
        
        while(!topSortQueue.isEmpty()) {
            int temp = topSortQueue.poll();
            if(topMap.containsKey(temp)) {
                for(int i : topMap.get(temp)) {
                    incomingEdges[i] -= 1;
                    if(incomingEdges[i] == 0) {
                        topSortQueue.add(i);
                    }
                }
            }
        }
        
        for(int i : incomingEdges) {
            if(i > 0) {
                return false;
            }
        }
        
        return true;
    }
}
