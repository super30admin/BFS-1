// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : faced issue with whiteboarding 
import java.util.*;
public class prob2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 1) return false;
        int [] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge: prerequisites){
            indegrees[edge[0]]++;
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = adjList.get(curr);
            if(children != null){
                for(int child: children){
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
