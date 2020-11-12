// Time Complexity : O(v+e) where  v is numOfCourses and e is edges ie matrix length
// Space Complexity : O(v+2e) e for map + e for queue + v indegree arr
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * Initial task is to identify the problem is Graph problem. Then keep inDegree arr
 * to keep track of independent nodes (no incoming route). Create a map with dependency relations
 * to optimize the solution.
 * */

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[2,0] then key is 0 and value is 2
        Map<Integer, List<Integer>> toDependencyMap= new HashMap<>();
        int[] indegree = new int[numCourses];

        //generate the indegree array
        //and fill toDependencyMap
        for(int i=0; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            if(!toDependencyMap.containsKey(prerequisites[i][1])){
                toDependencyMap.put(prerequisites[i][1], new ArrayList());
            }
            toDependencyMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        //find the independent nodes
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //traverse queue
        while (!q.isEmpty()){
            int course = q.poll();
            List<Integer> dependents = toDependencyMap.get(course);
            if(dependents!=null){
                for(int dependent : dependents){
                    indegree[dependent]--;
                    if(indegree[dependent]==0){
                        q.add(dependent);
                    }
                }
            }
        }

        //check if any course not yet processed
        for(int i=0; i<numCourses; i++){
            if(indegree[i]>0) return false;
        }

        return true;
    }
}
