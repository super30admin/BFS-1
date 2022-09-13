import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
 
Time Complexity :   O (V+E) 
Space Complexity :  O (V+E)
Did this code successfully run on Leetcode :    Yes (207. Course Schedule)
Any problem you faced while coding this :       No
 */

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int count = 0;
        
        // fill the inDegree array and HashMap to adjucency list
        for(int[] edge: prerequisites){
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        // Add nodes in the queue with No dependency
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i <inDegree.length; i++){
                if(inDegree[i] == 0){
                    q.add(i);
                    count++;
                }
        }

        if(count == numCourses){
            return true;
        }
        
        while(!q.isEmpty()){
            // take element from queue and get its adjacency list
            int curr = q.poll();
            List<Integer> childruns = map.get(curr);
            
            if(childruns != null){
                for(int i: childruns){
                    // subtracy childerns dependency from inDegree
                    inDegree[i]--;

                    // if independent node, add to queue to process
                    if(inDegree[i] == 0){
                        q.add(i);
                        count++;

                        // all courses taken
                        if(count == numCourses){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
