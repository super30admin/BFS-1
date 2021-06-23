import java.util.*;

public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites ==null || prerequisites.length==0)
            return true;
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] indegrees = new int[numCourses];
        //calculate te number of dependencies
        for(int[] pre: prerequisites)
        {
            int in = pre[0];
            int out = pre[1];
            indegrees[in]++;
            if(!map.containsKey(out))
            {
                map.put(out, new ArrayList());
            }
            map.get(out).add(in);
        }
        //indegrees and adj list
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
            }
        }
        if(q.size()==0)
            return false;

        //pop elements and reduce dependencies
        int count =0;
        while(!q.isEmpty())
        {
            int p = q.poll();
            count++;
            List<Integer> edges = map.get(p);
            if(edges!=null)
            {
                for(int edge : edges)
                {
                    indegrees[edge]--;
                    if(indegrees[edge]==0)
                    {
                        q.add(edge);
                    }
                }
            }
        }
        if(count!=numCourses)
        {
            return false;
        }
        return true;
    }
}

//Time complexity is O(v+e)
//Space Complexity is O(v+e)