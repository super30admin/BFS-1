// Time Complexity : O(V + E), V - vertices, E - edges
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Find the indegree and build adjacency list
// 2. Add the course whose indegree is 0
// 3. while processing each course from queue, decrement the indegree of its neighbors
// and add the course whose indegree is 0
// 4. Count the courses when added to queue, if it's not equal to numCourses, return false

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int count = 0;

        // build indegree array and adjacency list
        for(int[] pre : prerequisites) {
            inDegrees[pre[0]] += 1;

            if(adjList.get(pre[1]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                adjList.put(pre[1], list);
            }
            else {
                adjList.get(pre[1]).add(pre[0]);
            }
        }

        Queue<Integer> courseQ = new LinkedList<>();

        // add the first course with no dependency in queue
        for(int i=0; i<inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                courseQ.add(i);
                count++;
            }
        }

        while(!courseQ.isEmpty()) {
            int course = courseQ.remove();
            List<Integer> nextCourses = adjList.get(course);
            if(nextCourses == null) {
                continue;
            }

            for(int c : nextCourses){
                inDegrees[c] -= 1;
                if(inDegrees[c] == 0) {
                    courseQ.add(c);
                    count++;
                }
            }
        }

        if(count == numCourses) {
            return true;
        }
        return false;
    }
}
