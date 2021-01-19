// Time Complexity : O(V+E) where V is the vertices and E is the edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0; //no.of courses completed
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge : edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                    }
                }
            }
        }
        //System.out.println(count);
        if(count != numCourses) return false;
        return true;
    }
	
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		
		System.out.println(CourseSchedule.canFinish(numCourses, prerequisites));
	}
	
}
