// Time Complexity : O(V + E)
// Space Complexity :O(V + E)   
// Did this code successfully run on Leetcode : yes
import java.util.*;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap <Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int[numCourses];
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
               for(int child : children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                    q.add(child);
                    count++;
                }
            } 
            }
        }
        return count == numCourses;
    }
}
