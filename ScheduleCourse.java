import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Time Complexity : O(V+E)  V is the number of courses (vertices) and E is the number of prerequisites (edges).
// Space Complexity : O(V+E) 
public class ScheduleCourse {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int[numCourses];
        for(int [] edge : prerequisites)
        {
 
            int out = edge[1]; //independent
            int in = edge[0];
            indegrees[in]++;

            //make an entry in adj list
            if(!map.containsKey(out))
            {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i< numCourses; i++)
        {
            if(indegrees[i] == 0)
            {
                q.add(i);
                count++;
            }
        }
        if(count == numCourses)
                return true;
        if(q.isEmpty())
            return false;


        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children !=null)
            {
            for(int child : children)
            {
                indegrees[child]--;
                if(indegrees[child] == 0)
                {
                    q.add(child);
                    count++;
                    if(count == numCourses)
                        return true;
                }
            }
            }
        }    
        return false;
    }

    public static void main(String [] args)
    {
        int numcourses = 2;
        int[][] prerequisites = { { 1, 0}, { 0,1 }};
        ScheduleCourse sc = new ScheduleCourse();
       System.out.println( sc.canFinish(numcourses, prerequisites));

    }
}
