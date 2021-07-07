package s30Coding;
import java.util.*;

//Time Complexity :- O(V+E) V is the vertices and E is the edges of the graph
//Space Complexity :- O(V+E) V is the vertices and E is the edges of the graph

//LeetCode :- Yes
//Logic :- BFS

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
        indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children != null){
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] > 0){
                return false;
            }
        }
        
        return true;
    }
}
