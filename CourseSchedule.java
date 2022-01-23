package bfs1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	//Time Complexity : O(v+e), where v is the numCourses and e is edges - prerequisites
	//Space Complexity : O(v+e), indegrees array is v, queue is v, hashmap is v+e
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Followed the class explanation
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.offer(i);
                count++;
            }
        }
        
        if(q.isEmpty()) 
            return false;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null) {
                for(int i: children) {
                    indegrees[i]--;
                    if(indegrees[i] == 0) {
                        q.offer(i);
                        count++;
                    }
                }
            }
        }
        
        return count == numCourses ? true : false;
    }
}
