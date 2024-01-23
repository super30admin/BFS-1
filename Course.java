//TC: O(V+E)
//SC: O(V+E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


      int[] inDegrees = new int[numCourses];
      Queue<Integer> queue = new LinkedList<Integer>();
      HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

      for(int[] i : prerequisites ){
        // create indegress array
        int dependent = i[0];
        inDegrees[dependent]++;

        // create adjacency map
        int independent = i[1];
        if(!map.containsKey(independent)){
          map.put(independent, new ArrayList<>());
        }
        map.get(independent).add(dependent);
      }

      for(int i=0; i < inDegrees.length; i++){
        if(inDegrees[i]==0) queue.add(i);
      }

      while(!queue.isEmpty()){
        int curr = queue.poll();
        ArrayList<Integer> dependent = map.get(curr);
        if(dependent != null) {
          for(int i : dependent){
            inDegrees[i]= inDegrees[i]-1;
            if(inDegrees[i]==0) queue.add(i);
          }
        }
      }
      boolean flag=true;
      for(int i=0; i < inDegrees.length; i++){
        if(inDegrees[i]!=0) flag= false;
      }
      return flag;
    }
  }
