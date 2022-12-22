import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

//Time Complexity : O(V)+O(E) because traversing the whole map
//Space Complexity :O(V)+ O(E) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class CourseSchedule {
	  
    // Its a topological sort, we will create an indegree array and adjacency list of edges 
    // we will start with all 0 indegree nodes and travesre level by level 
    // after consuming a branch in traversal we will reduce the indegree count in indegree array 
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courseNo =0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        int[] inDegree = new int[numCourses];
        // prepare 
        for(int[] edge: prerequisites){
            inDegree[edge[0]]++;
           
            if(!map.containsKey(edge[1])){
              map.put(edge[1],new ArrayList<>());  
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        // Queue for level order traversal 
        Queue<Integer> queue = new LinkedList<>();
        
            for(int i=0;i<numCourses ;i++){

                    if(inDegree[i]==0){
                      queue.add(i);
                        courseNo++;
                    }
             }
        // If queue is empty means no independent node and we can not start traversal at all
        if(queue.isEmpty())
            return false;
        if(courseNo==numCourses)
            return true;
        
        // traverse the queue 
        while(!queue.isEmpty()){
               int j = queue.poll();
                List<Integer> edges = map.get(j);
                if(edges !=null)
                for(int k:edges){
                    inDegree[k]--;
                    if(inDegree[k]==0){
                         queue.add(k);
                        courseNo++;
                    }
                       
                }
                
            }
        
       
        return courseNo == numCourses;
    }
}
