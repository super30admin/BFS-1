//Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ex57 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(numCourses == 0)
                return true;
            int[] indegree = new int[numCourses];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i =0; i<prerequisites.length; i++){
                indegree[prerequisites[i][0]]++;
                if(!map.containsKey(prerequisites[i][1])){
                    map.put(prerequisites[i][1], new ArrayList<>());
                }
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i<numCourses; i++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int current = q.poll();
                List<Integer> children = map.get(current);
                if(children != null){
                    for(int child : children){
                        indegree[child]--;
                        if(indegree[child] == 0){
                            q.add(child);
                        }
                    }
                }
            }
            for(int i = 0; i<numCourses; i++){
                if(indegree[i] >0){
                    return false;
                }
            }
            return true;
        }
    }
}
