// Time Complexity : O(v+e)), where v is vertices and e is edges
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs1;
import java.util.*;
public class CourseScheduleGraph {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int [numCourses];
        for(int [] pre: prerequisites){
            int in = pre[0], out = pre[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        //adjacency list
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i ++){
            if(indegrees[i] == 0) q.add(i);
        }
        int count = 0; // used for counting on courses which can be taken
        if(q.size() == 0) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List <Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge: edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                    }
                }
            }
        }
        if(count != numCourses) return false;
        return true;
    }      
}
