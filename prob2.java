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
        Queue<Integer> q = new LinkedList<Integer>();
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

// DFS solution, NOT Intuitive
/*class Solution {
    boolean[] path;
    boolean[] visited;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 1 || prerequisites == null) return false;
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        for(int[] edge: prerequisites){
            int in = edge[0]; int out = edge[1];
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i)) return false;
        }

        return true;
    }

    private boolean hasCycle(int course){
        //base
        if(path[course]) return true;
        if(visited[course]) return false;


        //logic
        visited[course] = true;
        //action
        path[course] = true;
        List<Integer> children = map.get(course);
        if(children != null){
            for(int child: children){
                if(hasCycle(child)) return true;
            }
        }
        // backtrack
        path[course] = false;
        return false; 
    }
} */
