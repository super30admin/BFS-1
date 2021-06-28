package BFS1;

/* Time complexity : o(V+E) v vertices and E edges
space complexity: o(V+E) v vertices and E edges
Did this code run successfully in leetcode : yes
problems faces : no
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class canFinish {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	       //edge case
	       if(prerequisites == null || prerequisites.length == 0) return true; 
	        
	       int[] indegree = new int[numCourses];
	       HashMap<Integer, List<Integer>> map = new HashMap<>();
	       Queue<Integer> q = new LinkedList<>();
	       for(int[] pre : prerequisites){
	           int in = pre[0];
	           int out = pre[1];
	           indegree[in]++;
	           
	           if(!map.containsKey(out)){
	               map.put(out, new ArrayList<>());
	           }
	           map.get(out).add(in);
	       } 
	        
	       for(int i=0; i<indegree.length; i++){
	           if(indegree[i] == 0){
	               q.add(i);
	           }
	       } 
	       if(q.size() == 0) return false;
	       int count = 0; 
	       while(!q.isEmpty()){
	           int curr = q.poll();
	           count++;
	           List<Integer> children = map.get(curr);
	           
	           if(children!=null){
	               for(int child : children){
	                   indegree[child]--;
	                   if(indegree[child] == 0){
	                       q.add(child);
	                   }
	               }
	           }
	       } 
	        if(count == numCourses ) return true;
	        return false;
	    }
	}
