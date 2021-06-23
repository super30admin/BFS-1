import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. We perform topological sorting to eliminate the dependencies 
2. Vertex with no incoming edges are processesd first and incoming edges of it's adjacent vertcies are reducecd by 1
3. if we able to process all the edges and there is no cycle that means we can finish the courses.
*/
public class FinishCourses1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        int[] inDegree=new int[numCourses];
        int count=0;    
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            graph.putIfAbsent(prerequisites[i][0],new ArrayList<>());
            graph.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
       Queue<Integer> queue=new LinkedList<>();
       for(int i=0;i<numCourses;i++)
       {
           if(inDegree[i]==0)
               queue.add(i);
       }
       while(!queue.isEmpty())
       {
           int vertex=queue.poll();
           count++;
           List<Integer> children=graph.get(vertex);
           if(children!=null)
           {
                for(int child:children)
               {
                   inDegree[child]--;
                   if(inDegree[child]==0)
                       queue.add(child);
               }
           }
          
           
       }
    
        if(count!=numCourses)
            return false;
        
        return true;
    }
}
