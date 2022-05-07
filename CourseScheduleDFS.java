// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleDFS {
    Map<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //dfs
        if(numCourses == 0 || prerequisites.length == 0 || prerequisites == null){
            return true;
        }

        map = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        visited = new boolean[numCourses];
        path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){

            if(!visited[i]){ // Not visited
                if(dfs(i)){ // Cycle present or not
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int sv){ // Basically dfs to check cycle

        if(path[sv] == true){
            return true;
        }

        if(visited[sv] == true){ // This check should not be in for loop or it would not detect cycle
            return false;
        }

        visited[sv] = true;
        path[sv] = true;

        List<Integer> edges = map.get(sv);

        for(int i:edges){
            if(dfs(i)){
                return true;
            }
        }

        path[sv] = false;
        return false;
    }
}
