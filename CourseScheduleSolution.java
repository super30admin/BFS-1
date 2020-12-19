// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;
        int[] indegreeArr = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
         
        for(int i = 0; i<prerequisites.length; i++) {
            indegreeArr[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>(prerequisites[i][0]));
            } 
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean isIndependentCourse = false;
        for(int i=0; i<indegreeArr.length; i++) {
            if(indegreeArr[i] == 0) {
                isIndependentCourse = true;
                q.add(i);
            }
        }
        
        if(!isIndependentCourse)
            return false;
        
        while(!q.isEmpty()) {
            int courseId = q.poll();
            List<Integer> child = map.get(courseId);
            if(child!=null) {
                for(int id: child ) {
                    indegreeArr[id]--;
                    if(indegreeArr[id] == 0)
                        q.add(id);
                }
            }
        }
        for(int indegree: indegreeArr) {
            if(indegree > 0)
                return false;
        }
        return true;
    }
}