import java.util.*;
// Time Complexity : O(n)
// Space Complexity : O(h), h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class CourseSchedule {
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        map = new HashMap<>();
        
        for(int[] prereq : prerequisites){
            if(!map.containsKey(prereq[1])){
                map.put(prereq[1], new ArrayList<>());
            }
            map.get(prereq[1]).add(prereq[0]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(!visited[i] && hasCycle(i)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(int i){
        if(path[i]) return true;
        if(visited[i]) return false;
        
        visited[i] = true;
        path[i] = true;
        
        List<Integer> children = map.get(i);
        if(children != null){
            for(int child : children){
                if(hasCycle(child)) return true;
            }   
        }
        
        path[i] = false;
        return false;
    }
}