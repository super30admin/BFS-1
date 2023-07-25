// Time Complexity : O(V+E) where V is the number of courses and E is the number of dependencies
// Space Complexity : O(V+E) where V is the number of courses and E is the number of dependencies
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Used indegrees array to keep track of the number of dependencies for each course.
 * 2. Adjacency list is used to keep track of the courses that are dependent on the current course.
 * 3. Add all the courses with 0 dependencies to the queue.
 * 4. Poll the course from the queue and reduce the dependencies of the courses that are dependent on the current course.
 * 5. If the dependencies of the course becomes 0, add it to the queue.
 * 6. Repeat the process until the queue is empty.
 * 7. If the count of the courses that are taken is equal to the total number of courses, return true else return false.
 */

import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;

        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for(int[] pr : prerequisites){
            indegrees[pr[0]]++;
            adjList.get(pr[1]).add(pr[0]);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        if(queue.isEmpty())
            return false;

        while(!queue.isEmpty()){
            Integer course = queue.poll();
            List<Integer> preReqs = adjList.get(course);
            if(preReqs != null){
                for(Integer preReq : preReqs){
                indegrees[preReq]--;
                if(indegrees[preReq] == 0){
                    queue.offer(preReq);
                    count++;
                }
            }
            }
        }

        return count == numCourses;
    }
}