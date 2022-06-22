// timecomplexity : O(V+E)
// space complexity: O(V+E)
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int[] edge: prerequisites){
            indegrees[edge[0]]++;
            if(!hm.containsKey(edge[1])){
                hm.put(edge[1], new ArrayList<>());
            }
            hm.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            
            int ele = q.poll();
            
            List<Integer> li = hm.get(ele);
            if(li!=null){
              for(int edge : li){
                 indegrees[edge]--;
                  if(indegrees[edge] == 0){
                     q.add(edge);
                     count++;
                     if(count == numCourses)
                        return true;
                     
                  }
              }
           }
        }
       
       return false;
    }
}