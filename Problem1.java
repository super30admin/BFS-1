// Time Complexity : O(V+E) where V is the number of courses and E is the number of dependencies
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 Utilizing an array for indegrees to track dependencies and an adjacency list to note dependent courses,
 we enqueue courses with no dependencies. We then dequeue each course, reducing dependencies of its dependents
 and enqueueing them if they have none. Finally, we return true if the count of taken courses matches the total number, else false.
 */

import java.util.*;
class Problem1 {
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