import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
   HashMap<Integer, List<Integer>> adjList;
   boolean [] isVisited;    
   boolean [] currPath; 
   
   public boolean canFinish(int numCourses, int[][] prerequisites) {
       isVisited = new boolean[numCourses];
       currPath = new boolean[numCourses];
       adjList = new HashMap<>();
       
       for(int[] edge : prerequisites) {
           if(!adjList.containsKey(edge[1])) {
               adjList.put(edge[1], new ArrayList<>());
           }
           adjList.get(edge[1]).add(edge[0]);
       }
       
       for(int i = 0; i < numCourses; i++) {
           if(!isVisited[i] && hasCycle(i)) {
               return false;
           }
       }
       return true;
   }
   
   private boolean hasCycle(int course) {
       // If current course is already in the path
       if(currPath[course]) return true;
       
       // If course is already visited and it's not in current path
       if(isVisited[course]) return false;
       
       isVisited[course] = true;  
       currPath[course] = true;  
       if(adjList.get(course) != null) {
           for(int neighbor : adjList.get(course)) {
               if(hasCycle(neighbor)) return true;
           }
       }
       currPath[course] = false;
       return false;
   }
}
