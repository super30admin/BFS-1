//Time Complexity: O(V+E)
//Space Complexity: O(V+E)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //null case
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                que.add(i);
                count++;
            }
        }
        if(que.isEmpty()) {
            return false;
        }
        while(!que.isEmpty()) {
            int curr = que.poll();
            //get all dependencies from the map
            List<Integer> edges = map.get(curr);
            if(edges != null) {
                for(int edge: edges) {
                    indegrees[edge]--;
                    if(indegrees[edge] == 0) {
                        que.add(edge);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}
