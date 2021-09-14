package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseschedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        //adj list
	        HashMap<Integer,List<Integer>> adjList= new HashMap<>();
	        //indegess array
	        int[] array= new int[numCourses];
	        
	        for(int[] edge:prerequisites){
	            array[edge[0]]++;
	            if(!adjList.containsKey(edge[1])){
	                adjList.put(edge[1],new ArrayList<>());
	            }
	            adjList.get(edge[1]).add(edge[0]);
	        }
	        Queue<Integer> que= new LinkedList<>();
	          int count=0;
	        for(int i=0;i<array.length;i++){
	            if(array[i]==0){
	                que.add(i);
	                count++;
	            }
	        }
	        if(que.isEmpty()) return false;
	       
	        while(!que.isEmpty()){
	            int curr=que.poll();
	            List<Integer> children= adjList.get(curr);
	            if(children != null){
	                for(int i:children){
	                    array[i]--;
	                    if(array[i]==0){
	                        que.add(i);
	                        count++;
	                    }
	                }
	            }
	        }
	        return count==numCourses;
	    }

}
