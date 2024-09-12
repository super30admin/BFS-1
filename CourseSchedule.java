// Time Complexity :  O(V + E)
// Space Complexity : O(V + E) // n by 2
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();  // edges
        Queue<Integer> q = new LinkedList<Integer>();// verticies
        
        int[] indegree = new int[numCourses]; 
        
        for(int i = 0; i < prerequisites.length;i++ ){
            indegree[prerequisites[i][0]] += 1;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        
        for(int i = 0; i< numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            List<Integer> children = map.get(node);
            if(children != null){
                for(int c: children){
                    indegree[c]-=1;
                    if(indegree[c] == 0)
                        q.add(c);
                }
            }
        }
        return count == numCourses;
    }
}class CourseSchedule {
    
}
