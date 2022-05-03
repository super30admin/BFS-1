import java.util.*;
public class CourseSchedule {
    

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        if(prerequisites == null || prerequisites.length == 0)
        {
            return true;
        }
        
        int[] indegrees = new int[numCourses];
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edge: prerequisites)
        {
            indegrees[edge[0]]++;
            
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        
        
        if(q.isEmpty())
        {
            return false;
        }
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            
            if(edges!=null)
            {
                for(int edge: edges)
                {
                    indegrees[edge]--;
                    
                    if(indegrees[edge]==0)
                    {
                        q.add(edge);
                        count++;
                    }
                }
            }
        }
        
        return count == numCourses;
    }

    public static void main(String args[])
    {
        int[][] prerequisites = {{1,0}};

        System.out.println(canFinish(2, prerequisites));
    }
}
