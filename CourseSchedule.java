/**
 * Time complexity and space complexity is O(V+E)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()) {
            int course = queue.remove();
            List<Integer> children = map.getOrDefault(course, Collections.EMPTY_LIST);
            
            for(int child : children) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    queue.add(child);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}