// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int count = 0;
       
       int[] inc = new int[numCourses];
       HashMap<Integer, List<Integer>> adjL = new HashMap<>();
       for(int i=0; i< prerequisites.length; i++){
           // adjacency list
           if(!adjL.containsKey(prerequisites[i][1])){
               adjL.put(prerequisites[i][1], new ArrayList<Integer>());
           }
           adjL.get(prerequisites[i][1]).add(prerequisites[i][0]);

           //inCapcities
           inc[prerequisites[i][0]] += 1; 
       }

       Queue<Integer> queue = new java.util.LinkedList<Integer>();
       for(int i=0; i<numCourses; i++){
           if(inc[i] == 0){
               queue.add(i);
           }
       }
       while(!queue.isEmpty()){
           int course = queue.poll();
           count++;
           if(adjL.containsKey(course)){
               for(int c: adjL.get(course)){
                    inc[c]--;
                    if(inc[c] == 0){
                        queue.add(c);
                    }
                }
           }

           
       } 

       return count == numCourses ? true: false;
    }
}