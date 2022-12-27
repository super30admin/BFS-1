
// Time Complexity : O(n)
 // Space Complexity : O(n)
 // Did this code successfully run on Leetcode : Yes 
 // Any problem you faced while coding this : No


 // Your code here along with comments explaining your approach

import java.util.*;

 class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indergrees = new int[numCourses];
        for (int[] edge : prerequisites){
            indergrees[edge[0]]++;
            if (!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i=0; i<numCourses;i++){
            if (indergrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if (q.isEmpty()) return false;
        if (count == numCourses) return true;
        while (!q.isEmpty()){
            int curr= q.poll();
            List<Integer> children =map.get(curr);
            if (children != null){
                for (int child : children){
                    indergrees[child]--;
                    if (indergrees[child] == 0){
                        q.add(child);
                        count++;
                        if (count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}