package BFS1;

// Time Complexity : O(V+E)  // V- vertices and E- edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0) return true;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int[] pr: prerequisites)
        {
            indegrees[pr[0]]++;
            if(!map.containsKey(pr[1]))
            {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0; i< indegrees.length; i++)
        {
            if(indegrees[i] == 0)
            {
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;
        if(q.isEmpty()) return false;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> list = map.get(curr);

            if(list!=null)
            {
                for(Integer i:list)
                {
                    indegrees[i]--;
                    if(indegrees[i] == 0)
                    {
                        q.add(i);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;

    }
}
