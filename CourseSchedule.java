// Time Complexity : O(V+E) where V is number of verties i.e. courses in this case and E is edges i.e. prerequisites length in this case
// Space Complexity : O(V+E) where V is number of verties i.e. courses in this case and E is edges i.e. prerequisites length in this case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

import java.util.*;
public class CourseSchedule{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        //used to keep track of which course can be taken next
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        //fill indegree array
        for(int[] p:prerequisites){
            indegree[p[0]] += 1;
            
            //maintain independent to dependent course mapping
            if(!map.containsKey(p[1])){
                map.put(p[1],  new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }
        //put courses which is not depended on any other course in the queue
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> list = map.get(course);
            if(list == null){
                continue;
            }
            //this is equivalent to taking a course and adding its dependent to queue if they are no longer depended on any other courses
            for(int i=0; i<list.size(); i++){
                int curr = list.get(i);
                indegree[curr]--;
                if(indegree[curr] == 0){
                    q.offer(curr);
                }
            }
        }
        
        //if any value of is greater than 0, it means that course cannot be taken
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] > 0){
                return false;
            }
        }
        return true;
    }
}