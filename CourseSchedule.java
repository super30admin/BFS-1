// Time Complexity : O(V + E)
// Space Complexity : O(V + E) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegreeArray = new int[numCourses];
        
        for(int[] course : prerequisites){
            indegreeArray[course[0]]++;
            if(!map.containsKey(course[1]))
                map.put(course[1], new ArrayList<>());
            map.get(course[1]).add(course[0]);
        }
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegreeArray[i] == 0){
                queue.add(i);
                count++;
            }
        }
        if(queue.isEmpty()) return false;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            List<Integer> list = map.get(curr);
            if(list != null){
                for(int i : list){
                indegreeArray[i]--;
                    if(indegreeArray[i] == 0){
                        queue.add(i);
                        count++;
                        if(count == numCourses) return true;
                    }
            }
            }
        }
        return false;
    }
}
