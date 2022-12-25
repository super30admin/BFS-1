import java.util.*;
//BSF solution
// Time Complexity: O(V+E)
//Space Complexity: O(V+E)
/*
 * Here we store the number of dependency in an array and the 
 * dependencies in hashmap. keep the count of elements in queue 
 * and when it is equal to courses we return true else return false.
 */

public class CourseSchedule {
    HashMap<Integer, List<Integer>> map;
    int [] indegrees;
    Queue<Integer> q;
    int count;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        indegrees = new int[numCourses];
        q = new LinkedList<>();
        count = 0;
        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++; 
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()) return false;
        while(!q.isEmpty()){ //O(V)
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }    
            } 
        }
        
        return count == numCourses;
    }
}