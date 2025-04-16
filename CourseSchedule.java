// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
It builds a mapping of course dependencies and tracks the number of prerequisites for each course
using an in-degree array. Courses with no prerequisites are added to a queue and processed iteratively,
 reducing the in-degree of dependent courses. If a dependent course’s in-degree becomes zero,
 it’s added to the queue for processing. The algorithm runs in O(V + E) time and
uses O(V + E) space, where V is the number of courses and E is the number of prerequisites.
* */

import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int[] inDegree=new int[numCourses];

        for(int[] num:prerequisites)
        {
            inDegree[num[0]]++;
            map.putIfAbsent(num[1],new ArrayList<>());
            map.get(num[1]).add(num[0]);
        }


        Queue<Integer> q=new LinkedList<>();

        int count=0;
        for(int i=0;i<inDegree.length;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
                count++;
            }
        }


        while(!q.isEmpty())
        {
            int curr=q.poll();
            List<Integer> dependencies=map.get(curr);
            if(dependencies!=null)
            {
                for(int dependent:dependencies)
                {
                    inDegree[dependent]--;
                    if(inDegree[dependent]==0)
                    {
                        q.add(dependent);
                        count++;
                    }
                }
            }
        }


        return count==numCourses;

    }
}